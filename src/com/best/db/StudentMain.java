package com.best.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentMain stdMain=new StudentMain();
		//stdMain.insertStudent("Ma Ma","10/3434","0973434","3cs-1");
		//stdMain.showStudentList();
		//stdMain.deleteStudent(2);
		stdMain.updateStudent(1, "Zaw Zaw", "6/3434", "09893434", "5cs-23");
	}
	public void insertStudent(String name,String nrc,String phoneno,String rollno) {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/best_dec_db", "root", "root");
			Statement stmt=con.createStatement();
			String sql="insert into student(name,nrc,phoneno,rollno) values('"+name+"','"+nrc+"','"+phoneno+"','"+rollno+"');";
			int result=stmt.executeUpdate(sql);
			if(result>0) {
				System.out.println("Student has successfully saved");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public void showStudentList() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/best_dec_db", "root", "root");
			Statement stmt=con.createStatement();
			String sql="select * from student";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println("Name: "+rs.getString("name")+", Nrc: "+rs.getString("nrc")+", PhoneNo: "+rs.getString("phoneno")+", RollNo :"+rs.getString("rollno"));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public void deleteStudent(int id) {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/best_dec_db", "root", "root");
			Statement stmt=con.createStatement();
			String sql="delete from student where id='"+id+"'";
			int result=stmt.executeUpdate(sql);
			if(result>0) {
				System.out.println("Successfully deleted");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void updateStudent(int id,String name,String nrc,String phoneno,String rollno) {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/best_dec_db", "root", "root");
			Statement stmt=con.createStatement();
			String sql="update student set name='"+name+"',nrc='"+nrc+"',phoneno='"+phoneno+"',rollno='"+rollno+"' where id='"+id+"';";
			int result=stmt.executeUpdate(sql);
			if(result>0) {
				System.out.println("Student has successfully updated");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
