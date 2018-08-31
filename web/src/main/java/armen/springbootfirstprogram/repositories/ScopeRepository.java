package armen.springbootfirstprogram.repositories;

import armen.springbootfirstprogram.db.Score;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jt on 1/10/17.
 */
public interface ScopeRepository extends CrudRepository<Score, Long> {
}
