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
import java.util.ArrayList;
import java.util.List;

public class Route {
	private final City startCity; 
	private City currentCity; 
	private List<City> route = new ArrayList<>(); 


	public Route() {
		startCity = null;
	}


	public Route(City startCity) {
		this.startCity = startCity;
		this.currentCity = startCity;
		this.route.add(startCity);
	}


	public City getStartCity() {
		return startCity;
	}

	public City getCurrentCity() {
		return currentCity;
	}

	public void setCurrentCity(City currentCity) {
		this.currentCity = currentCity;
	}

	public List<City> getRoute() {
		return route;
	}

	public void setRoute(List<City> route) {
		this.route = route;
	}

	@Override
	public String toString() {
		String r = "";
		if (!route.isEmpty()) {
			// Short route for easier display
			for (City c : route) {
				r += c.getName() + ",";
			}

			// Remove trailing comma
			r = r.substring(0, r.length() - 1);
		}
		return "Route{" + r + '}';
	}
}
