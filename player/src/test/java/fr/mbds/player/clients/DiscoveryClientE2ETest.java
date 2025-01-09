package fr.mbds.player.clients;

import fr.mbds.player.proxies.ServicesProxy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@ExtendWith({SpringExtension.class})
public class DiscoveryClientE2ETest {

    Logger logger = LoggerFactory.getLogger(DiscoveryClientE2ETest.class);

    @Autowired
    public DiscoveryClient discoveryClient;

    @Test
    void getServices() {
        ServicesProxy servicesResponse = discoveryClient.services();
        assertThat(servicesResponse, instanceOf(ServicesProxy.class));
        logger.info("after GET /services :"+servicesResponse.toString());
    }

    @Test
    void register() {
        HashMap<String, String> map = new HashMap<>();
        map.put("test", "player");
        ServicesProxy servicesResponse = discoveryClient.register(map);
        assertThat(servicesResponse.getList(),is(map));
        logger.info("after POST /register :"+servicesResponse.toString());
    }
}
