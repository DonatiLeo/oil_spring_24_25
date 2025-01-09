package fr.mbds.player;

import fr.mbds.player.clients.DiceClient;
import fr.mbds.player.clients.DiscoveryClient;
import fr.mbds.player.proxies.DiceRollLogProxy;
import fr.mbds.player.proxies.ServicesProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class PlayerController {
    private final DiceClient diceClient;
    private final DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String port;

    @Autowired
    PlayerController(DiceClient diceClient, DiscoveryClient discoveryClient)
    {
        this.diceClient = diceClient;
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/rollDice")
    public DiceRollLogProxy rollDice()
    {
        return diceClient.rollDice();
    }

    @GetMapping("/rollDices/{count}")
    public DiceRollLogProxy rollDices(@PathVariable int count)
    {
        return diceClient.rollDices(count);
    }

    @GetMapping("/testDiscovery")
    public ServicesProxy register()
    {
        HashMap<String, String> map = new HashMap<>();
        map.put(port, "player");
        return discoveryClient.register(map);
    }
}
