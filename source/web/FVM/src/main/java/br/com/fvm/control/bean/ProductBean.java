package br.com.fvm.control.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import org.primefaces.context.RequestContext;

import br.com.fvm.model.Product;
import br.com.fvm.model.dao.ItemDao;
import br.com.fvm.model.dao.ProductDao;

@ManagedBean
@SessionScoped
public class ProductBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6361711547368565353L;
	

	@EJB
	private ProductDao productDao;
	
	@EJB
	private ItemDao itemDao;

	private Product product ;
	
	@PostConstruct
	private void init(){
		product = new Product();
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

	public void add() {
		this.productDao.add(product);
		String mensage = "O Produto: "+ product.getName() + " Foi adcionado!";
		product = new Product();		
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Opera��o Realizada Com sucesso", mensage);
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	/*

	public String delete(Product product) {
		productDao.delete(product);
		return "index?faces-redirect=true";

	}*/
	
	public void delete(Product product) {
		productDao.delete(product);
		String mensage = "O Produto: "+ product.getName() + " Foi Deletado!";
		product = new Product();		
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Opera��o Realizada Com sucesso", mensage);
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}

	public void update() {
		productDao.update(product);
		String mensage = "O Produto: "+ product.getName() + " Foi Atualizado!";
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Opera��o Realizada Com sucesso", mensage);
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}	
	
	public String editProduct() {
		return "editProduct";
	}


	public String voltar(){
		return "listProducts";
	}
	
}
