package armen.springbootfirstprogram.converters;

import armen.springbootfirstprogram.commands.ScoreForm;
import armen.springbootfirstprogram.db.Score;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.core.convert.converter.Converter;
/**
 * Created by jt on 1/10/17.
 */
@Component
public class ProductFormToProduct implements Converter<ScoreForm, Score> {

    @Override
    public Score convert(ScoreForm scoreForm) {
        Score score = new Score();
        if (scoreForm.getId() != null  && !StringUtils.isEmpty(scoreForm.getId())) {
           // score.setId(new Long(scoreForm.getId()));
        }
        score.setName(scoreForm.getName());
        score.setScore(scoreForm.getScore());
        return score;
    }
}
