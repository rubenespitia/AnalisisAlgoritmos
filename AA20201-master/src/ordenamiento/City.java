/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

/**
 *
 * @author ruben
 */
public class City {
	private String name;
	private int ID;
	private boolean visited;


	public City(String name, int ID, boolean visited) {
		this.name = name;
		this.ID = ID;
		this.visited = visited;
	}

	// Mutator functions

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	@Override
	public String toString() {
		return "City{" + "name=" + name + ", ID=" + ID + ", visited=" + visited + '}';
	}
}