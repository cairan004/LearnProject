package loginfo;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Log {
	 private static void createAndShowGUI() {
	        // ȷ��һ��Ư������۷��
	        JFrame.setDefaultLookAndFeelDecorated(true);

	        // ���������ô���
	        JFrame frame = new JFrame("Log");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        // ��� "Hello World" ��ǩ
	        JLabel logtime = new JLabel("��־ʱ��");
	        logtime.setBounds(10,20,80,25);
	        frame.getContentPane().add(logtime);
	        
	        JLabel testEnvironment = new JLabel("���Ի���");
	        testEnvironment.setBounds(10, 20, 80, 25); 
	        frame.getContentPane().add(testEnvironment);
	        
	        testEnvironment.setBounds(10,50,80,25);
	        JLabel logLevel = new JLabel("��־����");
	        logLevel.setBounds(10,80,80,25);
	        frame.getContentPane().add(logLevel);
	        JLabel keyWords = new JLabel("�ؼ���");
	        keyWords.setBounds(10,80,80,25);
            frame.getContentPane().add(keyWords);
	    

	        // ��ʾ����
	        frame.pack();
	        frame.setVisible(true);
	    }
	
	public static void main(String args[]) {
	  createAndShowGUI();
   }
}
