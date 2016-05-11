package br.com.fvm.service.client;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.google.gson.Gson;

import br.com.fvm.model.User;

public class ClientRest {

	// Client client1 = ClientBuilder.newBuilder().build();
	// WebTarget target = client1.target("http://foo.com/resource");
	// Response response = target.request().get();
	// String value = response.readEntity(String.class);
	// response.close(); // You should close connections!

	public static void main(String[] args) {
		
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target("http://localhost:8080/FVM/service/user/getById/4");
		Response response = target.request().get();
		String value = response.readEntity(String.class);
		Gson gson = new Gson();
		User user = gson.fromJson(value, User.class);
		
		
		System.out.println(value);
		System.out.println(user);
		
		User userPost=new User();
		userPost.setId(6);
		userPost.setName("novo Usuario");
		userPost.setEmail("nomo_email.novo");
		userPost.setPassowrd("1234");
		userPost.setLogin("uhuh");
		String requestJson=gson.toJson(userPost);
		System.out.println("\n\n"+requestJson+"\n\n");
		Entity<String>userJson=Entity.entity(requestJson,MediaType.APPLICATION_JSON);
		
		 
         target = client.target("http://localhost:8080/FVM/service/user/saveUser");  
         response=target.request().post(userJson);
         response.close();
	}

}
