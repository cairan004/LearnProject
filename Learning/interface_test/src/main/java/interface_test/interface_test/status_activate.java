package interface_test.interface_test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

public class status_activate extends JDBC_Mylink{
	@Test
	public void changeStatus() {
	//httpClient
    HttpClient httpClient = new DefaultHttpClient();

    // get method
    HttpPost httpPost = new HttpPost("http://192.168.201.10/v1/web/ad/item/update_status");    
  
    // set header
    httpPost.setHeader("Content-Type","application/x-www-form-urlencoded"); 

    //set params
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    String id = "00000000000000000058";
    String  statusinput = "1";
    params.add(new BasicNameValuePair("id",id));
    params.add(new BasicNameValuePair("status",statusinput));
    
    try{
        httpPost.setEntity(new UrlEncodedFormEntity(params));
    }catch (Exception e) {} 

    //response
    HttpResponse response = null;  
    try{
        response = httpClient.execute(httpPost);
    }catch (Exception e) {}
    
    //get response into String
    String temp;
    try{
        HttpEntity entity = response.getEntity();
        temp=EntityUtils.toString(entity,"UTF-8");
        System.out.println(temp);
        

    }catch (Exception e) {}
    
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
	             String status1=rs.getString("status");
	             System.out.println(status1);
	           
	          }
	          //6.关闭数据库资源
	        
	      } catch (Exception e) {
	          e.printStackTrace();
	      }finally{
	          connection.close();
	      }
	  }
	
	
	
}
