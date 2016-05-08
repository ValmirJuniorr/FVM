package br.com.fvm.service;



import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

@Path("/mapa")
public class OpaResource {

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	// @Produces ( MediaType.TEXT_PLAIN )
	public String helloResource(@QueryParam("x") int x, @QueryParam("y") int y) {
		Resposta resposta=new Resposta();
		resposta.setTitle("coordenada");
		resposta.setX(x);
		resposta.setY(y);
		Gson gson = new Gson();
		return gson.toJson(resposta);
	}

	
	@POST
	@Path ( "  /json / xml " )
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes ( MediaType.APPLICATION_JSON )
	// @Produces ( MediaType.TEXT_PLAIN )
	public String jsonResource(@QueryParam("x") int x, @QueryParam("y") int y) {
		Resposta resposta=new Resposta();
		resposta.setTitle("coordenada");
		resposta.setX(x);
		resposta.setY(y);
		Gson gson = new Gson();
		return gson.toJson(resposta);
	}
	
	@POST
	@Path ( " / json / xml " )
	@Consumes ( MediaType . APPLICATION_JSON )
	@Produces ( MediaType . APPLICATION_XML )
	public Resposta transformToXML ( Resposta p ) {
	return p ;
	}
	
}
