package fr.mbds.player.proxies;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Data
public class DiceRollLogProxy {
    Long id;
    List<Integer> results;
    Date ts;
}
