package com.galaxy.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ZipUnZipApk {

	private static String basePath;
	private static String apkPath;
	
	
	private static Object lockObj = new Object();

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		basePath = "C:\\work\\test\\apktool-install-windows-r05-ibot\\apktool-install-windows-r05-ibot";
		apkPath = "C:\\work\\test\\apktool-install-windows-r05-ibot\\apktool-install-windows-r05-ibot\\qianbao.apk";
//		apkIsExist(apkPath);
//		Thread unzipThread = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				unZipByApkTool();
//				System.out.println("unzip scuess");
//				synchronized(lockObj) {
//					lockObj.notifyAll();
//			}
//			}
//		});
//		unzipThread.start();
//		synchronized(lockObj) {
//			lockObj.wait();
//	}
		unZipByApkTool();
//		System.out.println("unzip scuess");
		modifyQudaoId("101");
		ZipByApkTool();
		singedApk();
//		Thread modifyThread = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				try {
//					modifyQudaoId("101");
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				System.out.println("modify scuess");
//				synchronized(lockObj) {
//					lockObj.notifyAll();
//				}
//				
//			}
//		});
//		modifyThread.start();
//		synchronized(lockObj) {
//				lockObj.wait();
//		}
//	
//		
//		Thread zipThread = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				try {
//					ZipByApkTool();
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				System.out.println("zip scuess");
//				synchronized(lockObj) {
//					lockObj.notifyAll();
//				}
//			}
//		});
//		zipThread.start();
//		synchronized(lockObj) {
//			lockObj.wait();
//	}
	}

	public static boolean apkIsExist(String s) {
		File file = new File(s);
		return file.exists();
	}
	
	public static void singedApk() {
		String cmd = "C:\\Program Files\\Java\\jdk1.7.0_17\\bin\\jarsigner  -verbose -keystore  " + basePath+"/manfun.ks -storepass manfun_funnylab  -signedjar " + basePath+"/signqianbao.apk  " + basePath+"/unsignqianbao.apk  manfun;";
		try {
			System.out.println(cmd);
			Process proc = Runtime.getRuntime().exec(cmd);
			InputStream stderr = proc.getErrorStream();  
			InputStreamReader isr = new InputStreamReader(stderr);  
			BufferedReader br = new BufferedReader(isr);  
			String line = null;  
			System.out.println("777");  
			while ((line = br.readLine()) != null)  
			  System.out.println(line);  
			System.out.println("888");  
			br.close();
			int exitVal = proc.waitFor();
			
			proc.destroy();
//		      BufferedReader br = new BufferedReader(new InputStreamReader(exec.getInputStream()));
//				String line = null;
//				System.out.println("111111111");
//				while((line = br.readLine()) != null){
//					System.out.println(line);
//				}
//				br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static void unZipByApkTool() {
		try {
			String unzipExec = basePath+"\\apktool.bat d -s "+apkPath+"  "+basePath+"\\qianbao";
			System.out.println(unzipExec);
			Process proc = Runtime.getRuntime().exec(unzipExec);
			InputStream stderr = proc.getErrorStream();  
			InputStreamReader isr = new InputStreamReader(stderr);  
			BufferedReader br = new BufferedReader(isr);  
			String line = null;  
			System.out.println("111");  
			while ((line = br.readLine()) != null)  
			  System.out.println(line);  
			System.out.println("2222");  
			br.close();
			int exitVal = proc.waitFor();
			
			proc.destroy();
//		      BufferedReader br = new BufferedReader(new InputStreamReader(exec.getInputStream()));
//				String line = null;
//				System.out.println("111111111");
//				while((line = br.readLine()) != null){
//					System.out.println(line);
//				}
//				br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void modifyQudaoId(String qudaoId) throws Exception {
		File orgFile=new File(basePath+"\\qianbao\\AndroidManifest.xml");
		File dstFile=new File(basePath+"\\qianbao\\AndroidManifest1.xml");
		BufferedReader bufferedReader= new BufferedReader(new FileReader(orgFile));
		BufferedWriter bufferedWriter= new BufferedWriter(new FileWriter(dstFile, false));
		
		String readLine="";
		while((readLine=bufferedReader.readLine()) != null){
		System.out.println(readLine);
		if(readLine.contains("UMENG_CHANNEL"))
		{
			bufferedWriter.write("<meta-data android:name=\"UMENG_CHANNEL\" android:value=\""+qudaoId+"\" />");
			
		}else
		{
			bufferedWriter.write(readLine);
		}
		}
		bufferedWriter.flush();
		bufferedReader.close();
		bufferedWriter.close();
		orgFile.delete();
		dstFile.renameTo(orgFile);
		dstFile.delete();
	}
	
	public static void ZipByApkTool()
	{
		try {
//			String zipExec = "C:/Users/gsx/Desktop/g/apktool-install-windows-r05-ibot/apktool.bat b  C:/Users/gsx/Desktop/g/apktool-install-windows-r05-ibot/qianbao  C:/Users/gsx/Desktop/g/apktool-install-windows-r05-ibot/unsignqianbao.apk";
//			String unzipExec = basePath+"\\apktool.bat d -s "+apkPath+"  "+basePath+"\\qianbao";
		
			String zipExec = basePath+"\\apktool.bat b  "+basePath+"\\qianbao  "+basePath+"\\unsignqianbao.apk;";
			System.out.println(zipExec);
			Process proc = Runtime.getRuntime().exec(zipExec);
			InputStream stderr = proc.getErrorStream();  
			InputStreamReader isr = new InputStreamReader(stderr);  
			BufferedReader br = new BufferedReader(isr);  
			String line = null;  
			System.out.println("333");  
			while ((line = br.readLine()) != null)  
			  System.out.println(line);  
			System.out.println("444");  
			br.close();
			int exitVal = proc.waitFor();  
			System.out.println("5555");
			proc.destroy();
		}catch (RuntimeException e) {
			e.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
