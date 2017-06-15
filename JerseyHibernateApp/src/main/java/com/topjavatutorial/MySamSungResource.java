package com.topjavatutorial;
 
import java.util.List;
//import com.topjavatutorial.CustomerDAO
 
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.topjavatutorial.dao.Customer;
import com.topjavatutorial.dao.CustomerDAO;
 
//import com.topjavatutorial.dao.Customer;
//import com.topjavatutorial.dao.SSCustomerDAO;
 
//http://localhost:8080/JerseyHibernateApp/webapi/getCustomer?id=5
 
@Path("/customers")
public class MySamSungResource {
 
    @GET
    //@Path("/{id}")
    //@Path("/getCustomer")
    @Produces("application/json")
    public List<Customer> getCustomers() {
    	CustomerDAO dao = new CustomerDAO();
        List<Customer> customers = dao.getCustomers();
        //return (List<Employee>) Response.ok().entity(employees).build();
        //return employee;
    	
        return customers;
    }

    @GET
    //@Path("/{id}")
    @Path("/getCustomer/{id}")
    @Produces("application/json")
    public Customer getCustomer(@PathParam("id") int id) {
    	CustomerDAO dao = new CustomerDAO();
        Customer customer = dao.getCustomer(id);
        //return (List<Employee>) Response.ok().entity(employees).build();
        //return employee;
    	
        return customer;
    }
}
