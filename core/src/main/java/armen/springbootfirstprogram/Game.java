package armen.springbootfirstprogram;

public interface Game {

    void randomValueGenerator();

    void setValue(int value);

    int isGameWon(int yourSet);

    void balanceAdd(int yourSet);

    void balanceRmv(int yourSet);

    void reset();

    int getValue();

    int getRandomNumber();

    int check (int value);

    int getBalance();

    void setBalance(int balance);

    int getYourWin();

    boolean getIsGameEnded();



}
