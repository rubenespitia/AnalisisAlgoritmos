/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa20201;

import aa20201.data.Grafica;
import busquedas.BusquedaSecuencial;
import busquedas.Busquedas;
import busquedas.GeneradorDatos;
import java.util.ArrayList;
import ordenamiento.Burbuja;
import ordenamiento.BurbujaOpt;
import ordenamiento.Elemento;
import ordenamiento.Fibonacci;
import ordenamiento.FibonacciIterativo;
import ordenamiento.FibonacciIterativoDinamico;
import ordenamiento.FibonacciRD;
import ordenamiento.InserSort;
import ordenamiento.MergeSort;
import ordenamiento.Mochila;
import ordenamiento.QuickSort;

/**
 *
 * @author working
 */
public class AA20201 {

    /**
     * @param args the command line arguments
     */
    
    
    
    
    
public static void main(String[] args) {
         ArrayList<Elemento> elementos = LeerDatos.tokenizarDataSet();
//
//        Mochila primera = new Mochila(50, elementos.size());
//        Mochila finalita = new Mochila(50, elementos.size());
//        llenarMochila(primera, elementos, false, finalita);
        
        int[] pesos= new int[elementos.size()];
        int[] beneficios= new int[elementos.size()];
        int[][] resuls; 
        for(int i=0;i<elementos.size();i++)
        {
            pesos[i]= elementos.get(i).getPeso();
            beneficios[i]= elementos.get(i).getBeneficio();
 
        }
        
        resuls=mochilaDin(pesos,beneficios,1000);
        
  for (int x=0; x < resuls.length; x++) {
  System.out.print("|");
  for (int y=0; y < resuls[x].length; y++) {
  System.out.print (resuls[x][y]);
   if (y!=resuls[x].length-1) System.out.print("\t");
  }
  System.out.println("|");
}
 
   //    System.out.println(finalita);
    }
    
    public static void llenarMochila(Mochila actual, ArrayList<Elemento> elementos, boolean llena, Mochila finalita) {
      if (llena) {
          //Compurebo cual tiene el mejor beneficio
          if (actual.getBeneficio() > finalita.getBeneficio()) {
              Elemento[] elementosMochBase = actual.getElementos();
              finalita.clear();
              //Agregamos los elementos a la mochila mejor optimizada
             for (Elemento e : elementosMochBase) {
             if (e != null) {
             finalita.aniadirElemento(e);
            }
           }
          }
      } else {
          //Recorre los elementos
        for (int i = 0; i < elementos.size(); i++) {
          //si existe el elemento
            if (!actual.existeElemento(elementos.get(i))) {
            //Si el peso de la mochila se supera, indicamos que esta llena
            if (actual.getPesoMaximo() > actual.getPeso() + elementos.get(i).getPeso()) {
              //añadimos
                actual.aniadirElemento(elementos.get(i)); 
                llenarMochila(actual, elementos, false, finalita);
                //Eliminamos el elemento por pasarse del peso
                actual.eliminarElemento(elementos.get(i)); 
        } else {
         llenarMochila(actual, elementos, true, finalita);
        }
       }
      }
    }
  }
    
    public static int[][] mochilaDin(int[] pesos, int[] beneficios, int capacidad){
   
   int[][]  matriz_mochila = new int[pesos.length+1][capacidad+1];
   for(int i = 0; i <= capacidad; i++)
            matriz_mochila[0][i] = 0; 
   for(int i = 0; i <= pesos.length; i++)  
           matriz_mochila[i][0] = 0;   
        for(int j = 1; j <= pesos.length ; j++)  
           for(int c = 1; c <= capacidad; c++){  
      if(c <  pesos[j-1] ){   
        matriz_mochila[j][c] = matriz_mochila[j-1][c]; 
            }else{   
              if(matriz_mochila[j-1][c] > matriz_mochila[j-1][c-pesos[j-1]]+ beneficios[j-1]){
           matriz_mochila[j][c] = matriz_mochila[j-1][c];
               }else{
                 matriz_mochila[j][c] = matriz_mochila[j-1][c-pesos[j-1]]+beneficios[j-1];
               }
            }
       }
       return matriz_mochila;
     }
}
