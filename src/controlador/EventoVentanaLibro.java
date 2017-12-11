/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Libro;
import vista.VentanaLibro;

/**
 *
 * @author Marcelo11
 */
public class EventoVentanaLibro implements ActionListener{
    private VentanaLibro ventanaLibro;

   
    public EventoVentanaLibro(VentanaLibro ventanaLibro) {
        this.ventanaLibro = ventanaLibro;
    }

    public VentanaLibro getVentanaLibro() {
        return ventanaLibro;
    }

    public void setVentanaLibro(VentanaLibro ventanaLibro) {
        this.ventanaLibro = ventanaLibro;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
        if (e.getSource().equals(this.ventanaLibro.getBoton1())) {
            
            String ruta=this.ventanaLibro.getTxtList().get(0).getText();
            String nombreLibro=this.ventanaLibro.getTxtList().get(1).getText();
            int numeroPaginas=Integer.parseInt(this.ventanaLibro.getTxtList().get(2).getText());
            String genero=this.ventanaLibro.getTxtList().get(3).getText();
            String autor= this.ventanaLibro.getCombo().getSelectedItem().toString();
            
            Libro libro = new Libro(nombreLibro, numeroPaginas,genero ,this.ventanaLibro.getgD().buscarAutor(autor));
            
            boolean retorno = false;
                for (Libro l : this.ventanaLibro.getgD().getLibroList()) {
                    if (nombreLibro.equals(libro.getNombreLibro()) == true) {
                        retorno = true;
                        break;
                    }
                }
                if (retorno == true) {
                    JOptionPane.showMessageDialog(null,"Datos ya INGRESADOS");
                } else {
                    this.ventanaLibro.getgD().addLibro(libro);

                }

                Object[][] dato = this.ventanaLibro.cargaDatosTabla(this.ventanaLibro.getgD().getLibroList().size(), 4);
                this.ventanaLibro.setDatos(dato);
                this.ventanaLibro.getModeloTabla().setDataVector(this.ventanaLibro.getDatos(), this.ventanaLibro.getEncabezado());
                
                File guardarArchivo = new File(ruta);
                this.ventanaLibro.getgD().persistirLibroList(this.ventanaLibro.getgD().getLibroList(),guardarArchivo);
                this.ventanaLibro.getgD().LeerLibroList(guardarArchivo);

        }    
            
        if (e.getSource().equals(this.ventanaLibro.getBoton2())) {
            this.ventanaLibro.getTxtList().get(0).setText("");
            this.ventanaLibro.getTxtList().get(1).setText("");
            this.ventanaLibro.getTxtList().get(2).setText("");
            this.ventanaLibro.getTxtList().get(3).setText("");
        }
        
        if (e.getSource().equals(this.ventanaLibro.getBoton3())) {
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            JFrame frame = new JFrame();
            frame.setLayout(new FlowLayout());
           
            
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            
            File selectedFile = fileChooser.getSelectedFile();
                        
            frame.pack();
            
            this.ventanaLibro.getTxtList().get(0).setText(selectedFile.getAbsolutePath());   
        }
        }catch(Exception x){
    
        }
    }
}
