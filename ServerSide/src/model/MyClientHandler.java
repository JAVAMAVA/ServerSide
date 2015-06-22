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
	String mazeGeneratorType;
	String SolutionType;
	
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
		//PrintWriter ToClient = new PrintWriter(new OutputStreamWriter(outToClient));
		try {
			objToClient = new ObjectOutputStream(sock.getOutputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Handle");
		
		try {
			String[] line = FromClient.readLine().split(" ");
			
			System.out.println(line[0] + line[1]);
			
			if((line[0] + " " + line[1]).equals("get maze"))//generating maze
			{
				//m.generateMaze(line[2], Integer.parseInt(line[3]) , Integer.parseInt(line[4]));
				
				//ToClient.println("Done");
				//ToClient.flush();
				
				inFromClient.close();
				outToClient.close();
				sock.close();
				return;
			}
			else if((line[0] + " " + line[1]).equals("generate maze")){//getting a maze to the client
				System.out.println("generating maze for client");
				Maze maze;
				MazeSerialzable senm ;
				
				switch (mazeGeneratorType) {
				case "Random Generator":
					System.out.println("creating randon maze");
					RandomMazeGenerator rnd = new RandomMazeGenerator();
					maze = rnd.generateMaze(Integer.parseInt(line[2]), Integer.parseInt(line[3]));
					System.out.println("size of maze: "+Integer.parseInt(line[2]+" "+Integer.parseInt(line[3])));
					senm = new MazeSerialzable(maze);
					senm.maze.print();
					objToClient.writeObject(senm);
					objToClient.flush();
					break;
				case "DFS":
					System.out.println("creating dfs maze");
					DFSMazeGenerator df = new DFSMazeGenerator();
					maze = df.generateMaze(Integer.parseInt(line[2]), Integer.parseInt(line[3]));
					System.out.println("size of maze: "+line[2]+" "+line[2]);
					senm = new MazeSerialzable(maze);
					senm.maze.print();
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
				//ToClient.flush();
				
				objToClient.close();
				inFromClient.close();
				outToClient.close();
				sock.close();
				return;
			}
			else if((line[0] + " " + line[1]).equals("get solution")){//getting solution to client
				
				Solution sol = new Solution();
				SolutionSerialzable sendSolution ;
				
				switch (SolutionType) {
				case "Astar":
					
					
					
					
					break;
				case "BFS" :
					
					break;

				default:
					break;
				}
				
				
				
				if(m.checkSolution(line[2])){
					sol = m.getSolution(line[3]);
					SolutionSerialzable sendsol = new SolutionSerialzable(sol);
					//ToClient.print(sendsol);
				}
				
				objToClient.writeObject(sol);
				//ToClient.println("Done");
				//ToClient.flush();
				
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


	public String getMazeGeneratorType() {
		return mazeGeneratorType;
	}


	public void setMazeGeneratorType(String mazeGeneratorType) {
		this.mazeGeneratorType = mazeGeneratorType;
	}


	public String getSolutionType() {
		return SolutionType;
	}


	public void setSolutionType(String solutionType) {
		SolutionType = solutionType;
	}
	
}





