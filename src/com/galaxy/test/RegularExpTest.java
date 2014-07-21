package com.galaxy.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpTest
{
	public static void main(String[] args)
	{
		extractURL();
	}
	
	public static void extractURL()
	{
		String img = "[img]http:\\\\www.baidu.com[/img]";
		
		Pattern p = Pattern.compile("\\[([^]]+)\\](.+)\\[/\\1\\]");
		Matcher m = p.matcher(img);
		System.out.println(m.groupCount());//2,总共两个组，不包括组0
		while(m.find())
		{
			System.out.println(m.group(0));//组0始终代表整个表达式,这里输出[img]http:\\\\www.baidu.com[/img]
			System.out.println(m.group(1));//img
			System.out.println(m.group(2));//http:\\www.baidu.com
		}
	}
	
	public static void test1()
	{
		String str = "aaabb<div fff>aaaa</div>dfsdfsd";
		//<div\b[^>]*>(.*?)</div>
		Pattern p = Pattern.compile("<div\\s[^>]*>(.*?)</div>");
		Matcher m = p.matcher(str);
		System.out.println(m.groupCount());
		if(m.find())
		{
			System.out.println(m.group(0));
			System.out.println(m.group(1));
		}
	}
	
	public static void test2()
	{
		String img = "[img]http:\\\\www.baidu.com[/img]";
		
		Pattern p = Pattern.compile("(?<=\\[([^]]{1,10})\\]).*?(?=\\[/\\1\\])");
		Matcher m = p.matcher(img);
		System.out.println(m.groupCount());//1
		while(m.find())
		{
			System.out.println(m.group(0));//组0始终代表整个表达式:这里输出http:\\www.baidu.com
			System.out.println(m.group(1));//img
		}
	}
}
