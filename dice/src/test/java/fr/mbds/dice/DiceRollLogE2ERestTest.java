package fr.mbds.dice;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static io.restassured.RestAssured.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DiceRollLogE2ERestTest {

    @LocalServerPort
    private int port;

    @Autowired
    DiceRollLogRepository diceRollLogRepository;

    @AfterEach
    public void tearDown() throws Exception {
        diceRollLogRepository.deleteAll();
    }

    @Test
    public void shouldCreateDiceRollLog() throws Exception {
        when()
                .get(String.format("http://localhost:%s/rollDice", port))
                .then()
                .statusCode(is(200))
                .body("results", hasItem(either(is(1))
                        .or(is(2)).or(is(3)).or(is(4)).
                        or(is(5)) .or(is(6))));
    }
}
