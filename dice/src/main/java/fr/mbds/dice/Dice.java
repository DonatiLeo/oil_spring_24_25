package fr.mbds.dice;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
@Data
public class Dice {

    private int value;

    public int roll()
    {
        this.value = (int) (Math.random() * 6) + 1;
        return this.value;
    }
}
