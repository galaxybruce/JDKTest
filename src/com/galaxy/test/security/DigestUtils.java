package com.galaxy.test.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/** 
 * reference apache commons <a 
 * href="http://commons.apache.org/codec/">http://commons.apache.org/codec/</a> 
 *  
 * support MD2/MD5/SHA/SHA256/SHA384/SHA512 
 * @author Aub 
 *  
 */
public class DigestUtils
{
	/** 
	     * ���ݸ���ժҪ�㷨����һ����ϢժҪʵ�� 
	     *  
	     * @param algorithm 
	     *            ժҪ�㷨�� 
	     * @return  ��ϢժҪʵ�� 
	     * @see MessageDigest#getInstance(String) 
	     * @throw s RuntimeException 
	     *             �� {@link java.security.NoSuchAlgorithmException} ����ʱ 
	     */
	static MessageDigest getDigest(String algorithm)
	{
		try
		{
			return MessageDigest.getInstance(algorithm);
		}
		catch (NoSuchAlgorithmException e)
		{
			throw new RuntimeException(e.getMessage());
		}
	}

	/** 
	     * ��ȡ MD5 ��ϢժҪʵ�� 
	     *  
	     * @return  MD5 ��ϢժҪʵ�� 
	     * @throw s RuntimeException 
	     *             �� {@link java.security.NoSuchAlgorithmException} ����ʱ 
	     */
	private static MessageDigest getMd5Digest()
	{
		return getDigest("MD5");
	}

	/** 
	     * ��ȡ SHA-1 ��ϢժҪʵ�� 
	     *  
	     * @return  SHA-1 ��ϢժҪʵ�� 
	     * @throw s RuntimeException 
	     *             �� {@link java.security.NoSuchAlgorithmException} ����ʱ 
	     */
	private static MessageDigest getShaDigest()
	{
		return getDigest("SHA");
	}

	/** 
	     * ��ȡ SHA-256 ��ϢժҪʵ�� 
	     *  
	     * @return  SHA-256 ��ϢժҪʵ�� 
	     * @throw s RuntimeException 
	     *             �� {@link java.security.NoSuchAlgorithmException} ����ʱ 
	     */
	private static MessageDigest getSha256Digest()
	{
		return getDigest("SHA-256");
	}

	/** 
	     * ��ȡ SHA-384 ��ϢժҪʵ�� 
	     *  
	     * @return  SHA-384 ��ϢժҪʵ�� 
	     * @throw s RuntimeException 
	     *             �� {@link java.security.NoSuchAlgorithmException} ����ʱ 
	     */
	private static MessageDigest getSha384Digest()
	{
		return getDigest("SHA-384");
	}

	/** 
	     * ��ȡ SHA-512 ��ϢժҪʵ�� 
	     *  
	     * @return  SHA-512 ��ϢժҪʵ�� 
	     * @throw s RuntimeException 
	     *             �� {@link java.security.NoSuchAlgorithmException} ����ʱ 
	     */
	private static MessageDigest getSha512Digest()
	{
		return getDigest("SHA-512");
	}

	/** 
	     * ʹ��MD5��ϢժҪ�㷨������ϢժҪ 
	     *  
	     * @param data 
	     *            ����ϢժҪ������ 
	     * @return  ��ϢժҪ������Ϊ16���ֽ����飩 
	     */
	public static byte[] encodeMD5(byte[] data)
	{
		return getMd5Digest().digest(data);
	}

	/** 
	     * ʹ��MD5��ϢժҪ�㷨������ϢժҪ 
	     *  
	     * @param data 
	     *            ����ϢժҪ������ 
	     * @return  ��ϢժҪ������Ϊ32��ʮ�������ַ����� 
	     */
	public static String encodeMD5Hex(byte[] data)
	{
		return Hex.encodeHexStr(encodeMD5(data));
	}

	/** 
	     * ʹ��SHA-1��ϢժҪ�㷨������ϢժҪ 
	     *  
	     * @param data 
	     *            ����ϢժҪ������ 
	     * @return  SHA-1��ϢժҪ������Ϊ20���ֽ����飩 
	     */
	public static byte[] encodeSHA(byte[] data)
	{
		return getShaDigest().digest(data);
	}

