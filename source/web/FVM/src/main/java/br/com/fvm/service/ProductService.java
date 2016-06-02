package br.com.fvm.service;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import br.com.fvm.model.Product;
import br.com.fvm.model.dao.ProductDao;
@Path("/Product")

public class ProductService {
	@EJB
	ProductDao productDao;
	
	@POST
	@Produces({ MediaType.TEXT_PLAIN+";charset=UTF-8"})
	@Consumes("application/json")
	@Path("/saveUser")
	// @Produces ( MediaType.TEXT_PLAIN )
	public String saveProduct(String  body) {
		Gson gson=new Gson();
		Product product=gson.fromJson(body, Product.class);
		productDao.add(product);
		return "O produto -> "+product.getName()+" foi adicionado com sucesso!";
	}
	
	@PUT
	@Produces({ MediaType.TEXT_PLAIN+";charset=UTF-8"})
	@Consumes("application/json")
	@Path("/updateUser")
	// @Produces ( MediaType.TEXT_PLAIN )
	public String updateProduct(String  body) {
		Gson gson = new Gson();
		Product product=gson.fromJson(body, Product.class);
		productDao.update(product);
		return "O produto -> "+product.getName()+" foi Atualizado com sucesso!";
	}
	
	@DELETE
	@Produces({ MediaType.TEXT_PLAIN+";charset=UTF-8"})
	@Consumes("application/json")
	@Path("/deleteUser/{id}")
	// @Produces ( MediaType.TEXT_PLAIN )
	public String deleteProduct( @PathParam("id") int id) {
		Product product=productDao.getById(id);
		productDao.delete(product);
		return "O produto -> "+product.getName()+" foi removido do banco de dados com sucesso!";
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON+";charset=UTF-8"})
	@Path("/getOne/{id}")
	// @Produces ( MediaType.TEXT_PLAIN )
	public String getProductById( @PathParam("id") int id) {
		Product product= productDao.getById(id);
		Gson gson = new Gson();
		return gson.toJson(product);
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON+";charset=UTF-8"})
	@Path("/getAll")
	// @Produces ( MediaType.TEXT_PLAIN )
	public String getProductUsers( ) {
		Gson gson = new Gson();
		return gson.toJson(productDao.getAll());
	}
	
}
