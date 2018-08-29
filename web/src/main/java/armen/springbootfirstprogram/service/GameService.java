package armen.springbootfirstprogram.service;

public interface GameService {

    boolean isGameOver();

    String getMainMessage();

    String getResultMessage(int yourSet);

    void setValues(int guess);

    void reset();

    int getRandomValue();

    int getYourBalance();

    int getYourWin();

}
