package view;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import dao.UserDao;
import fuction.ChartTest;
import pojo.User;
import pojo.userMes;
import util.Dbutil;
import util.StringUtil;

public class Main_college extends javax.swing.JFrame {
	// ����
	private JTextField nameTxt;
	private JLabel jLabel2;
	// ѧ��
	private JTextField idTxt;
	private JLabel jLabel1;
	// �Ա�
	private JTextField sexTxt;
	private JLabel jLabel3;
	// ����ʡ
	private JTextField proTxt;
	private javax.swing.JLabel jLabel4;
	// ������
	private JTextField cityTxt;
	private JLabel jLabel5;
	// ��У���
	private JTextField arriveTxt;
	private JLabel jLabel6;
	// ȷ�����
	private JTextField checkTxt;
	private JLabel jLabel7;
	// ����
	private JTextField dateTxt;
	private JLabel jLabel8;

	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	// ��ѯ
	private JButton jb_search;
	// ͼ��
	private JButton jb_graph;
	private JTable userTable;
	private String userCollege;
	Dbutil dbUtil = new Dbutil();
	UserDao userDao = new UserDao();

	/** Creates new form StudentViewInterFrm */
	public Main_college() {
		initComponents();
		//userCollege=college;
		//userMes user = new userMes(college);
		//this.setLocation(300, 70);
		this.fillTable(new userMes());
		this.setLocationRelativeTo(null);
	}

	private void fillTable(userMes user) {
		DefaultTableModel dtm = (DefaultTableModel) userTable.getModel();
		int currentcollegeID = logOn.currentCollege.getID();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = userDao.SelectedList(con, currentcollegeID);
			int num=0;
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
			if(num==0) {
				JOptionPane.showMessageDialog(null,"������Ϣ!");
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
		jb_search = new javax.swing.JButton();
		jb_graph = new javax.swing.JButton();

		setTitle("��Ժ������Ϣ�鿴");

		userTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "ѧ��/����", "����", "�Ա�", "ѧԺ","ʡ��", "����", "����","��У���", "�������", "ȷ�����", "����" }) {
			   boolean[] canEdit = new boolean[] { false, false,false,false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane1.setViewportView(userTable);

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("��������"));

		jLabel1.setText("ѧ��/����");
		jLabel2.setText("    ����      ");
		jLabel3.setText("  �Ա�      ");
		jLabel4.setText("  ʡ�� ");
		jLabel5.setText("    ����      ");
		jLabel6.setText("��У���");
		jLabel7.setText("ȷ�����");
		jLabel8.setText("  ���� ");

		jb_search.setText("��ѯ");
		jb_search.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jb_searchActionPerformed(evt);
					jb_resetActionPerformed(evt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		jb_graph.setText("ͼ����ʾ");
		jb_graph.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jb_graphActionPerformed(evt);
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
						.addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 104,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(69, 69, 69).addComponent(jLabel2)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 96,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(78, 78, 78).addComponent(jLabel3)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(sexTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 104,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(78, 78, 78).addComponent(jLabel4)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(proTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 104,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(56, 56, 56).addComponent(jb_search).addContainerGap(85, Short.MAX_VALUE))
				
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(78, 78, 78).addComponent(jLabel5)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(cityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 104,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(69, 69, 69).addComponent(jLabel6)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(arriveTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 96,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(78, 78, 78).addComponent(jLabel7)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(checkTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 104,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(78,78, 78).addComponent(jLabel8)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(dateTxt,
								javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(56, 56, 56).addComponent(jb_graph).addContainerGap(85, Short.MAX_VALUE)
						)

		);
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(25, 25, 25).addGroup(jPanel1Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1)
								.addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jb_search)
								.addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2)
								.addComponent(sexTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel3)
								.addComponent(proTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel4)).addContainerGap(38, Short.MAX_VALUE))
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(100, 100, 100).addGroup(jPanel1Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel5)
								.addComponent(cityTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jb_graph)

								.addComponent(arriveTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel6)
								.addComponent(checkTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel7)
								.addComponent(dateTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel8)).addContainerGap(38, Short.MAX_VALUE)
								));

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
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,250,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(36, Short.MAX_VALUE)));

		pack();

	}
	/**
	 * ��Ӧ���ݻ�ȡ
	 * 
	 * @param userID
	 * @throws Exception
	 */
	protected userMes getUser() throws Exception {
		// TODO Auto-generated method stub		
		String userID = this.idTxt.getText();
		String userName = this.nameTxt.getText();
		String userSex = this.sexTxt.getText();
		String userPro = this.proTxt.getText();
		String userCity = this.cityTxt.getText();
		String userArrive = this.arriveTxt.getText();
		String userCheck = this.checkTxt.getText();
		String college = userCollege;
		String date = this.dateTxt.getText();  
		if (StringUtil.isEmpty(userID)) {
			userID = "-1";
			
		}
		if (StringUtil.isEmpty(date)) {
			date = "-1";
			
		}
		//System.out.print(date);
		userMes user = new userMes(Integer.parseInt(userID), userName, userSex,college,userPro, userCity, userArrive,userCheck,Integer.parseInt(date));
		return user;
	}
	protected void jb_graphActionPerformed(ActionEvent evt) throws Exception {
		// TODO Auto-generated method stub
		userMes user = getUser();
		Connection con = null;
		con = dbUtil.getCon();
		ResultSet rs = userDao.Chart(con, user);
		ChartTest chart = new ChartTest();
		chart.getChart1(rs);
	}

	private void jb_searchActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
		userMes user = getUser();
		this.fillTable(user);
	}
	/*
	 * ����
	 */
	private void jb_resetActionPerformed(java.awt.event.ActionEvent evt) {
		this.resetValue();
	}
	private void resetValue() {
		this.idTxt.setText("");
		this.nameTxt.setText("");
		this.sexTxt.setText("");
		this.proTxt.setText("");
		this.cityTxt.setText("");
		this.arriveTxt.setText("");
		this.checkTxt.setText("");
		this.dateTxt.setText("");
	}
	/*public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Main_college().setVisible(true);
			}
		});
	}*/

}
