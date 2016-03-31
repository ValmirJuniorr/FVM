package control.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import model.Product;
import model.dao.repository.ProductRepository;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class ProductBean implements Serializable {	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6361711547368565353L;


	@EJB
	private ProductRepository productRepository;
	

	private Product product=new Product();
	
	public void add() {
		productRepository.add(product);
		System.out.println(product);
		product=null;		
	}
	
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


	public List<Product> getProducts() {
		return productRepository.getAll();
	}
}
