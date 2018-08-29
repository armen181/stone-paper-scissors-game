package armen.springbootfirstprogram;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator {

    // == constants ==
    private static final String MAIN_MESSAGE = "game.main.message";
    private static final String WIN = "game.win";
    private static final String LOSE = "game.lose";
    private static final String EQUAL = "game.equal";
    private static final String INVALID_RANGE = "game.invalid.range";
    private static final String FIRST_GUESS = "game.first.guess";
    private static final String HIGHER = "game.higher";
    private static final String LOWER = "game.lower";
    private static final String REMAINING = "game.remaining";

    // == fields ==
    private final Game game;
    private final MessageSource messageSource;

    // == constructor ==

    public MessageGeneratorImpl(Game game, MessageSource messageSource) {
        this.game = game;
        this.messageSource = messageSource;
    }
    // == init ==
    @PostConstruct
    public void init() {
        log.info("game = {}", game);
    }

    @Override
    public String getMainMessage() {
        return getMessage(MAIN_MESSAGE, game.getRandomNumber(), game.getValue());
    }

    @Override
    public String getResultMessage() {
        if(game.isGameWon()==1){
            return getMessage(WIN, game.getRandomNumber(), game.getValue());
        }else if(game.isGameWon()==-1){
            return getMessage(LOSE, game.getRandomNumber(), game.getValue());
        }else if(game.isGameWon()==0) {
            return getMessage(EQUAL, game.getRandomNumber(), game.getValue());
        }

        return null;
    }



    private String getMessage(String code, Object... args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
