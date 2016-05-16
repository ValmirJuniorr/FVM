package br.com.fvm.service;

import java.util.List;

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

import br.com.fvm.model.User;
import br.com.fvm.model.dao.UserDao;

@Path("/user")
public class UserService {
	
	@EJB
	UserDao userDao;
	
	@POST
	@Produces({ MediaType.TEXT_PLAIN+";charset=UTF-8"})
	@Consumes("application/json")
	@Path("/saveUser")
	// @Produces ( MediaType.TEXT_PLAIN )
	public String saveUser(String  body) {
		Gson gson=new Gson();
		User user=gson.fromJson(body, User.class);
		userDao.add(user);
		return "O usuario -> "+user.getName()+" foi adicionado com sucesso!";
	}
	
	@PUT
	@Produces({ MediaType.TEXT_PLAIN+";charset=UTF-8"})
	@Consumes("application/json")
	@Path("/updateUser")
	// @Produces ( MediaType.TEXT_PLAIN )
	public String updateUser(String  body) {
		Gson gson = new Gson();
		User user=gson.fromJson(body, User.class);
		userDao.update(user);
		return "O usuario -> "+user.getName()+" foi Atualizado com sucesso!";
	}
	
	@DELETE
	@Produces({ MediaType.TEXT_PLAIN+";charset=UTF-8"})
	@Consumes("application/json")
	@Path("/deleteUser/{id}")
	// @Produces ( MediaType.TEXT_PLAIN )
	public String deleteUser( @PathParam("id") int id) {
		User user=userDao.getById(id);
		userDao.delete(user);
		return "O usuario -> "+user.getName()+" foi removido do banco de dados com sucesso!";
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON+";charset=UTF-8"})
	@Path("/getById/{id}")
	// @Produces ( MediaType.TEXT_PLAIN )
	public String getUserById( @PathParam("id") int id) {
		User user= userDao.getById(id);
		Gson gson = new Gson();
		return gson.toJson(user);
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON+";charset=UTF-8"})
	@Path("/getAll")
	// @Produces ( MediaType.TEXT_PLAIN )
	public String getUsers( ) {
		Gson gson = new Gson();
		return gson.toJson(userDao.getAll());
	}
	
	
	

}
