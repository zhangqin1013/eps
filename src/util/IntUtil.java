package util;
/**
 * FileName: InUtil.java
 * �ж�int�����Ƿ�Ϊ��
 * @author Lipeishan��ZhangQin
 * @Date  2020.03.19
 */
public class IntUtil{
	public static boolean isEmpty(int interger){
		String s = String.valueOf(interger);
		if("".equals(s)||s==null){
			return true;
		}else{
			return false;
		}
	}
	public static boolean isNotEmpty(int interger){
		String s = String.valueOf(interger);
		if(!"".equals(s)&&s!=null){
			return true;
		}else{
			return false;
		}
	}
}