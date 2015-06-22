package model;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public interface ClientHandler {
	void handle(Socket sock, InputStream inFromClient,OutputStream outToClient);
	public String getMazeGeneratorType();
	public void setMazeGeneratorType(String mazeGeneratorType);
	public String getSolutionType();
	public void setSolutionType(String solutionType);
	
	
}
