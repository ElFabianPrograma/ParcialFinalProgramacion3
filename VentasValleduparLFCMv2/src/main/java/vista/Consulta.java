/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import entidades.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.*;

/**
 *
 * @author jcontreras
 */
public class Consulta extends JDialog{

    private Container contenedor;
    private JPanel panelFiltro, panelBase;
    private JScrollPane panelResultado;
    private JButton Consultorio;     
    private JTable tabla;
    private DefaultTableModel modelo;
    private String titulos[]={"CogTienda", "NomTienda", "Ciudad", "Dpto", "NomProducto","SubTotal","Descuento","Total"};
    private RegistroReporte logica;
    
    public Consulta(JFrame frame, boolean bln) {
        super(frame, bln);
        this.logica = new RegistroReporte();
        this.setTitle("Consulta Reporte");
        this.iniciarComponentes();
        //this.pack(); 
        this.setSize(800, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        //this.actualizarTabla();
        this.setVisible(true);
    }
    
    public void iniciarComponentes(){
        this.contenedor = this.getContentPane();
        this.panelBase = new JPanel();
        this.panelBase.setLayout(new BorderLayout());
        this.panelBase.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.iniciarPanelFiltro();
        this.iniciarPanelResultado();
        this.contenedor.add(this.panelBase);
    }
    
    public void iniciarPanelFiltro(){
        this.panelFiltro = new JPanel();
        this.panelFiltro.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        
        this.Consultorio=new JButton("Votar Registro");
        this.Consultorio.addActionListener(new ActionButtonConsulta());
        this.panelFiltro.add(this.Consultorio);
        
        
        this.panelBase.add(this.panelFiltro, BorderLayout.NORTH);
        
       
    }
    
    public void iniciarPanelResultado(){
        
        this.panelResultado = new JScrollPane();
        
        this.tabla = new JTable();
        this.modelo = new DefaultTableModel(null, this.titulos);
        this.tabla.setModel(modelo);
        this.panelResultado.setViewportView(this.tabla);
        
        this.panelBase.add(this.panelResultado, BorderLayout.CENTER);
    
    }
    
    public void actualizarTabla(){
        
        try {
            List<Negocio> lista = this.logica.leer();
            this.modelo.setNumRows(0);
            for(Negocio n: lista){
                String fila[]={n.getCogtienda(),n.getNomtienda(),n.getCiudad(),n.getDpto(),n.getNomproducto(),String.valueOf(n.getSubtotal()),String.valueOf(n.getSubtotal()),String.valueOf(n.getToltal())};
                
                    this.modelo.addRow(fila);
            }
        } catch (IOException ex) {
          JOptionPane.showMessageDialog(null,"Error");
        }
        
    }
    
    
    class ActionButtonConsulta implements ActionListener{

        
        @Override
        public void actionPerformed(ActionEvent e) {
            
        actualizarTabla();    
        }
        
    
    }    
}


