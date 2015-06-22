package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class ServerStart extends BasicWindow implements View {

	public ServerStart(String title, int width, int height, Display dis) {
		super(title, width, height, dis);
		
	}

	@Override
	void initWidgets() {
//		shell.setBackground(new Color(display.getCurrent(), 255,255, 255));
		shell.setLayout(new GridLayout(2,false));
		shell.getDisplay().loadFont("Fonts//YanoneKaffeesatz-Bold.ttf");
		shell.setBackgroundMode(SWT.INHERIT_FORCE );
		
		Color basicf = new Color(this.display.getCurrent(), 0, 0, 160);
		Color back = new Color(this.display.getCurrent(), 255,255, 255);
		Font font = new Font(shell.getDisplay(), "name of the font", 23, SWT.BOLD);
		Label Title=new Label(shell, SWT.BOLD);
		
		
		Title.setFont(font);
		Title.setText("Start the server:");
		Title.setForeground(new Color(display.getCurrent(), 0, 0, 160));
		Title.setBackground(null);
		Title.setLayoutData(new GridData(SWT.CENTER,SWT.TOP, true,false,2,1));
		
		Label ep=new Label(shell, SWT.CENTER);
		ep.setFont(font);
		ep.setText("Enter Port:");
		ep.setForeground(new Color(display.getCurrent(), 0, 0	, 0));
		ep.setBackground(null);
		ep.setLayoutData(new GridData(SWT.CENTER,SWT.TOP | SWT.CENTER, true,false,2,1));
		
		Text port  = new Text(shell, SWT.CENTER | SWT.BORDER);//port number
		port.setFont(font);
		port.setForeground(basicf);
		port.setBackground(back);
		port.setLayoutData(new GridData(SWT.CENTER,SWT.TOP | SWT.CENTER, true,false,2,1));
		
		Label cn=new Label(shell, SWT.CENTER);
		cn.setFont(font);
		cn.setText("Enter Maximum client number:");
		cn.setForeground(new Color(display.getCurrent(), 0, 0	, 0));
		cn.setBackground(null);
		cn.setLayoutData(new GridData(SWT.CENTER,SWT.TOP | SWT.CENTER, true,false,2,1));
		
		Text clientNum  = new Text(shell, SWT.CENTER | SWT.BORDER);//client number
		clientNum.setFont(font);
		clientNum.setForeground(basicf);
		clientNum.setBackground(back);
		clientNum.setLayoutData(new GridData(SWT.CENTER,SWT.TOP | SWT.CENTER, true,false,2,1));
		
		Label ma=new Label(shell, SWT.CENTER);
		ma.setFont(font);
		ma.setText("Enter Maximum client number:");
		ma.setForeground(new Color(display.getCurrent(), 0, 0	, 0));
		ma.setBackground(null);
		ma.setLayoutData(new GridData(SWT.CENTER,SWT.TOP | SWT.CENTER, true,false,2,1));
		
		Combo mazeGen  = new Combo(shell, SWT.CENTER | SWT.BORDER);//maze generator
		String[] comboStringm = {"DFS" , "Random Generator"  };
		mazeGen.setItems(comboStringm);
		mazeGen.setFont(font);
		mazeGen.setForeground(basicf);
		mazeGen.setBackground(back);
		mazeGen.setLayoutData(new GridData(SWT.CENTER,SWT.TOP | SWT.CENTER, true,false,2,1));
		
		Label ms=new Label(shell, SWT.CENTER);
		ms.setFont(font);
		ms.setText("Enter Maximum client number:");
		ms.setForeground(new Color(display.getCurrent(), 0, 0	, 0));
		ms.setBackground(null);
		ms.setLayoutData(new GridData(SWT.CENTER,SWT.TOP | SWT.CENTER, true,false,2,1));
		
		Combo mazeSol  = new Combo(shell, SWT.CENTER | SWT.BORDER);//maze generator
		String[] comboStrings = {"Astar" , "BFS"  };
		mazeSol.setItems(comboStrings);
		mazeSol.setFont(font);
		mazeSol.setForeground(basicf);
		mazeSol.setBackground(back);
		mazeSol.setLayoutData(new GridData(SWT.CENTER,SWT.TOP | SWT.CENTER, true,false,2,1));
		
		Button confirm = new Button(shell, SWT.None);
		confirm.setText("Start Server");
		confirm.setFont(new Font(display, "Arial", 12, SWT.NORMAL));
		confirm.setLayoutData(new GridData(SWT.CENTER ,SWT.BOTTOM, false,true,2,1));
		confirm.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

	@Override
	void closeWindow() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void CloseMe() {
		// TODO Auto-generated method stub
		
	}

}
