package Registration_Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

 class registration
{
	String name,password,conpassword,email_id,url,uer,qurey;
	int id;
	long contact;
	void registerData () throws ClassNotFoundException, SQLException
	{
	Scanner  sc = new Scanner(System.in);
	System.out.println("Enter name");
	name = sc.next();
	System.out.println("enter password");
	password = sc.next();
	System.out.println("enter conpassword");
	conpassword = sc.next();
	
	if(password.equals(conpassword))
	{
		System.out.println("enter email");
		email_id = sc.next();
		
		System.out.println("enter contact");
		contact = sc.nextLong();
		String url,user,pass;
		url = "jdbc:mysql://localhost:3306/Authentication";																																																				user = "root";
		pass = "Vs_vishnu@";
		String query = "insert into Registration_login(name,email_id,password,conpassword,contact) values(?,?,?,?,?)"; 
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url,user,pass);
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, name);
		ps.setString(2,email_id);
		ps.setString(3,password);
		ps.setString(4,conpassword);
		ps.setLong(5, contact);	
		
		int i = ps.executeUpdate();
		
		if(i>0) 
		{
			System.out.println("Registration Successfull...");
		}
		else
		{
			System.out.println("Registration Failed...Please try after sometime.");
		}
	}
	else
	{
		System.out.println("Password does'nt match...");
	}
	}
 void login() throws ClassNotFoundException, SQLException 
 {
	 Scanner sc = new Scanner(System.in);
	 String url,user,pass,query;
	 url = "jdbc:mysql://localhost:3306/Authentication";
	 user = "root";
     pass = "Vs_vishnu@";
     
     query = "select * from registration_login where email_id = ? and password =?"; 
    System.out.println("Enter email_id :");
    String email_id = sc.next();
    System.out.println("Enter password");
    password = sc.next();
    
    Connection conn = DriverManager.getConnection(url,user,pass);
	PreparedStatement ps = conn.prepareStatement(query);
	ps.setString(1, email_id);
	ps.setString(2, password);
	
	ResultSet rs = ps.executeQuery();
	
	if(rs.next())
	{
		System.out.println("Login success");
	}
	else
	{
		System.out.println("Login Failed");
	}
	}
}
public class registration1
{
	public static void main(String...args) throws ClassNotFoundException, SQLException
	{
		int choice;
		registration r1 =  new registration ();
		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.println("1>Registration\n2> login");
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch(choice)
			{
			case 1:			
				r1.registerData();
			break;
				case 2:
				r1.login();
		   break;
			}
	}while(choice <2);
	}
	}