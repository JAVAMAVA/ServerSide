package boot;


import model.ClientHandler;
import model.Model;
import model.MyClientHandler;
import model.MyModel;
import model.myTCPServ;


public class Run {
	public static void main(String[] args) {
		
		Model myModel = new MyModel(10);
		ClientHandler sh=new MyClientHandler(myModel);
		myTCPServ myserv=new myTCPServ(5070, sh);
		try {
			myserv.run();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		/*ObjectOutputStream ob;
		DFSMazeGenerator dfs=new DFSMazeGenerator();
		
		BFS bfs=new BFS();
		NewMazeDomain md=new NewMazeDomain(dfs.generateMaze(10, 10));
		SolutionSerialzable sol = new SolutionSerialzable(bfs.search(md));
		
		
		
		
		
		try {
			ob = new ObjectOutputStream(new FileOutputStream("txt.txt" ));
			ob.writeObject(sol);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*try {
			ObjectInputStream obj=new ObjectInputStream(new FileInputStream("txt.txt"));
			SolutionSerialzable mazesol=(SolutionSerialzable) obj.readObject();
			mazesol.getSol().printSolution();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		

}

