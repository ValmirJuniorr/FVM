package fvm.controll.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import fvm.model.Product;
import fvm.model.dao.repository.ProductRepository;

@ManagedBean
public class ProductBean {	
	
	@EJB
	private ProductRepository productRepository;
	

	private Product product=new Product();
	
	public void add() {
		productRepository.add(product);
		System.out.println(product);
		product=new Product();		
	}
	
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


	public List<Product> getProducts() {
		return productRepository.getProducts();
	}
}
