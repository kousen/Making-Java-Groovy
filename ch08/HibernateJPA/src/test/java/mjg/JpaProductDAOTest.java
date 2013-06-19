package mjg;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
@Transactional
public class JpaProductDAOTest {
    @Autowired
    private ProductDAO dao;

    @Test
    public void testFindById() {
        Product p = dao.findProductById(1);
        assertEquals("baseball", p.getName());
    }
    
    @Test
    public void testGetAllProducts() {
        List<Product> products = dao.getAllProducts();
        assertEquals(3, products.size());
    }
    
    @Test
    public void testInsert() {
        Product p = new Product(99, "racketball", 7.99);
        int id = dao.insertProduct(p);
        Product p1 = dao.findProductById(id);
        assertEquals("racketball", p1.getName());
    }
    
    @Test
    public void testDelete() {
        List<Product> products = dao.getAllProducts();
        for (Product p : products) {
            dao.deleteProduct(p.getId());
        }
        assertEquals(0, dao.getAllProducts().size());
    }
}
