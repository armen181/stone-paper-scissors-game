package armen.springbootfirstprogram.controller;


import armen.springbootfirstprogram.db.Score;
import armen.springbootfirstprogram.service.GameService;
import armen.springbootfirstprogram.service.ScoreService;
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
    private final ScoreService scoreService;

    // == constructor ==
    @Autowired
    public GameForRest(GameService gameService, ScoreService scoreService) {
        this.gameService = gameService;
        this.scoreService= scoreService;
    }


    @GetMapping("game")
    public PostAnswer test(){
        gameService.reset();
        Score score = new Score();
        score.setId(1);
        score.setName("Armen");
        Score.setScore(1200);
        scoreService.saveOrUpdate(score);
        return new PostAnswer("Start new game", 100, 0, 1,1, false);
    }


    @PostMapping("game")
    public PostAnswer test(@RequestHeader int guess, @RequestHeader int radioButton){
        log.info("guess= {}", guess);
        gameService.setValues(guess);

        return new PostAnswer(gameService.getResultMessage(radioButton), gameService.getYourBalance()<0 ? 0: gameService.getYourBalance(), gameService.getYourWin(), gameService.getRandomValue(),guess, gameService.isGameOver());
    }

}
