package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.Socket;
import java.util.Observable;

import algorithms.mazeGenerators.DFSMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MazeGenerator;
import algorithms.mazeGenerators.RandomMazeGenerator;
import algorithms.search.CommonSearcher;
import algorithms.search.Solution;
/**
 * {@link MyClientHandler} handles the traffic from the client
 * @author Michael&Amit
 *@param Model holds the Model (the server model)
 */

public class MyClientHandler extends Observable implements ClientHandler{
	
	Model m;
	CommonSearcher cms;
	MazeGenerator mg;
	String mgen;
	String soltype;
	
	public MyClientHandler(Model m) { //from the run
		super();
		this.m = m;		
	}

	
	/**
	 * This method handles the Client that connected to the server
	 * @param FromClient the Reader
	 * @param ToClient the writer
	 */
	@Override
	public void handle(Socket sock, InputStream inFromClient, OutputStream outToClient) {
		ObjectOutputStream objToClient = null; //To Send Serializble 
		BufferedReader FromClient = new BufferedReader(new InputStreamReader(inFromClient));
		PrintWriter ToClient = new PrintWriter(new OutputStreamWriter(outToClient));
		try {
			objToClient = new ObjectOutputStream(outToClient);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Handle");
		
		try {
			String[] line = FromClient.readLine().split(" ");
			
			System.out.println(line[0] + line[1]);
			
			if((line[0] + " " + line[1]).equals("generate maze"))//generating maze
			{
				//m.generateMaze(line[2], Integer.parseInt(line[3]) , Integer.parseInt(line[4]));
				
				ToClient.println("Done");
				ToClient.flush();
				
				inFromClient.close();
				outToClient.close();
				sock.close();
				return;
			}
			else if((line[0] + " " + line[1]).equals("get maze")){//getting a maze to the client
				
				Maze maze;
				sendMaze senm ;
				
				switch (mgen) {
				case "Random Generator":
					RandomMazeGenerator rnd = new RandomMazeGenerator();
					maze = rnd.generateMaze(Integer.parseInt(line[2]), Integer.parseInt(line[3]));
					
					senm = new sendMaze(maze);
					objToClient.writeObject(senm);
					objToClient.flush();
					break;
				case "DFS":
					DFSMazeGenerator df = new DFSMazeGenerator();
					maze = df.generateMaze(Integer.parseInt(line[2]), Integer.parseInt(line[3]));
					
					senm = new sendMaze(maze);
					objToClient.writeObject(senm);
					objToClient.flush();
					break;
					
				default:
					break;
				}
				
//				if(m.checkMaze(line[3])){
//					maze = m.getMaze();
//					sendMaze sendm = new sendMaze(maze);
//					ToClient.println(sendm);
//				}
				
				
				//ToClient.println("Done");
				ToClient.flush();
				
				objToClient.close();
				inFromClient.close();
				outToClient.close();
				sock.close();
				return;
			}
			else if((line[0] + " " + line[1]).equals("get solution")){//getting solution to client
				
				Solution sol = new Solution();
				sendSolution sendSolution ;
				
				switch (soltype) {
				case "Astar":
					
					
					
					
					break;
				case "BFS" :
					
					break;

				default:
					break;
				}
				
				
				
				if(m.checkSolution(line[2])){
					sol = m.getSolution(line[3]);
					sendSolution sendsol = new sendSolution(sol);
					ToClient.print(sendsol);
				}
				
				objToClient.writeObject(sol);
				ToClient.println("Done");
				ToClient.flush();
				
				objToClient.close();
				inFromClient.close();
				outToClient.close();
				sock.close();
				return;
			}
			else if((line[0] + " " + line[1]).equals("get clue")){//get a clue to the client
				
				inFromClient.close();
				outToClient.close();
				sock.close();
				return;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			inFromClient.close();
			outToClient.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
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
