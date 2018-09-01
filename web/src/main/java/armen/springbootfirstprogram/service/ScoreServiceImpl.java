package armen.springbootfirstprogram.service;


import armen.springbootfirstprogram.converters.ProductFormToProduct;
import armen.springbootfirstprogram.db.Score;
import armen.springbootfirstprogram.repositories.ScopeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
@Service
public class ScoreServiceImpl implements ScoreService {

    private ScopeRepository scoreRepository;
    private ProductFormToProduct productFormToProduct;

    @Autowired
    public ScoreServiceImpl(ScopeRepository productRepository, ProductFormToProduct productFormToProduct) {
        this.scoreRepository = productRepository;
        this.productFormToProduct = productFormToProduct;
    }


    @Override
    public List<Score> listAll() {
        List<Score> scores = new ArrayList<>();
        scoreRepository.findAll().forEach(scores::add); //fun with Java 8
        return scores;
    }

//    @Override
//    public Score getById(Long id) {
//        return productRepository.findById(id).orElse(null);
//    }

    @Override
    public Score saveOrUpdate(Score score) {
        scoreRepository.save(score);
        return score;
    }

//    @Override
//    public void delete(Long id) {
//        productRepository.deleteById(id);
//
//    }

//    @Override
//    public Product saveOrUpdateProductForm(ProductForm productForm) {
//        Product savedProduct = saveOrUpdate(productFormToProduct.convert(productForm));
//
//        System.out.println("Saved Product Id: " + savedProduct.getId());
//        return savedProduct;
//    }
}
