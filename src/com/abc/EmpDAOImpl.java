package com.abc;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class EmpDAOImpl implements EmpDAO 
{
	private static final String Update_Email="update Empdetails set mail=:newmail where no=:Eid";
	private static final String DELETE_EMP="delete from Empdetails where no=:Eid";

public boolean modifyEmail(int no, String newmail)
	{
	   Session ses=Hibernateutil.getSession();
	   
	   Query q1=ses.createQuery(Update_Email);
	   q1.setString("newmail", newmail);
	   q1.setInteger("Eid", no);
	   
	   Transaction tx=null;
	   try
	   {
		   tx=ses.beginTransaction();
		   q1.executeUpdate();
		   System.out.println("update successfully");
		   
		   
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
		   tx.rollback();
		   
	   }
	    tx.commit();
		return false;
	}

	public boolean removeEmp(int no) 
	{
		Session ses=Hibernateutil.getSession();
		Query q2=ses.createQuery(DELETE_EMP);
		q2.setInteger("Eid",no);
		Transaction tx=null;
		try
		{
			tx=ses.beginTransaction();
			q2.executeUpdate();
			tx.commit();
			System.out.println("deleted successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		return false;
	}

	

	


	
}
