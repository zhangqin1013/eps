package fuction;

/**
 * FileName: ChartTest.java
 * ������״ͼ����
 * @author Lipeishan��ZhangQin
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

import util.Dbutil;

public class ChartTest {
	ChartPanel frame1;

	// ĳ��ȷ������ͳ��
	public void getChart1(ResultSet rs) throws Exception {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		while (rs.next()) {
			dataset.setValue(rs.getInt("num"), "����", rs.getString("userSex"));
		}
		// �����򵥵�����ͼ
		JFreeChart freeChart = ChartFactory.createBarChart("ȷ����Ϣ", // ͼ�����
				"�Ա�", "����", dataset, // ���ݼ�����Ҫ��ʾ��ͼ���ϵ�����
				PlotOrientation.VERTICAL, true, // �Ƿ���ʾͼ��
				false, // �Ƿ���ʾ��ʾ
				false// �Ƿ�����URL����
		);
		// ��ȡͼ���������
		CategoryPlot plot = freeChart.getCategoryPlot();
		// ˮƽ�ײ��б�
		CategoryAxis domainAxis = plot.getDomainAxis();
		// ˮƽ�ײ�����
		domainAxis.setLabelFont(new Font("����", Font.BOLD, 14));
		// ��ֱ����
		domainAxis.setTickLabelFont(new Font("����", Font.BOLD, 12));
		// ��ȡ��״
		ValueAxis rangeAxis = plot.getRangeAxis();
		rangeAxis.setLabelFont(new Font("����", Font.BOLD, 15));
		freeChart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));
		// ���ñ�������
		freeChart.getTitle().setFont(new Font("����", Font.BOLD, 20));

		frame1 = new ChartPanel(freeChart, true);
		JFrame frame = new JFrame("��״ͼ");
		frame.add(frame1); // �������ͼ
		frame.setBounds(50, 50, 800, 600);
		frame.setVisible(true);
		// ��״ͼ��ʾ
		// SHOW(freeChart,800,500);
		// �ر����ݿ⣻����
		// Dbutil.closeCon(rs, stmt, conn);
	}

	public void getChart2(ResultSet rs) throws Exception {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		while (rs.next()) {
			dataset.setValue(rs.getInt("num"), "����", rs.getString("userCheck"));
		}
		// �����򵥵�����ͼ
		JFreeChart freeChart = ChartFactory.createBarChart("�Ƿ�ȷ��", // ͼ�����
				"�Ա�", "����", dataset, // ���ݼ�����Ҫ��ʾ��ͼ���ϵ�����
				PlotOrientation.VERTICAL, true, // �Ƿ���ʾͼ��
				false, // �Ƿ���ʾ��ʾ
				false// �Ƿ�����URL����
		);
		// ��ȡͼ���������
		CategoryPlot plot = freeChart.getCategoryPlot();
		// ˮƽ�ײ��б�
		CategoryAxis domainAxis = plot.getDomainAxis();
		// ˮƽ�ײ�����
		domainAxis.setLabelFont(new Font("����", Font.BOLD, 14));
		// ��ֱ����
		domainAxis.setTickLabelFont(new Font("����", Font.BOLD, 12));
		// ��ȡ��״
		ValueAxis rangeAxis = plot.getRangeAxis();
		rangeAxis.setLabelFont(new Font("����", Font.BOLD, 15));
		freeChart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));
		// ���ñ�������
		freeChart.getTitle().setFont(new Font("����", Font.BOLD, 20));

		frame1 = new ChartPanel(freeChart, true);
		JFrame frame = new JFrame("��״ͼ");
		frame.add(frame1); // �������ͼ
		frame.setBounds(50, 50, 800, 600);
		frame.setVisible(true);
		// ��״ͼ��ʾ
		// SHOW(freeChart,800,500);
		// �ر����ݿ⣻����
		// Dbutil.closeCon(rs, stmt, conn);
	}
}