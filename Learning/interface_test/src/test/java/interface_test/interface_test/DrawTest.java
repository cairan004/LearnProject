package interface_test.interface_test;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

public class DrawTest {
	
	@Test
	public void testLottery() throws ClientProtocolException, IOException {
		int iphone = 0;
		int certificate = 0;
		int charger = 0;
		int fail = 0;
		double periphone = 0;
		double percertificate = 0;
		double percharger = 0;
		double perfail = 0;
		int m;
		for(m=0;m<100;m++) {
			
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet("http://192.168.201.14/v1/api/20anniversary/lottery?boxNum=1&userId=24753002484006913");
			CloseableHttpResponse response = httpclient.execute(httpGet);
			
			try {
				 HttpEntity entity = response.getEntity();
	             String result = EntityUtils.toString(entity);
	             int res=Integer.parseInt(result);  //将中奖的类型为 string类型转化为int类型
	             
	             if(res==0) {
	            	 fail++;
	             }
	             else if(res==1) {
	            	 iphone++;
	             }
	             
	             else if (res==2) {
					certificate++;
				}
	             
	             else if (res==3) {
					charger++;
				}
	             
			} catch (Exception e) {
				// TODO: handle exception
			}
			finally {
				response.close();
			}
		}
		
		periphone =(double)iphone/m ;
		percertificate = (double)certificate/m;
		percharger = (double)percharger/m;
		perfail = (double)perfail/m;
		
		System.out.println("未中奖次数为："+fail+",概率为："+perfail);
		System.out.println("抽中iPhone的次数为"+iphone+",概率为："+periphone);
		System.out.println("抽中礼券的次数为"+certificate+",概率为"+percertificate);
		System.out.println("抽中充电器的次数为"+charger+"，概率为"+percharger);
	}
}
