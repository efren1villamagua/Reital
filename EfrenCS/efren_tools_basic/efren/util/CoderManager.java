package efren.util;

import java.util.Vector;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

import efren.util.config.Constantes;

public class CoderManager {
	/**
	 *
	 */
	public static String encrypt(String aWord) {
		return encrypt2(encrypt1(aWord));
	}
	/**
	 *
	 */
	public static String decrypt(String aWord) {
		return decrypt1(decrypt2(aWord));
	}
	/**
	 *
	 */
	private static byte[] encrypt1(String aWord) {
		if (aWord == null || aWord.trim().length() == 0) {
			return aWord.getBytes();
		}
		try {
			byte[] encryptKey = Constantes.TEMPNOUSE1.getBytes();
			DESedeKeySpec spec = new DESedeKeySpec(encryptKey);
		    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
		    SecretKey theKey = keyFactory.generateSecret(spec);
		    Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
		    IvParameterSpec ivParameters = new IvParameterSpec(new byte[] { 12, 34, 56, 78, 90, 87, 65, 43 });
		    cipher.init(Cipher.ENCRYPT_MODE, theKey, ivParameters);
		    byte[] plainText = aWord.getBytes();
		    byte[] encrypted = cipher.doFinal(plainText);

		    return encrypted;

		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
	/**
	 *
	 */
	private static String encrypt2(byte[] aWord) {
		String al = "0123456789";
		String ec = "";
		for (int i = 0; i < aWord.length; i++) {
			for (int j = 1; j <= 10; j++) {
				try {
					ec = ec + al.charAt((int) (Math.random()*al.length()));
				} catch (Exception e) {
					ec = ec + "0";
				}
			}
			//...
			ec = ec + parse1(aWord[i]);
		}
		String extra = ""+al.charAt((int) (Math.random()*al.length())) + al.charAt((int) (Math.random()*al.length()))
			+ al.charAt((int) (Math.random()*al.length())) + al.charAt((int) (Math.random()*al.length()))
			+ al.charAt((int) (Math.random()*al.length()));
		return ec + extra;
	}
	/**
	 *
	 */
	private static String decrypt1(byte[] aWord) {
		try {
			byte[] encryptKey = Constantes.TEMPNOUSE1.getBytes();
			DESedeKeySpec spec = new DESedeKeySpec(encryptKey);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
			SecretKey theKey = keyFactory.generateSecret(spec);
			Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
			IvParameterSpec ivParameters = new IvParameterSpec(new byte[] { 12, 34, 56, 78, 90, 87, 65, 43 } );
		    cipher.init(Cipher.DECRYPT_MODE, theKey, ivParameters);
		    byte[] encryptedText = aWord;
		    byte[] plainText = cipher.doFinal(encryptedText);

		    return new String(plainText);

		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
	/**
	 *
	 */
	private static byte[] decrypt2(String aWord) {
	    if (aWord == null || aWord.trim().length() == 0) {
	        return aWord.getBytes();
	    }
	    String temp;
	    Vector letrasStr = new Vector();
	    int count = 0;
	    for (int i = 0; i < aWord.length(); i++) {
	    	try {
		        if (((i + 5) % 14) == 0) {
		        	temp = aWord.substring(i+1, i+5);
		        	letrasStr.addElement(temp);
		        	count++;
		        }
			} catch (Exception e) {
				e.getMessage();
			}
	    }
	    byte[] letrasBytes = new byte[letrasStr.size()];
	    byte letra;
	    for (int i = 0; i < letrasStr.size(); i++) {
	    	try {
	    		temp = letrasStr.elementAt(i).toString();
	    		letra = new Integer(temp.substring(1)).byteValue();
	    		if (temp.substring(0,1).compareTo("0") == 0) {
	    			letra = new Integer(letra * (-1)).byteValue();
	    		}
	    		letrasBytes[i] = letra;
			} catch (Exception e) {
				e.getMessage();
			}
		}
	    return letrasBytes;
	}
	/**
	 *
	 */
	private static String parse1(byte letra) {
		String result = "";
		int letraInt;
		letraInt = (int) letra;
		if (letra >= 0) {
			result = result + "1";
		} else {
			result = result + "0";
			letraInt = letraInt * (-1);
		}
		if (letraInt >= 100) {
			result = result + letraInt;
		} else {
			if (letraInt >= 10) {
				result = result + "0"+letraInt;
			} else {
				result = result + "00"+letraInt;
			}
		}
		return result;
	}
}