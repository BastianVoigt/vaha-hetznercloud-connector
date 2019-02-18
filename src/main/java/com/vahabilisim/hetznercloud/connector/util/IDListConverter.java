package com.vahabilisim.hetznercloud.connector.util;

import com.vahabilisim.hetznercloud.connector.model.IDInterface;
import com.fasterxml.jackson.databind.util.StdConverter;
import java.util.List;
import java.util.stream.Collectors;

public class IDListConverter extends StdConverter<List<IDInterface>, List<Long>> {

    @Override
    public List<Long> convert(List<IDInterface> list) {
        return list.stream()
                .map(IDInterface::getId)
                .collect(Collectors.toList());
    }

}
