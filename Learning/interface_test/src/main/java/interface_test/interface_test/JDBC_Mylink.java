package interface_test.interface_test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

import org.testng.annotations.Test;

public class JDBC_Mylink {
 Connection connection;
  ResultSet resultSet;
  Statement statement;
  
  String driver="com.mysql.jdbc.Driver";
  String url = "jdbc:mysql://192.168.201.6:3306/test_hsh_ems";
  String  username="root";
  String  password="cd@cmcc_hsh";
  
 //创建连接 
  public Connection connectDB() {
	  try {
		   Class.forName(driver);
		   connection = DriverManager.getConnection(url,username,password);
		   if(!connection.isClosed()) {
			   System.out.println("connection pass");
		   }
		   else {
			System.out.println("connection fail");
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	  return connection;
  }
  
  

	public void selectDB() throws SQLException {
		
		connection = connectDB();
		String  selectstatus="SELECT `status` FROM `ad_item` WHERE id='00000000000000000058'";
		
		statement = connection.createStatement();
		ResultSet rSet = statement.executeQuery(selectstatus);
		
		while( rSet.next()) {
		 int id=rSet.getInt(1);
		 String status=resultSet.getString("status");
		 
		System.out.println("111");
		}
	}
  
  @Test
  public void testResultSet() throws Exception{
      //获取id=2的customers数据表的记录，并打印
      //面向接口的编程
      Connection conn=null;
      Statement statement=null;
      ResultSet rs=null;
      try {
          //1.获取Connection
    	  conn = connectDB();
          System.out.println(conn);
          //2.获取Statement
          statement=conn.createStatement();
          System.out.println(statement);
          //3.准备SQL
          String sql="SELECT `status` FROM `ad_item` WHERE id='00000000000000000058'";
          //4.执行查询，得到ResultSet
          rs=statement.executeQuery(sql);
          System.out.println(rs);
          //5.处理ResultSet
          while(rs.next()){
              int id=rs.getInt(1);
              String status=rs.getString("status");
             System.out.println(status);
          }
          //6.关闭数据库资源
          
      } catch (Exception e) {
          e.printStackTrace();
      }finally{
          connection.close();
      }
  }
  
  //关闭连接
  
  public void close() {
	  
	  try {
		  if(resultSet != null) {
			  resultSet.close();
		  }
		  if(connection !=null) {
			 connection .close(); 
		  }
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
  }
   
  
}
