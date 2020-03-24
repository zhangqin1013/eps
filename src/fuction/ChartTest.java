package fuction;

/**
 * FileName: ChartTest.java
 * 产生柱状图界面
 * @author Lipeishan，ZhangQin
 * @Date  2020.03.21
 */
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import util.DbUtil;

public class ChartTest {
	ChartPanel frame1;

	// 某天确诊人数统计
	public void getChart1(ResultSet rs) throws Exception {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		while (rs.next()) {
			dataset.setValue(rs.getInt("num"), "人数", rs.getString("userSex"));
		}
		// 创建简单的条形图
		JFreeChart freeChart = ChartFactory.createBarChart("确诊信息", // 图表标题
				"性别", "人数", dataset, // 数据集，即要显示在图表上的数据
				PlotOrientation.VERTICAL, true, // 是否显示图例
				false, // 是否显示提示
				false// 是否生成URL连接
		);
		// 获取图表区域对象
		CategoryPlot plot = freeChart.getCategoryPlot();
		// 水平底部列表
		CategoryAxis domainAxis = plot.getDomainAxis();
		// 水平底部标题
		domainAxis.setLabelFont(new Font("黑体", Font.BOLD, 14));
		// 垂直标题
		domainAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 12));
		// 获取柱状
		ValueAxis rangeAxis = plot.getRangeAxis();
		rangeAxis.setLabelFont(new Font("黑体", Font.BOLD, 15));
		freeChart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
		// 设置标题字体
		freeChart.getTitle().setFont(new Font("宋体", Font.BOLD, 20));

		frame1 = new ChartPanel(freeChart, true);
		JFrame frame = new JFrame("柱状图");
		frame.add(frame1); // 添加柱形图
		frame.setBounds(50, 50, 800, 600);
		frame.setVisible(true);
		// 柱状图显示
		// SHOW(freeChart,800,500);
		// 关闭数据库；连接
		// Dbutil.closeCon(rs, stmt, conn);
	}

	public void getChart2(ResultSet rs) throws Exception {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		while (rs.next()) {
			dataset.setValue(rs.getInt("num"), "人数", rs.getString("userCheck"));
		}
		// 创建简单的条形图
		JFreeChart freeChart = ChartFactory.createBarChart("是否确诊", // 图表标题
				"性别", "人数", dataset, // 数据集，即要显示在图表上的数据
				PlotOrientation.VERTICAL, true, // 是否显示图例
				false, // 是否显示提示
				false// 是否生成URL连接
		);
		// 获取图表区域对象
		CategoryPlot plot = freeChart.getCategoryPlot();
		// 水平底部列表
		CategoryAxis domainAxis = plot.getDomainAxis();
		// 水平底部标题
		domainAxis.setLabelFont(new Font("黑体", Font.BOLD, 14));
		// 垂直标题
		domainAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 12));
		// 获取柱状
		ValueAxis rangeAxis = plot.getRangeAxis();
		rangeAxis.setLabelFont(new Font("黑体", Font.BOLD, 15));
		freeChart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
		// 设置标题字体
		freeChart.getTitle().setFont(new Font("宋体", Font.BOLD, 20));

		frame1 = new ChartPanel(freeChart, true);
		JFrame frame = new JFrame("柱状图");
		frame.add(frame1); // 添加柱形图
		frame.setBounds(50, 50, 800, 600);
		frame.setVisible(true);
		// 柱状图显示
		// SHOW(freeChart,800,500);
		// 关闭数据库；连接
		// Dbutil.closeCon(rs, stmt, conn);
	}
}