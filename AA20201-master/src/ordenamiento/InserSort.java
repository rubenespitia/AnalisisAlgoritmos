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
public class InserSort {
    
    public long tInicio;
    public long tFinal;
    public long tTotal;

    public InserSort() {
        this.tFinal = 0;
        this.tInicio = 0;
        this.tTotal = 0 ;
    }
  
    public void ordenar(int[] datos){
        this.tInicio = System.currentTimeMillis();
        ordenarDatos(datos);
        this.tFinal = System.currentTimeMillis();
        this.tTotal = this.tFinal - this.tInicio;
    }
    public long gettFinal() {
        return tFinal;
    }

    public long gettInicio() {
        return tInicio;
    }

    public long gettTotal() {
        return tTotal;
    }

    private void ordenarDatos(int[] datos) { //
         int n = datos.length; //2 una asignacion y la longitud se obtiene
        for (int i = 1; i < n; ++i) { //2+2n 
            int aux = datos[i]; //1 una asignacion
            int j = i - 1; //2 una asignacion y una resta
            while (j >= 0 && datos[j] > aux) { //(n+1)(n+1), se multiplica por tener un and//(n+1)^2=n^2+2n+1
                datos[j + 1] = datos[j]; //2 operaciones, una asignacion y una suma
                j = j - 1; //2 operaciones, una asignacion y una resta
            } 
            datos[j + 1] = aux; //2 operaciones por asignacion 
        } 
    }    
    // la complejidad es 2+2+2n+1+2+(n+1)^2+2+2+2=n^2+2n+11
    
}
