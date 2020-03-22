package fuction;

/**
 * FileName: pieChart.java
 * ��¼����
 * @author Lipeishan��ZhangQin
 * @Date  2020.03.21
 */
import java.awt.Font;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import pojo.userMes;
import util.Dbutil;

public class pieChart {
	ChartPanel frame1;
	public String College = null;

	public void pieChart1(String college) throws SQLException, Exception {
		DefaultPieDataset data = getDataSet(college);
		JFreeChart chart = ChartFactory.createPieChart3D("����", data, true, false, false);
		// ���ðٷֱ�
		PiePlot pieplot = (PiePlot) chart.getPlot();
		DecimalFormat df = new DecimalFormat("0.00%");// ���һ��DecimalFormat������Ҫ������С������
		NumberFormat nf = NumberFormat.getNumberInstance();// ���һ��NumberFormat����
		StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);// ���StandardPieSectionLabelGenerator����
		pieplot.setLabelGenerator(sp1);// ���ñ�ͼ��ʾ�ٷֱ�

		// û�����ݵ�ʱ����ʾ������
		pieplot.setNoDataMessage("��������ʾ");
		pieplot.setCircular(false);
		pieplot.setLabelGap(0.02D);

		pieplot.setIgnoreNullValues(true);// ���ò���ʾ��ֵ
		pieplot.setIgnoreZeroValues(true);// ���ò���ʾ��ֵ
		frame1 = new ChartPanel(chart, true);
		chart.getTitle().setFont(new Font("����", Font.BOLD, 20));// ���ñ�������
		PiePlot piePlot = (PiePlot) chart.getPlot();// ��ȡͼ���������
		piePlot.setLabelFont(new Font("����", Font.BOLD, 10));// �������
		chart.getLegend().setItemFont(new Font("����", Font.BOLD, 10));

		JFrame frame = new JFrame("��״ͼ");
		frame.add(frame1); // �������ͼ
		frame.setBounds(50, 50, 800, 600);
		frame.setVisible(true);
	}

	private static DefaultPieDataset getDataSet(String college) throws SQLException, Exception {
		DefaultPieDataset dataset = new DefaultPieDataset();
		java.util.List<userMes> list = Check(college);
		// װ��JFreeChart��Ҫ�����ݼ�
		for (userMes usermes : list) {
			dataset.setValue(usermes.getStatus(), usermes.getNum());
		}
		return dataset;
	}

	public static java.util.List<userMes> Check(String college) throws SQLException, Exception {
		Connection con = null;
		con = Dbutil.getCon();
		// String col = College;
		java.util.List<userMes> list = new ArrayList<userMes>();
		try {
			String sql = "select  \"δ��д\" as status ,count(id) as num from user where not exists(select 1 from mes where mes.userCollege='"
					+ college
					+ "'and user.id = mes.userId) UNION select \"��д\" as status,count(userId) as num from mes where userCollege='"
					+ college + "'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(new userMes(rs.getString(1), rs.getInt(2)));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;

	}
}
