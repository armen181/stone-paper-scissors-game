package armen.springbootfirstprogram;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.Set;

@Slf4j
@Getter
@Component
public class GameImpl implements Game {

    // == fields ==
    private final int rock = 1;
    private final int paper = 2;
    private final int scissors = 3;


    @Setter
    private int balance=100;

    private int yourWin;


    private boolean isGameEnded;

    @Override
    public boolean getIsGameEnded() {
        return isGameEnded;
    }


    private int randomNumber;


    @Getter
    @Setter
    private int value;

    Random random = new Random();


    @Override
    public void randomValueGenerator() {
        randomNumber = random.nextInt(3) + 1;

    }

    @Override
    public void balanceAdd(int yourSet) {
        //balance += yourSet;
        yourWin += yourSet;
    }


    @Override
    public void balanceRmv(int yourSet) {
        balance -= yourSet;
        if (balance <= 0) {
            isGameEnded = true;
        }
    }

    @Override
    public int isGameWon(int yourSet) {

        if(!isGameEnded) {
            if (check(value) == 1) {
                balanceAdd(yourSet);
                return 1;
            } else if (check(value) == -1) {
                balanceRmv(yourSet);
                return -1;
            }
        }
        return 0;
    }

    @Override
    public void reset() {
        isGameEnded = false;
        randomNumber = 1;
        value = 1;
        yourWin = 0;
        balance = 100;

    }

    @Override
    public int check(int value) {
        if (randomNumber == rock && value == paper) {

            return 1;
        } else if (randomNumber == rock && value == scissors) {

            return -1;
        } else if (randomNumber == rock && value == rock)
            return 0;
        else if (randomNumber == paper && value == rock) {

            return -1;
        } else if (randomNumber == paper && value == scissors) {

            return 1;
        } else if (randomNumber == paper && value == paper)
            return 0;
        else if (randomNumber == scissors && value == rock) {

            return 1;
        } else if (randomNumber == scissors && value == scissors)
            return 0;
        else {

            return -1;
        }
    }

}