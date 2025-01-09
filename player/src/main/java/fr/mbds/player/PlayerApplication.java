package fr.mbds.player;

import fr.mbds.player.clients.DiscoveryClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;

@SpringBootApplication
@EnableFeignClients
@Slf4j
public class PlayerApplication {

    @Value("${server.port}")
    private String port;

    public static void main(String[] args) {
        SpringApplication.run(PlayerApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(DiscoveryClient discoveryClient)
//    {
//        return args -> {
//            HashMap<String, String> map = new HashMap<>();
//            map.put(port, "player");
//            discoveryClient.register(map);
//            log.info("Service is now registered with discovery");
//        };
//    }
}
