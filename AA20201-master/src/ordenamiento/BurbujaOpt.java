/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

/**
 *
 * @author working
 */
public class BurbujaOpt {
     
   
    public long tInicio;
    public long tFinal;
    public long tTotal;

    public BurbujaOpt() {
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

    private void ordenarDatos(int[] a) { 
for(int i=1; i<a.length; i++) {
boolean is_sorted = true;

for(int j=0; j < a.length - i; j++) { // skip the already sorted largest elements
if(a[j] > a[j+1]) {
int temp = a[j];
        a[j] = a[j+1];
        a[j+1] = temp;
        is_sorted = false;
    }
}

if(is_sorted) return;
}
        
        
        
    }    
    
}
