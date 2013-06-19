package mjg;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class JpaProductDAO implements ProductDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> getAllProducts() {
        return entityManager.createQuery("from Product p").getResultList();
    }

    @Override
    public Product findProductById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public int insertProduct(Product p) {
        entityManager.persist(p);
        return p.getId();
    }

    @Override
    public void deleteProduct(int id) {
        entityManager.remove(findProductById(id));
    }

}
