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
import modelo.Capitulo;
import vista.VentanaCapitulo;

/**
 *
 * @author Marcelo11
 */
public class EventoVentanaCapitulo implements ActionListener{
    private VentanaCapitulo ventanaCapitulo;

    public EventoVentanaCapitulo() {
    }

    public EventoVentanaCapitulo(VentanaCapitulo ventanaCapitulo) {
        this.ventanaCapitulo = ventanaCapitulo;
    }

    public VentanaCapitulo getVentanaCapitulo() {
        return ventanaCapitulo;
    }

    public void setVentanaCapitulo(VentanaCapitulo ventanaCapitulo) {
        this.ventanaCapitulo = ventanaCapitulo;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
        if (e.getSource().equals(this.ventanaCapitulo.getBoton1())) {
            
            String ruta=this.ventanaCapitulo.getTxtList().get(0).getText();
            String nombreCapitulo=this.ventanaCapitulo.getTxtList().get(1).getText();
            int numeroPaginas=Integer.parseInt(this.ventanaCapitulo.getTxtList().get(2).getText());
            String libro= this.ventanaCapitulo.getCombo().getSelectedItem().toString();
            
            Capitulo capitulo = new Capitulo(nombreCapitulo, numeroPaginas, this.ventanaCapitulo.getgD().buscarLibro(libro));
            
            boolean retorno = false;
                for (Capitulo c : this.ventanaCapitulo.getgD().getCapituloList()) {
                    if (nombreCapitulo.equals(capitulo.getNombreCapitulo()) == true) {
                        retorno = true;
                        break;
                    }
                }
                if (retorno == true) {
                    JOptionPane.showMessageDialog(null,"Datos ya INGRESADOS");
                } else {
                    this.ventanaCapitulo.getgD().addCapitulo(capitulo);

                }

                Object[][] dato = this.ventanaCapitulo.cargaDatosTabla(this.ventanaCapitulo.getgD().getCapituloList().size(), 3);
                this.ventanaCapitulo.setDatos(dato);
                this.ventanaCapitulo.getModeloTabla().setDataVector(this.ventanaCapitulo.getDatos(), this.ventanaCapitulo.getEncabezado());
                
                File guardarArchivo = new File(ruta);
                this.ventanaCapitulo.getgD().persistirCapituloList(this.ventanaCapitulo.getgD().getCapituloList(),guardarArchivo);
                this.ventanaCapitulo.getgD().LeerCapituloList(guardarArchivo);

        }    
            
        if (e.getSource().equals(this.ventanaCapitulo.getBoton2())) {
            this.ventanaCapitulo.getTxtList().get(0).setText("");
            this.ventanaCapitulo.getTxtList().get(1).setText("");
            this.ventanaCapitulo.getTxtList().get(2).setText("");
        }
        
        if (e.getSource().equals(this.ventanaCapitulo.getBoton3())) {
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            JFrame frame = new JFrame();
            frame.setLayout(new FlowLayout());
           
            
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            
            File selectedFile = fileChooser.getSelectedFile();
                        
            frame.pack();
            
            this.ventanaCapitulo.getTxtList().get(0).setText(selectedFile.getAbsolutePath());   
        }
        
        }catch(Exception x){
    
        }
    }
}