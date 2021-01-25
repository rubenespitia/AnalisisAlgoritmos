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

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 *
 * @author SaruraiTensai
 */
public class Caballo{

    static final int N = 7;
    static final int n = (N + 1);
    private int[][] tablero = new int[n][n];
    private boolean exito;
    private int[][] mov = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1},
    {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
    private int x0, y0;
// constructor

    public Caballo(int x, int y) throws Exception {
        if ((x < 1) || (x > N)
                || (y < 1) || (y > N)) {
            throw new Exception("Coordenadas fuera de rango");
        }
        x0 = x;
        y0 = y;
        for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
        tablero[i][j] = 0;
        }
        }
        tablero[x0][y0] = 1;
        exito = false;
    }
    public boolean resolverProblema() {
        saltoCaballo(x0, y0, 2);
        return exito;
    }
    private void saltoCaballo(int x, int y, int i) {
        int nx, ny;
        int k;
// inicializa los posibles movimientos
        k = 0; 
        do {
            k++;
            nx = x + mov[k - 1][0];
            ny = y + mov[k - 1][1];
                // determina si nuevas coordenadas estan dentro del arreglo
                if ((nx >= 1) && (nx <= N) && (ny >= 1) && (ny <= N)
                && (tablero[nx][ny] == 0)) {
                tablero[nx][ny] = i; // anota movimiento
                if (i < N * N) {
                saltoCaballo(nx, ny, i + 1);
                // Se completa la solucion
                if (!exito) { // no se alcanzó la solución
                tablero[nx][ny] = 0; //la anotacion se borra
                }
                } else {
                exito = true; // tablero cubierto
                }
            }
        } while ((k < 8) && !exito);
    }

//Imprime el recorrido
    void recorrido() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    
 public static void main(String[] args) {
        int x, y;
        boolean solucion;
        BufferedReader entrada = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            System.out.println("Coordenadas iniciales ");
            System.out.print(" x = ");
            x = Integer.parseInt(entrada.readLine());
            System.out.print(" y = ");
            y = Integer.parseInt(entrada.readLine());
            Caballo CaballoBiens = new Caballo(x, y);
            solucion = CaballoBiens.resolverProblema();
            if (solucion) {
                CaballoBiens.recorrido();
            }
        } catch (Exception m) {
            System.out.println("No se pudo probar el algoritmo, " + m);
        }
    } 
}






