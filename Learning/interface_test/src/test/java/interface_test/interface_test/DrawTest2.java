package interface_test.interface_test;

import java.io.IOException;
import java.text.NumberFormat;

import javax.imageio.event.IIOReadWarningListener;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class DrawTest2 {
	
	@Test
	public void testLottery() throws ClientProtocolException, IOException{
	
		int iphone = 0;
		int certificate = 0;
		int charger = 0;
		int card_dawanqu=0;
		int card_local=0;
		int failed = 0;
		double periphone = 0;
		double percertificate = 0;
		double percharger = 0;
		double perfail = 0;
		double percard_dawanq=0;
		double percard_local=0;
		
		int m;
		
		CloseableHttpClient httpClient = HttpClients.createDefault(); //浏览器
		
		String url = "http://192.168.100.62:8080/lottery?boxNum=1&userId=25032072746434561"; //请求链接
		
		HttpGet httpGet = new HttpGet(url); //开了一个网页
		
		httpGet.setHeader("lang", "tc"); 
		
		for(m = 0; m<1000;m++) {
		HttpResponse response = httpClient.execute(httpGet); //执行
		
		HttpEntity entity = response.getEntity();//获取响应实体
		entity = new BufferedHttpEntity(entity);//加入缓存,方便多次调用		
		String result = EntityUtils.toString(entity);//把实体转换为String格式
		
	    System.out.println(result);//json格式的
		
		JSONObject jsonObject = new JSONObject(result);
		JSONObject jsonObject2 = jsonObject.getJSONObject("body");
		JSONObject jsonObject3 = jsonObject2.getJSONObject("winningRecord");
		
		if(jsonObject3.isNull("prizeName")){
			
			failed++;
			
		}else {
	
			if(jsonObject3.get("prizeName").equals("CMHK 外置充電器 (10000mAh)")){
				charger++;
				
			}else if(jsonObject3.get("prizeName").equals("iPhone X (64GB)")){
				
				iphone++;
				
			}else if(jsonObject3.get("prizeName").equals("$500旅遊禮券")){
				
				certificate++;
				
			}else if (jsonObject3.get("prizeName").equals("4G/3G大灣區3日儲值卡")) {
				
				card_dawanqu++;
				
			}else if (jsonObject3.get("prizeName").equals("4G/3G本地話音儲值卡")) {
				
				card_local++;
			}
		}
		
	}	
		periphone =(double)iphone/m ;
		percertificate = (double)certificate/m;
		percharger = (double)charger/m;
		perfail = (double)failed/m;
		percard_dawanq=(double)card_dawanqu/m;
		percard_local=(double)card_local/m;
		
		System.out.println("未中奖次数为："+failed+",概率为："+perfail);
		System.out.println("抽中iPhone的次数为"+iphone+",概率为："+periphone);
		System.out.println("抽中礼券的次数为"+certificate+",概率为"+percertificate);
		System.out.println("抽中充电器的次数为"+charger+"，概率为"+percharger);
		System.out.println("抽中4G/3G大灣區3日儲值卡的次数为"+card_dawanqu+"，概率为"+percard_dawanq);
		System.out.println("抽中4G/3G本地話音儲值卡的次数为"+card_local+"，概率为"+percard_local);
	
		httpGet.releaseConnection();
		httpClient.close();
	}
}
