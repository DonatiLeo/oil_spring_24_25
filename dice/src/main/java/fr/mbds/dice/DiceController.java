package fr.mbds.dice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiceController {

    private final DiceService diceService;

    @Autowired
    public DiceController(DiceService diceService)
    {
        this.diceService = diceService;
    }

    @GetMapping("/rollDice")
    public DiceRollLog rollDice()
    {
        return diceService.rollDice();
    }

    @GetMapping("/rollDices/{count}")
    public DiceRollLog rollDices(@PathVariable int count)
    {
        return diceService.rollDices(count);
    }

}
