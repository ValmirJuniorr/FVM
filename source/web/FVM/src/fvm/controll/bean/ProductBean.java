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
	private List<Product> products=null;
	

	private Product product=new Product();
	
	public void add() {
		productRepository.add(product);
		System.out.println(product);
		product=new Product();
		products=null;
	}
	
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


	public List<Product> getProducts() {
		if(products==null){
			products= productRepository.getAll();
		}
		return products;
	}
	

	public void setProducts(List<Product> products) {
		this.products = productRepository.getAll();
	}	

}
