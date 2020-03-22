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
	      JFreeChart chart = ChartFactory.createPieChart3D("填报情况",data,true,false,false);
	    //设置百分比
	      PiePlot pieplot = (PiePlot) chart.getPlot();
	      DecimalFormat df = new DecimalFormat("0.00%");//获得一个DecimalFormat对象，主要是设置小数问题
	      NumberFormat nf = NumberFormat.getNumberInstance();//获得一个NumberFormat对象
	      StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//获得StandardPieSectionLabelGenerator对象
	      pieplot.setLabelGenerator(sp1);//设置饼图显示百分比
	  
	  //没有数据的时候显示的内容
	      pieplot.setNoDataMessage("无数据显示");
	      pieplot.setCircular(false);
	      pieplot.setLabelGap(0.02D);
	  
	      pieplot.setIgnoreNullValues(true);//设置不显示空值
	      pieplot.setIgnoreZeroValues(true);//设置不显示负值
	     frame1=new ChartPanel (chart,true);
	      chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
	      PiePlot piePlot= (PiePlot) chart.getPlot();//获取图表区域对象
	      piePlot.setLabelFont(new Font("宋体",Font.BOLD,10));//解决乱码
	      chart.getLegend().setItemFont(new Font("黑体",Font.BOLD,10));
	}
    private static DefaultPieDataset getDataSet() throws SQLException, Exception {
        DefaultPieDataset dataset = new DefaultPieDataset();
        java.util.List<userMes> list = Check();
		//装成JFreeChart需要的数据集
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
			String sql = "select \"未填写\" as status ,count(user.id)-B.num as num from user,(select date,count(date) as num from mes where date=\"2020-3-20\")as B GROUP BY date UNION select \"填写\"as status,count(date) from mes where date=\"2020-3-20\"" ;
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
    	JFrame frame = new JFrame("柱状图");
		frame.add(new pieChart().getChartPanel()); // 添加柱形图
		frame.setBounds(50, 50, 800, 600);
		frame.setVisible(true);
		
	}

}
