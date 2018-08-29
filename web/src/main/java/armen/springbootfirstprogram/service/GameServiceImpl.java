package armen.springbootfirstprogram.service;


import armen.springbootfirstprogram.Game;
import armen.springbootfirstprogram.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class GameServiceImpl implements GameService {

    // == fields ==
    private final Game game;
    private final MessageGenerator messageGenerator;

    // == constructors ==
    @Autowired
    public GameServiceImpl(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    // == init ==
    @PostConstruct
    public void init() {
        log.info("number = {}", game.getValue());
        log.info("mainMessage = {}", messageGenerator.getMainMessage());
    }

    // == public methods ==
    @Override
    public boolean isGameOver() {
        return true;
    }

    @Override
    public String getMainMessage() {
        return messageGenerator.getMainMessage();
    }

    @Override
    public String getResultMessage() {
        return messageGenerator.getResultMessage();
    }

    @Override
    public void checkGuess(int guess) {
        game.randomValueGenerator();
        game.setValue(guess);
        game.check(guess);
    }

    @Override
    public void reset() {
        game.reset();
    }
}
