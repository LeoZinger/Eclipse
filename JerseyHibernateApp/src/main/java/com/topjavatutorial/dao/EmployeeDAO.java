package com.topjavatutorial.dao;
 
import java.util.List;
 
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
 
public class EmployeeDAO {
    
    public void addEmployee(Employee emp){
        Session session = SessionUtil.getSession();        
        Transaction tx = session.beginTransaction();
        //addEmployee(session,bean);        
        session.save(emp);
        tx.commit();
        session.close();
        
    }
       
    public List<Employee> getEmployees(){
        Session session = SessionUtil.getSession();    
        Query query = session.createQuery("from Employee");
        List<Employee> employees =  query.list();
        session.close();
        return employees;
    }
    
    public Employee getEmployee(int id){
        Session session = SessionUtil.getSession();    
        String hql = "from Employee where id = :id";
        Query query = session.createQuery(hql);
        query.setInteger("id",id);
        
        Employee employee =  (Employee) query.uniqueResult();
        session.close();
        return employee;
    }
 
    public int deleteEmployee(int id) {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "delete from Employee where id = :id";
        Query query = session.createQuery(hql);
        query.setInteger("id",id);
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();
        return rowCount;
    }
    
    public int updateEmployee(int id, Employee emp){
         if(id <=0)  
               return 0;  
         Session session = SessionUtil.getSession();
            Transaction tx = session.beginTransaction();
            String hql = "update Employee set name = :name, age=:age where id = :id";
            Query query = session.createQuery(hql);
            query.setInteger("id",id);
            query.setString("name",emp.getName());
            query.setInteger("age",emp.getAge());
            int rowCount = query.executeUpdate();
            System.out.println("Rows affected: " + rowCount);
            tx.commit();
            session.close();
            return rowCount;
    }
}