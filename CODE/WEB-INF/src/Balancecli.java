import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Balancecli extends HttpServlet
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
				String name=req.getParameter("username");
				String pass=req.getParameter("password");
				//String amt=req.getParameter("amt");
				PrintWriter out= res.getWriter();
				Statement st=con.createStatement();
				String ds="select amo1 from open1 where aname1='"+ac+"'";
				ResultSet rs=st.executeQuery(ds);
				while(rs.next())
					{
						out.println("Your account balance is:"+rs.getString("amount"));
						int rec =pst.executeUpdate();

					 }
			  }

			  catch(Exception ee){ee.printStackTrace();}
	}
}			
	
					
		/*	pw.println("<HTML><BODY><FONT COLOR=RED>acno " + ac +"</FONT></BODY></HTML>name "+  name +"</FONT></BODY></HTML>");
	        //b=(Details)Naming.lookup("http://localhost:9090/bank");
			pw.println("<HTML><BODY><FONT COLOR=RED>Balance in U R account is  :   " +b.open1(ac,name,pass)+"</FONT></BODY></HTML>");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}*/
