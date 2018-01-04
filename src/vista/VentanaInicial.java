/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.EventoVentanaInicial;
import GestionDato.GestionDato1;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author EstebanRM
 */
public class VentanaInicial extends JFrame{
    private JDesktopPane escritorio;
    private JMenuBar barraMenu;
    private JMenu menu1;
    private JMenu menu2;
    private JMenu menu3; 
    private List<JMenuItem> itemMenuList;
    private GestionDato1 gD;

    public VentanaInicial(GestionDato1 gD){
        this.setTitle("Practica_3");
        this.setSize(1366, 730);
        this.setDefaultCloseOperation(3);
        this.gD=gD;
        this.iniciaComponentes();
    }
    public void iniciaComponentes(){
        
        this.escritorio=new JDesktopPane();
        this.barraMenu=new JMenuBar();
        
        this.itemMenuList=new ArrayList<JMenuItem>();
        
        this.menu1=new JMenu("Libro");
        this.itemMenuList.add(new JMenuItem("Registrar Libro"));
        
        this.menu2=new JMenu("Capitulo");
        this.itemMenuList.add(new JMenuItem("Registrar Capitulo"));
        
        this.menu3=new JMenu("Autor");
        this.itemMenuList.add(new JMenuItem("Registrar Autor"));
        
        this.setContentPane(escritorio);
        this.setJMenuBar(barraMenu);
        
        this.barraMenu.add(menu1);
        this.menu1.add(this.itemMenuList.get(0));
        
        this.barraMenu.add(menu2);
        this.menu2.add(this.itemMenuList.get(1));
        
        this.barraMenu.add(menu3);
        this.menu3.add(this.itemMenuList.get(2));
        
        this.itemMenuList.get(0).addActionListener(new EventoVentanaInicial(this));
        this.itemMenuList.get(1).addActionListener(new EventoVentanaInicial(this));
        this.itemMenuList.get(2).addActionListener(new EventoVentanaInicial(this));
        
        
    }
    public JDesktopPane getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }

    public JMenuBar getBarraMenu() {
        return barraMenu;
    }

    public void setBarraMenu(JMenuBar barraMenu) {
        this.barraMenu = barraMenu;
    }

    public JMenu getMenu1() {
        return menu1;
    }

    public void setMenu1(JMenu menu1) {
        this.menu1 = menu1;
    }

    public JMenu getMenu2() {
        return menu2;
    }

    public void setMenu2(JMenu menu2) {
        this.menu2 = menu2;
    }

    public JMenu getMenu3() {
        return menu3;
    }

    public void setMenu3(JMenu menu3) {
        this.menu3 = menu3;
    }

    public List<JMenuItem> getItemMenuList() {
        return itemMenuList;
    }

    public void setItemMenuList(List<JMenuItem> itemMenuList) {
        this.itemMenuList = itemMenuList;
    }

    public GestionDato1 getgD() {
        return gD;
    }

    public void setgD(GestionDato1 gD) {
        this.gD = gD;
    }
    
}
