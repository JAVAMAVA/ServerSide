package boot;


import org.eclipse.swt.widgets.Display;

import presenter.Presenter;
import viewGui.StartWindow;
import algorithms.mazeGenerators.Maze;
import model.ClientModel;
import model.Model;


public class Run {
public static void main(String[] args) {
		
	Display display = new Display();
	
	StartWindow start = new StartWindow("My Window", 500, 500,display );
	start.start();
	start.run();
//	ClientModel m=new ClientModel();
//	//MazeWindow win=new MazeWindow("My Ascii art window", 500, 500);
//	MyView win=new MyView();
//	Presenter c=new Presenter(win,m);
//	m.addObserver(c);
//	win.addobserver(c);
//	win.start();
	
		//Model myModel = new ClientModel();
		//Maze m;
		//myModel.generateMaze("momo", 10, 20);
		//m = myModel.getMaze();
		
	}

}
