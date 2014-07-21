package com.galaxy.test;


public class QianBao
{
	public static void main(String[] args)
	{
		long benjin = 100 * 50000;            //本金
		long baozhengjin = 100 * 10000;       //保证金
		long shouyi = 4100;               //收益
		
		long money = calcMoney(benjin, baozhengjin, shouyi)  - benjin;
		System.out.println(money / 100);
	}
	
	private static long calcMoney(long benjin, long baozhengjin, long shouyi)
	{
		long i = benjin;
		for (int j = 1; j <= 6; j++) 
		{
			long qiandao = i;
			for (int m = 1; m <= 5; m++) 
			{
				qiandao += qiandao / 2000;//签到收益
			}
			
			i = i / baozhengjin * shouyi + qiandao;
		}
		
		return i;
	}
}

