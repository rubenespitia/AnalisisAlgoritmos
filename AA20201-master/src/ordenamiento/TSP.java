/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

import java.util.ArrayList;
import java.util.List;

public class TSP {
    
	// Lista de las ciudades
	private static List<City> ciudades;
	// Distancias
	private static final double[][] VdeRutas = {
                        { 0,31,45,78,4,5},
			{31,0,132,1,74,12},
                        { 45,132,0,3,47,65},
			{ 78,1,3,0,7,15},
			{ 4,74,47,7,0,69},
                        {  5,12,65,15,69,0}};

	public static void main(String[] args) {
                //Almacenamos el tiempo que tarde en hacerlo
		long tiempo2 = 0;
		// Numero de veces que repetimos el algoritmo
		int numIterations = 1;

		for (int i = 0; i < numIterations; i++) {
		long tiempo = System.currentTimeMillis();
		tiempo = System.currentTimeMillis();
		//Corre el programa
		DistanciaMasCorta();
		System.out.println("\tTiempo implementado:" + (System.currentTimeMillis() - tiempo) + "ms");
		tiempo2 += System.currentTimeMillis() - tiempo;
		tiempo = System.currentTimeMillis();
		}

		
	}

            //Calculamos la ruta mas corta
	private static void DistanciaMasCorta() {
		// Setup city list
		ListaCero();
		double CostoDeRuta = 0;

		// Nueva ruta con inicio desde ciudad
		Route rutaCercana = new Route(ciudades.get(5));

		while (rutaCercana.getRoute().size() != ciudades.size()) {

			City ciudadCercana = null;
			double distanciaCercana = Double.MAX_VALUE;

			for (int i = 0; i < 5; i++) {
                        // Entra al if si no es el mismo nodo. si no está visitado y si es cercano
			if (VdeRutas[rutaCercana.getCurrentCity().getID()][i] < distanciaCercana
			&& VdeRutas[rutaCercana.getCurrentCity().getID()][i] != 0
			 && ciudades.get(i).isVisited() == false) {

                        // Comprueba la ciudad vecina mas cercana
                         ciudadCercana = ciudades.get(i);
                         distanciaCercana = VdeRutas[rutaCercana.getCurrentCity().getID()][i];
			}
			}

			if (ciudadCercana != null) {
                        // Actualiza donde estamos, añade una ruta, actualiza donde estamos como visitado
			rutaCercana.getRoute().add(ciudadCercana);
                        rutaCercana.setCurrentCity(ciudadCercana);
			ciudadCercana.setVisited(true);

                        // Añadimos distancia
			CostoDeRuta += distanciaCercana;
			}
		}
		// Añadimos el costo de viaje a nuestra cuenta
		CostoDeRuta += VdeRutas[rutaCercana.getStartCity().getID()][rutaCercana.getCurrentCity().getID()];
		// Añadimos la ciudad utilizada a la lista
		rutaCercana.getRoute().add(ciudades.get(5));
		System.out.println("\t" + rutaCercana.toString() + "\n\t Valor del viaje: " + CostoDeRuta);
	}

	//Lleva todos los valores de ciudades a 0
	private static void ListaCero() {
		ciudades = new ArrayList<City>();
		// Ciudades
		ciudades.add(new City("Tepito", 0, false));
		ciudades.add(new City("La Guadalupana", 1, false));
		ciudades.add(new City("Queretaro", 2, false));
		ciudades.add(new City("Guerrero", 3, false));
		ciudades.add(new City("Monterrey", 4, false));
		ciudades.add(new City("Arizona", 5, true));

	}
}