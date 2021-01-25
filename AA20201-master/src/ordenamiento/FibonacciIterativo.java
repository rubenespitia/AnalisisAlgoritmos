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
public class FibonacciIterativo {
        public long tInicio;
    public long tFinal;
    public long tTotal;

    public FibonacciIterativo() {
        this.tFinal = 0;
        this.tInicio = 0;
        this.tTotal = 0 ;
    }
  
    public void ordenar(int datos){
        this.tInicio = System.currentTimeMillis();
        fibonacciI(datos);
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

    public static void fibonacciI(int n) {
 
        int n1 = 0;
        int n2 = 1;
        int limite = n;  
 
        System.out.print(n1 + ", ");
        System.out.print(n2 + ", ");
 
        for(int i = 0; i<limite-2; i++){
            n2 = n1 + n2;
            n1 = n2 - n1;
            System.out.print(n2 + ", ");
        }
    
     }
   }
