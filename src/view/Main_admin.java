package view;

/**
 * FileName: Main_admin.java
 * 防疫办功能界面
 * @author Lipeishan，ZhangQin
 * @Date  2020.03.21
 */
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import util.DbUtil;

import dao.UserDao;
import fuction.ChartTest;
import fuction.DBtoExcel;
import fuction.PieChart;
import pojo.Admin;
import pojo.User;
import pojo.UserMes;
import util.StringUtil;

public class Main_admin extends javax.swing.JFrame {
	// 姓名
	private javax.swing.JTextField nameTxt;
	private javax.swing.JLabel jLabel2;
	// 学号
	private javax.swing.JTextField idTxt;
	private javax.swing.JLabel jLabel1;
	// 性别
	private javax.swing.JTextField sexTxt;
	private javax.swing.JLabel jLabel3;
	// 所在省
	private javax.swing.JTextField proTxt;
	private javax.swing.JLabel jLabel4;
	// 所在市
	private javax.swing.JTextField cityTxt;
	private javax.swing.JLabel jLabel5;
	// 返校情况
	private javax.swing.JTextField arriveTxt;
	private javax.swing.JLabel jLabel6;
	// 确诊情况
	private javax.swing.JTextField checkTxt;
	private javax.swing.JLabel jLabel7;
	// 日期
	private javax.swing.JTextField dateTxt;
	private javax.swing.JLabel jLabel8;
	// 学院
	private javax.swing.JTextField collegeTxt;
	private javax.swing.JLabel jLabel9;

	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	// 查询
	private javax.swing.JButton jb_search;
	// 图表
	private javax.swing.JButton jb_graph;
	// 图表
	private javax.swing.JButton jb_Bgraph;
	// 导出到excel
	private javax.swing.JButton jb_excel;
	private javax.swing.JTable userTable;

	DbUtil dbUtil = new DbUtil();
	UserDao userDao = new UserDao();

	/** 防疫办显示界面 */
	public Main_admin() {
		initComponents();
		this.setLocation(300, 70);
		this.fillTable(new UserMes());
		this.setLocationRelativeTo(null);
	}

