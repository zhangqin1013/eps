package util;

import java.math.BigDecimal;

/**
 * FileName: FloatUtil.java
 * �ж�Float�Ƿ�Ϊ��
 * @author Lipeishan��ZhangQin
 * @Date  2020.03.20
 */
public class FloatUtil {
	public static boolean isEmpty(Float num) {
		String s = String.valueOf(num);
		if ("".equals(s) || s == null) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isNotEmpty(Float num) {
		String s = String.valueOf(num);
		if (!"".equals(s) && s != null) {
			return true;
		} else {
			return false;
		}
	}

}
