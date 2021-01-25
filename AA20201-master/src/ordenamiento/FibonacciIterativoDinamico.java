/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

import static ordenamiento.FibonacciRD.fib;

/**
 *
 * @author ruben
 */
public class FibonacciIterativoDinamico {
    int n1;
    int n2;
    int tamano;
    int[] contenedor;
    int posicionClave;
    public long tInicio;
    public long tFinal;
    public long tTotal;
    
    public FibonacciIterativoDinamico(){
        this.tFinal = 0;
        this.tInicio = 0;
        this.tTotal = 0;
    }
        public void ordenar(){
        this.tInicio = System.currentTimeMillis();
        fibonacci();
        this.tFinal = System.currentTimeMillis();
        this.tTotal = this.tFinal - this.tInicio;
    }
    public FibonacciIterativoDinamico(int tamano){
        n1 = 0;
        n2 = 1;
        this.tamano=tamano;
        this.tFinal = 0;
        this.tInicio = 0;
        this.tTotal = 0;
        
        this.contenedor = new int[tamano];
        
        for (int i = 0; i < tamano; i++) {
            this.contenedor[i] = 0;    
        }
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

    public int getN1() {
        return n1;
    }

    public int getN2() {
        return n2;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public int getTamano() {
        return tamano;
    }
    
    public void fibonacci(){
        this.tInicio = System.currentTimeMillis();
        System.out.println("Fibonacci iterativo de tamano "+tamano+" :");
        System.out.print(n1+", ");
        System.out.print(n2+", ");
        
        if (comprobarRepeticion(n1) == true){
            System.out.print(contenedor[posicionClave]+", ");
        }else{
            for (int i = 0; i < tamano-2; i++) {
            n2 = n1 + n2;
            n1 = n2 - n1;
            System.out.print(n2+", ");
            }
        }
        
        this.tFinal = System.currentTimeMillis();
        this.tTotal = this.tFinal - this.tInicio;
    }
    
    public boolean comprobarRepeticion(int x){
        boolean prueba = false;
        
            if (contenedor[x] != 0){
                prueba = true;
                posicionClave = x;
            }else{
                prueba = false;
            }
        
        
        return prueba;
    }
}
