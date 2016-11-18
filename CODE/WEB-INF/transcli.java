import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Transcli extends HttpServlet
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
	
			   	String ac=req.getParameter("acno");
				String name=req.getParameter("uname");
				String pass=req.getParameter("pwd");
				String tacc=req.getParameter("tacno");
				String amt=req.getParameter("amt");
				PrintWriter out= res.getWriter();
				Statement st=con.createStatement();
				String ds="select * from deposit where acno='"+ac+"'";
				ResultSet rs=st.executeQuery(ds1);
			while(rs.next())
					{
				//out.println("Your account balance is:"+rs.getString("amo1"));
				//String amount=rs.getString("amo1");
					out.println("Your account balance is:"+rs.getString("amo1"));
						String amount=rs.getString("amo1");
				String ds="set amount=amnt+amt where amo1='' from deposit";
				rs=st.executeQuery(ds);
							   pst=con.prepareStatement("insert into deposit values(?,?,?,?)");
			 //		PrintWriter pw= res.getWriter();
				 System.out.println(acno);
				 System.out.println(uname);
				 System.out.println(pwd);
				 System.out.println(tacno);
 				 System.out.println(amount);
				pst.setString(1,ac);
				pst.setString(2,name);
                pst.setString(3,pass);
				pst.setString(4,pass);
                pst.setString(5,amount);
				int rec =pst.executeUpdate();


					 }
			  }

			  catch(Exception ee){ee.printStackTrace();}
	}
}			 	