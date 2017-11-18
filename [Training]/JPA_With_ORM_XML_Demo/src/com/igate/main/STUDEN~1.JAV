package com.igate.main;
import com.igate.entity.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class StudentClient {
   private EntityManager em;
   private EntityManagerFactory emf;
   
   public void initEmfAndEm()
   {
       emf=Persistence.createEntityManagerFactory("JPAEntityPU");
       em=emf.createEntityManager();
   }
   public void cleanup()
   {
        em.close();
   }
   public void insertAndRetrieve()
   {
      System.out.println("-------------------Creating the Objects---------------------");
      Student studentObj1=new Student();   
     studentObj1.setStudentName("Jack");
      studentObj1.setStudentMarks(90.5);
      
      
      Student studentObj2=new Student();   
      studentObj2.setStudentName("Tom");
       studentObj2.setStudentMarks(99.3);
       
        
      System.out.println("-------------------Starting the transaction---------------------");
      em.getTransaction().begin();
      em.persist(studentObj1);
      em.persist(studentObj2);
      System.out.println("-------------------Committing the transaction---------------------");
      em.getTransaction().commit();
      System.out.println("-------------------Objects saved successfully--------------------");
      System.out.println("*******************************************************************");
      System.out.println("------------------- Reading Objects--------------------");
      List students=em.createQuery("SELECT s FROM Student s").getResultList();
      for (Object current :students )
          System.out.println(current);
      System.out.println("-------------------Finished Reading Objects--------------------");
   }
   public static void main(String args[])
   {	   
	   
       StudentClient myClient=new StudentClient();
       System.out.println("-------------------Starting the Client---------------------");
       myClient.initEmfAndEm();
       myClient.insertAndRetrieve();
       myClient.cleanup();
       System.out.println("---------------Shutting down the Client---------------------");
    /*   
	   EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPAEntityPU");
	   EntityManager em=emf.createEntityManager();
	   em.getTransaction().begin();
	   Employee empObj1=new Employee();
	   empObj1.setEmpId(30);
	   empObj1.setEmpName("sarba");
	   empObj1.setEmpSalary(8000);
	  em.merge(empObj1);
	  em.getTransaction().commit();
	   System.out.println(" emp created");
	   
*/	   
   }
}//End of EmpClient.java
