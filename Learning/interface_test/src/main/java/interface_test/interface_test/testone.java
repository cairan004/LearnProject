package interface_test.interface_test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

public class testone {
	/*
	@Test
	public void baiduTest() throws ClientProtocolException, IOException{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String urlString = "http://www.baidu.com";
		
		//打开一个标签页，实例化一个get请求--直接载入一个URL地址
		HttpGet httpGet = new HttpGet(urlString);
		
		//用客户端去执行get请求，声明
		HttpResponse httpResponse = httpClient.execute(httpGet);
		int statusCode =httpResponse.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		
		HttpEntity httpEntity = httpResponse.getEntity();
		httpEntity = new BufferedHttpEntity(httpEntity);
		String responseMsg = EntityUtils.toString(httpEntity);
		System.out.println(responseMsg);
		
		httpGet.releaseConnection();
		httpClient.close();		
	}
	*/
	@Test
	public void baiduTest2() throws ClientProtocolException, IOException, Exception{
		System.out.println("------------------------------------");
		CloseableHttpClient httpClient = HttpClients.createDefault();
		List<NameValuePair> namevaluePairs = new LinkedList<NameValuePair>();
		namevaluePairs.add(new BasicNameValuePair("wd", "python"));
		
		//uri构造器
		URI uri = new URIBuilder().setScheme("http")//协议
			     .setHost("www.baidu.com") //host 或者IP地址
			     .setPath("/s")//接口地址
			     .setParameters(namevaluePairs)//参数
			     .build();
		System.out.println(uri);
		
		//实例化httpget
		HttpGet httpGet = new HttpGet(uri);
		
		//获取返回的响应
		HttpResponse httpResponse = httpClient.execute(httpGet);
		System.out.println(httpResponse.getStatusLine().getStatusCode());
		System.out.println("*******************************************************");
		
		HttpEntity httpEntity =httpResponse.getEntity();
		httpEntity = new BufferedHttpEntity(httpEntity);
		String responseMsg = EntityUtils.toString(httpEntity);
		System.out.println(responseMsg);
		
		httpGet.releaseConnection();
	   httpClient.close();
		
	}
	
	
}
