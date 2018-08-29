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


    @GetMapping("test")
    public String test(){
        log.info("guess= {}", 1);
        gameService.checkGuess(1);


        return gameService.getResultMessage();
    }
    @PostMapping("test")
    public PostAnswer test(@RequestHeader int guess){
        log.info("guess= {}", guess);
        gameService.checkGuess(guess);

        return new PostAnswer(gameService.getResultMessage(), 100, 200);
    }

}
