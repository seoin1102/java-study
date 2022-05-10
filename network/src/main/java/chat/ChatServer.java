package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	
	private static final int PORT = 4000;
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		// 1. 서버 소겟 생성
		try {
			List<Writer> listWriters = new ArrayList<Writer>();
			serverSocket = new ServerSocket();
						
			// 2. 바인딩
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind( new InetSocketAddress( hostAddress, PORT ) );
			log( "연결 기다림 " + hostAddress + ":" + PORT );
		
			// 3. 요청 대기 
			while( true ) {
			   Socket socket = serverSocket.accept();
			   new ChatServerThread(socket, listWriters ).start();}
				} catch (IOException e) {
					e.printStackTrace();
			}			
		}

	public static void log(String log) {
		System.out.println(log);
	}
	
}
