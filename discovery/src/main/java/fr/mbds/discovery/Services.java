package fr.mbds.discovery;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@Data
public class Services {
    private Map<String, String> list = new HashMap<>();

    public Map<String, String> addService(String location, String name)
    {
        list.put(name, location);
        return list;
    }
    public Map<String, String> addService(HashMap<String, String> serviceData)
    {
        list.putAll(serviceData);
        return list;
    }

    public String toString()
    {
        return list.keySet().stream()
                .map(key -> key + "=" + list.get(key))
                .collect(Collectors.joining(", ", "{", "}"));
    }
}
