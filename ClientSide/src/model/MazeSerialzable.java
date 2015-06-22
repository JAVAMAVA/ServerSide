package model;

import java.io.Serializable;

import algorithms.mazeGenerators.Maze;
/**
 * {@link sendMaze} is a {@link Serializable} class to send a maze via the socket
 * 
 */
public class MazeSerialzable implements Serializable{
	
	//private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Maze maze;
	public MazeSerialzable(Maze m) {
		this.maze = m;
	}
	public Maze getMaze() {
		return maze;
	}
	public void setMaze(Maze maze) {
		this.maze = maze;
	}
	
}
