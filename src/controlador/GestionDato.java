/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Autor;
import modelo.Capitulo;
import modelo.Libro;

/**
 *
 * @author EstebanRM
 */
public class GestionDato {
    
    private List<Autor> autorList;
    private List<Capitulo> capituloList;
    private List<Libro> libroList;

    public GestionDato(List<Autor> autorList, List<Capitulo> capituloList, List<Libro> libroList) {
        this.autorList = autorList;
        this.capituloList = capituloList;
        this.libroList = libroList;
    }

    public List<Autor> getAutorList() {
        return autorList;
    }

    public void setAutorList(List<Autor> autorList) {
        this.autorList = autorList;
    }

    public List<Capitulo> getCapituloList() {
        return capituloList;
    }

    public void setCapituloList(List<Capitulo> capituloList) {
        this.capituloList = capituloList;
    }

    public List<Libro> getLibroList() {
        return libroList;
    }

    public void setLibroList(List<Libro> libroList) {
        this.libroList = libroList;
    }

    

    public boolean addCapitulo(Capitulo capitulo) {
        return this.capituloList.add(capitulo);
    }
   
    public boolean addLibro(Libro libro) {
        return this.libroList.add(libro);
    }
    
     public boolean addAutor(Autor autor) {
        return this.autorList.add(autor);
    }
    
    public Libro buscarLibro(String Libro){
        for(Libro l:this.getLibroList()){
            if((l.getNombreLibro()+" | "+l.getNumeroPagina()).equals(Libro)== true){
                return l;
            }
        }
        return null;
    }
     public Autor buscarAutor(String Autor){
        for(Autor a:this.getAutorList()){
            if((a.getApellido().equals(Autor))== true){
                return a;
            }
        }
        return null;
    }
    
    public boolean persistirCapituloList(List<Capitulo> lista, File datosCapitulo){
        try {
            FileOutputStream ae = new FileOutputStream(datosCapitulo.getAbsolutePath());
            DataOutputStream escritura = new DataOutputStream(ae);
            for(Capitulo c:lista ){
            
            escritura.writeUTF(c.getNombreCapitulo());
            escritura.writeInt(c.getNumeroPaginasCapitulo());
            escritura.writeUTF(c.getLibro().toString());
            }
            escritura.close();
           return true;     
        } catch (IOException e) {
            return false;
        }
    }
    
    public List<Capitulo> LeerCapituloList( File datosCapitulo){
        try{
            List<Capitulo> capituloList = new ArrayList<Capitulo>();
            FileInputStream ae = new FileInputStream(datosCapitulo.getAbsolutePath());
            DataInputStream lectura = new  DataInputStream(ae); 
            
            while(true){
                String n = lectura.readUTF();
                int nP = lectura.readInt();
                String l = lectura.readUTF();
                Capitulo capitulo = new Capitulo(n, nP, this.buscarLibro(l));
                capituloList.add(capitulo);
            }
         
        }catch(Exception e){
            
        }
        return capituloList;
    }
    
     public boolean persistirAutorList(List<Autor> lista, File datosAutor){
        try {
            FileOutputStream ae = new FileOutputStream(datosAutor.getAbsolutePath());
            DataOutputStream escritura = new DataOutputStream(ae);
            for(Autor c:lista ){
            
            escritura.writeUTF(c.getNombre());
            escritura.writeUTF(c.getApellido());
            escritura.writeUTF(c.getFechaNac());
            escritura.writeUTF(c.getCedula());
            }
            escritura.close();
            
           return true;
           
        } catch (IOException e) {
            
            return false;
        }
    }
    
    public List<Autor> LeerAutorList( File datosAutor){
        try{
            List<Autor> autorList = new ArrayList<Autor>();
            FileInputStream ae = new FileInputStream(datosAutor.getAbsolutePath());
            DataInputStream lectura = new  DataInputStream(ae); 
            
            while(true){
                String n  = lectura.readUTF();
                String a  = lectura.readUTF();
                String fn = lectura.readUTF();
                String c  = lectura.readUTF();
                Autor autor = new Autor(n,a,fn,c);
                autorList.add(autor);
            }
         
        }catch(Exception e){
            
        }
        return autorList;
    }
    
     public boolean persistirLibroList(List<Libro> lista, File datosLibro){
        try {
            FileOutputStream ae = new FileOutputStream(datosLibro.getAbsolutePath());
            DataOutputStream escritura = new DataOutputStream(ae);
            for(Libro l:lista ){
            
            escritura.writeUTF(l.getNombreLibro());
            escritura.writeInt(l.getNumeroPagina());
            escritura.writeUTF(l.getGeneroLiterario());
            escritura.writeUTF(l.getAutor().toString());
            }
            escritura.close();
           return true;     
        } catch (IOException e) {
            return false;
        }
    }
    
    public List<Libro> LeerLibroList( File datosLibro){
        try{
            List<Libro> libroList = new ArrayList<Libro>();
            FileInputStream ae = new FileInputStream(datosLibro.getAbsolutePath());
            DataInputStream lectura = new  DataInputStream(ae); 
            
            while(true){
                String n = lectura.readUTF();
                int nP = lectura.readInt();
                String g = lectura.readUTF();
                String au = lectura.readUTF();
                Libro libro = new Libro(n, nP, g,this.buscarAutor(au));
                libroList.add(libro);
            }
         
        }catch(Exception e){
            
        }
        return libroList;
    }
}

