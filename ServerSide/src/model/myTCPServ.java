package model;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
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
		Scanner inUserSrver = new Scanner(System.in);
		System.out.println("----ServerStarted----");
		ServerSocket Server;
		System.out.println("Enter for DFS - 1 \n for Random Generator - 2 \n ");
		boolean flag=false;
		while(flag==false)
		{
			int temp=inUserSrver.nextInt();
			switch (temp) {
			case 1:
				myClientHandler.setMazeGeneratorType("DFS");
				flag=true;
				break;
			case 2:
				myClientHandler.setMazeGeneratorType("Random Generator");
				flag=true;
				break;
				
			default:
				System.out.println("Wrong Input, try again:");
				break;
			}
		}
		
		System.out.println("Enter for BFS - 1 \n for Astar - 2 \n ");
		flag=false;
		while(flag==false)
		{
			int temp=inUserSrver.nextInt();
			switch (temp) {
			case 1:
				myClientHandler.setSolutionType("BFS");
				flag=true;
				break;
			case 2:
				myClientHandler.setSolutionType("Astar");
				flag=true;
				break;
				
			default:
				System.out.println("Wrong Input, try again:");
				break;
			}
		}
		
		
		System.out.println("----ServerWaiting----");
		Server = new ServerSocket(port);
		Server.setSoTimeout(100000);
		
		threadpool=Executors.newFixedThreadPool(10);
		
		while(!stopped){
			Socket someClient = Server.accept();
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
