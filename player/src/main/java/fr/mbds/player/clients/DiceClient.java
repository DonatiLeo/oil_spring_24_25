package fr.mbds.player.clients;

import fr.mbds.player.proxies.DiceRollLogProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "dice", url = "http://localhost:8080")
public interface DiceClient {

    @GetMapping("/rollDice")
    public DiceRollLogProxy rollDice();

    @GetMapping("/rollDices/{count}")
    public DiceRollLogProxy rollDices(@PathVariable int count);
}
