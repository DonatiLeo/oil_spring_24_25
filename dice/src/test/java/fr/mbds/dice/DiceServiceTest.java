package fr.mbds.dice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;

public class DiceServiceTest {

    DiceService subject;

    @Mock
    Dice dice;

    @Mock
    DiceRollLogRepository diceRollLogRepository;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        subject = new DiceService(dice, diceRollLogRepository);
    }

    @Test
    public void shouldReturnRollDice() throws Exception {
        given(dice.roll()).willReturn((int) (Math.random() * 6) + 1);
        assertThat(subject.rollDice(), instanceOf(DiceRollLog.class));
    }

    @Test
    public void shouldReturnXRollDiceLogValues() throws Exception {
        int rollCount = (int) (Math.random()*10);

        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < rollCount; i++) {
            values.add((int) (Math.random() * 6) + 1);
        }

        DiceRollLog diceRollLog = new DiceRollLog();
        diceRollLog.setResults(values);

        assertThat(subject.rollDices(rollCount).getResults().size(), is(rollCount));
    }
}
