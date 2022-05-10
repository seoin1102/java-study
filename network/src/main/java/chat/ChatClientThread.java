package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import chat.ChatServer;

public class ChatClientThread extends Thread {
	private Socket socket;
	private BufferedReader bufferedReader;
	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {

		/* reader를 통해 읽은 데이터 콘솔에 출력하기 (message 처리) */	
		InetSocketAddress inetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
		String remoteHostAddress = inetSocketAddress.getAddress().getHostAddress();
		int remoteHostPort = inetSocketAddress.getPort();
		ChatServer.log("connected by client[" + remoteHostAddress + ":" + remoteHostPort + "]");
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			
			while(true) {
				String data = br.readLine();
				if(data == null) {
					ChatServer.log("closed by client");
					break;
				}
				
				ChatServer.log("received:" + data);
				pw.println(data);
			}
		} catch(SocketException ex) {
			System.out.println("[server] suddenly closed by client");
		} catch(IOException ex) {
			System.out.println("[server] error:" + ex);
		} finally {
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		}
}


}
