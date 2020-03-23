package fuction;

/**
 * FileName: pieChart.java
 * 登录界面
 * @author Lipeishan，ZhangQin
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
		JFreeChart chart = ChartFactory.createPieChart3D("填报情况", data, true, false, false);
		// 设置百分比
		PiePlot pieplot = (PiePlot) chart.getPlot();
		DecimalFormat df = new DecimalFormat("0.00%");// 获得一个DecimalFormat对象，主要是设置小数问题
		NumberFormat nf = NumberFormat.getNumberInstance();// 获得一个NumberFormat对象
		StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);// 获得StandardPieSectionLabelGenerator对象
		pieplot.setLabelGenerator(sp1);// 设置饼图显示百分比

		// 没有数据的时候显示的内容
		pieplot.setNoDataMessage("无数据显示");
		pieplot.setCircular(false);
		pieplot.setLabelGap(0.02D);

		pieplot.setIgnoreNullValues(true);// 设置不显示空值
		pieplot.setIgnoreZeroValues(true);// 设置不显示负值
		frame1 = new ChartPanel(chart, true);
		chart.getTitle().setFont(new Font("宋体", Font.BOLD, 20));// 设置标题字体
		PiePlot piePlot = (PiePlot) chart.getPlot();// 获取图表区域对象
		piePlot.setLabelFont(new Font("宋体", Font.BOLD, 10));// 解决乱码
		chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 10));

		JFrame frame = new JFrame("柱状图");
		frame.add(frame1); // 添加柱形图
		frame.setBounds(50, 50, 800, 600);
		frame.setVisible(true);
	}

	/**
	 * 使用查询数据库的数据
	 * 
	 * @return 数据集
	 * @throws Exception
	 */
	private static DefaultPieDataset getDataSet(String college) throws SQLException, Exception {
		DefaultPieDataset dataset = new DefaultPieDataset();
		java.util.List<userMes> list = Check(college);
		// 装成JFreeChart需要的数据集
		for (userMes usermes : list) {
			dataset.setValue(usermes.getStatus(), usermes.getNum());
		}
		return dataset;
	}

	/**
	 * 产生进行做柱状图的结果表
	 * 
	 * @return list 查询结果
	 * @throws SQLException
	 * @throws Exception
	 */
	public static java.util.List<userMes> Check(String college) throws SQLException, Exception {
		Connection con = null;
		con = Dbutil.getCon();
		// String col = College;
		java.util.List<userMes> list = new ArrayList<userMes>();
		try {
			String sql = "select  \"未填写\" as status ,count(id) as num from user where not exists(select 1 from mes where mes.userCollege='"
					+ college
					+ "'and user.id = mes.userId) UNION select \"填写\" as status,count(userId) as num from mes where userCollege='"
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
