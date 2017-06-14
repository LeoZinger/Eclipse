package com.topjavatutorial;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserRestService {

	@GET
	@Path("{id}")
	//public String getUserById(@PathParam("id") String id) {
	public Response getUserById(@PathParam("id") String id) {

		
		//String id_str = id.toString();
		
		return Response.status(200).entity("getUserById is called, id : " + id).build();
		//return "Leo: getUserById is called, id = " + id_str;

	}

}