package br.com.fvm.service.client;

import java.lang.reflect.Type;
import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.fvm.model.User;

public class ClientRest {

	// Client client1 = ClientBuilder.newBuilder().build();
	// WebTarget target = client1.target("http://foo.com/resource");
	// Response response = target.request().get();
	// String value = response.readEntity(String.class);
	// response.close(); // You should close connections!

	public static void main(String[] args) {
		// User user = new User();
		// user.setId(7);
		// user.setName("Junior");
		// user.setEmail("valmir_junyor@hotmail.com");
		// user.setPassowrd("1234");
		// user.setLogin("uhuh");		
		//getOne(7);
		//add(user);
		//update(user);
		//delete(4);
		List<User> users=getAll();
		for (User user : users) {
			System.out.println("valor do Usuario: "+user);
		}
		System.out.println(users.size());
	}
	
	public static void add(User user){
		Gson gson = new Gson();
		String requestJson = gson.toJson(user);
		Entity<String> userJson = Entity.entity(requestJson, MediaType.APPLICATION_JSON);

		ResteasyClient clientPost = new ResteasyClientBuilder().build();
		ResteasyWebTarget targetPost = clientPost.target("http://localhost:8080/FVM/service/user/saveUser");
		Response response = targetPost.request().post(userJson);
		String value = response.readEntity(String.class);
		response.close();
		System.out.println("retornou: " + value);
	}
	
	public static void update(User user){
		Gson gson = new Gson();
		String requestJson = gson.toJson(user);		
		Entity<String> userJson = Entity.entity(requestJson, MediaType.APPLICATION_JSON);

		ResteasyClient clientPost = new ResteasyClientBuilder().build();
		ResteasyWebTarget targetPost = clientPost.target("http://localhost:8080/FVM/service/user/updateUser");
		Response response = targetPost.request().put(userJson);
		String value = response.readEntity(String.class);
		response.close();
		System.out.println("retornou: " + value);
	}
	
	public static void delete(int id){
		ResteasyClient clientPost = new ResteasyClientBuilder().build();
		ResteasyWebTarget targetPost = clientPost.target("http://localhost:8080/FVM/service/user/deleteUser/"+id);
		Response response = targetPost.request().delete();
		String value = response.readEntity(String.class);
		response.close();
		System.out.println("retornou: " + value);
	}
	
	public static User getOne(int id){
		Gson gson = new Gson();
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target("http://localhost:8080/FVM/service/user/getOne/"+id);
		Response response = target.request().get();
		String value = response.readEntity(String.class);		
		User user = gson.fromJson(value, User.class);
		System.out.println(user);
		return user;
	}
	
	public static List<User> getAll(){
		Gson gson = new Gson();
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target("http://localhost:8080/FVM/service/user/getAll");
		Response response = target.request().get();
		String value = response.readEntity(String.class);
		Type listType = new TypeToken<List<User>>(){}.getType();
		List<User> users = gson.fromJson(value, listType);		
		return users;
	}

}
