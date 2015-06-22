package model;

import java.io.Serializable;

import algorithms.search.Solution;
/**
 * {@link SolutionSerialzable} is a {@link Serializable} class to send a Solution via socket
 * 
 */
public class SolutionSerialzable implements Serializable {
	
	
	
	private static final long serialVersionUID = 2L;
	Solution sol;
	
	public SolutionSerialzable(Solution sol) {
		this.sol=sol;
	}

	public Solution getSol() {
		return sol;
	}

	public void setSol(Solution sol) {
		this.sol = sol;
	}

}
