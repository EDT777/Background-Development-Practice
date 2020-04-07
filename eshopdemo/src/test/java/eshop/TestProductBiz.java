package eshop;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.octopus.biz.ProductBiz;
import com.octopus.biz.impl.ProductBizImpl;
import com.octopus.entity.Product;

public class TestProductBiz {

	private ProductBiz productBiz= new ProductBizImpl(); 
	@Test
	public void testFindById() {
		Product product=productBiz.findById(1);
		assertNotNull(product);
		System.out.println(product);
	}
	
	@Test
	public void testFindByName() {
		List<Product> products =productBiz.find("测试", 10, 1);
		assertNotNull(products.size()>0);
		System.out.println(products);
	}
}
