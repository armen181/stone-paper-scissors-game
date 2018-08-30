package armen.springbootfirstprogram.controller;


import armen.springbootfirstprogram.service.GameService;
import armen.springbootfirstprogram.util.PostAnswer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class GameForRest {

    // == fields ==
    private final GameService gameService;

    // == constructor ==
    @Autowired
    public GameForRest(GameService gameService) {
        this.gameService = gameService;
    }


    @GetMapping("game")
    public boolean test(){

        return gameService.isGameOver();
    }


    @PostMapping("game")
    public PostAnswer test(@RequestHeader int guess, @RequestHeader int radioButton){
        log.info("guess= {}", guess);
        gameService.setValues(guess);

        return new PostAnswer(gameService.getResultMessage(radioButton), gameService.getYourBalance()<0 ? 0: gameService.getYourBalance(), gameService.getYourWin(), gameService.getRandomValue(),guess, gameService.isGameOver());
    }

}
