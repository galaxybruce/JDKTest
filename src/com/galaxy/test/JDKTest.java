package com.galaxy.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JDKTest
{
	public final static String HTTP_URL_QIANWANG = "http://test.qianwang365.com:3030";

	public final static String HTTP_URL_QIANBAO = "http://www.qianbao666.com/";

	public static Object obj = new Object();

	public static void main(String[] args)
	{
		//		String filename1 = "http://192.168.1.135:9090/plugins/qbfiletransfers/open?v=866fb2278b728713b208fca6913ff3e0&type=jpg&ticket=MTM3MzkxODg5NjI6MTM2OTcwODcxMTM2NA==&casid=436665";
		//		String filename2 = "http://192.168.1.135:9090/plugins/qbfiletransfers/open?v=866fb2278b728713b208fca6913ff3e0";
		//		String filename3 = "http://192.168.1.135:9090/plugins/qbfiletransfers/open?type=jpg&v=866fb2278b728713b208fca6913ff3e0&ticket=MTM3MzkxODg5NjI6MTM2OTcwODcxMTM2NA==&casid=436665";
		//		
		//		testAssetPattern(filename1);
		//		testAssetPattern(filename2);
		//		testAssetPattern(filename3);

		//		Collection<MyThread> originalCollection = new ArrayList<MyThread>();
		//		MyThread thread1= new MyThread();
		//		MyThread thread2= new MyThread();
		//		MyThread thread3= new MyThread();
		//		originalCollection.add(thread1);
		//		originalCollection.add(thread3);
		//		originalCollection.add(thread2);
		//
		//		System.out.println(thread1);
		//		System.out.println(thread2);
		//		System.out.println(thread3);
		//		Collection<MyThread> unmodifiableCollection = Collections.unmodifiableCollection(originalCollection);
		//		for (MyThread t : unmodifiableCollection)
		//		{
		//			System.out.println(thread2 == t);
		//		}

//		String aaa = "[img]http:\\\\im.qianbao666.com\\upload\\8714fbcfaf904ba59716dd12b816b340.jpg[\\img]";
//		
//		Pattern p = Pattern.compile("\\[^]]+\\](.+)\\[[^]]+\\]");
//		Matcher m = p.matcher(aaa);
//		System.out.println(m.groupCount());
//		if(m.find())
//			aaa = m.group(1);
//		System.out.println(aaa);
		
//		System.out.println(String.format("MAC: %s (%.2fm)", "aaaa", 3.0000));
//		System.out.println("&updateTime=20140613025039000".length());
//		System.out.println("&updateTime=20140613025039000000".length());
//		
//		String url = "http://m.qianbao666.com/api/v10/userinfo4Client/queryAvataByClient?uid=389762&updateTime=201406130250390000";
//		String tUrl1 = url.substring(0, url.indexOf("&updateTime="));
//		String tUrl2 = url.substring(url.indexOf("&updateTime="));
//		if(tUrl2.length() >= 29)
//		{
//			url = tUrl1 + tUrl2.substring(0, 29);
//		}
//		
//		System.out.println(url);
		
		Pattern p = Pattern.compile("\\[#(.+)\\]");
		Matcher m = p.matcher("[#大哭]");
		if(m.find())
		{
			System.out.println(m.group(1));
		}
		
	}
	
	public static double roundUp(final double val)
	{
		int exponent = (int) Math.floor(Math.log10(val));
		double rval = val * Math.pow(10, -exponent);
		if (rval > 5.0)
		{
			rval = 10.0;
		}
		else if (rval > 2.0)
		{
			rval = 5.0;
		}
		else if (rval > 1.0)
		{
			rval = 2.0;
		}
		rval *= Math.pow(10, exponent);
		return rval;
	}

	public static boolean isNumeric(String str)
	{
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

	public static String formatChatDate(long data, boolean showThisYear)
	{
		final long cDate = System.currentTimeMillis();
		if (data <= 0 || data > cDate)
		{
			data = System.currentTimeMillis();
		}

		final Date date = new Date(data);
		final SimpleDateFormat sdf = new SimpleDateFormat();

		final Calendar c = Calendar.getInstance();

		//需格式化时间
		c.setTime(date);
		final int bYear = c.get(Calendar.YEAR);
		final int bMonth = c.get(Calendar.MONTH);
		final int bDay = c.get(Calendar.DATE);

		//当前时间
		c.setTime(new Date());
		final int cYear = c.get(Calendar.YEAR);
		final int cMonth = c.get(Calendar.MONTH);
		final int cDay = c.get(Calendar.DATE);

		if (cYear != bYear || showThisYear)
		{
			sdf.applyPattern("yyyy-MM-dd HH:mm");
			return sdf.format(date);
		}

		if (cMonth == bMonth)
		{
			final StringBuffer sb = new StringBuffer();
			if (cDay == bDay)
			{
				sdf.applyPattern("HH:mm");
				return sdf.format(date);
			}

			if (cDay - bDay == 1)
			{
				sdf.applyPattern("HH:mm");
				final String yestoday = "昨天";
				final String formatDate = sdf.format(date);
				sb.append(yestoday).append(" ").append(formatDate);
				return sb.toString();
			}
		}

		sdf.applyPattern("MM-dd HH:mm");
		return sdf.format(date);
	}

	public static class MyThread extends Thread
	{
		@Override
		public void run()
		{
			System.out.println("abc");
		}
	}

	public static void createRandom()
	{
		Random r = new Random();
		int n = 8 + r.nextInt(6);
		System.out.println(n);
	}

	public static void testThreadState()
	{
		MyThread mt = new MyThread();
		System.out.println(mt.isAlive());
		mt.start();
		System.out.println(mt.isAlive());
		try
		{
			mt.join();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		while (mt.getState() == Thread.State.TERMINATED)
		{
			System.out.println("aaaaaa");
			mt = new MyThread();
			mt.start();
			break;
		}
	}

	public static void testWait()
	{
		try
		{
			synchronized (obj)
			{
				System.out.println("a");
				long waitTime = 10000;
				long start = System.currentTimeMillis();
				while (true)
				{
					if (waitTime <= 0)
					{
						break;
					}
					obj.wait(waitTime);
					long now = System.currentTimeMillis();
					waitTime -= now - start;
					start = now;
				}
			}
		}
		catch (InterruptedException ie)
		{
			// Ignore.
		}
	}

	public static void testAssetPattern(String filename)
	{
		Pattern p = null;
		Matcher m = null;

		p = Pattern.compile("(?<=v=)[\\w]{1,}(?=&|$)");
		m = p.matcher(filename);

		if (m.find())
		{
			int beginIndex = m.start();
			int endIndex = m.end();
			System.out.println(filename.substring(beginIndex, endIndex));
		}
	}

	public static void testCon()
	{
		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		list.add("1");
		list.add("1");
		list.add("1");
		list.add("1");

		int n = 0;
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext())
		{
			String str = iterator.next();
			if (n++ == 3)
			{
				list.clear();

				//iterator = list.iterator();
			}
		}
	}

	public static String formatCasid2Jid(String casid, String resource)
	{
		if (casid == null)
		{
			casid = "";
		}

		String jid = casid + "@" + "qianbao";

		if (!"".equals(resource))
		{
			jid += "/" + resource;
		}

		return jid;
	}

	public static String formatJid2Casid(String jid)
	{
		if ("".equals(jid))
		{
			return "";
		}

		final int index = jid.indexOf("@");
		if (index > 0)
		{
			return jid.substring(0, index);
		}

		return jid;
	}

	public static void checkPassword(String str)
	{

		Pattern NAME_ADDR_EMAIL_PATTERN = Pattern
				.compile("^(?!_)(?!.*?_$)[a-zA-Z0-9_]+$");
		Matcher match = NAME_ADDR_EMAIL_PATTERN.matcher(str);

		if (match.matches())
		{
			System.out.println(true);
		}
		else
		{
			System.out.println(false);
		}
	}

	public static String encode4Title(String value)
	{
		return value.replaceAll("&", "&amp;").replaceAll("'", "&#39;")
				.replaceAll("\"", "&quot;");
	}

	public static boolean isHanZi(String str)
	{
		boolean isHanZi = true;
		for (int i = 0; i < str.length(); i++)
		{
			String bb = str.substring(i, i + 1);
			// 鐢熸垚涓�釜Pattern,鍚屾椂缂栬瘧涓�釜姝ｅ垯琛ㄨ揪寮�
			isHanZi = java.util.regex.Pattern.matches("[\\u4e00-\\u9fa5]", bb);
			if (!isHanZi)
			{
				break;
			}
		}

		System.out.println(isHanZi);
		return isHanZi;
	}

	private static String convertUrlToFileName(String url)
	{
		String filename = url;

		if (filename.contains(HTTP_URL_QIANWANG))
		{
			int index = filename.indexOf(HTTP_URL_QIANWANG);

			if (index < filename.length())
			{
				filename = filename.substring(index
						+ HTTP_URL_QIANWANG.length() + 1);
			}
		}
		else if (filename.contains(HTTP_URL_QIANBAO))
		{
			int index = filename.indexOf(HTTP_URL_QIANBAO);

			if (index < filename.length())
			{
				filename = filename.substring(index + HTTP_URL_QIANBAO.length()
						+ 1);
			}
		}

		filename = filename.replaceAll("/", ".").replaceAll(":", "");
		filename = filename.replaceAll("\\?", "_");
		filename = filename.replaceAll("=", "_");

		return filename;
	}

	public enum AccessType
	{
		DROPBOX("dropbox"), APP_FOLDER("sandbox");

		private final String urlPart;

		private AccessType(String urlPart)
		{
			this.urlPart = urlPart;
		}

		@Override
		public String toString()
		{
			return urlPart;
		}

		//        System.out.println(AccessType.values());
		//		System.out.println(AccessType.valueOf(AccessType.APP_FOLDER.name()));
		//		System.out.println(AccessType.valueOf("APP_FOLDER"));
		//		System.out.println(AccessType.valueOf("DROPBOX"));
		//		System.out.println(AccessType.APP_FOLDER.toString());
		//		System.out.println(AccessType.APP_FOLDER.ordinal());
		//		System.out.println(AccessType.DROPBOX.ordinal());
	}

	public enum Type
	{

		/**
		 * (Default) a normal text message used in email like interface.
		 */
		normal,

		/**
		 * Typically short text message used in line-by-line chat interfaces.
		 */
		chat,

		/**
		 * Chat message sent to a groupchat server for group chats.
		 */
		groupchat,

		/**
		 * Text message to be displayed in scrolling marquee displays.
		 */
		headline,

		/**
		 * indicates a messaging error.
		 */
		error;

		public static Type fromString(String name)
		{
			try
			{
				return Type.valueOf(name);
			}
			catch (Exception e)
			{
				return normal;
			}
		}

	}
}
