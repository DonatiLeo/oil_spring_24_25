package fr.mbds.dice;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@DataJpaTest
public class DiceRollLogRepositoryIntegrationTest {

    @Autowired
    private DiceRollLogRepository subject;

    @AfterEach
    public void clean() throws Exception {
        subject.deleteAll();
    }

    @Test
    public void shouldSaveAndFetchDiceRollLog() throws Exception {
        DiceRollLog diceRollLog = new DiceRollLog(List.of(1, 2, 3));
        subject.saveAndFlush(diceRollLog);

        var shouldBeDiceRollLog = subject.findById(diceRollLog.getId());

        assertThat(shouldBeDiceRollLog, is(Optional.of(diceRollLog)));
    }
}
