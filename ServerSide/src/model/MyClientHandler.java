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
import java.util.HashMap;
import java.util.Observable;

import algorithms.demo.MazeDomain;
import algorithms.mazeGenerators.DFSMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MazeGenerator;
import algorithms.mazeGenerators.RandomMazeGenerator;
import algorithms.search.AStar;
import algorithms.search.BFS;
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
	HashMap<String, MazeSerialzable> nameMazes;
	HashMap<String,SolutionSerialzable> nameSolutions;
	
	public MyClientHandler(Model m) { //from the run
		super();
		this.m = m;		
		this.nameMazes=new HashMap<>();
		this.nameSolutions=new HashMap<>();
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
			objToClient = new ObjectOutputStream(sock.getOutputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Handle");
		
		try {
			String[] line = FromClient.readLine().split(" ");
			
			System.out.println(line[0] + line[1]);
			
			if((line[0] + " " + line[1]).equals("get maze")){ //generating maze
				inFromClient.close();
				outToClient.close();
				sock.close();
				return;
			}
			else if((line[0] + " " + line[1]).equals("generate maze")){//getting a maze to the client
				if (nameMazes.get(line[2]) != null) {
					ToClient.println("Maze already exists");
					ToClient.flush();
				}
				else{
					ToClient.println("Maze doesn't exists");
					ToClient.flush();
				}
				System.out.println("generating maze for client");
				Maze maze;
				MazeSerialzable senm ;
				
				switch (mazeGeneratorType) {
				case "Random Generator":
					m.setMazeAlg("Random");
					System.out.println("creating randon maze");
					m.generateMaze(line[2], Integer.parseInt(line[3]), Integer.parseInt(line[4]));
					senm = new MazeSerialzable(m.getMaze());
					
//					RandomMazeGenerator rnd = new RandomMazeGenerator();
//					System.out.println(line[3]+" "+line[4]);
//					maze = rnd.generateMaze(Integer.parseInt(line[3]), Integer.parseInt(line[4]));
//					senm = new MazeSerialzable(maze);
				
					senm.maze.print();
					objToClient.writeObject(senm);
					objToClient.flush();
					break;
				case "DFS":
					m.setMazeAlg("DFS");
					System.out.println("creating DFS maze");
					m.generateMaze(line[2], Integer.parseInt(line[3]), Integer.parseInt(line[4]));
					senm = new MazeSerialzable(m.getMaze());
					
//					System.out.println("creating dfs maze");
//					DFSMazeGenerator df = new DFSMazeGenerator();
//					maze = df.generateMaze(Integer.parseInt(line[3]), Integer.parseInt(line[4]));
//					System.out.println("size of maze: "+line[3]+" "+line[4]);
//					senm = new MazeSerialzable(maze);
					
					senm.maze.print();
					objToClient.writeObject(senm);
					objToClient.flush();
					
					break;
					
				default:
					break;
				}
				
				objToClient.close();
				inFromClient.close();
				outToClient.close();
				sock.close();
				return;
			}
			else if((line[0] + " " + line[1]).equals("solve maze")){//getting solution to client
				SolutionSerialzable sol=null;
				if(nameMazes.get(line[2])!=null)
				{
				
				NewMazeDomain md=new NewMazeDomain(nameMazes.get(line[2]).maze);
				
				
				switch (SolutionType) {
				case "Astar":
					m.setSolveAlg("Astar");
					m.solveMaze(line[2]);
					sol = new SolutionSerialzable(m.getSolution(line[2]));
					
					sol.getSol().printSolution();
					
					objToClient.writeObject(sol);
					objToClient.flush();
					
//					AStar astar=new AStar();
//					sol=new SolutionSerialzable(astar.search(md));
					break;
				case "BFS" :
					m.setSolveAlg("Bfs");
					m.solveMaze(line[2]);
					sol = new SolutionSerialzable(m.getSolution(line[2]));
					
					sol.getSol().printSolution();
					
					objToClient.writeObject(sol);
					objToClient.flush();
					
					
//					BFS bfs=new BFS();
//					sol=new SolutionSerialzable(bfs.search(md));
					break;

				default:
					break;
				}
				
				objToClient.close();
				inFromClient.close();
				outToClient.close();
				sock.close();
				return;
				}
				else 
				{
					ToClient.println("Maze was not found");
					ToClient.flush();
				}
			}
			else if((line[0] + " " + line[1]).equals("get Solution")){//get a clue to the client
				if (nameSolutions.get(line[2])!=null) {
					objToClient.writeObject(nameSolutions.get(line[2]));
					objToClient.flush();
					
				}
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





