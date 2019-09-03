package com.jribero.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.jribero.dao.PersonaServiceImpl;
import com.jribero.model.Persona;



@Path("/Persona")
@Produces("application/json")
public class PersonaService {
	
	//URI:
	// /contextPath/rest/Persona
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Persona> getPersonas_JSON() throws SQLException, NamingException{

		PersonaServiceImpl k = new PersonaServiceImpl();
		List<Persona>listOfPersonas = k.getAllQuery();
		return listOfPersonas;
	}
	
	// URI:
	// /contextPath/rest/Persona/{documento]
	@GET
	@Path("/{documento}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getPersona(@PathParam("documento") String doc) throws JsonGenerationException, JsonMappingException, IOException, NamingException {

		PersonaServiceImpl k = new PersonaServiceImpl();
		String p = k.getSingleQuery(doc);
		if (p.contains("Error")) {
			return Response.status(Response.Status.NOT_FOUND).entity(p).build();
		}
		return Response.ok(p,MediaType.APPLICATION_JSON).build();
	}
	
	// URI:
	// /contextPath/rest/Persona
	@POST
	@Path("/{documento}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response addPersona(@PathParam("documento")String doc,Persona per) throws SQLException, NamingException, JsonGenerationException, JsonMappingException, IOException {

		if (!doc.equals(per.getDocumento())) {
			return Response.serverError().entity("Error: El documento enviado no coincide con los parámetros.").build();
		}
		if (per.getDocumento() == null) {
			return Response.serverError().entity("Error: El parámetro documento es obligatorio.").build();
		}
		if (per.getNombre() == null || per.getNombre().trim().length()==0) {
			return Response.serverError().entity("Error: El parámetro nombre es obligatorio.").build();
		}
		if (per.getApellido() == null || per.getApellido().trim().length()==0) {
			return Response.serverError().entity("Error: El parámetro apellido es obligatorio.").build();
		}
		if (per.getEdad() == null || per.getEdad().trim().length() == 0) {
			return Response.serverError().entity("Error: El parámetro edad es obligatorio.").build();
		}
		if (per.getEmail() == null || per.getEmail().trim().length() == 0) {
			return Response.serverError().entity("Error: El parámetro email es obligatorio.").build();
		}
		//Persona p1 = PersonaDao.addPersona(per);	
		PersonaServiceImpl k = new PersonaServiceImpl();
		String json = k.createQuery(per,doc);
		if (json.contains("Error")) {
			return Response.status(Response.Status.FOUND).entity(json).build();
		}
		return Response.ok(json,MediaType.APPLICATION_JSON).build();
	}
	
	// URI:
	// contextPath/rest/Persona
	@PUT
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response updatePersona(Persona per) throws JsonGenerationException, JsonMappingException, IOException, SQLException, NamingException {
		

		if (per.getDocumento() == null || per.getDocumento().trim().length()==0) {
			return Response.serverError().entity("Error: El parámetro documento es obligatorio.").build();
		}
		if (per.getNombre() == null || per.getNombre().trim().length()==0) {
			return Response.serverError().entity("Error: El parámetro nombre es obligatorio.").build();
		}
		if (per.getApellido() == null || per.getApellido().trim().length()==0) {
			return Response.serverError().entity("Error: El parámetro apellido es obligatorio.").build();
		}
		if (per.getEdad() == null || per.getEdad().trim().length() == 0) {
			return Response.serverError().entity("Error: El parámetro edad es obligatorio.").build();
		}
		if (per.getEmail() == null || per.getEmail().trim().length() == 0) {
			return Response.serverError().entity("Error: El parámetro email es obligatorio.").build();
		}
		
		PersonaServiceImpl k = new PersonaServiceImpl();
		String json = k.updateQuery(per);
		if (json.contains("Error")) {
			return Response.status(Response.Status.NOT_FOUND).entity(json).build();
		}
		return Response.ok(json,MediaType.APPLICATION_JSON).build();
	}
	
	// URI:
	// /contextPath/rest/Persona/{documento}
	@DELETE
	@Path("/{documento}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response deletePersona(@PathParam("documento")String doc) throws SQLException, NamingException {
		
		PersonaServiceImpl k = new PersonaServiceImpl();
		String json = k.deleteQuery(doc);
		if (json.contains("Error")) {
			return Response.status(Response.Status.NOT_FOUND).entity(json).build();
		}
		return Response.ok(json,MediaType.APPLICATION_JSON).build();
	}
}