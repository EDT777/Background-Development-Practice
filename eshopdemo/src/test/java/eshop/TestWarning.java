package eshop;
import java.util.Date;
import java.util.Map;;
//演示代码常见的warning及可能的风险
public class TestWarning {
public static void main(String[] args) {
	int num=10;
	System.out.println("程序结束");
	Map<Object,Object> map=null;
	System.out.println(map);
	
	Date d= new Date(2011,1,1);
	System.out.println(d);
}
}
