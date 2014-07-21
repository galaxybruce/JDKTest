package com.galaxy.test;

public class B extends A
{
	public int a;
	
	protected void init()
	{
		a = 2;
	}
	
	public static void main(String[] args)
	{
		B b = new B();
		System.out.println(b.a);
	}
}
