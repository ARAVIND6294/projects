package com.abc;

public class Test 
{

	public static void main(String[] args) 
	{
		EmpDAO dao=EmpDAOFactory.getDAOInstance();
		//System.out.println(dao.register(1003, "harish", "vallabaneni", "ddd@gmail.com"));
		//System.out.println(dao.modifyEmail(1002, "fff@gmail.com"));

		System.out.println(dao.removeEmp(1002));
	}

}
