package viewGui;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Observer;

import javax.swing.ButtonModel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import javax.sound.sampled.*;
import javax.sound.sampled.Control.Type;
import javax.sound.sampled.Line.Info;

import presenter.Presenter.Command;
import algorithms.mazeGenerators.Maze;
import algorithms.search.Solution;
import view.View;

public class StartWindow extends BasicWindow implements View  {

	PropertiesWindow prop;
	File sound;
	
	public StartWindow(String title, int width, int height,Display dis) {
		super(title, width, height ,dis);

	}

	@Override
	void initWidgets() {
//		shell.setBackground(new Color(display.getCurrent(), 255,255, 255));
		shell.setLayout(new GridLayout(2,false));
		shell.getDisplay().loadFont("Fonts//YanoneKaffeesatz-Bold.ttf");
		shell.setBackgroundMode(SWT.INHERIT_FORCE );
		
		Font font = new Font(shell.getDisplay(), "name of the font", 23, SWT.BOLD);
		Label Title=new Label(shell, SWT.BOLD);
		Title.setFont(font);
		Title.setText("Welcome To Our Maze Game");
		Title.setForeground(new Color(display.getCurrent(), 200, 40, 160));
//		Title.setBackground(new Color(display.getCurrent(), 255,255, 255));
		Title.setBackground(null);
		Title.setLayoutData(new GridData(SWT.CENTER,SWT.TOP, true,false,2,1));
		
		Image main = new Image(display, "Images//Start.jpg");
//		Label img = new Label(shell, SWT.BORDER |SWT.FILL);
//		img.setLayoutData(new GridData(SWT.CENTER,SWT.TOP | SWT.CENTER, true,false,2,1));
//		img.setImage(main);
		shell.setBackgroundImage(main);
		
		Label creators=new Label(shell, SWT.CENTER);
		creators.setFont(new Font(shell.getDisplay(), "name of the font", 15, SWT.BOLD));
		creators.setText("Creators:\nAmit Munichor\nand\n Michael Chickov");
		creators.setForeground(new Color(display.getCurrent(), 0, 0	, 0));
//		creators.setBackground(new Color(display.getCurrent(), 255,255, 255));
		creators.setBackground(null);
		creators.setLayoutData(new GridData(SWT.CENTER,SWT.TOP | SWT.CENTER, true,false,2,1));
		
		sound = new File("Images//Anac.mp3");
		
		Clip backMusic = new Clip() {
			
			@Override
			public void removeLineListener(LineListener listener) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void open() throws LineUnavailableException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isOpen() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isControlSupported(Type control) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Info getLineInfo() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Control[] getControls() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Control getControl(Type control) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void close() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addLineListener(LineListener listener) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void stop() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void start() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isRunning() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isActive() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public long getMicrosecondPosition() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public long getLongFramePosition() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public float getLevel() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getFramePosition() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public AudioFormat getFormat() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getBufferSize() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public void flush() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drain() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public int available() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public void setMicrosecondPosition(long microseconds) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setLoopPoints(int start, int end) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setFramePosition(int frames) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void open(AudioFormat format, byte[] data, int offset, int bufferSize)
					throws LineUnavailableException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void open(AudioInputStream stream) throws LineUnavailableException,
					IOException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void loop(int count) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public long getMicrosecondLength() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getFrameLength() {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		
		Button okbutton =new Button(shell, SWT.None);
		okbutton.setText("Start Playing!!");
		okbutton.setFont(new Font(display, "Arial", 12, SWT.NORMAL));
		//okbutton.setImage(new Image(this.display,"Images//FloorImages//floorU.jpg"));
		okbutton.setLayoutData(new GridData(SWT.CENTER ,SWT.BOTTOM, false,true,2,1));
		okbutton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				
				prop = new PropertiesWindow("Proparties", 500, 500, display);
				prop.start();
				prop.run();
				
				//MazeWindow mW=new MazeWindow("My Maze Window",500, 500);
				//mW.start();
				//mW.myMaze=new Maze(Integer.parseInt(TROW.getText()),Integer.parseInt(TCOLUMN.getText()));
				//shell.dispose();	
				
			
			
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				
			}
			});
		//Image i =new Image(display,"Images//Pickacho.jpg");
		// okbutton.setImage(i);
		
		
	}

	@Override
	public Command getUserCommand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void displayMaze(Maze m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displaySolution(Solution s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displaySuccess(String str) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCommands(HashMap<String, Command> comm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyArg(Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLastCommand(Command comm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addobserver(Observer observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HashMap<String, Command> getHM() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void closeWindow() {
		// TODO Auto-generated method stub
		
	}

}
