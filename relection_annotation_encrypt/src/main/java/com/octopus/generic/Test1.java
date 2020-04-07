package com.octopus.generic;

public class Test1 {
public static void main(String[] args) {
	MyGenericClass<Integer> generic = new MyGenericClass<Integer>();
	generic.print(10);
	
	MyGenericClass<Double> generic2 = new MyGenericClass<Double>();
	generic2.print(10.0);
}
}
