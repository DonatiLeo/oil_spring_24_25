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

public class DiceControllerTest {

    private DiceController subject;

    @Mock
    private DiceService diceService;

    @BeforeEach
    public void setUp() throws Exception {
        // Set up the mocks, without this the mocks will be null
        MockitoAnnotations.openMocks(this);
        subject = new DiceController(diceService);
    }

    @Test
    public void shouldReturnRollDice() throws Exception {
        given(diceService.rollDice()).willReturn(new DiceRollLog());

        assertThat(subject.rollDice(), instanceOf(DiceRollLog.class));
    }

    @Test
    public void shouldReturnXValues() throws Exception {
        int rollCount = (int) (Math.random()*10);

        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < rollCount; i++) {
            values.add((int) (Math.random() * 6) + 1);
        }

        DiceRollLog diceRollLog = new DiceRollLog();
        diceRollLog.setResults(values);
        given(diceService.rollDices(rollCount)).willReturn(diceRollLog);

        assertThat(subject.rollDices(rollCount).getResults().size(), is(rollCount));
    }

}
