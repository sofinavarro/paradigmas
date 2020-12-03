/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import modelo.Pesaje;

/**
 *
 * @author chelo
 */
public class MysqlConnector implements IRepositorioBD
{
    
    private String url="jdbc:mysql://localhost/paradigmasClinica?characterEncoding=utf8"; // CAMBIAR ESTO
    private String usuario;
    private String password;
    
    public MysqlConnector(String usuario, String password)
    {  
        
        this.usuario = usuario;
        this.password = password;
        
    }
    
    public boolean probarConexion(){
        
        try
        {
            Connection conexion = DriverManager.getConnection(url,usuario,password);
            return true;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return false;
        }
        
    }
    
    private Connection conectar() throws SQLException{
         Connection conexion = DriverManager.getConnection(url,usuario,password);
         return conexion;
    }

    @Override
    public void registrarPesaje(Pesaje nuevo) 
    {
       
       try
       {
           Connection conexion = conectar();
           PreparedStatement s = conexion.prepareStatement("INSERT INTO pesajes VALUES(?,?,?,?)");
           
           s.setInt(1, nuevo.getDni());
           s.setString(2, nuevo.getNombre());
           s.setDouble(3,nuevo.getPeso());
           s.setDouble(4, nuevo.getAltura());
           
           s.execute();
           
           conexion.close();
          
       }catch(Exception e){
           
       }
       
    }

    @Override
    public ArrayList<Pesaje> listarPesajes() {
        try
        {
            ArrayList<Pesaje> pesajes = new ArrayList<Pesaje>();
            
            Connection conexion = conectar();
            Statement s = conexion.createStatement();
            
            String sql = "SELECT * FROM paradigmasClinica.pesajes";
            
            ResultSet resultados = s.executeQuery(sql);
            
            while(resultados.next())
            {
                Pesaje pesaje = new Pesaje(
                        resultados.getInt("dni"), 
                        resultados.getString("nombre"),
                        resultados.getDouble("peso"), 
                        resultados.getDouble("altura")
                );
                pesajes.add(pesaje);
            }
            
            return pesajes;
            
        }
        catch(Exception e)
        {
            return null;
        }
    }

    @Override
    public void eliminarPesaje(int dni) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarPesaje(int dni, double medida) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
