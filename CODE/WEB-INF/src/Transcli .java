import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class transcli extends HttpServlet
{
          PreparedStatement pst=null;
             Connection con=null;

	public void init()throws ServletException
	{

	 try{ Class.forName( "oracle.jdbc.driver.OracleDriver");
		   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
	      System.out.println("Looking for Server .........");
             }catch(Exception e){System.out.println(e);}
	}

	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
            try
				{
			
			   	String ac=req.getParameter("acno");
				String name=req.getParameter("uname");
				String pass=req.getParameter("pwd");
				String tacc=req.getParameter("tacno");
				int amt=Integer.parseInt(req.getParameter("amt"));
				PrintWriter out= res.getWriter();
				Statement st=con.createStatement();
				String ds1="select * from open1 where aname='"+ac+"'";
				ResultSet rs1=st.executeQuery(ds1);
				String ds2="select * from open1 where aname='"+ac+"'";
				ResultSet rs2=st.executeQuery(ds2);
				while(rs1.next())
					{
				int amnt=Integer.parseInt(rs1.getString(3));
				int a=amnt-amt;
				String st1="update open1 set amo1='"+a+"' where aname='"+ac+"'";
				out.println("Your account balance is:"+a);
				int rec =st.executeUpdate(st1);
				while(rs2.next())
					{
				int amnt=Integer.parseInt(rs2.getString(3));
				int a1=amnt-amt;
				String st2="update open1 set amo1='"+a1+"' where aname='"+ac+"'";
				out.println("Your account balance is:"+a1);
				int rec =st.executeUpdate(st2);				

					}

				
			  }

			  catch(Exception ee){ee.printStackTrace();}
	}
}			
	
			   	