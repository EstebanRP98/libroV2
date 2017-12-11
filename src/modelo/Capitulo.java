/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Marcelo11
 */
public class Capitulo {
    private String nombreCapitulo;
    private int numeroPaginasCapitulo;
    private Libro libro;

    public Capitulo(String nombreCapitulo, int numeroPaginasCapitulo, Libro libro) {
        this.nombreCapitulo = nombreCapitulo;
        this.numeroPaginasCapitulo = numeroPaginasCapitulo;
        this.libro = libro;
    }

    public String getNombreCapitulo() {
        return nombreCapitulo;
    }

    public void setNombreCapitulo(String nombreCapitulo) {
        this.nombreCapitulo = nombreCapitulo;
    }

    public int getNumeroPaginasCapitulo() {
        return numeroPaginasCapitulo;
    }

    public void setNumeroPaginasCapitulo(int numeroPaginasCapitulo) {
        this.numeroPaginasCapitulo = numeroPaginasCapitulo;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    @Override
    public String toString() {
        return nombreCapitulo + " / " + numeroPaginasCapitulo + " / " + libro ;
    }
    
    
}
