/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VentanaAutor;
import vista.VentanaCapitulo;
import vista.VentanaInicial;
import vista.VentanaLibro;

/**
 *
 * @author EstebanRM
 */
public class EventoVentanaInicial implements ActionListener {
    private VentanaInicial ventanaInicial;

    public EventoVentanaInicial(VentanaInicial ventanaInicial) {
        this.ventanaInicial = ventanaInicial;
    }

    public VentanaInicial getVentanaInicial() {
        return ventanaInicial;
    }

    public void setVentanaInicial(VentanaInicial ventanaInicial) {
        this.ventanaInicial = ventanaInicial;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
        if(e.getSource().equals(this.ventanaInicial.getItemMenuList().get(0))){
            VentanaLibro vL = new VentanaLibro(this.ventanaInicial.getgD());
            vL.setVisible(true);
        }
        
        if(e.getSource().equals(this.ventanaInicial.getItemMenuList().get(1))){
            VentanaCapitulo vC = new VentanaCapitulo(this.ventanaInicial.getgD());
            vC.setVisible(true);
        }
        
        if(e.getSource().equals(this.ventanaInicial.getItemMenuList().get(2))){
             VentanaAutor vA = new VentanaAutor(this.ventanaInicial.getgD());
            vA.setVisible(true);
            
        }
        }catch(Exception x){
    
        }
    }
}