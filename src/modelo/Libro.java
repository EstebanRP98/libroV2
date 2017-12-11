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
public class Libro {
    private String nombreLibro;
    private int numeroPagina;
    private String generoLiterario;
    private Autor autor;

    public Libro(String nombreLibro, int numeroPagina, String generoLiterario, Autor autor) {
        this.nombreLibro = nombreLibro;
        this.numeroPagina = numeroPagina;
        this.generoLiterario = generoLiterario;
        this.autor = autor;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public int getNumeroPagina() {
        return numeroPagina;
    }

    public void setNumeroPagina(int numeroPagina) {
        this.numeroPagina = numeroPagina;
    }

    public String getGeneroLiterario() {
        return generoLiterario;
    }

    public void setGeneroLiterario(String generoLiterario) {
        this.generoLiterario = generoLiterario;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return nombreLibro + " / " + numeroPagina + " / " + generoLiterario + " / " + autor;
    }
    
    
}
