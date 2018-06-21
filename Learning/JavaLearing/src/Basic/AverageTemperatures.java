package Basic;

import java.util.Scanner;

public class AverageTemperatures {
	
    public static void  main(String args[]) {
		
    	int count;
    	double sum,aver;
    	sum=0;
    	double []temperature = new double[7];
    	Scanner sc = new Scanner(System.in);
    	System.out.println("请输入7天的温度：");
    	for(count=0;count<temperature.length;count++) {
    		temperature[count] = sc.nextDouble();
    		sum+=temperature[count];
    	}
    	aver = sum/7;
    	System.out.println("平均温度为："+aver);
    	//比较每天与平均气温
    	for(count=0;count<temperature.length;count++) {
    		if(temperature[count]<aver) {
    			System.out.println("第"+temperature[count]+"天，小于平均温度");
    		}
    		else if (temperature[count]==aver) {
    			System.out.println("第"+temperature[count]+"天，等于平均温度");
			}
    		else if (temperature[count]>aver) {
    			System.out.println("第"+temperature[count]+"天，大于平均温度");
			}
    	}
	}
}
