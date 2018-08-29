package armen.springbootfirstprogram;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Getter
@Component
public class GameImpl implements Game {

    // == fields ==
    private final int rock = 1;
    private final int paper = 2;
    private final int scissors = 3;

    @Getter
    private int randomNumber;


    @Getter
    @Setter
    private int value;

    Random random = new Random();




    @Override
    public void randomValueGenerator() {
        randomNumber=random.nextInt(3)+1;

    }

    @Override
    public int isGameWon() {

        return check(value);

    }

    @Override
    public void reset() {

        randomNumber=1;
        value=1;

    }

    @Override
    public int check(int value) {
        if(randomNumber== rock && value==paper)
            return 1;
        else if(randomNumber== rock && value==scissors)
            return -1;
        else if(randomNumber== rock && value== rock)
            return 0;
        else if (randomNumber==paper && value== rock)
            return -1;
        else if (randomNumber==paper && value==scissors)
            return 1;
        else if (randomNumber==paper && value==paper)
            return 0;
        else if(randomNumber==scissors && value== rock)
            return 1;
        else if(randomNumber==scissors && value==scissors)
            return 0;
        else
            return -1;
    }

}