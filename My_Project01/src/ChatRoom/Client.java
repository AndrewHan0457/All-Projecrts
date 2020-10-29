package ChatRoom;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
	
	Socket socket = null;
	public Client() throws Exception{
		socket = new Socket("127.0.0.1", 8888);
		new Thread(new ReceiveThread()).start();
	}
	public void send(String str) throws IOException{
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF(str);
	}
	public void disconnection() throws IOException {
		if(socket != null) {
			socket.close();
		}
	}
	
	class ReceiveThread implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			if(socket ==null) {
				return;
			}
			try {
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				String str = dis.readUTF();
				
				while(str!=null) {
					System.out.println(str);
					str = dis.readUTF();
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bReader=new BufferedReader(new InputStreamReader(System.in));
		Client chatClient=new Client();

		System.out.println("Please input£º");
		String str=bReader.readLine();
		System.out.println("I said£º"+str);
		while(str!=null&&str.length()!=0){
			chatClient.send(str);
			System.out.println("Please input£º");
			str=bReader.readLine();
			System.out.println("I said£º"+str);
		}
		chatClient.disconnection();
	}
}
