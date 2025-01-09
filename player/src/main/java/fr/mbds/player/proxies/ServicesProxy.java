package fr.mbds.player.proxies;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Data
public class ServicesProxy {
    private Map<String, String> list = new HashMap<>();

    public String toString()
    {
        return list.keySet().stream()
                .map(key -> key + "=" + list.get(key))
                .collect(Collectors.joining(", ", "{", "}"));
    }
}
