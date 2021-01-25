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
public class Fibonacci {
       
    public long tInicio;
    public long tFinal;
    public long tTotal;

    public Fibonacci() {
        this.tFinal = 0;
        this.tInicio = 0;
        this.tTotal = 0 ;
    }
  
    public void ordenar(int datos){
        this.tInicio = System.currentTimeMillis();
        fibonacciRecursion(datos);
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

	public static int fibonacciRecursion(int n){
            
	if(n == 0){
		return 0;
	}
	if(n == 1 || n == 2){
			return 1;
		}
	return fibonacciRecursion(n-2) + fibonacciRecursion(n-1);
	
        }
        
        
        public void mostrarSerie(int tamano){
    for (int i = 0; i < tamano; i++) {
        System.out.print(fibonacciRecursion(i)+" ");
    }
    System.out.println();
}
    }    
    

