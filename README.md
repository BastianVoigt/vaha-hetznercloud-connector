# vaha-hetznercloud-connector

#### What is it?
A desktop and Android compatible Java 8 based connector for Hetzner Cloud API.

#### ExampleUsage.java (a basic example of how to use [vaha-hetznercloud-connector](https://github.com/vahithanoglu/vaha-hetznercloud-connector))
```java
package com.vahabilisim.hetznercloud.connector;

import com.vahabilisim.hetznercloud.connector.core.ConnectorException;
import com.vahabilisim.hetznercloud.connector.core.HetznerCloudConnector;
import com.vahabilisim.hetznercloud.connector.model.main.*;
import com.vahabilisim.hetznercloud.connector.request.create.*;
import com.vahabilisim.hetznercloud.connector.request.delete.*;
import com.vahabilisim.hetznercloud.connector.request.getall.*;
import com.vahabilisim.hetznercloud.connector.request.update.*;
import com.vahabilisim.hetznercloud.connector.response.*;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExampleUsage {

    private static final String TOKEN = "..."; //enter your own token

    private static final Map<Long, ISO> ISOS = new LinkedHashMap<>();
    private static final Map<Long, Image> IMAGES = new LinkedHashMap<>();
    private static final Map<Long, Location> LOCATIONS = new LinkedHashMap<>();
    private static final Map<Long, Datacenter> DATACENTERS = new LinkedHashMap<>();
    private static final Map<Long, ServerType> SERVERTYPES = new LinkedHashMap<>();

    public static void main(String[] args) {
        final HetznerCloudConnector connector = new HetznerCloudConnector(TOKEN);

        try {
            populateLookupData(connector);

            final Volume volume = createVolume(connector);

            final SSHKey sshKey = createSSHKey(connector);

            final Server server = createServer(connector, volume, sshKey);

            final FloatingIP floatingIP = createAndAssignFloatingIP(connector, server);

            // before creating an image, server creation should be completed
            // this is why the following line is commented out
            // final Image image = createImage(connector, server);
            listResources(connector);

            updateNewlyCreatedResources(connector, volume, sshKey, floatingIP, server);

            deleteNewlyCreatedResources(connector, volume, sshKey, floatingIP, server);

        } catch (ConnectorException ex) {
            ex.printStackTrace(System.err);
        }
    }

    private static void populateLookupData(HetznerCloudConnector connector) throws ConnectorException {
        ISOS.clear();
        IMAGES.clear();
        LOCATIONS.clear();
        DATACENTERS.clear();
        SERVERTYPES.clear();

        System.out.println("");
        System.out.println("********************* ISOS *********************");
        connector.requestAll(new GetISOs()).getList().forEach(item -> {
            System.out.println(item);
            ISOS.put(item.getId(), item);
        });

        System.out.println("");
        System.out.println("********************* IMAGES *********************");
        connector.requestAll(new GetImages()).getList().forEach(item -> {
            System.out.println(item);
            IMAGES.put(item.getId(), item);
        });

        System.out.println("");
        System.out.println("********************* LOCATIONS *********************");
        connector.requestAll(new GetLocations()).getList().forEach(item -> {
            System.out.println(item);
            LOCATIONS.put(item.getId(), item);
        });

        System.out.println("");
        System.out.println("********************* DATACENTERS *********************");
        connector.requestAll(new GetDatacenters()).getList().forEach(item -> {
            System.out.println(item);
            DATACENTERS.put(item.getId(), item);
        });

        System.out.println("");
        System.out.println("********************* SERVER TYPES *********************");
        connector.requestAll(new GetServerTypes()).getList().forEach(item -> {
            System.out.println(item);
            SERVERTYPES.put(item.getId(), item);
        });
    }

    private static Volume createVolume(HetznerCloudConnector connector) throws ConnectorException {
        System.out.println("");
        System.out.println("********************* CREATE VOLUME *********************");

        final Location nurembergDCPark1 = LOCATIONS.get(2L);

        final CreateVolume createVolume = CreateVolume.builder()
                .size(10L)
                .name("api-test-volume")
                .format(Volume.Format.EXT4)
                .location(nurembergDCPark1)
                //.server(...)
                //.automount(true) //can be set to true if the volume is attached to a server
                .build();

        final ResponseCreateVolume response = connector.request(createVolume);
        System.out.println(response);

        return response.getVolume();
    }

    private static SSHKey createSSHKey(HetznerCloudConnector connector) throws ConnectorException {
        System.out.println("");
        System.out.println("********************* CREATE SSH KEY *********************");
        final CreateSSHKey createSSHKey = CreateSSHKey.builder()
                .name("api-test-ssh-key")
                .publicKey("...") //enter your own ssh key
                .build();

        final SSHKey sshKey = connector.request(createSSHKey);
        System.out.println(sshKey);

        return sshKey;
    }

    private static Server createServer(HetznerCloudConnector connector, Volume volume, SSHKey sshKey) throws ConnectorException {
        System.out.println("");
        System.out.println("********************* CREATE SERVER *********************");

        final ServerType cx11 = SERVERTYPES.get(1L);
        final Image ubuntu1804 = IMAGES.get(168855L);
        final Location nurembergDCPark1 = LOCATIONS.get(2L);

        final CreateServer createServer = CreateServer.builder()
                .name("api-test-server")
                .serverType(cx11)
                .image(ubuntu1804)
                .location(nurembergDCPark1)
                .startAfterCreate(false)
                .sshKeys(Collections.singletonList(sshKey))
                .volumes(Collections.singletonList(volume))
                .automount(true) //can be set to true if a volume is attached
                .build();

        final ResponseCreateServer response = connector.request(createServer);
        System.out.println(response);

        return response.getServer();
    }

    private static Image createImage(HetznerCloudConnector connector, Server server) throws ConnectorException {
        System.out.println("");
        System.out.println("********************* CREATE IMAGE *********************");

        final CreateImage createImage = CreateImage.builder()
                .type(Image.Type.SNAPSHOT)
                .server(server)
                .description("api-test-image-snapshot")
                .build();

        final ResponseCreateImage response = connector.request(createImage);
        System.out.println(response);

        return response.getImage();
    }

    private static FloatingIP createAndAssignFloatingIP(HetznerCloudConnector connector, Server server) throws ConnectorException {
        System.out.println("");
        System.out.println("********************* CREATE & ATTACH FLOATING IP *********************");

        final Location helsinkiDCPark1 = LOCATIONS.get(3L);

        final CreateFloatingIP createFloatingIP = CreateFloatingIP.builder()
                .description("api-test-floating-ip")
                .type(FloatingIP.Type.IPv4)
                .server(server)
                .homeLocation(helsinkiDCPark1)
                .build();

        final ResponseCreateFloatingIP response = connector.request(createFloatingIP);
        System.out.println(response);

        return response.getFloatingIP();
    }

    private static void listResources(HetznerCloudConnector connector) throws ConnectorException {

        System.out.println("");
        System.out.println("********************* VOLUMES *********************");
        connector.requestAll(new GetVolumes()).getList().forEach(item -> {
            System.out.println(item);
        });

        System.out.println("");
        System.out.println("********************* SSH KEYS *********************");
        connector.requestAll(new GetSSHKeys()).getList().forEach(item -> {
            System.out.println(item);
        });

        System.out.println("");
        System.out.println("********************* FLOATING IPS *********************");
        connector.requestAll(new GetFloatingIPs()).getList().forEach(item -> {
            System.out.println(item);
        });

        System.out.println("");
        System.out.println("********************* SERVERS *********************");
        connector.requestAll(new GetServers()).getList().forEach(item -> {
            System.out.println(item);
        });
    }

    private static void updateNewlyCreatedResources(HetznerCloudConnector connector, Volume volume, SSHKey sshKey, FloatingIP floatingIP, Server server) throws ConnectorException {
        System.out.println("");
        System.out.println("********************* UPDATE VOLUME *********************");
        Volume respVol = connector.request(UpdateVolume.builder()
                .volume(volume)
                .name("api-test-volume-newname")
                .build()
        );
        System.out.println(respVol);

        System.out.println("");
        System.out.println("********************* UPDATE SSH KEY *********************");
        SSHKey respSSH = connector.request(UpdateSSHKey.builder()
                .sshKey(sshKey)
                .name("api-test-ssh-key-newname")
                .build()
        );
        System.out.println(respSSH);

        System.out.println("");
        System.out.println("********************* UPDATE FLOATING IP *********************");
        FloatingIP respIP = connector.request(UpdateFloatingIP.builder()
                .floatingIP(floatingIP)
                .description("api-test-floating-ip-newdesc")
                .build()
        );
        System.out.println(respIP);

        System.out.println("");
        System.out.println("********************* UPDATE SERVER *********************");
        Server respServer = connector.request(UpdateServer.builder()
                .server(server)
                .name("api-test-server-newname")
                .build()
        );
        System.out.println(respServer);
    }

    private static void deleteNewlyCreatedResources(HetznerCloudConnector connector, Volume volume, SSHKey sshKey, FloatingIP floatingIP, Server server) throws ConnectorException {
        System.out.println("");
        System.out.println("********************* DELETE VOLUME *********************");
        connector.request(new DeleteVolume(volume));

        System.out.println("");
        System.out.println("********************* DELETE SSH KEY *********************");
        connector.request(new DeleteSSHKey(sshKey));

        System.out.println("");
        System.out.println("********************* DELETE FLOATING IP *********************");
        connector.request(new DeleteFloatingIP(floatingIP));

        System.out.println("");
        System.out.println("********************* DELETE SERVER *********************");
        Action action = connector.request(new DeleteServer(server));
        System.out.println(action);
    }
}
```
