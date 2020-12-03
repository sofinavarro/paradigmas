/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.ArrayList;
import modelo.Pesaje;

/**
 *
 * @author chelo
 */
//Estructura que me permite deifinir metodos 
public interface IRepositorioBD 
{
    public void registrarPesaje(Pesaje nuevo);
    public ArrayList<Pesaje> listarPesajes();
    public void eliminarPesaje(int dni);
    public void actualizarPesaje(int dni,double medida);
    
}
