package model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * {@link myTCPServ} implements {@link Runnable} is the server side
 * it handles the communication between the client and the server
 * @author Michael&Amit
 *
 */
public class myTCPServ implements Runnable {
	
	ClientHandler myClientHandler;
	private int port;
	private volatile boolean stopped;
	private int clientNum;
	ExecutorService threadpool;
	
	/**
	 * Constructor for the server
	 * @param port the server port
	 * @param myServhandle the server handler
	 */
	public myTCPServ(int port, ClientHandler myClientHandler) {
		this.port = port;
		stopped = false;
		this.myClientHandler=myClientHandler;
	}
	/**
	 * run from {@link Runnable} override, calls start function
	 */
	
	@Override
	public void run() {
		try {
			this.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * start is the main method that runs the server and the communication to the client
	 * @param numOfClient the number of clients connected to the server
	 * @throws Exception
	 */
	
	public void start() throws Exception{
		System.out.println("ServerStarted");
		ServerSocket Server;
		
		Server = new ServerSocket(port);
		Server.setSoTimeout(20000);
		
		threadpool=Executors.newFixedThreadPool(10);
		
		while(!stopped){
			Socket someClient = Server.accept();
			System.out.println("ACCEPT");
			System.out.println("Connected");
			InputStream in = someClient.getInputStream();
		    OutputStream out = someClient.getOutputStream();
			threadpool.execute(new Runnable() {
				
				@Override
				public void run() {
					System.out.println("Run");
					try {
						
						//myClientHandler.handle(someClient.getInputStream(), someClient.getOutputStream());
						myClientHandler.handle(someClient,in, out);
						//System.out.println(someClient.getInputStream().toString());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});

//			new Thread(new Runnable() {
//				@Override
//				public void run() {
//					System.out.println("Run");
//					try {
//						
//						//myClientHandler.handle(someClient.getInputStream(), someClient.getOutputStream());
//						myClientHandler.handle(someClient,in, out);
//						//System.out.println(someClient.getInputStream().toString());
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//
//				}
//			}).start();
				
		}
		Server.close();
	}
	
	public void stop(){
		stopped = true;
		
	}

	


	
	

}
