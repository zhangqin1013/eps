package view;

/**
 * FileName: LogOn.java
 * ��¼����
 * @author Lipeishan��ZhangQin
 * @Date  2020.03.19
 */
import java.awt.Font;
import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import dao.LogOnDao;
import fuction.TimeTrigger;
import pojo.Admin;
import pojo.User;
import pojo.College;
import util.Dbutil;
import util.StringUtil;

/*
 * ��¼����
 */
public class logOn extends JFrame {
	// ��ʾ��¼���
	private ButtonGroup buttonGroup1;
	private JLabel jLabel1;
	// �˺ű�ǩ
	private JLabel jLabel2;
	// �����ǩ
	private javax.swing.JLabel jLabel3;
	private javax.swing.JButton jb_logOn;
	private javax.swing.JButton jb_reset;
	// ��ʦѧ����¼
	private javax.swing.JRadioButton userButton;
	// ѧԺ��¼
	private javax.swing.JRadioButton collegeButton;
	// ���ذ��¼
	private javax.swing.JRadioButton adminButton;
	private javax.swing.JFormattedTextField userNameTxt;
	private javax.swing.JPasswordField passwordTxt;
	// ���ݿ�����
	Dbutil dbutil = new Dbutil();
	LogOnDao logOnDao = new LogOnDao();
	// �û�ʵ��
	public static User currentUser;
	// ѧԺʵ��
	public static College currentCollege;
	public static Admin currentAdmin;

	public logOn() {
		initComponents();
		this.setLocationRelativeTo(null);
		this.userButton.setSelected(true);
	}

