/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import GestionDato.GestionDato1;
import java.util.ArrayList;
import java.util.List;
import modelo.Autor;
import modelo.Capitulo;
import modelo.Libro;

/**
 *
 * @author EstebanRM
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Capitulo> capitulo = new ArrayList<Capitulo>();
        List<Libro> libro = new ArrayList<Libro>();
        List<Autor> autor = new ArrayList<Autor>();
                
        GestionDato1 gD = new GestionDato1(autor, capitulo, libro );
        
        VentanaInicial vI = new VentanaInicial(gD);
        vI.setVisible(true);
    }
}
    

