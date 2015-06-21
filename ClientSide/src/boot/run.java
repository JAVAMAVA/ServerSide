package boot;


import algorithms.mazeGenerators.Maze;
import model.ClientModel;
import model.Model;


public class run {
public static void main(String[] args) {
		
		Model myModel = new ClientModel();
		Maze m;
		myModel.generateMaze("momo", 10, 20);
		//m = myModel.getMaze();
		
	}

}
