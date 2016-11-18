import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Opencli extends HttpServlet
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

	public void doPost(HttpServletRequest srq,HttpServletResponse res)throws ServletException,IOException
	{
            try
				{
				PrintWriter out= res.getWriter();
                pst=con.prepareStatement("insert into open1 values(?,?,?,?,?,?,?)");
    	     String aname=srq.getParameter("ANAME");
			 String uname=srq.getParameter("UNAME");
			 //out.println(uname);
		     String pwd=srq.getParameter("PWD");
		     String cwd=srq.getParameter("CPWD");
		     String addr=srq.getParameter("ADD");
		     int phone=Integer.parseInt(srq.getParameter("PHO"));
		     int amo=Integer.parseInt(srq.getParameter("AMT"));
             res.setContentType("text/html");
			 System.out.println(aname);
                System.out.println(uname);
                 System.out.println(pwd);
				 System.out.println(cwd);
				 System.out.println(addr); 
                pst.setString(7,aname);
				pst.setString(1,uname);
                pst.setString(2,pwd);
                pst.setString(6,cwd);
                pst.setString(4,addr);
                pst.setInt(5,phone);
                pst.setInt(3,amo);
                int rec =pst.executeUpdate();
                if(rec>0)
               {
				out.println("<h1>welcome to website</h1>");
	            //out.println("<a href=Main2.html><h1>HOME</h1></a>");
					 }
			  }

			  catch(Exception ee){ee.printStackTrace();}
	}
}