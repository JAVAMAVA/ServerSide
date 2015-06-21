package model;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public interface ClientHandler {
	void handle(Socket sock, InputStream inFromClient,OutputStream outToClient);
	
}
