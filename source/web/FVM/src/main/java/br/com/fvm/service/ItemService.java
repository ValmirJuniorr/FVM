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

import br.com.fvm.model.Item;
import br.com.fvm.model.dao.ItemDao;
@Path("/item")
public class ItemService {
	@EJB
	ItemDao itemDao;
	
	@POST
	@Produces({ MediaType.TEXT_PLAIN+";charset=UTF-8"})
	@Consumes("application/json")
	@Path("/saveItem")
	// @Produces ( MediaType.TEXT_PLAIN )
	public String saveItem(String  body) {
		Gson gson=new Gson();
		Item item=gson.fromJson(body, Item.class);
		itemDao.add(item);
		return "O item -> "+item.getName()+" foi adicionado com sucesso!";
	}
	
	@PUT
	@Produces({ MediaType.TEXT_PLAIN+";charset=UTF-8"})
	@Consumes("application/json")
	@Path("/updateItem")
	// @Produces ( MediaType.TEXT_PLAIN )
	public String updateItem(String  body) {
		Gson gson = new Gson();
		Item item=gson.fromJson(body, Item.class);
		itemDao.update(item);
		return "O item -> "+item.getName()+" foi Atualizado com sucesso!";
	}
	
	@DELETE
	@Produces({ MediaType.TEXT_PLAIN+";charset=UTF-8"})
	@Consumes("application/json")
	@Path("/deleteUser/{id}")
	// @Produces ( MediaType.TEXT_PLAIN )
	public String deleteItem( @PathParam("id") int id) {
		Item item=itemDao.getById(id);
		itemDao.delete(item);
		return "O item -> "+item.getName()+" foi removido do banco de dados com sucesso!";
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON+";charset=UTF-8"})
	@Path("/getOne/{id}")
	// @Produces ( MediaType.TEXT_PLAIN )
	public String getItemById( @PathParam("id") int id) {
		Item item= itemDao.getById(id);
		Gson gson = new Gson();
		return gson.toJson(item);
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON+";charset=UTF-8"})
	@Path("/getAll")
	// @Produces ( MediaType.TEXT_PLAIN )
	public String getItens( ) {
		Gson gson = new Gson();
		return gson.toJson(itemDao.getAll());
	}
	

}
