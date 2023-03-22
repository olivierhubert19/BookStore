package util;

import java.security.MessageDigest;

import org.apache.tomcat.util.codec.binary.Base64;

public class MaHoa {
	public static String toSHA1(String s){
		String saltString = "1i2ouoiduo1i@";
		String resString = null;
		s = s+ saltString;
		try {
			byte[] data = s.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			resString = Base64.encodeBase64String(md.digest(data));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return resString;
	}
	public static void main(String[] args) {
		System.out.println(toSHA1("123456"));
//		EJUWJFckdUEHg69EmyU5x3yXLyg=
	}
}