package br.com.fvm.service.client;

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
		ResteasyWebTarget target = client.target("http://localhost:8080/FVM/service/user/getById/5");
		Response response = target.request().get();
		String value = response.readEntity(String.class);
		Gson gson = new Gson();
		User user = gson.fromJson(value, User.class);
		response.close();
		System.out.println(value);
		System.out.println(user);
	}

}
