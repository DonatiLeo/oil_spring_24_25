package fr.mbds.player.clients;

import fr.mbds.player.proxies.ServicesProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;

@FeignClient(name = "discovery", url = "http://localhost:8999/")
public interface DiscoveryClient {

    @PostMapping("/register")
    public ServicesProxy register(@RequestBody HashMap<String, String> serviceData);

    @GetMapping("/services")
    public ServicesProxy services();
}
