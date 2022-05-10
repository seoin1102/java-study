package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import echo.EchoServer;

public class ChatServerThread extends Thread {

	private String nickname;
	private Socket socket;
	List<Writer> listWriters;

	public ChatServerThread(Socket socket, List<Writer> listWriters ) {
		this.socket = socket;
		this.listWriters = listWriters;
	}
	@Override
	public void run() {
		//1. Remote Host Information

		//2. 스트림 얻기
			try {
				BufferedReader br = new BufferedReader( new InputStreamReader( socket.getInputStream(), StandardCharsets.UTF_8 ) );
				PrintWriter pw =  new PrintWriter( new OutputStreamWriter( socket.getOutputStream(), StandardCharsets.UTF_8 ), true );
					
				//3. 요청 처리 			
				while( true ) {
				   String request = br.readLine();
				   if( request == null ) {
					  ChatServer.log( "클라이언트로 부터 연결 끊김" );
					  doQuit( pw );

				      break;
				   }
				   
				   // 4. 프로토콜 분석
				   ChatServer.log(request);
				   pw.println(request);
				   String[] tokens = request.split( ":" );
					
				   if( "join".equals( tokens[0] ) ) {

					   doJoin( tokens[1], pw );

				   } 
				   //else if( "message".equals( tokens[0] ) ) {
				      
				   //   doMessage( tokens[1] );

				   //} 
				   else if( "quit".equals( tokens[0] ) ) {
				      
				      doQuit(pw);

				   } else {

				      ChatServer.log( "에러:알수 없는 요청(" + tokens[0] + ")" );
				      break;
				   }

				  
		
				}
				} catch(SocketException e) {
					System.out.println("[server] error:" + e);
				} catch(IOException e) {
				System.out.println("[server] suddenly closed by client");
				}finally {
					try {
						if(socket != null && !socket.isClosed()) {
							socket.close();
						}
					} catch(IOException ex) {
						ex.printStackTrace();
					}
	}
	
	
	
}
	private void doQuit(PrintWriter pw) {
		   String data = nickname + "님이 퇴장 하였습니다."; 
		   broadcast( data );
		   removeWriter(pw);

		
	}
	private void removeWriter(PrintWriter pw) {
		// TODO Auto-generated method stub
		
	}
	private void doMessage(PrintWriter pw) {
		System.out.println(pw);
		
	}
	private void doJoin(String nickName, PrintWriter pw) {
		this.nickname = nickName;
		/* writer pool에  저장 */
		addWriter( pw );
	   String data = nickName + "님이 참여하였습니다."; 
	   broadcast( data );

	   // ack
	   pw.println( "join:ok" );

	}
	private void addWriter(PrintWriter pw) {
		synchronized( listWriters ) {
		      listWriters.add(pw);
		   }

}
	private void broadcast( String data ) {

		   synchronized( listWriters ) {

		      for( Writer writer : listWriters ) {
				PrintWriter printWriter = (PrintWriter)writer;
				printWriter.println( data );
		      }

		   }

		}

}
