package com.topjavatutorial.dao;
 
import java.util.ArrayList;
import java.util.List;
 
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
 
public class CustomerDAO {
    
    public void addCustomer(Customer customer){
        Session session = SessionUtil.getSession();        
        Transaction tx = session.beginTransaction();
        //addEmployee(session,bean);        
        session.save(customer);
        tx.commit();
        session.close();
        
    }
       
    public List<Customer> getCustomers(){
        Session session = SessionUtil.getSession();    
        Query query = session.createQuery("from Customer");
        //Query query = session.createQuery("from Employee");
        //@SuppressWarnings("unchecked")
		//List<Employee> employees = query.list();
		List<Customer> customers = query.list();
		//List<Customer> customers = new ArrayList<Customer>();
        session.close();
        return customers;
    }
    
    public Customer getCustomer(int id){
        Session session = SessionUtil.getSession();    
        String hql = "from Customer where id = :id";
        Query query = session.createQuery(hql);
        query.setInteger("id",id);
        //Customer customer = new Customer();
        
        Customer customer =  (Customer) query.uniqueResult();
        session.close();
        return customer;
    }
 
    public int deleteCustomer(int id) {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "delete from Customer where id = :id";
        Query query = session.createQuery(hql);
        query.setInteger("id",id);
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();
        return rowCount;
    }
    
    public int updateCustomer(int id, Customer customer){
         if(id <=0)  
               return 0;  
         Session session = SessionUtil.getSession();
            Transaction tx = session.beginTransaction();
            String hql = "update Customer set name = :name, url=:url where id = :id";
            Query query = session.createQuery(hql);
            query.setInteger("id",id);
            query.setString("name",customer.getName());
            //query.setInteger("age",customer.getAge());
            query.setString("url",customer.getUrl());
            int rowCount = query.executeUpdate();
            System.out.println("Rows affected: " + rowCount);
            tx.commit();
            session.close();
            return rowCount;
    }
}