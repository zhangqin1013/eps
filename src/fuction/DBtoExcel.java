package fuction;

/**
 * FileName: DBtoExcel.java
 * ����excel
 * @author Lipeishan��ZhangQin
 * @Date  2020.03.19
 */
import java.io.File;
import jxl.*;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;

import java.sql.*;
import java.util.*;

public class DBtoExcel {

	/**
	 * ����Excel��
	 * 
	 * @param rs         ���ݿ�����
	 * @param filePath   Ҫ�����·��
	 * @param sheetName  ���������� ����������
	 * @param columnName ����������ΪVector
	 */
	public void WriteExcel(ResultSet rs, String filePath, String sheetName, Vector columnName) {
		WritableWorkbook workbook = null;
		WritableSheet sheet = null;

		int rowNum = 1; // �ӵ�һ�п�ʼд��
		try {
			// ����Excel�ļ�
			workbook = Workbook.createWorkbook(new File(filePath));
			sheet = workbook.createSheet(sheetName, 0);
			// ���Ƚ�����д��
			this.writeCol(sheet, columnName, 0);
			// �������д��
			while (rs.next()) {
				Vector col = new Vector(); // ���Ա���һ������
				for (int i = 1; i <= columnName.size(); i++) {
					col.add(rs.getString(i));
				}
				// д��Excel
				this.writeCol(sheet, col, rowNum++);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// �ر�
				workbook.write();
				workbook.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/***
	 * ������д�빤����
	 * 
	 * @param sheet  Ҫд��Ĺ�����
	 * @param col    Ҫд�����������
	 * @param rowNum Ҫд����һ��
	 * @throws WriteException
	 * @throws RowsExceededException
	 */
	private void writeCol(WritableSheet sheet, Vector col, int rowNum) throws RowsExceededException, WriteException {
		int size = col.size();
		for (int i = 0; i < size; i++) {
			Label label = new Label(i, rowNum, (String) col.get(i));
			sheet.addCell(label);
		}
	}

}
