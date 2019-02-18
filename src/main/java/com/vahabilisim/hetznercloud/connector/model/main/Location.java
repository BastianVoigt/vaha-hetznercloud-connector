package com.vahabilisim.hetznercloud.connector.model.main;

import com.vahabilisim.hetznercloud.connector.model.IDInterface;
import lombok.Data;

@Data
public class Location implements IDInterface {

    private long id;
    private String name;
    private String description;
    private String country;
    private String city;
    private double latitude;
    private double longitude;
}
