package view;
/**
 * FileName: pieChart.java
 * �û����ܽ���
 * @author Lipeishan��ZhangQin
 * @Date  2020.03.20
 */
import java.sql.Connection;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import dao.UserDao;
import fuction.TimeTrigger;
import pojo.User;
import pojo.userMes;
import util.Dbutil;
import util.FloatUtil;
import util.IntUtil;
import util.StringUtil;

public class Main_user extends javax.swing.JFrame {
	// id
	private JTextField userIDTxt;
	// ����
	private JTextField userNameTxt;
	// b
	private JTextField userSexTxt;
	//ѧԺ
	private JTextField userCollegeTxt;
	// ʡ��
	private JTextField userProTxt;
	// ����
	private JTextField userCityTxt;
	// �¶�
	private JTextField userTemperatureTxt;
	//�Ƿ�У
	private JTextField userArriveTxt;
	// �Ƿ�����
	private JTextField userSymptomTxt;
	// �Ƿ�ȷ��
	private JTextField userCheckTxt;
	
    //id
	private javax.swing.JLabel jLabel1;
	//����
	private javax.swing.JLabel jLabel2;
	//ʡ��
	private javax.swing.JLabel jLabel3;
	//����
	private javax.swing.JLabel jLabel4;
	//�Ա�
	private javax.swing.JLabel jLabel5;
	//����
	private javax.swing.JLabel jLabel6;
	//����
	private javax.swing.JLabel jLabel7;
	//ȷ��
	private javax.swing.JLabel jLabel8;
	//ѧԺ
	private javax.swing.JLabel jLabel9;
	//�Ƿ�У
	private javax.swing.JLabel jLabel10;
	private javax.swing.JButton jb_reset;
	private javax.swing.JButton jb_add;

	Dbutil dbUtil = new Dbutil();
	UserDao userDao = new UserDao();

	public Main_user() {
		initComponents();
		// this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setSize(600, 350);
		this.setLocationRelativeTo(null);
	}

