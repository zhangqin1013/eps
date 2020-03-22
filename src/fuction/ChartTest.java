package fuction;

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
	//ĳ��ȷ������ͳ��
	public void getChart1(ResultSet rs) throws Exception {	
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		while(rs.next()){
		    dataset.setValue(
		            rs.getInt("num"),
		            "����",
		            rs.getString("userSex")
		    );
		}
		// �����򵥵�����ͼ
		JFreeChart freeChart=ChartFactory.createBarChart(
		        "ȷ����Ϣ",// ͼ�����
		        "�Ա�",
		        "����",
		        dataset,//���ݼ�����Ҫ��ʾ��ͼ���ϵ�����
		        PlotOrientation.VERTICAL,
		        true,//�Ƿ���ʾͼ��
		        false,//�Ƿ���ʾ��ʾ
		        false//�Ƿ�����URL����
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
		//��״ͼ��ʾ
		//SHOW(freeChart,800,500);
		//�ر����ݿ⣻����
		//Dbutil.closeCon(rs, stmt, conn);  
	}
	//��״ͼ��ʾ����
		public void SHOW(JFreeChart freeChart,int width,int height) {
			//�������ʾ������һ��ͼ�����
	        ChartPanel chartPanel=new ChartPanel(freeChart);
	        //���ô�С
	        chartPanel.setPreferredSize(new java.awt.Dimension(560,400));
	        //����һ������������ʾ���
	        JFrame frame=new JFrame("����ͳ��ͼ");
	        frame.setLocation(500,400);
	        frame.setSize(width,height);
	        //��ͼ���������Ϊ�����ڵ��������
	        frame.setContentPane(chartPanel);
	        //��ʾ������
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	        
	        //����ͼ��
	        freeChart.getTitle().setFont(new Font("����", Font.ITALIC, 15));//���ñ���
			//����ͼ���������         
			freeChart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));  
			freeChart.setBackgroundPaint(Color.WHITE);
			CategoryPlot categoryPlot=freeChart.getCategoryPlot();//����������ʾ����
			categoryPlot.setBackgroundPaint(Color.WHITE);
			categoryPlot.setDomainGridlinePaint(Color.BLACK);//����������������ɫ
			categoryPlot.setDomainGridlinesVisible(true);
			categoryPlot.setRangeGridlinePaint(Color.GREEN);//����������������ɫ
			
			CategoryAxis domainAxis=categoryPlot.getDomainAxis(); //ˮƽ�ײ��б� 
			domainAxis.setLabelFont(new Font("����",Font.BOLD,14)); //ˮƽ�ײ����� 
			domainAxis.setTickLabelFont(new Font("����",Font.BOLD,12)); //��ֱ����
			ValueAxis rangeAxis=categoryPlot.getRangeAxis();//��ȡ��״ 
			rangeAxis.setLabelFont(new Font("����",Font.BOLD,15)); //������״����
			
			CategoryAxis axis = categoryPlot.getDomainAxis(); //x��
			axis.setMaximumCategoryLabelLines(10); //����������ÿ������ʾһ��
			axis.setMaximumCategoryLabelWidthRatio(0.5f); //ÿ�������ȣ�����Ϊ1���ֵĿ��
			
			NumberAxis axis1 = (NumberAxis)freeChart.getCategoryPlot().getRangeAxis();
			//axis1.setTickUnit(new NumberTickUnit(0.5D);//0.5Ϊһ�������λ
			axis1.setTickUnit(new NumberTickUnit(1D));//1Ϊһ�������λ
		}
}