package armen.springbootfirstprogram.converters;


import armen.springbootfirstprogram.controller.commands.ScoreForm;
import armen.springbootfirstprogram.domain.Score;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by jt on 1/10/17.
 */
@Component
public class ProductToProductForm implements Converter < Score, ScoreForm> {
    @Override
    public ScoreForm convert(Score score) {
        ScoreForm scoreForm = new ScoreForm();
        scoreForm.setId(score.getId());
        scoreForm.setName(score.getName());
        scoreForm.setScore(score.getScore());
        return scoreForm;
    }
}
