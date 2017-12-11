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
import modelo.Autor;
import vista.VentanaAutor;

/**
 *
 * @author Joel Vasquez
 */
public class EventoVentanaAutor implements ActionListener{
    
    private VentanaAutor ventanaAutor;

    public EventoVentanaAutor(VentanaAutor ventanaAutor) {
        this.ventanaAutor = ventanaAutor;
    }

    public VentanaAutor getVentanaAutor() {
        return ventanaAutor;
    }

    public void setVentanaAutor(VentanaAutor ventanaAutor) {
        this.ventanaAutor = ventanaAutor;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try{
         if (ae.getSource().equals(this.ventanaAutor.getBoton1())) {
            String ruta = this.ventanaAutor.getTxtList().get(0).getText();
            String nombre = this.ventanaAutor.getTxtList().get(1).getText();
            String apellido = this.ventanaAutor.getTxtList().get(2).getText();
            String fechaNac = this.ventanaAutor.getTxtList().get(3).getText();
            String cedula = this.ventanaAutor.getTxtList().get(4).getText();
        
            try {
                Autor autor = new Autor(nombre, apellido, fechaNac, cedula);
                boolean retorno = false;
                for (Autor au : this.ventanaAutor.getgD().getAutorList()) {
                    if (cedula.equals(au.getCedula()) == true) {
                        retorno = true;
                        break;
                    }
                }
                if (retorno == true) {

                    throw new TestException("DATOS YA INGRESADOS");
                    
                } else {
                    this.ventanaAutor.getgD().addAutor(autor);

                }

                Object[][] dato = this.ventanaAutor.cargaDatosTabla(this.ventanaAutor.getgD().getAutorList().size(), 5);
                this.ventanaAutor.setDatos(dato);
                this.ventanaAutor.getModeloTabla().setDataVector(this.ventanaAutor.getDatos(), this.ventanaAutor.getEncabezado());
                
                File guardarArchivo = new File(ruta);
                this.ventanaAutor.getgD().persistirAutorList(this.ventanaAutor.getgD().getAutorList(),guardarArchivo);
                this.ventanaAutor.getgD().LeerAutorList(guardarArchivo);
                

            } catch (TestException te) {

                JOptionPane.showMessageDialog(ventanaAutor, "NO INGRESAR DATOS REPETIDOS", "ERROR!", JOptionPane.ERROR_MESSAGE);
               
            }

        }
        if (ae.getSource().equals(this.ventanaAutor.getBoton2())) {
            this.ventanaAutor.getTxtList().get(0).setText("");
            this.ventanaAutor.getTxtList().get(1).setText("");
            this.ventanaAutor.getTxtList().get(2).setText("");
            this.ventanaAutor.getTxtList().get(3).setText("");
            this.ventanaAutor.getTxtList().get(4).setText("");
            
        }

        if (ae.getSource().equals(this.ventanaAutor.getBoton3())) {
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            JFrame frame = new JFrame();
            frame.setLayout(new FlowLayout());
           
            
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println(selectedFile.getName());
            System.out.println(selectedFile.getAbsolutePath());   
                        
            frame.pack();
            
            
            this.ventanaAutor.getTxtList().get(0).setText(selectedFile.getAbsolutePath());   
        }
        
        }catch(Exception x){
    
        }
    }
}
