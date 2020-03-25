package view;
/**
 * FileName: pieChart.java
 * 用户功能界面
 * @author Lipeishan，ZhangQin
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
import pojo.UserMes;
import util.DbUtil;
import util.FloatUtil;
import util.IntUtil;
import util.StringUtil;

public class Main_user extends javax.swing.JFrame {
	// id
	private JTextField userIDTxt;
	// 姓名
	private JTextField userNameTxt;
	// 性别
	private JTextField userSexTxt;
	//学院
	private JTextField userCollegeTxt;
	// 省份
	private JTextField userProTxt;
	// 城市
	private JTextField userCityTxt;
	// 温度
	private JTextField userTemperatureTxt;
	//是否返校
	private JTextField userArriveTxt;
	// 是否疑似
	private JTextField userSymptomTxt;
	// 是否确诊
	private JTextField userCheckTxt;
	
    //id
	private javax.swing.JLabel jLabel1;
	//姓名
	private javax.swing.JLabel jLabel2;
	//省份
	private javax.swing.JLabel jLabel3;
	//城市
	private javax.swing.JLabel jLabel4;
	//性别
	private javax.swing.JLabel jLabel5;
	//体温
	private javax.swing.JLabel jLabel6;
	//疑似
	private javax.swing.JLabel jLabel7;
	//确诊
	private javax.swing.JLabel jLabel8;
	//学院
	private javax.swing.JLabel jLabel9;
	//是否返校
	private javax.swing.JLabel jLabel10;
	private javax.swing.JButton jb_reset;
	private javax.swing.JButton jb_add;

	DbUtil dbUtil = new DbUtil();
	UserDao userDao = new UserDao();

	public Main_user() {
		initComponents();
		// this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setSize(600, 350);
		this.setLocationRelativeTo(null);
	}

	/** 页面设置 */
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

		setTitle("防疫信息添加");

		jLabel1.setText("学号/工号");

		jLabel2.setText("  姓名      ");

		jLabel3.setText("所在省份");

		jLabel4.setText("所在城市 ");
 
		jLabel5.setText("   性别      ");

		jLabel6.setText("当日体温 ");

		jLabel7.setText("是否疑似 ");

		jLabel8.setText("是否确诊");
		
		jLabel9.setText("  学院       ");
		
		jLabel10.setText("是否返校");


		jb_add.setText("确认");
		/*
		 * 添加确认监听
		 */
		jb_add.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_addActionPerformed(evt);
			}
		});

		jb_reset.setText("重置");
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

	/** 添加信息*/
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
			JOptionPane.showMessageDialog(this, "姓名不能为空!");
			return;
		}
		if (IntUtil.isEmpty(Integer.parseInt(userId))) {
			JOptionPane.showMessageDialog(this, "工号/学号不能为空!");
			return;
		}
		if (StringUtil.isEmpty(userSex)) {
			JOptionPane.showMessageDialog(this, "性别不能为空!");
			return;
		}
		if (FloatUtil.isEmpty(Float.parseFloat(userTemperature))) {
			JOptionPane.showMessageDialog(this, "当日体温不能为空!");
			return;
		}
		if (StringUtil.isEmpty(userPro)) {
			JOptionPane.showMessageDialog(this, "所在省份不能为空!");
			return;
		}
		if (StringUtil.isEmpty(userCity)) {
			JOptionPane.showMessageDialog(this, "所在城市不能为空!");
			return;
		}

		if (StringUtil.isEmpty(userSympotom)) {
			JOptionPane.showMessageDialog(this, "疑似情况不能为空!");
			return;
		}
		if (StringUtil.isEmpty(userCheck)) {
			JOptionPane.showMessageDialog(this, "确诊情况不能为空!");
			return;
		}
		if (StringUtil.isEmpty(userCollege)) {
			JOptionPane.showMessageDialog(this, "学院不能为空!");
			return;
		}
		if (StringUtil.isEmpty(userArrive)) {
			JOptionPane.showMessageDialog(this, "到校情况不能为空!");
			return;
		}
		UserMes user = new UserMes(Integer.parseInt(userId), userName, userSex,userCollege, userPro,
				userCity, Float.parseFloat(userTemperature), userArrive,userSympotom, userCheck);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int n = userDao.userAdd(con, user);
			if (n == 1) {
				JOptionPane.showMessageDialog(this, "添加成功!");
				this.resetValue();
			} else {
				JOptionPane.showMessageDialog(this, "添加失败!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "添加失败!");
		}

	}
	/** 重置*/
	private void jb_resetActionPerformed(java.awt.event.ActionEvent evt) {
		this.resetValue();
	}


	 
	 private static final long PERIOD_DAY = 24 * 60 * 60 * 1000;
	 private static final long TEST_SEC = 15 * 1000;
	 public static void timeTig() {
	  // 使用默认时区和语言环境获得一个日历
	  Calendar calendar = Calendar.getInstance();
	  // 设置时间
	  calendar.set(Calendar.HOUR_OF_DAY, 10);// 小时
	  calendar.set(Calendar.MINUTE, 00);// 分钟
	  calendar.set(Calendar.SECOND, 0);// 秒
	  // 第一次执行任务的时间
	  Date time = calendar.getTime();
	  // 如果第一次执行任务的时间早于当前时间
	  if (time.before(new Date())) {
	   time = addDay(time, 1);
	   System.exit(0);
	  }
	 }
	 // 增加一天
	 public static Date addDay(Date date, int num) {
	  JOptionPane.showMessageDialog(null,"错过打卡时间!");
	  Calendar startDT = Calendar.getInstance();
	  startDT.setTime(date);
	  startDT.add(Calendar.DAY_OF_MONTH, num);
	  return startDT.getTime();
	 }
	// 增加一分钟

	public Date addMinute(Date date, int num) {

		System.out.println("增加一分钟");

		Calendar startDT = Calendar.getInstance();

		startDT.setTime(date);

		startDT.add(Calendar.MINUTE, num);

		return startDT.getTime();

	}
	public void timeTigAlarm() {

		// 使用默认时区和语言环境获得一个日历

		Calendar calendar = Calendar.getInstance();

		// 设置时间

		calendar.set(Calendar.HOUR_OF_DAY, 9);// 小时

		calendar.set(Calendar.MINUTE, 55);// 分钟

		calendar.set(Calendar.SECOND, 0);// 秒

		// 第一次执行任务的时间

		Date time = calendar.getTime();

		// 如果第一次执行任务的时间早于当前时间，那么第一次执行任务的时间推迟一天

		//System.out.println("启动时间:" + time);

		// 启动计划

		Timer timer = new Timer();

		timer.schedule(new TimeTrigger(), time, PERIOD_DAY);

		//System.out.println("当前时间:" + new Date());

	}


	/** 重置清空*/
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
