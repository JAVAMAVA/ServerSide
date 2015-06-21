package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Observable;

import algorithms.mazeGenerators.Maze;
import algorithms.search.Solution;

/**
 * {@link ClientModel} is the model for the client, it opens a connection to a server asks for something and closes the connection
 * It's an {@link Observable} type and implements {@link Model}
 * @author 
 *
 */
public class ClientModel extends Observable implements Model {
	
	Maze currMaze;
	Solution currSol;
	String mazeAlg;
	String solveAlg;
	String HOST;
	int PORT;
	/**
	 * Default Constructor
	 */
	public ClientModel(String Host,int Port) {
		this.HOST = Host;
		this.PORT = Port;
	}
	
	/**
	 * solveMaze asks a server to solve a maze
	 * @param myServer the server we connect to
	 */
	@Override
	public void solveMaze(String name) {
		System.out.println("Solving maze");
		Socket myServer = null;
		try {
			//myServer = new Socket(HOST, PORT);
			myServer = new Socket("127.0.0.1", 5070);
			BufferedReader inServer = new BufferedReader(new InputStreamReader(myServer.getInputStream()));
			PrintWriter outToServer = new PrintWriter(new OutputStreamWriter(myServer.getOutputStream()));
			
			//BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
			
			//String line = null;
			//line = inFromUser.readLine();
			
			//outToServer.println("solve maze" + line );
			
			outToServer.println("solve maze" + " " + name);
			outToServer.flush();
			
			myServer.close();
			inServer.close();
			outToServer.close();
			//inFromUser.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * getSolution gets a Solution for a maze from the server
	 * @param myServer the server we connect to
	 */

	@Override
	public Solution getSolution(String name) {
		System.out.println("Getting Solution");
		Socket myServer = null;
		
		Solution sol = null;
		sendSolution getSol = new sendSolution(sol);
		try {
			//myServer = new Socket(HOST, PORT);
			myServer = new Socket("127.0.0.1", 5070);
			BufferedReader inServer = new BufferedReader(new InputStreamReader(myServer.getInputStream()));
			PrintWriter outToServer = new PrintWriter(new OutputStreamWriter(myServer.getOutputStream()));
			ObjectInputStream getSolIn = new ObjectInputStream(myServer.getInputStream());
			
			//BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
			
			//String line;
			//line = inFromUser.readLine();
			//outToServer.println("solve maze" + line );
			
			
			outToServer.println("get solution");
			outToServer.flush();
			

			try {
				getSol = (sendSolution)getSolIn.readObject(); //getting the maze
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			myServer.close();
			inServer.close();
			outToServer.close();
			//inFromUser.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * getMaze gets a maze from the server
	 * @param myServer is the server we connect to
	 * @param m a maze
	 * @param mazes a {@link Serializable} maze for getting a maze out of the {@link InputStream}
	 */

	@Override
	public Maze getMaze() {
		System.out.println("Getting maze");
		Socket myServer = null;
		Maze m = null;
		sendMaze mazes = new sendMaze(m);
		try {
			myServer = new Socket("127.0.0.1", 5070);
			BufferedReader inServer = new BufferedReader(new InputStreamReader(myServer.getInputStream()));
			PrintWriter outToServer = new PrintWriter(new OutputStreamWriter(myServer.getOutputStream()));
			ObjectInputStream getMazeIn = new ObjectInputStream(myServer.getInputStream());
			
			//BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
			
			//String line;
			//line = inFromUser.readLine();
			
			outToServer.println("get maze");
			outToServer.flush();
			
			try {
				mazes = (sendMaze)getMazeIn.readObject(); //getting the maze
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mazes.maze.print();
			
			getMazeIn.close();
			myServer.close();
			inServer.close();
			outToServer.close();
			inFromUser.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}
	
	/**
	 * generateMaze sends a request to the server to generate a maze
	 * @param myServer the server we connect to
	 * 
	 */
	
	@Override
	public void generateMaze(String name, int rows, int cols) {
		System.out.println("Generating maze");
		Socket myServer = null;
		try {
			myServer = new Socket("127.0.0.1", 5070);
			BufferedReader inServer = new BufferedReader(new InputStreamReader(myServer.getInputStream()));
			PrintWriter outToServer = new PrintWriter(new OutputStreamWriter(myServer.getOutputStream()));
			
			BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
			
			String line = null;;
			//line = inFromUser.readLine();
			
			//outToServer.println(line+" "+name);
			//outToServer.println("generate maze" + " " + name+" "+rows+" "+cols);
			outToServer.println("generate maze mmm 10 10");
			outToServer.flush();
			
			
			String str = inServer.readLine();
			if(str.equals("Done")) {
				System.out.println("Done");
			}
			
			myServer.close();
			inServer.close();
			outToServer.close();
			inFromUser.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public void getMazeInModel(String arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getSolutionInModel(String arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveToFile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readFromFile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}
}


/**
 * {@link sendMaze} is a {@link Serializable} class to send a maze via the socket
 * 
 */
class sendMaze implements Serializable{
	Maze maze;
	public sendMaze(Maze m) {
		this.maze = m;	
		
	}
	
}
/**
 * {@link sendSolution} is a {@link Serializable} class to send a Solution via socket
 * 
 */

class sendSolution implements Serializable{
	Solution sol;
	public sendSolution(Solution sol) {
		this.sol = sol;
	}
	
}
