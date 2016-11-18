import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class depocli extends HttpServlet
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
				String amt=req.getParameter("amt");
				PrintWriter out= res.getWriter();
				Statement st=con.createStatement();
				String ds="select * from open1 where aname='"+ac+"'";
				ResultSet rs=st.executeQuery(ds);
				while(rs.next())
					{
				String amnt=rs.getString(7);
				String a=amt+amnt;
				out.println("Your account balance is:"+a);
				int rec =pst.executeUpdate();
					}
				//String ds="update deposit set amo1='"+a+"' where amnt='"+' from open1";
				//ResultSet rs=st.executeUpdate();
				/*while(rs.next())
					{
 				out.println("Your account balance is:"+rs.getString("amount"));
				String amount=rs.getString("amount");
			    pst=con.prepareStatement("insert into deposit values(?,?,?,?)");
				System.out.println(ac);
				System.out.println(name);
				System.out.println(pass);
 				System.out.println(amount);
				pst.setString(1,ac);
				pst.setString(2,name);
                pst.setString(3,pass);
                pst.setString(4,amount);
				int rec =pst.executeUpdate();

					 }*/
			  }

			  catch(Exception ee){ee.printStackTrace();}
	}
}			
	