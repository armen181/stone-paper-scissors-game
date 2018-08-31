package armen.springbootfirstprogram.controller.commands;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by jt on 1/10/17.
 */
@Setter
@Getter
public class ScoreForm {
    private Long id;
    private String name;
    private int score;

}
