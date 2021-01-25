/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa20201;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import ordenamiento.Elemento;

/**
 *
 * @author working
 */
public class LeerDatos {
    
    
    public static ArrayList<Elemento> tokenizarDataSet(){
     
     // conjunto de patrones del data set
     ArrayList<Elemento> instancias = new ArrayList<>();
     
     String texto, aux;
   
     LinkedList<String> lista = new LinkedList();
        
        try {
            //llamamos el metodo que permite cargar la ventana
            JFileChooser file = new JFileChooser();
            file.setCurrentDirectory(new File("./"));
            file.showOpenDialog(file);
            //abrimos el archivo seleccionado
            File abre = file.getSelectedFile();

            //recorremos el archivo y lo leemos
            if (abre != null) {
                FileReader archivos = new FileReader(abre);
                BufferedReader lee = new BufferedReader(archivos);

                while ((aux = lee.readLine()) != null) {
                    texto = aux;
                    lista.add(texto);
                }
                lee.close();
                //System.out.println(lista.size());

                ArrayList<String> lista2 = new ArrayList<>();

                for (int i = 0; i < lista.size(); i++) {
                    StringTokenizer st = new StringTokenizer(lista.get(i), ",");

                    while (st.hasMoreTokens()) {
                        lista2.add(st.nextToken());
                    }

                    int[] vector = new int[lista2.size()];

                    for (int x = 0; x < lista2.size(); x++) {
                        vector[x] = Integer.parseInt(lista2.get(x));
                    }
                    // el ultimo del lista
                    // a la coleccion de patrones se agrega un nuevo patron
                    instancias.add(new Elemento(Integer.parseInt(lista2.get(0)),Integer.parseInt(lista2.get(1))));
                   // patrones.add();
                    lista2.clear();

                }
          
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
            
        }
        return instancias;
    }
    
}