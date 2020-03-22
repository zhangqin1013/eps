package fuction;
import java.awt.Font;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
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
	public pieChart() throws SQLException, Exception{
		  DefaultPieDataset data = getDataSet();
	      JFreeChart chart = ChartFactory.createPieChart3D("����",data,true,false,false);
	    //���ðٷֱ�
	      PiePlot pieplot = (PiePlot) chart.getPlot();
	      DecimalFormat df = new DecimalFormat("0.00%");//���һ��DecimalFormat������Ҫ������С������
	      NumberFormat nf = NumberFormat.getNumberInstance();//���һ��NumberFormat����
	      StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//���StandardPieSectionLabelGenerator����
	      pieplot.setLabelGenerator(sp1);//���ñ�ͼ��ʾ�ٷֱ�
	  
	  //û�����ݵ�ʱ����ʾ������
	      pieplot.setNoDataMessage("��������ʾ");
	      pieplot.setCircular(false);
	      pieplot.setLabelGap(0.02D);
	  
	      pieplot.setIgnoreNullValues(true);//���ò���ʾ��ֵ
	      pieplot.setIgnoreZeroValues(true);//���ò���ʾ��ֵ
	     frame1=new ChartPanel (chart,true);
	      chart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ�������
	      PiePlot piePlot= (PiePlot) chart.getPlot();//��ȡͼ���������
	      piePlot.setLabelFont(new Font("����",Font.BOLD,10));//�������
	      chart.getLegend().setItemFont(new Font("����",Font.BOLD,10));
	}
    private static DefaultPieDataset getDataSet() throws SQLException, Exception {
        DefaultPieDataset dataset = new DefaultPieDataset();
        java.util.List<userMes> list = Check();
		//װ��JFreeChart��Ҫ�����ݼ�
		for (userMes usermes : list) {
		dataset.setValue(usermes.getStatus(), usermes.getNum());
		}
		return dataset;
}
    
	public static java.util.List<userMes> Check() throws SQLException, Exception {
		Connection con = null;
		con = Dbutil.getCon();
		java.util.List<userMes> list = new ArrayList<userMes>();
		try {
			String sql = "select \"δ��д\" as status ,count(user.id)-B.num as num from user,(select date,count(date) as num from mes where date=\"2020-3-20\")as B GROUP BY date UNION select \"��д\"as status,count(date) from mes where date=\"2020-3-20\"" ;
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

    public ChartPanel getChartPanel(){
    	return frame1;
    	
    }
    public static void main(String[] args) throws SQLException, Exception {
    	JFrame frame = new JFrame("��״ͼ");
		frame.add(new pieChart().getChartPanel()); // �������ͼ
		frame.setBounds(50, 50, 800, 600);
		frame.setVisible(true);
		
	}

}