	/*
	 * ҳ������
	 */
	private void initComponents() {
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		userIDTxt = new javax.swing.JTextField();
		userNameTxt = new javax.swing.JTextField();
		userSexTxt = new javax.swing.JTextField();
		userProTxt = new javax.swing.JTextField();
		userCityTxt = new javax.swing.JTextField();
		userTemperatureTxt = new javax.swing.JTextField();
		userSymptomTxt = new javax.swing.JTextField();
		userCheckTxt = new javax.swing.JTextField();
		userArriveTxt = new javax.swing.JTextField();
		userCollegeTxt  =new javax.swing.JTextField();
		jb_add = new javax.swing.JButton();
		jb_reset = new javax.swing.JButton();

		setTitle("������Ϣ���");

		jLabel1.setText("ѧ��/����");

		jLabel2.setText("  ����      ");

		jLabel3.setText("����ʡ��");

		jLabel4.setText("���ڳ��� ");
 
		jLabel5.setText("   �Ա�      ");

		jLabel6.setText("�������� ");

		jLabel7.setText("�Ƿ����� ");

		jLabel8.setText("�Ƿ�ȷ��");
		
		jLabel9.setText("  ѧԺ       ");
		
		jLabel10.setText("�Ƿ�У");


		jb_add.setText("ȷ��");
		/*
		 * ���ȷ�ϼ���
		 */
		jb_add.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_addActionPerformed(evt);
			}
		});

		jb_reset.setText("����");
		jb_reset.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_resetActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(41, 41, 41)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addComponent(jLabel1)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(userIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 144,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(60, 60, 60).addComponent(jLabel2)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(
										userNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 144,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						
						.addGroup(layout.createSequentialGroup().addComponent(jLabel9)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(userCollegeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 144,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(60, 60, 60).addComponent(jLabel5)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(userSexTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 144,
										javax.swing.GroupLayout.PREFERRED_SIZE))

						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(layout.createSequentialGroup().addComponent(jLabel3)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(userProTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 144,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(jb_add))
								.addGap(60, 60, 60)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addComponent(jLabel4)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(userCityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 144,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(jb_reset)))

						.addGroup(layout.createSequentialGroup().addComponent(jLabel6)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(userTemperatureTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 144,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(60, 60, 60).addComponent(jLabel10)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(userArriveTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 144,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addComponent(jLabel7)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(userSymptomTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 144,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(60, 60, 60).addComponent(jLabel8)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(userCheckTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 144,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(44, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(46, 46, 46)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1).addComponent(jLabel2)
								.addComponent(userIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(userNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel9).addComponent(jLabel5)
								.addComponent(userCollegeTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(userSexTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3).addComponent(jLabel4)
								.addComponent(userProTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(userCityTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel6).addComponent(jLabel10)
								.addComponent(userTemperatureTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(userArriveTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel7).addComponent(jLabel8)
								.addComponent(userSymptomTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(userCheckTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(5, 5, 5)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jb_reset).addComponent(jb_add))
						.addGap(20, 20, 20)));

		pack();

	}

	/*
	 * �����Ϣ
	 */
	private void jb_addActionPerformed(java.awt.event.ActionEvent evt) {
		String userName = this.userNameTxt.getText();
		String userId = this.userIDTxt.getText();
		String userSex = this.userSexTxt.getText();
		String userTemperature = this.userTemperatureTxt.getText();
		String userPro = this.userProTxt.getText();
		String userCity = this.userCityTxt.getText();
		String userSympotom = this.userSymptomTxt.getText();
		String userCheck = this.userCheckTxt.getText();
		String userCollege = this.userCollegeTxt.getText();
		String userArrive = this.userCheckTxt.getText();
		if (StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(this, "��������Ϊ��!");
			return;
		}
		if (IntUtil.isEmpty(Integer.parseInt(userId))) {
			JOptionPane.showMessageDialog(this, "����/ѧ�Ų���Ϊ��!");
			return;
		}
		if (StringUtil.isEmpty(userSex)) {
			JOptionPane.showMessageDialog(this, "�Ա���Ϊ��!");
			return;
		}
		if (FloatUtil.isEmpty(Float.parseFloat(userTemperature))) {
			JOptionPane.showMessageDialog(this, "�������²���Ϊ��!");
			return;
		}
		if (StringUtil.isEmpty(userPro)) {
			JOptionPane.showMessageDialog(this, "����ʡ�ݲ���Ϊ��!");
			return;
		}
		if (StringUtil.isEmpty(userCity)) {
			JOptionPane.showMessageDialog(this, "���ڳ��в���Ϊ��!");
			return;
		}

		if (StringUtil.isEmpty(userSympotom)) {
			JOptionPane.showMessageDialog(this, "�����������Ϊ��!");
			return;
		}
		if (StringUtil.isEmpty(userCheck)) {
			JOptionPane.showMessageDialog(this, "ȷ���������Ϊ��!");
			return;
		}
		if (StringUtil.isEmpty(userCollege)) {
			JOptionPane.showMessageDialog(this, "ѧԺ����Ϊ��!");
			return;
		}
		if (StringUtil.isEmpty(userArrive)) {
			JOptionPane.showMessageDialog(this, "��У�������Ϊ��!");
			return;
		}
		userMes user = new userMes(Integer.parseInt(userId), userName, userSex,userCollege, userPro,
				userCity, Float.parseFloat(userTemperature), userArrive,userSympotom, userCheck);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int n = userDao.userAdd(con, user);
			if (n == 1) {
				JOptionPane.showMessageDialog(this, "��ӳɹ�!");
				this.resetValue();
			} else {
				JOptionPane.showMessageDialog(this, "���ʧ��!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "���ʧ��!");
		}

	}
	/*
	 * ����
	 */
	private void jb_resetActionPerformed(java.awt.event.ActionEvent evt) {
		this.resetValue();
	}

	/*
	 * �������
	 */
	private void resetValue() {
		this.userIDTxt.setText("");
		this.userNameTxt.setText("");
		this.userSexTxt.setText("");
		this.userTemperatureTxt.setText("");
		this.userProTxt.setText("");
		this.userCityTxt.setText("");
		this.userSymptomTxt.setText("");
		this.userCheckTxt.setText("");
		this.userArriveTxt.setText("");
		this.userCollegeTxt.setText("");
	}
}
