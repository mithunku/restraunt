package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.customer;

public class Mydao {

	EntityManagerFactory e=Persistence.createEntityManagerFactory("dev");
	EntityManager em=e.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	
	public void save(customer c)
	{
		et.begin();
		try {
		em.persist(c);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		et.commit();
	}


	public customer fetchByEmail(String email) {
		// TODO Auto-generated method stub
	    Query query = em.createQuery("select x from customer x where email=?1").setParameter(1, email);
	    List<customer> list = query.getResultList();
	    if(list.isEmpty())
	    {
	    	return null;
	    }
	    else
	    {
	    	return list.get(0);
	    }
	}


	public customer fetchByMobile(long phno) {
		// TODO Auto-generated method stub
		 Query query = em.createQuery("select x from customer x where phno=?1").setParameter(1, phno);
		    List<customer> list = query.getResultList();
		    if(list.isEmpty())
		    {
		    	return null;
		    }
		    else
		    {
		    	return list.get(0);
		    }
	}


	public customer validateEmail(String email) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select x from customer x where fullname=?1").setParameter(1, email);
	    List<customer> list = query.getResultList();
	    if(list.isEmpty())
	    {
	    	return null;
	    }
	    else
	    {
	    	return list.get(0);
	    }
		
	}
	
	public customer validatePassword(String pass) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select x from customer x where password=?1").setParameter(1, pass);
	    List<customer> list = query.getResultList();
	    if(list.isEmpty())
	    {
	    	return null;
	    }
	    else
	    {
	    	return list.get(0);
	    }
		
	}
	
	
	
}
