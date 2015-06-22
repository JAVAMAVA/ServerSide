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
	
	}

}