	/** 
	     * ʹ��SHA-1��ϢժҪ�㷨������ϢժҪ 
	     *  
	     * @param data 
	     *            ����ϢժҪ������ 
	     * @return  SHA-1��ϢժҪ������Ϊ40��ʮ�������ַ����� 
	     */
	public static String encodeSHAHex(byte[] data)
	{
		return Hex.encodeHexStr(getShaDigest().digest(data));
	}

	/** 
	     * ʹ��SHA-256��ϢժҪ�㷨������ϢժҪ 
	     *  
	     * @param data 
	     *            ����ϢժҪ������ 
	     * @return  SHA-256��ϢժҪ������Ϊ32���ֽ����飩 
	     */
	public static byte[] encodeSHA256(byte[] data)
	{
		return getSha256Digest().digest(data);
	}

	/** 
	     * ʹ��SHA-256��ϢժҪ�㷨������ϢժҪ 
	     *  
	     * @param data 
	     *            ����ϢժҪ������ 
	     * @return  SHA-256��ϢժҪ������Ϊ64��ʮ�������ַ����� 
	     */
	public static String encodeSHA256Hex(byte[] data)
	{
		return Hex.encodeHexStr(encodeSHA256(data));
	}

	/** 
	     * ʹ��SHA-384��ϢժҪ�㷨������ϢժҪ 
	     *  
	     * @param data 
	     *            ����ϢժҪ������ 
	     * @return  SHA-384��ϢժҪ������Ϊ43���ֽ����飩 
	     */
	public static byte[] encodeSHA384(byte[] data)
	{
		return getSha384Digest().digest(data);
	}

	/** 
	     * ʹ��SHA-384��ϢժҪ�㷨������ϢժҪ 
	     *  
	     * @param data 
	     *            ����ϢժҪ������ 
	     * @return  SHA-384��ϢժҪ������Ϊ86��ʮ�������ַ����� 
	     */
	public static String encodeSHA384Hex(byte[] data)
	{
		return Hex.encodeHexStr(encodeSHA384(data));
	}

	/** 
	     * ʹ��SHA-512��ϢժҪ�㷨������ϢժҪ 
	     *  
	     * @param data 
	     *            ����ϢժҪ������ 
	     * @return  SHA-512��ϢժҪ������Ϊ64���ֽ����飩 
	     */
	public static byte[] encodeSHA512(byte[] data)
	{
		return getSha512Digest().digest(data);
	}

	/** 
	     * ʹ��SHA-512��ϢժҪ�㷨������ϢժҪ 
	     *  
	     * @param data 
	     *            ����ϢժҪ������ 
	     * @return  SHA-512��ϢժҪ������Ϊ128��ʮ�������ַ����� 
	     */
	public static String encodeSHA512Hex(byte[] data)
	{
		return Hex.encodeHexStr(encodeSHA512(data));
	}
	
	public static void main(String[] args)
	{
	String data = "Mac����";
	System.out.println("����ǰ����: string:" + data);
	
	System.out.println();
	
	String encodeData = encodeMD5Hex(data.getBytes());
	System.out.println("���ܺ����ݳ���: encodeMD5Hex.length:" + encodeData.length());
	encodeData = encodeSHAHex(data.getBytes());
	System.out.println("���ܺ����ݳ���: encodeSHAHex.length:" + encodeData.length());
	encodeData = encodeSHA256Hex(data.getBytes());
	System.out.println("���ܺ����ݳ���: encodeSHA256Hex.length:" + encodeData.length());
	encodeData = encodeSHA384Hex(data.getBytes());
	System.out.println("���ܺ����ݳ���: encodeSHA384Hex.length:" + encodeData.length());
	encodeData = encodeSHA512Hex(data.getBytes());
	System.out.println("���ܺ����ݳ���: encodeSHA512Hex.length:" + encodeData.length());
	}
}
