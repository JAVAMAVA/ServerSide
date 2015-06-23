package presenter;



//public class Presenter implements Observer{
//
//	public class Presenter implements Observer {
//		View v;
//		Model m;
//		HashMap<String,Command> comm=new HashMap<String, Command>();
//		public HashMap<String, Command> hm;
//		public Presenter(View v,Model m) {
//			this.v=v;
//			this.m=m;
//			this.setCommands();
//			
//		}
//		public void setCommands()
//		{
//			comm.put("generate maze",new GenerateMazeCommand());
//			comm.put("display maze", new DisplayMazeCommand());
//			comm.put("solve maze", new SolveMazeCommand());
//			comm.put("display solution", new DisplaySolutionCommand());
//			comm.put("exit", new ExitCommand());
//			v.setCommands(comm);
//		}
//		/**
//		 * this method overrides the update method from {@link Observer} 
//		 * this method is the main method that controls the traffic between the model and the view
//		 */
//		@Override
//		public void update(Observable o, Object args) {
//				//if the view notified the presenter
//	 		   if(o == v) {
//				   if((String)args=="start")
//				   {
//					   v.setCommands(comm);
//					   v.displaySuccess("done");
//				   }
//				   else if((String)args=="exit")
//				   {
//						Command newComm=new ExitCommand();
//						newComm.doCommand((String)args);
//				   }
//				   else 
//				   {
//					   
//					   Command newComm=v.getUserCommand();
//					   newComm.doCommand((String)args);
//					   v.displaySuccess("done");
//				   }
//			   }
//			   
//			   //if the model notified the presenter
//			   if(o == m) {
//				   switch((String)args)
//				   {
//				   case "Maze was found":
//					   v.displayMaze(m.getMaze());
//					   break;
//				   case "Maze was not found":
//					   v.displaySuccess((String)args);
//					   break;
//				   case "Solution was found":
//				   		v.displaySolution(m.solveMaze((String)args));
//				   		break;
//				   case "Solution was not found":
//					   v.displaySuccess((String)args);
//					   break;
//				   case "Maze generated":
//					   v.displaySuccess((String)args);
//					   v.displayMaze(m.getMaze());
//					   break;
//				   case "Maze already exists":
//					   v.displaySuccess((String)args);
//					   break;
//				   }
//			   }
//			}
//
//		public interface Command {
//			void doCommand(String arg);
//		}
//		/**
//		 * {@link GenerateMazeCommand} is called when the view sends a generate maze command
//		 *
//		 */
//		public class GenerateMazeCommand implements Command {
//
//			@Override
//			public void doCommand(String arg) {
//				String[] commands=arg.split(" ");
//				//check input
//				m.generateMaze(commands[0],Integer.parseInt(commands[1]),Integer.parseInt(commands[2]));
//				v.displaySuccess("maze"+commands[0]+" is ready");
//			}
//		}
//		
//	}
//
//	@Override
//	public void update(Observable o, Object arg) {
//		// TODO Auto-generated method stub
//		
//	}
//
//		
//		
//	
//
//}
