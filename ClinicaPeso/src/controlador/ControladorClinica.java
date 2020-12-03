/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import datos.IRepositorioBD;
import javax.swing.JOptionPane;
import vista.VentanaClinica;
import modelo.Pesaje;
import datos.MysqlConnector;
import datos.PostgreSQLConnector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chelo
 */
public class ControladorClinica 
{    
    // Controlador maneja la lógica de toda la aplicacion
    
    private static VentanaClinica ventana;
    
    
    public static void iniciar(){
        ventana = new VentanaClinica();
        listarPesajes();
    }
    
    public static void  calcularIMC(){
        
        int dni = Integer.parseInt(ventana.getTxtDni().getText());
        
        String nombre = ventana.getTxtNombre().getText();
        
        double peso = Double.parseDouble(ventana.getTxtPeso().getText());
        
        double altura = Double.parseDouble(ventana.getTxtAltura().getText());
        
        Pesaje nuevo = new Pesaje(dni, nombre, peso, altura);
        
        String resultadoIMC = String.format("%.2f",nuevo.calcularIMC());
        
        ventana.getLabelIMC().setText(String.valueOf(resultadoIMC));
        
        ventana.getLabelCategoria().setText(nuevo.calcularClasificacion());
                
    }
    
    public static void agregarPesaje()
    {
         int dni = Integer.parseInt(ventana.getTxtDni().getText());
        
         String nombre = ventana.getTxtNombre().getText();
        
         double peso = Double.parseDouble(ventana.getTxtPeso().getText());
        
         double altura = Double.parseDouble(ventana.getTxtAltura().getText());
        
         Pesaje nuevo = new Pesaje(dni, nombre, peso, altura);         
       
         
         ControladorClinica.getRepo().registrarPesaje(nuevo);
         
         JOptionPane.showMessageDialog(ventana, "Pesaje Creado");
         
         ControladorClinica.listarPesajes();
    }
    
    
    private static IRepositorioBD getRepo()
    {
         return new MysqlConnector("root", "password"); // CAmbiar
         //return new PostgreSQLConnector();
    }
    
    public static void listarPesajes()
    {
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("Dni");
        modelo.addColumn("Nombre");
        modelo.addColumn("Peso");
        modelo.addColumn("Altura");
        modelo.addColumn("IMC");
        modelo.addColumn("Categoría");
        
        for(Pesaje p : ControladorClinica.getRepo().listarPesajes()){
            Object fila[] = {
                p.getDni(),
                p.getNombre(),
                p.getPeso(),
                p.getAltura(),
                String.format("%.2f",p.calcularIMC()),
                p.calcularClasificacion()
            };
            modelo.addRow(fila);
        }
        
        ventana.getTablaPesajes().setModel(modelo);
        
    }
    
    public static void mostrarMensaje(){
        JOptionPane.showMessageDialog(ventana,"Se ha mostrado este mensaje");
    }
    
  
    
    
    
}
