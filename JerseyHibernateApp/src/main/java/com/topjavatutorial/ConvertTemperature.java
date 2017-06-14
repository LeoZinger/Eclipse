package com.topjavatutorial;
  
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
 

@Path("/cToFService")
public class ConvertTemperature {
 
    @GET
    @Path("{c}")
    @Produces("application/json")
    public String cToF(@PathParam("c") int celsius) {
        int fahrenheit = (celsius* 9) /5 + 32;
        //String  = new JSONObject();
        String  json = new String("{Fahrenheit : "+fahrenheit + "}");
        //return Response.ok().entity(json).build();
        //return "fahrenheit="+fahrenheit;
        return json;
    }
}
 
