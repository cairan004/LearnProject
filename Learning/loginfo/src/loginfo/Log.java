package loginfo;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Log {
	 private static void createAndShowGUI() {
	        // 确保一个漂亮的外观风格
	        JFrame.setDefaultLookAndFeelDecorated(true);

	        // 创建及设置窗口
	        JFrame frame = new JFrame("Log");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        // 添加 "Hello World" 标签
	        JLabel logtime = new JLabel("日志时间");
	        logtime.setBounds(10,20,80,25);
	        frame.getContentPane().add(logtime);
	        
	        JLabel testEnvironment = new JLabel("测试环境");
	        testEnvironment.setBounds(10, 20, 80, 25); 
	        frame.getContentPane().add(testEnvironment);
	        
	        testEnvironment.setBounds(10,50,80,25);
	        JLabel logLevel = new JLabel("日志级别");
	        logLevel.setBounds(10,80,80,25);
	        frame.getContentPane().add(logLevel);
	        JLabel keyWords = new JLabel("关键字");
	        keyWords.setBounds(10,80,80,25);
            frame.getContentPane().add(keyWords);
	    

	        // 显示窗口
	        frame.pack();
	        frame.setVisible(true);
	    }
	
	public static void main(String args[]) {
	  createAndShowGUI();
   }
}
