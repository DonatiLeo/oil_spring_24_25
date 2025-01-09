package fr.mbds.dice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiceService {

    private final Dice dice;
    private final DiceRollLogRepository diceRollLogRepository;


    @Autowired
    public DiceService(Dice dice, DiceRollLogRepository diceRollLogRepository) {
        this.dice = dice;
        this.diceRollLogRepository = diceRollLogRepository;
    }

    public DiceRollLog rollDice() {
        int value = dice.roll();
        DiceRollLog diceRollLog = DiceRollLog.builder().results(List.of(value)).build();
        diceRollLogRepository.save(diceRollLog);
        return diceRollLog;
    }

    public DiceRollLog rollDices(int count) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            results.add(dice.roll());
        }
        DiceRollLog diceRollLog = DiceRollLog.builder().results(results).build();
        diceRollLogRepository.save(diceRollLog);
        return diceRollLog;
    }
}
