package Basic;

import java.util.Scanner;

public class AverageTemperatures {
	
    public static void  main(String args[]) {
		
    	int count;
    	double sum,aver;
    	sum=0;
    	double []temperature = new double[7];
    	Scanner sc = new Scanner(System.in);
    	System.out.println("������7����¶ȣ�");
    	for(count=0;count<temperature.length;count++) {
    		temperature[count] = sc.nextDouble();
    		sum+=temperature[count];
    	}
    	aver = sum/7;
    	System.out.println("ƽ���¶�Ϊ��"+aver);
    	//�Ƚ�ÿ����ƽ������
    	for(count=0;count<temperature.length;count++) {
    		if(temperature[count]<aver) {
    			System.out.println("��"+temperature[count]+"�죬С��ƽ���¶�");
    		}
    		else if (temperature[count]==aver) {
    			System.out.println("��"+temperature[count]+"�죬����ƽ���¶�");
			}
    		else if (temperature[count]>aver) {
    			System.out.println("��"+temperature[count]+"�죬����ƽ���¶�");
			}
    	}
	}
}
