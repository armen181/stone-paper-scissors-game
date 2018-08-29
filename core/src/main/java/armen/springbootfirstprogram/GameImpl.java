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
    private final int stone = 1;
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
        if(randomNumber==stone && value==paper)
            return 1;
        else if(randomNumber==stone && value==scissors)
            return -1;
        else if(randomNumber==stone && value==stone)
            return 0;
        else if (randomNumber==paper && value==stone)
            return -1;
        else if (randomNumber==paper && value==scissors)
            return 1;
        else if (randomNumber==paper && value==paper)
            return 0;
        else if(randomNumber==scissors && value==stone)
            return 1;
        else if(randomNumber==scissors && value==scissors)
            return 0;
        else
            return -1;
    }

}