package fuction;

import javax.swing.JOptionPane;

import java.util.Calendar;

import java.util.Date;

import java.util.Timer;

 

/**

 * 每天触发一次任务，实现短信自动发送

 */

import java.util.TimerTask;

import javax.swing.JOptionPane;

 

public class TimeTrigger extends TimerTask{


	@Override

	public void run() {

		JOptionPane.showMessageDialog(null,"打卡时间到了!");

	}

}

