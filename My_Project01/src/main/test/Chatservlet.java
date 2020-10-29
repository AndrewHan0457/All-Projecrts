package main.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Chatservlet {
	private ServerSocket serverSocket=null;
	//��ͻ���
	private ArrayList<Clientconn> list=new ArrayList<Clientconn>();
	//�����ҵķ����
	public Chatservlet(int port) throws IOException{
	serverSocket=new ServerSocket(port);
	}
	//�������������
	public void startServer() throws Exception{
	System.out.println("Server Start!");
	while(true){
	Socket socket = serverSocket.accept();
	list.add(new Clientconn(socket));
	System.out.println("Connected " + socket.getInetAddress());
	System.out.println(list.size()+" Clients online.");
	}
	}
	//�ڲ���,����ͻ��˵����ӣ��Զ��̷߳�ʽ
	class Clientconn implements Runnable{
	Socket s=null;
		public Clientconn(Socket s) {
		this.s=s;
		new Thread(this).start();
		}
	//������Ϣ�ķ���
		public void send(String str) throws IOException{
		DataOutputStream dos=new DataOutputStream(s.getOutputStream());
		dos.writeUTF(str);
		}
	//�رտͻ������ӵķ���
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
	//������Ϣ
		try {
		DataInputStream dis=new DataInputStream(s.getInputStream());
		//�ȶ���Ϣ����
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
