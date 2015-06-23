package boot;


import org.eclipse.swt.widgets.Display;


import viewGui.StartWindow;


public class Run {
public static void main(String[] args) {
		
	Display display = new Display();
	
	StartWindow start = new StartWindow("My Window", 500, 500,display );
	start.start();
	start.run();
	
	}

}
