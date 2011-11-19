package mjg;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class POJOTest {
    @Autowired
    private POJO pojo;

    @Test
    public void callSetters() {
        pojo.setOne("one");
        pojo.setTwo(22);
        pojo.setThree(333.0);
        assertEquals("one", pojo.getOne());
        assertEquals(22, pojo.getTwo());
        assertEquals(333.0, pojo.getThree(),0.0001);
    }
}
