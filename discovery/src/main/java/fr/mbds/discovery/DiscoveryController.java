package fr.mbds.discovery;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class DiscoveryController {

    private final HttpServletRequest request;

    private final Services services;

    @Autowired
    DiscoveryController(Services services, HttpServletRequest request)
    {
        this.request = request;
        this.services = services;
    }

    @PostMapping("/register")
    public Services register(@RequestBody HashMap<String, String> serviceData)
    {
        services.addService(serviceData);
        return services;
    }

    @GetMapping("/services")
    public Services services()
    {
        return services;
    }
}
