package fr.mbds.dice;

import org.junit.jupiter.api.Test;

public class DiceTest {

    @Test
    public void shouldRollDice() {
        Dice dice = new Dice();
        dice.roll();
        assert dice.getValue() >= 1 && dice.getValue() <= 6;
    }
}
