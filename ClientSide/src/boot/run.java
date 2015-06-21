package boot;


import algorithms.mazeGenerators.Maze;
import model.ClientModel;
import model.Model;


public class run {
public static void main(String[] args) {
		
		Model myModel = new ClientModel("127.0.0.1",5070);
		Maze m;
		myModel.getMaze();
		//m = myModel.getMaze();
		
	}

}
