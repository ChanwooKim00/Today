package edu20181206;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.servlet.ServletException;

public class Server {
	public static void main(String[] args) throws IOException, ServletException {
		Server sv=new Server();
		ServerSocket server=sv.openserver();
		String output=sv.acceptclient(server);
		System.out.println(output);
//		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
//		bw.write(output);

	}
	
	
	public ServerSocket openserver() {
		ServerSocket server;
		try {
			server = new ServerSocket(8088);
			System.out.println("open server port:8088");
			return server;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String acceptclient(ServerSocket server) throws IOException {		
		Server sv=new Server();
		while(true) {
			//Ŭ���̾�Ʈ ���� ��� 
			Socket client=server.accept();
			InputStreamReader input=new InputStreamReader(client.getInputStream());
			BufferedReader reader = new BufferedReader(input);
			
			//get , post �з� select ����
			char[] sel=new char[3];
			reader.read(sel);
			String select=String.copyValueOf(sel);
			System.out.println("select�� �����̳�>>"+select);

			Integer contentLength = 0;			

			String result= sv.selectparsing(select, reader);
		
			
			PrintWriter out = new PrintWriter(
                    new BufferedWriter(
                       new OutputStreamWriter(client.getOutputStream())), 
                    true);   
			
			out.write("HTTP/1.0 200 OK\r\n");
			out.write("Content-Type: text/html\r\n");
			out.write("\r\n");
			out.write(result);

			out.close();
			reader.close();
			input.close();
			client.close();
			
			return result;
		}
	}
	
	public String selectparsing(String select, BufferedReader reader) throws IOException{
		String result;
		
		//���� ���� post�� ������ �� 	
		if(select.equals("POS")) {	
			String line = reader.readLine();
			Integer contentLength = 0;			
			while(!line.isEmpty()) {
				if(line.startsWith("Accept-Language: ")) {
					break;
				}
				line=reader.readLine();
					if(line.startsWith("Content-Length")) {
		                contentLength = Integer.parseInt(line.replaceAll("Content-Length: ",""));
		                System.out.println("contentLength >>"+contentLength);
					}
			}
			if(contentLength!=0) {
				char[] data = new char[contentLength+4];
				reader.read(data);
				result=String.copyValueOf(data);
				System.out.println(result);
				return result;
			}
			
		//���� ���� get���� ������ ��
		}else if(select.equals("GET")) {
			String line= reader.readLine();
			String[] getresult = line.split("H");
			return getresult[0];
		}
		System.out.println("ifend");
		return null;
	}
	
	

}



	