package fuction;

/**
 * FileName: TimeTrigger.java
 * ��¼����
 * @author Lipeishan��ZhangQin
 * @Date  2020.03.21
 */
import javax.swing.JOptionPane;

/**

 * ÿ�촥��һ�������Զ�������ʾ

 */

import java.util.TimerTask;

public class TimeTrigger extends TimerTask {

	@Override
	public void run() {

		JOptionPane.showMessageDialog(null, "��ʱ�仹������ӽ�ֹ!");

	}

}
