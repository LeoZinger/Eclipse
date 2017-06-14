package com.topjavatutorial;
  
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;
 

@Path("/Math")
//@Path("/")
public class SimpleAddition {
 
    @GET
    @Path("/add/{a}/{b}")
    //@Produces("application/json")
    public Response add(@PathParam("a") int a, @PathParam("b") int b) {
        int result = a + b;
        //String  = new JSONObject();
        String json = new String("{addition result : "+ result + "}");
        /*
        JSONObject json = new JSONObject(); //Doesn't work. 500 Server Java Exception error.
        String resultStr = String.valueOf(result);
        try {
			json.put("addition result : ", resultStr);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        */
        return Response.ok().entity(json).build(); //ok, works
        //return Response.ok().entity(json).build(); //ok, works
        //return "fahrenheit="+fahrenheit; //ok, works
        //return result; //ok, works
    }
}
