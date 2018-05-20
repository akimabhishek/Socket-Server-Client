package com.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocServer {

	public static void main(String[] args) throws Exception {
		
		System.out.println("server started");
		ServerSocket sersock = new ServerSocket(9999);
		System.out.println("Server is waiting for client");
		Socket ss = sersock.accept();
		System.out.println("Server connected with client");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		OutputStreamWriter ostream = new OutputStreamWriter(ss.getOutputStream());
		PrintWriter pwrite = new PrintWriter(ostream);
		
		InputStream instream = ss.getInputStream();
		BufferedReader receivedRead = new BufferedReader(new InputStreamReader(instream));
		
		String receiveMessage, sendMessage;
		
		while(true) {
			if((receiveMessage = receivedRead.readLine())!=null) {
				System.out.println(receiveMessage);
			}
			sendMessage = br.readLine();
			pwrite.println(sendMessage);
			pwrite.flush();
		}
	}

}
