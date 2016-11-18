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
				PrintWriter out= res.getWriter();
				Statement st=con.createStatement();
			String ds="select * from open1 where aname='"+ac+"'";
			ResultSet rs=st.executeQuery(ds);
			out.println("<HTML><CENTER><BODY><br><br><br><br>REPORT FOR THE ACCOUNT NO:   "+acno); 
			out.println("<table border=1><thead><td>ACNO</TD><TD>NAME</TD><TD>AMOUNT</TD><TD>TTYPE</TD><TD>DATE</TD></thead>");
			while(rs.next())
			{
			out.println("<tr>");
			out.println("<TD>"+rs.getInt(1)+"</td>");
			out.println("<td>"+rs.getString(2)+"</td>");
			out.println("<td>"+rs.getInt(3)+"</td>");
			out.println("<td>"+rs.getString(4)+"</td>");
			out.println("<td>"+rs.getDate(5)+"</td>");
			out.println("</tr>");
			}
			out.println("</table></body></html>");
	   }catch(Exception ee){
		   System.out.println(ee.toString());}
	}
} 
		
	        