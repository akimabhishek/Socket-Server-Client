package com.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SocClient {

	public static void main(String[] args) throws Exception{
		
		String ip = "localhost";
		int port = 9999;
		Socket sock = new Socket(ip,port);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		OutputStreamWriter ostream = new OutputStreamWriter(sock.getOutputStream());
		PrintWriter pwrite = new PrintWriter(ostream);
		
		//InputStream instream = new InputStream(sock.getInputStream());
		BufferedReader receivedRead = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		
		String receivedMessage,sendMessage;
		
		while(true) {
			sendMessage = br.readLine();
			pwrite.println(sendMessage);
			pwrite.flush();
			if((receivedMessage=receivedRead.readLine())!=null){
				System.out.println(receivedMessage);
			}
		}
	}

}
