package br.com.fvm.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/Ponto")
public class Ponto {

	@GET
	@Path ("/getPonto")
	public void getXPonto() {
		System.out.println("cordenada: "); 	
	}
	
	
}
