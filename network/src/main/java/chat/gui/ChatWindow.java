package chat.gui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import chat.ChatServer;

public class ChatWindow {
    private String name;
	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

    private Socket socket;
	private PrintWriter pw;


	public ChatWindow(String name, Socket socket) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
        this.name = name;
        this.socket = socket;

		new ChatClientThread(socket).start();
		
	}

	public void show() {
		/*
		 * 1. UI 초기화 
		 */
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener(
			( ActionEvent actionEvent ) -> {
				System.out.println("clicked!!");
				sendMessage();
			}
		);

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if(keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
			
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				PrintWriter pw;
                try {
                    pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
                    String request = "quit";
                    pw.println(request);
                    System.exit(0);
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();
		/** 
		 * 2. IOStream (Pipeline established)
		 */
		 
		/**
		 *  3. Chat Client Thread 생성하고 실행
		 */
	}
	
	private void sendMessage() {
        PrintWriter pw;
        try {
        	pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
			String message = textField.getText();
			String request = "message:" + message;
			System.out.println("메시지 보내는 프로토콜 구현:" + message);
			pw.println(request);
			textField.setText("");
			textField.requestFocus();
			
			// Chat Client Thread에서 서버로 부터 받은 메시지가 있다고 치고~~(mock data)
			updateTextArea(message);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
		
	}
	private void finish() {
        try {
			if(socket != null && !socket.isClosed())
				socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
	}
	
	/**
	 * 
	 * Receive Thread from Chat Server
	 * 
	 */
	public class ChatClientThread extends Thread{
		Socket socket = null;
		public ChatClientThread(Socket socket) {
			this.socket = socket;
		}
		
		@Override
		public void run() {	
			//1. Remote Host Information
			InetSocketAddress inetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
			String remoteHostAddress = inetSocketAddress.getAddress().getHostAddress();
			int remoteHostPort = inetSocketAddress.getPort();
			ChatServer.log("connected by client[" + remoteHostAddress + ":" + remoteHostPort + "]");
			
			try {
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                while(true) {
                    String message = br.readLine();
                    
                  
                    textArea.append(message);
                    textArea.append("\n");
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
		}
		
			}

		
	
}
