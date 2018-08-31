package armen.springbootfirstprogram.db;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Score {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int _id;
        private String name;
        private int score;



}
