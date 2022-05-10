package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import chat.ChatServer;

public class ChatClient {
	private static final String SERVER_IP = "192.168.56.1";
	private static final int SERVER_PORT = 4000;
	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;
	try {
		List<Writer> listWriters = new ArrayList<Writer>();
		//1. 키보드 연결
		scanner = new Scanner(System.in);

		
	   //2. socket 생성
		socket = new Socket();
		
	   //3. 연결
		socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
		log("connected");
		
	   //4. reader/writer 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

	   //5. join 프로토콜
	   System.out.print("닉네임>>" );
	   String nickname = scanner.nextLine();
	   pw.println( "join:" + nickname );


	   //6. ChatClientThread 시작
	   new ChatServerThread(socket, listWriters ).start();
	   //7. 키보드 입력 처리
	   while( true ) {
	      System.out.print( ">>" );
	      String input = scanner.nextLine();
					
	      if( "quit".equals( input ) == true ) {
	          // 8. quit 프로토콜 처리
	          break;
	      } else {
	          // 9. 메시지 처리      
	      }
	   }

	} catch( IOException ex ) {
	       log( "error:" + ex );
	} 
	//finally {
	      //10. 자원정리
	finally {
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

	private static void log(String log) {
		System.out.println("[Client]:" + log);
	}}