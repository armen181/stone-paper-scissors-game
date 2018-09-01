package armen.springbootfirstprogram.service;



import armen.springbootfirstprogram.db.Score;

import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
public interface ScoreService {

    List<Score> listAll();

   // Product getById(Long id);

    Score saveOrUpdate(Score score);

   // void delete(Long id);

   // Product saveOrUpdateProductForm(ProductForm productForm);
}