	/*
	 * ҳ�沼��
	 */
	private void initComponents() {
		buttonGroup1 = new javax.swing.ButtonGroup();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		userNameTxt = new javax.swing.JFormattedTextField();
		jLabel3 = new javax.swing.JLabel();
		userButton = new javax.swing.JRadioButton();
		collegeButton = new javax.swing.JRadioButton();
		adminButton = new javax.swing.JRadioButton();
		jb_logOn = new javax.swing.JButton();
		jb_reset = new javax.swing.JButton();
		passwordTxt = new javax.swing.JPasswordField();
		Font font = new java.awt.Font("����", 1, 15);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("�û���¼");
		setResizable(false);

		jLabel1.setFont(new java.awt.Font("����", 1, 24));
		jLabel1.setText("ʦ������ÿ���ϱ�ϵͳ");

		jLabel2.setFont(font);

		jLabel2.setText("�˺�");

		jLabel3.setFont(font);

		jLabel3.setText("����");

		buttonGroup1.add(userButton);
		userButton.setFont(font);
		userButton.setText("ѧ��/��ʦ");

		buttonGroup1.add(collegeButton);
		collegeButton.setFont(font);
		collegeButton.setText("ѧԺ");

		buttonGroup1.add(adminButton);
		adminButton.setFont(font);
		adminButton.setText("���ذ�");

		jb_logOn.setFont(font);
		jb_logOn.setText("��¼");
		jb_logOn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_logOnActionPerformed(evt);
			}
		});

		jb_reset.setFont(font);
		jb_reset.setText("����");
		jb_reset.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_resetActionPerformed(evt);
			}
		});
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(100, 100, 100)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jLabel1)

						.addGroup(layout.createSequentialGroup().addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup().addComponent(jLabel3).addGap(30, 30, 30))
								.addGroup(layout.createSequentialGroup().addComponent(jLabel2).addGap(30, 30, 30)))
								.addGap(6, 6, 6)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addComponent(passwordTxt, 0, 0, Short.MAX_VALUE)
										.addComponent(userNameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 135,
												Short.MAX_VALUE)
										.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
												layout.createSequentialGroup().addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(jb_logOn).addComponent(userButton))

														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING,
																		false)
																.addGroup(layout.createSequentialGroup()
																		.addGap(30, 30, 30).addComponent(jb_reset)

																)

																.addGroup(layout.createSequentialGroup()
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(layout.createSequentialGroup()
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addGap(30, 30, 30)
																				.addComponent(collegeButton,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE))
																		.addGap(30, 30, 30).addComponent(adminButton,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)))))))
				.addContainerGap(143, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(77, Short.MAX_VALUE).addComponent(jLabel1)
						.addGap(39, 39, 39).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2).addComponent(userNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3).addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)

								.addComponent(userButton).addComponent(collegeButton).addComponent(adminButton))
						.addGap(30, 30, 30)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jb_reset).addComponent(jb_logOn))
						.addGap(58, 58, 58)));

		pack();
	}

	/*
	 * ��¼
	 */
	private void jb_logOnActionPerformed(java.awt.event.ActionEvent evt) {
		String userName = userNameTxt.getText();
		String password = new String(passwordTxt.getPassword());
		if (StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(this, "�˺Ų���Ϊ��");
			return;
		}
		if (StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(this, "���벻��Ϊ��!");
			return;
		}
		Connection con = null;
		// �ж����ѧ�����߽�ʦ
		if (this.userButton.isSelected()) {
			User user = new User(Integer.parseInt(userName), password);
			try {
				con = dbutil.getCon();
				currentUser = logOnDao.login(con, user);
				if (currentUser != null) {
					this.dispose();
					//
					new Main_user().setVisible(true);
				} else {
					JOptionPane.showMessageDialog(this, "�û������������!");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "��¼ʧ��");
			} finally {
				try {
					dbutil.closeCon(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} // ���ذ��¼
		else if (this.adminButton.isSelected()) {
			// User user = new User(Integer.parseInt(userName), password);
			Admin admin = new Admin(Integer.parseInt(userName), password);
			try {
				con = dbutil.getCon();
				currentAdmin = logOnDao.login(con, admin);
				// currentUser = logOnDao.login(con, user);
				if (currentAdmin != null) {
					this.dispose();

					new Main_admin().setVisible(true);
				} else {
					JOptionPane.showMessageDialog(this, "�û������������!");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "��¼ʧ��!");
			} finally {
				try {
					dbutil.closeCon(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} // ѧԺ��¼
		else if (this.collegeButton.isSelected()) {
			College college1 = new College(Integer.parseInt(userName), password);
			try {
				con = dbutil.getCon();
				currentCollege = logOnDao.login(con, college1);
				if (currentCollege != null) {
					this.dispose();
					new Main_college().setVisible(true);
				} else {
					JOptionPane.showMessageDialog(this, "�û������������!");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "��¼ʧ��!");
			} finally {
				try {
					dbutil.closeCon(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	/*
	 * ���ù���
	 */
	private void jb_resetActionPerformed(java.awt.event.ActionEvent evt) {
		this.resetValue();
	}

	private void resetValue() {
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");
		this.userButton.setSelected(true);
		this.collegeButton.setSelected(true);
		this.adminButton.setSelected(true);
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new logOn().setVisible(true);
			}
		});
	}

	private static final long PERIOD_DAY = 24 * 60 * 60 * 1000;

	private static final long TEST_SEC = 15 * 1000;

	public void timeTig() {

		// ʹ��Ĭ��ʱ�������Ի������һ������

		Calendar calendar = Calendar.getInstance();

		// ����ʱ��

		calendar.set(Calendar.HOUR_OF_DAY, 9);// Сʱ

		calendar.set(Calendar.MINUTE, 55);// ����

		calendar.set(Calendar.SECOND, 0);// ��

		// ��һ��ִ�������ʱ��

		Date time = calendar.getTime();

		// �����һ��ִ�������ʱ�����ڵ�ǰʱ�䣬��ô��һ��ִ�������ʱ���Ƴ�һ��
		if (time.before(new Date())) {
			time = addDay(time, 1);
			System.exit(0);
		}
		// System.out.println("����ʱ��:" + time);
		// �����ƻ�
		Timer timer = new Timer();
		timer.schedule(new TimeTrigger(), time, PERIOD_DAY);
		// System.out.println("��ǰʱ��:" + new Date());
	}

	// ����һ��
	public Date addDay(Date date, int num) {
		JOptionPane.showMessageDialog(null, "�����ʱ��!");
		Calendar startDT = Calendar.getInstance();
		startDT.setTime(date);
		startDT.add(Calendar.DAY_OF_MONTH, num);
		return startDT.getTime();
	}
}