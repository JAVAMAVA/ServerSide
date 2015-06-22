package boot;


import org.eclipse.swt.widgets.Display;

import view.BasicWindow;
import view.ServerStart;
import model.ClientHandler;
import model.Model;
import model.MyClientHandler;
import model.MyModel;
import model.myTCPServ;


public class Run {
	public static void main(String[] args) {
		
		Display dis = new Display();
		BasicWindow startWin = new ServerStart("Server", 400, 400, dis);
		startWin.run();
		
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
		
		
		

}

