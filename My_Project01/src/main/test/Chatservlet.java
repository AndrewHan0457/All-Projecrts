package main.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Chatservlet {
	private ServerSocket serverSocket=null;
	//存客户端
	private ArrayList<Clientconn> list=new ArrayList<Clientconn>();
	//聊天室的服务端
	public Chatservlet(int port) throws IOException{
	serverSocket=new ServerSocket(port);
	}
	//启动聊天服务器
	public void startServer() throws Exception{
	System.out.println("Server Start!");
	while(true){
	Socket socket = serverSocket.accept();
	list.add(new Clientconn(socket));
	System.out.println("Connected " + socket.getInetAddress());
	System.out.println(list.size()+" Clients online.");
	}
	}
	//内部类,管理客户端的连接，以多线程方式
	class Clientconn implements Runnable{
	Socket s=null;
		public Clientconn(Socket s) {
		this.s=s;
		new Thread(this).start();
		}
	//发送消息的方法
		public void send(String str) throws IOException{
		DataOutputStream dos=new DataOutputStream(s.getOutputStream());
		dos.writeUTF(str);
		}
	//关闭客户端连接的方法
		public void dispose() throws IOException{
			if(s!=null){
			s.close();
			}
		list.remove(this);
		System.out.println("One client exit.");
		System.out.println("NO."+list.size()+" online.");
		}
	@Override
	public void run() {
	//发送消息
		try {
		DataInputStream dis=new DataInputStream(s.getInputStream());
		//先读消息进来
		String str=dis.readUTF();
			while(str!=null&&str.length()!=0){
				if("exit".equals(str.toLowerCase())) {
					break;
				}
				System.out.println(s.getInetAddress()+" said: "+str);
					for(Clientconn cc:list){
					if(this!=cc){
					cc.send(str);
					System.out.println("test line");				
					}
				}
			str = dis.readUTF();
			}
		this.dispose();
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	
	}
	
	}
	
	public static void main(String[] args) throws Exception {
	Chatservlet chatservlet=new Chatservlet(8888);
	chatservlet.startServer();
	
	}
}
