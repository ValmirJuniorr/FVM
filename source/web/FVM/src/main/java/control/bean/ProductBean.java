package control.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import model.Product;
import model.dao.ProductDao;

import java.io.Serializable;

@ManagedBean
@SessionScoped
public class ProductBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6361711547368565353L;

	@EJB
	private ProductDao productDao;

	private Product product = new Product();

	public void add() {
		this.productDao.add(product);
		product = new Product();
	}
	/*

	public String delete(Product product) {
		productDao.delete(product);
		return "index?faces-redirect=true";

	}*/
	public void delete(Product product) {
		productDao.delete(product);
	}

	public void update() {
		productDao.update(product);
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getProducts() {
		return productDao.getAll();
	}
}
