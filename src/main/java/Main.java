import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter '1' for Insert Staff Details ");
		System.out.println("Enter '2' for UpdateById Staff Details ");
		System.out.println("Enter '3' for Delete Staff Details ");
		System.out.print("Enter (1-3) for above operations:");
		int n=in.nextInt();
		switch(n) {
		case 1:{
			Staff staff =new Staff();
			 getStaffDetails(staff);
			//System.out.print(staff.toString());
			 createStaff(staff);
			 System.out.println("Staff details entered into table sucessfully..");
			break;
		}
		case 2:{
			Staff staff =new Staff();
			getStaffDetails(staff);
			
			//update
			upadteStaff(staff);
			break;
		}
		case 3:{
			System.out.print("Enter Staff Id      : ");
			   int id=in.nextInt();
			   //delete
			   deleteStaff(id);
			break;
		}
		default :
			System.out.println("Sorry! Invalid Operation");
		}
	}
	
	private static void getStaffDetails(Staff staff) {
		Scanner o=new Scanner(System.in);
		Scanner p=new Scanner(System.in);
		System.out.print("Enter Staff Id      : ");
		   staff.setStaff(o.nextInt());
		System.out.print("Enter Staff Name    : ");
		   staff.setName(p.nextLine());
		System.out.print("Enter Staff Address : ");
		   staff.setAddress(p.nextLine());
	}
	private static void createStaff(Staff staff) {
		try{  
		//	Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/staffs","root","Bannu@8938");  
	        String sql="insert into customer values(?,?,?)";
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setInt(1,staff.getStaff());
            stmt.setString(2,staff.getName());
            stmt.setString(3,staff.getAddress());
            int i=stmt.executeUpdate();  
	        con.close();  
		}catch(Exception e){ System.out.println(e);}  
	}
   private static void upadteStaff(Staff staff) {
	   try{  
			//	Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/staffs","root","Bannu@8938");  
				String sql="update customer set name=?,address=? where id=? ";
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setInt(3,staff.getStaff());
	            stmt.setString(1,staff.getName());
	            stmt.setString(2,staff.getAddress());
	            int i=stmt.executeUpdate();  
		        con.close();  
			}catch(Exception e){ System.out.println(e);}  
   }
   private static void deleteStaff(int id) {
	   try{  
			//	Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/staffs","root","Bannu@8938");  
				String sql="DELETE FROM customer where id=?";
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setInt(1, id);
	            int i=stmt.executeUpdate();  
		        con.close();  
			}catch(Exception e){ System.out.println(e);}  
   }
}
