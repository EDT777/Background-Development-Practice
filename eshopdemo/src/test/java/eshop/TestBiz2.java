package eshop;

import org.junit.Test;
import org.junit.runners.MethodSorters;
//此注解 设置测试顺序按照方法名称
@org.junit.FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestBiz2 {
		@Test
		public void test1Add(){
			System.out.println("test1Add");
		}
		@Test
		public void test2Update(){
			System.out.println("test2Update");
		}
		@Test
		public void test3Select() {
			System.out.println("test3Select");
		}
}
