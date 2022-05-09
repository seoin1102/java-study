package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String url = scanner.next();
		System.out.println(url);
		InetAddress[] inetAddress =null;
		String[] str = null;
		System.out.println(url);
		try {
			inetAddress = InetAddress.getAllByName("www.naver.com");
			inetAddress.
			System.out.println("inetAddress"+inetAddress);
		} catch (UnknownHostException e) {
			System.out.println("e"+e);
			e.printStackTrace();
		}  
		str = new String[inetAddress.length];
		for (int i = 0;  i<inetAddress.length; i++) {
			str[i] = inetAddress[i].getHostAddress();
			
		}
		System.out.println(str);
		
	}
}
