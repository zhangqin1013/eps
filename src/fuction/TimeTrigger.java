package fuction;

/**
 * FileName: TimeTrigger.java
 * 登录界面
 * @author Lipeishan，ZhangQin
 * @Date  2020.03.21
 */
import javax.swing.JOptionPane;

/**

 * 每天触发一次任务，自动发送提示

 */

import java.util.TimerTask;

public class TimeTrigger extends TimerTask {

	@Override
	public void run() {

		JOptionPane.showMessageDialog(null, "打卡时间还有五分钟截止!");

	}

}
