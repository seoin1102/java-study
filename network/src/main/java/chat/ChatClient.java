package chat;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "192.168.10.16";
	private static final int SERVER_PORT = 4000;
	
	public static void main(String[] args) {	
		Scanner scanner = null;
		Socket socket = null;
		
		try {
			//1. 키보드 연결
			scanner = new Scanner(System.in);
			
			//2. socket 생성
			socket = new Socket();
		
			//3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			log("connected");
			
			//4. reader/writer 생성
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

			//5. join 프로토콜
		   System.out.print("닉네임>>" );
		   String nickname = scanner.nextLine();
		   pw.println( "join:" + nickname );
	

			//6. ChatClientReceiveThread 시작
			new ChatClientThread( socket ).start();

			
			//7. 키보드 입력 처리
			while( true ) {
		      System.out.print( ">>" );
		      String input = scanner.nextLine();
							
		      if("quit".equals(input)) {
					break;
		      }else if("".equals(input)) {
		    	  
		      }else {
					pw.println("message:"+input);
					}
			}
		} catch (IOException e) {
			log("error:" + e);
		} finally {
			//10. 자원정리

			try {
				if(scanner != null) {
					scanner.close();
				}
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	static void log(String log) {
		System.out.println("[Chat Client]" + log);
	}
}