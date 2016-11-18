import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Closecli extends HttpServlet
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
				String pass=req.getParameter("pass");
				int amt=Integer.parseInt(req.getParameter("amt"));
				PrintWriter out= res.getWriter();
				Statement st=con.createStatement();
				String ds="select * from open1 where aname='"+ac+"'";
				ResultSet rs=st.executeQuery(ds);
				while(rs.next())
					{
				String st1="delete open1 where aname='"+ac+"'";
				out.println("The current record is deleted"+ac);
				int rec =st.executeUpdate(st1);
				
					}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
