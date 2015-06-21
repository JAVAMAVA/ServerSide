package boot;


import java.util.Properties;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import presenter.Presenter;
import viewGui.PropertiesWindow;
import algorithms.mazeGenerators.Maze;
import model.ClientModel;
import model.Model;


public class run {
public static void main(String[] args) {
		
		/*Model myModel = new ClientModel();
		Maze m;
		Display d=new Display();
		myModel.generateMaze("momo", 10, 20);
		//m = myModel.getMaze();*/
	
	Display d=new Display();
	/*Shell sh=new Shell();
	String temp="U";
	Image im=new Image(d, "Images//FloorImageSolution//floor"+temp+".jpg");
	*/
	PropertiesWindow pw=new PropertiesWindow("hello", 500, 500, d);
	pw.run();
		
	}

}