	private void fillTable(UserMes user) {
		DefaultTableModel dtm = (DefaultTableModel) userTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = userDao.StudentList(con, user);
			int num = 0;
			while (rs.next()) {
				num++;
				Vector v = new Vector();
				v.add(rs.getString("userId"));
				v.add(rs.getString("userName"));
				v.add(rs.getString("userSex"));
				v.add(rs.getString("userCollege"));
				v.add(rs.getString("userPro"));
				v.add(rs.getString("userCity"));
				v.add(rs.getString("userTemperature"));
				v.add(rs.getString("userArrive"));
				v.add(rs.getString("userSympotom"));
				v.add(rs.getString("userCheck"));
				v.add(rs.getString("date"));
				dtm.addRow(v);
			}
			if (num == 0) {
				JOptionPane.showMessageDialog(null, "暂无信息!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 界面初始化
	 */
	private void initComponents() {
		jScrollPane1 = new javax.swing.JScrollPane();
		userTable = new javax.swing.JTable();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		idTxt = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		nameTxt = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		sexTxt = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		proTxt = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		cityTxt = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		arriveTxt = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		checkTxt = new javax.swing.JTextField();
		jLabel8 = new javax.swing.JLabel();
		dateTxt = new javax.swing.JTextField();
		jLabel9 = new javax.swing.JLabel();
		collegeTxt = new javax.swing.JTextField();
		jb_search = new javax.swing.JButton();
		jb_graph = new javax.swing.JButton();
		jb_Bgraph = new javax.swing.JButton();
		jb_excel = new javax.swing.JButton();

		setTitle("防疫信息查看");

		userTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "学号/工号", "姓名", "性别", "学院", "省份", "城市", "体温", "返校情况", "疑似情况", "确诊情况", "日期" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false,
					false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane1.setViewportView(userTable);

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("搜索条件"));

		jLabel1.setText("学号/工号");
		jLabel2.setText("    姓名      ");
		jLabel3.setText("  性别      ");
		jLabel4.setText("   省份      ");
		jLabel5.setText("    城市     ");
		jLabel6.setText("返校情况");
		jLabel7.setText("确诊情况 ");
		jLabel8.setText("     日期    ");
		jLabel9.setText("    学院     ");

		jb_search.setText("查询");
		jb_search.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jb_searchActionPerformed(evt);
					// jb_resetActionPerformed(evt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		jb_graph.setText("图表显示");
		jb_graph.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jb_graphActionPerformed(evt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// jb_resetActionPerformed(evt);
			}
		});

		jb_excel.setText("导出");
		jb_excel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					String urls = jb_excelActionPerformed(evt);
					// jb_resetActionPerformed(evt);
					JOptionPane.showMessageDialog(null, "数据导出成功!路径为:" + urls);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		jb_Bgraph.setText("当日填报情况");
		jb_Bgraph.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jb_BgraphActionPerformed(evt);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(78, 78, 78).addComponent(jLabel1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(69, 69, 69).addComponent(jLabel2)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(78, 78, 78).addComponent(jLabel3)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(sexTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(56, 56, 56).addComponent(jb_search).addGap(56, 56, 56).addComponent(jb_Bgraph)
						.addContainerGap(85, Short.MAX_VALUE))

				.addGroup(jPanel1Layout.createSequentialGroup().addGap(78, 78, 78).addComponent(jLabel9)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(collegeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(69, 69, 69).addComponent(jLabel4)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(proTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
								javax.swing.GroupLayout.PREFERRED_SIZE)

						.addGap(78, 78, 78).addComponent(jLabel5)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(cityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(56, 56, 56).addComponent(jb_graph).addContainerGap(85, Short.MAX_VALUE))

				.addGroup(jPanel1Layout.createSequentialGroup().addGap(78, 78, 78).addComponent(jLabel6)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(arriveTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(69, 69, 69).addComponent(jLabel7)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)

						.addComponent(checkTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(78, 78, 78).addComponent(jLabel8)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)

						.addComponent(dateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(56, 56, 56).addComponent(jb_excel).addContainerGap(85, Short.MAX_VALUE))

		);
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(25, 25, 25).addGroup(jPanel1Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1)
								.addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jb_search).addComponent(jb_Bgraph)
								.addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2)
								.addComponent(sexTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel3)).addContainerGap(38, Short.MAX_VALUE))
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(85, 85, 85).addGroup(jPanel1Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel9)
								.addComponent(collegeTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jb_graph)
								.addComponent(proTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel4)
								.addComponent(cityTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel5)).addContainerGap(38, Short.MAX_VALUE))
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(145, 145, 145).addGroup(jPanel1Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel6)
								.addComponent(arriveTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jb_excel)
								.addComponent(checkTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel7)
								.addComponent(dateTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel8)).addContainerGap(38, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(36, Short.MAX_VALUE)));

		pack();

	}

	/**
	 * 相应数据获取
	 * 
	 * @param userID
	 * @throws Exception
	 */
	protected UserMes getUser() throws Exception {
		// TODO Auto-generated method stub
		String userID = this.idTxt.getText();
		String userName = this.nameTxt.getText();
		String userSex = this.sexTxt.getText();
		String userPro = this.proTxt.getText();
		String userCity = this.cityTxt.getText();
		String userArrive = this.arriveTxt.getText();
		String userCheck = this.checkTxt.getText();
		String userCollege = this.collegeTxt.getText();
		String date = this.dateTxt.getText();
		if (StringUtil.isEmpty(userID)) {
			userID = "-1";

		}
		if (StringUtil.isEmpty(date)) {
			date = "-1";

		}
		// System.out.print(date);
		UserMes user = new UserMes(Integer.parseInt(userID), userName, userSex, userCollege, userPro, userCity,
				userArrive, userCheck, Integer.parseInt(date));
		return user;
	}

	/**
	 * 按下导出的具体功能实现
	 * 
	 * @param evt,相应事件
	 * @throws Exception
	 */
	protected String jb_excelActionPerformed(ActionEvent evt) throws Exception {
		// TODO Auto-generated method stub
		DBtoExcel dBtoExcel = new DBtoExcel();
		UserMes user = getUser();
		String urls = this.Write(user);
		return urls;
	}

	/**
	 * 将查询结果写入excel中
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	private String Write(UserMes user) throws Exception {
		Vector columnName = new Vector();
		columnName.add("学号/工号");
		columnName.add("姓名");
		columnName.add("性别");
		columnName.add("学院");
		columnName.add("省份");
		columnName.add("城市");
		columnName.add("当日体温");
		columnName.add("是否返校");
		columnName.add("是否疑似");
		columnName.add("是否确诊");
		columnName.add("日期");
		Connection con = null;
		con = dbUtil.getCon();
		ResultSet rs = userDao.StudentList(con, user);
		String urls = "D:/1.xls";
		new DBtoExcel().WriteExcel(rs, urls, "防疫信息", columnName);
		return urls;
	}

	/**
	 * 查询结果显示为柱状
	 * 
	 * @param evt 响应事件
	 * @throws Exception
	 */
	private void jb_graphActionPerformed(ActionEvent evt) throws Exception {
		// TODO Auto-generated method stub
		String userID = this.idTxt.getText();
		String userName = this.nameTxt.getText();
		String userSex = this.sexTxt.getText();
		String userPro = this.proTxt.getText();
		String userCity = this.cityTxt.getText();
		String userArrive = this.arriveTxt.getText();
		String userCheck = this.checkTxt.getText();
		String userCollege = this.collegeTxt.getText();
		String date = this.dateTxt.getText();
		if (StringUtil.isEmpty(userID)) {
			userID = "-1";

		}
		if (StringUtil.isEmpty(date)) {
			date = "-1";

		}
		if (StringUtil.isEmpty(userSex)) {
			if (StringUtil.isEmpty(userCheck)) {
				userCheck = "是";

			}
			UserMes user = new UserMes(Integer.parseInt(userID), userName, userSex, userCollege, userPro, userCity,
					userArrive, userCheck, Integer.parseInt(date));
			Connection con = null;
			con = dbUtil.getCon();
			ResultSet rs = userDao.Chart(con, user);
			ChartTest chart = new ChartTest();
			chart.getChartSex(rs);
		} else {
			UserMes user = new UserMes(Integer.parseInt(userID), userName, userSex, userCollege, userPro, userCity,
					userArrive, userCheck, Integer.parseInt(date));
			// userMes user = getUser();
			Connection con = null;
			con = dbUtil.getCon();
			ResultSet rs = userDao.ChartCheckAll(con, user);
			ChartTest chart = new ChartTest();
			chart.getChartCheck(rs);
		}
	}

	/**
	 * 填写情况依靠学院显示为饼状图
	 * 
	 * @param evt 相应事件
	 * @throws Exception
	 */
	protected void jb_BgraphActionPerformed(ActionEvent evt) throws Exception {
		String userCollege = this.collegeTxt.getText();
		PieChart chart = new PieChart();
		chart.pieChart1(userCollege);
	}

	/** 查询功能实现*/
	private void jb_searchActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
		UserMes user = getUser();
		this.fillTable(user);
	}

	/*
	 * public static void main(String args[]) { java.awt.EventQueue.invokeLater(new
	 * Runnable() { public void run() { new Main_admin().setVisible(true); } }); }
	 */
}
