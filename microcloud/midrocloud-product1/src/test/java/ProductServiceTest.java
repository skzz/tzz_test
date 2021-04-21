import cn.enjoy.ProductApp1;
import cn.enjoy.service.IProductService;
import cn.enjoy.vo.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = ProductApp1.class)
//@RunWith(SpringRunner.class)
public class ProductServiceTest {
    @Resource
    private IProductService iProductService;
    @Test
    public void testGet() {
        System.out.println(iProductService.get(1));
    }
    @Test
    public void testAdd() {
        Product dept = new Product() ;
        dept.setProductName("lison-" + System.currentTimeMillis());
        System.out.println(iProductService.add(dept));
    }
    @Test
    public void testList() {
        System.out.println(iProductService.list());
    }
}