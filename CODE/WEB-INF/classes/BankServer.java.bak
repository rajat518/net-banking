import java.rmi.*;
import java.sql.*;
import java.util.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class BankServer extends UnicastRemoteObject implements Details
{
   Connection con;
   Statement st,st1,st2,transst;
   ResultSet rs,rstrans;
   int ams;
   int bal; 
	public BankServer()throws RemoteException,Exception
	{
	  super();

	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      con=DriverManager.getConnection("jdbc:odbc:bank","scott","tiger");
	  st=con.createStatement();
  	  st1=con.createStatement();
  	  st2=con.createStatement();
	}

   public int open(String username,String password,int amt,String address,int phone)throws RemoteException
	{
      int Ac=2;
      
	  try{ 

			rs=st.executeQuery("select max(acno) from details");

			if(rs.next())
			{
				  Ac=rs.getInt(1);
				  Ac=Ac+1;
				  System.out.println(Ac);
				  try
				  {
					ResultSet rs1=st1.executeQuery("Insert into details Values("+Ac+",'"+username+"','"+password+"','"+address+"',"+phone+")");
					
				  }
				  catch(Exception e1){System.out.println(e1);}
		    }

ResultSet rs2=st2.executeQuery("Insert into daccount Values("+Ac+","+amt+")");
			System.out.println("Account Created Successfully......");	
		
		}catch(Exception e){System.out.println(e);}
	  
		return Ac;
	}

	public String withdraw(int acno,String username,String password,int amt)
	throws RemoteException
	{
		int am;
		
		try{

			System.out.println("select * from details where acno="+acno+" and " +"Username='"+username+"'");
			Statement st1=con.createStatement();
			ResultSet rs1=st1.executeQuery("select * from details where Username='"+username+"' and password='"+password+"' and acno="+acno);
			if(rs1.next())
			{

				Statement st2=con.createStatement();
				ResultSet rs2=st2.executeQuery("select * from daccount where acno="+acno);
				if(rs2.next())
				{
				  int a=rs2.getInt(2);
				  am=a-amt;
				  
				  if(am>=500)
				  {
				    try{

					     st2.executeUpdate("update daccount set amt="+am+" where acno="+acno);
					     System.out.println("values updated");
                         transst=con.createStatement();
						 rstrans=transst.executeQuery("insert into transbank values("+acno+",'"+username+"',"+am+",'withdraw',sysdate)");
            		   }catch(Exception e){ System.out.println(e);}

                      
					   return String.valueOf(am);
				  }
				  else
					return "U can't withdraw coz bal<300";
				}	
			}
			else
			return "Accno does not exist";
			
		}
		catch(Exception e){System.out.println(e);}

		return "";
	}

	public String deposit(int acno,String username,String password,int amt)
	throws RemoteException
	{

		try
		{
			Statement st1=con.createStatement();
			ResultSet rs=st1.executeQuery("select * from details where acno="+acno+"and username='"+username+"'and password='"+password+"'");
			if(rs.next())
			{
				Statement st2=con.createStatement();
				ResultSet rs2=st2.executeQuery("select * from daccount where acno="+acno);
				if(rs2.next())
				{
					try
					{
					
						int b=rs2.getInt(2);
						ams=b+amt;
						System.out.println("update daccount set amt="+ams+" where acno="+acno);
						st2.executeUpdate("update daccount set amt="+ams+" where acno="+acno);
						System.out.println("updated");
                        transst=con.createStatement();
						String sql = "insert into transbank values("+acno+",'"+username+"',"+ams+",'deposit',sysdate)";
						System.out.println("updated" + sql);
					    rstrans=transst.executeQuery(sql);
					   return String.valueOf(ams);
					}
					catch(Exception e){ System.out.println(e);}
				}
			}
			else
			return "Accno does not exist";
		}
		catch(Exception e){System.out.println(e);}
		return String.valueOf(ams);
	}     

   public String transfer(int acno,String username,String password,int tacno,int amt)
   throws RemoteException
   {
	  try{
			Statement st1=con.createStatement();
			Statement st2=con.createStatement();
			ResultSet rs=st1.executeQuery("select * from details where acno="+acno+" and username='"+username+"'and password='"+password+"'");
			ResultSet rs3=st2.executeQuery("select * from details where acno="+tacno);
			
			if(rs.next())
			{
			 if(rs3.next())
			 {
			  System.out.println("transfer is possible");
			  ResultSet rs1=st1.executeQuery("select amt from daccount where acno="+acno);
			 System.out.println("transfer is possible  "+acno);
			  if(rs1.next())
			  {
				  int k=rs1.getInt(1);
				  System.out.println(k);
				  k=k-amt;
//				  System.out.println(k);

				  if(k>=500)
				  {
			        ResultSet rs2=st1.executeQuery("select amt from daccount where acno="+tacno);
					
					if(rs2.next())
					{
					  int x=rs2.getInt(1)+amt;
					  System.out.println(x); 
					  int y=st1.executeUpdate("update daccount set amt="+k+" where acno="+acno);
					  int z=st1.executeUpdate("update daccount set amt="+x+" where acno="+tacno);
                       Statement transst=con.createStatement();
		               rstrans=transst.executeQuery("insert into transbank values("+acno+" ,'"+username+"' ,"+amt+" ,'transfer',sysdate)")  ;

//					  System.out.println(y);
//					  System.out.println(z);
					  String str="   "+k;
					  return str;
                    }
				  }	
              } 
             }
			 else System.out.println("transfer is not possible");
            
           }
			  	
	      }catch(Exception e){System.out.println(e);} 
	      return "Dil";  
	}

	public String close(int acno,String uname,String pass)
	throws RemoteException
	{
		System.out.println("server contacted");
		try
		{
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from details where acno="+acno+" and username='"+uname+"' and password='"+pass+"'");
			System.out.println("select * from details where acno="+acno+" and username='"+uname+"' and password='"+pass+"'");
			//System.out.println(rs.next());
			if(rs.next())
			{
				try
				{
					st2.executeUpdate("delete from details where acno="+acno+" and username='"+uname+"' and password='"+pass+"'");
				}
				catch(Exception e){ System.out.println(e);}
				st.executeUpdate("delete from daccount where acno="+acno);
				System.out.println("record deleted");
				
			}
			else
			{
				System.out.println("the acno does not exist");
			}
		}
		catch(Exception e){System.out.println(e);}
		return "";
	}
	public ResultSet report(int acno)
	{

		try{

		 st = con.createStatement();
		 rs = st.executeQuery("select a.acno,d.username,a.amt from daccount a,details d where a.acno=d.acno and d.acno="+acno);
			}catch (Exception ee) {System.out.println("errrrrr:  " + ee.toString());}
		return rs;
	}

	public String balance(int acno,String uname,String pass)
	throws RemoteException
	{

	   
		System.out.println("server contacted .....");
		try
		{
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from details where acno="+acno+" and username='"+uname+"' and password='"+pass+"'");
			System.out.println("select * from details where acno="+acno+" and username='"+uname+"' and password='"+pass+"'");

			if(rs.next())
			{
				try
				{   
				    System.out.println("select amt from daccount where acno="+acno);
					ResultSet rs1=st.executeQuery("select amt from daccount where acno="+acno);
					if(rs1.next()) bal=rs1.getInt(1);
				}
				catch(Exception e){System.out.println(e);}

				System.out.println("Balance is : "+bal);
				return String.valueOf(bal);
			}
			else
			{
				System.out.println("the acno does not exist");
			}
		}
		catch(Exception e){System.out.println(e);}
		return String.valueOf(bal);
	}

	public static void main(String args[])throws Exception
	{
	    System.out.println("Please Wait ....................");
		BankServer bs=new BankServer();
		Registry reg=LocateRegistry.createRegistry(5555);
		reg.bind("bank",bs);
		System.out.println("Bank Server is Ready .....");
	}
}