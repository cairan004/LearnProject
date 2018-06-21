package interface_test.interface_test;

import java.awt.datatransfer.FlavorListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class creatUser {
	//声明connect对象
	Connection con ;
	ResultSet rs;
	Statement statement;
	//驱动程序名
	String driver = "com.mysql.jdbc.Driver";
	//URL指向数据库名
	String url = "jdbc:mysql://192.168.201.6:3306/trade_hk_cd_test";
	String username = "root";
	String password = "cd@cmcc_hsh";
	
	//链接数据库
    public Connection connectDB(){
    	try {
    		Class.forName(driver);
    		con = DriverManager.getConnection(url, username, password);
    		
    		if(!con.isClosed()) {
    		      System.out.println("Succeeded connecting to the Database!");
    		}else {
				System.out.println("cannot connect");
			}	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    	return con;
    }
    
    @Test(dependsOnMethods = {"insertData"}, enabled = false)
    public void query() {
    	
    	con = connectDB();

		//要执行的SQL语句
		String selectSql = "select * from user where user_id=200";
    	
		try {
			statement = con.createStatement();
			rs = statement.executeQuery(selectSql);
			//3.ResultSet类，用来存放获取的结果集！！
			String user_id = null;
            String user_name = null;
            while(rs.next()){
                //获取userid这列数据
                user_id = rs.getString("user_id");
                //获取stuid这列数据
                user_name = rs.getString("user_name");   		 
                //输出结果
                System.out.println(user_id + "\t" + user_name);
            }		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  		              	             
	 close() ;  
    }
    
    @Test
    public void insertData() {
    	String uid = null;
    	String uname = null;
    	
    	con = connectDB();
    	
        for(int i=1;i<=1000;i++) {
        	uid = String.valueOf(i);
        	uname = "cc"+String.valueOf(i);
   
            String insertSql = "insert into `user` (`user_id`, `user_name`, `phone`, `create_time`, `update_time`, `is_delete`, `source_app`) values('"+uid+"','"+uname+"','12345678','2017-12-12 10:55:10',NULL,'1',NULL)";

            
        	try {
    			statement = con.createStatement();
    			int status = statement.executeUpdate(insertSql);
    			if(1 == status) {
    				System.out.println(uid+"  ||  "+uname+"  插入数据成功！！");
    			}else {
    				System.err.println(uid+"  ||  "+uname+"  插入数据失败！！");
    			}
    			
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			System.err.println(uid+"  ||  "+uname+"  插入数据失败！可能主键重复。");
    		}
        	
        	
        }
    	
	 close() ;  
    }
       
    //关闭各种连接
    public void close() {
    	try {
        	if(rs != null) {
        		rs.close();

        	}
        	if(con != null) {
                con.close(); 
        	}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

    }
    

}
