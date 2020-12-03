/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author chelo
 */
public class Pesaje 
{
    
    /*Atributos*/
    private int dni;
    private String nombre;
    private double peso;
    private double altura;
    
    
    /*Constructor*/
    public Pesaje(int dni, String nombre, double peso, double altura){
        this.dni = dni;
        this.nombre = nombre;
        this.peso = peso;
        this.altura = altura;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    
    
    /*Metodo*/
    public double calcularIMC()
    {
        return (peso)/(altura*altura);
    }
    
    public String calcularClasificacion()
    {
        double imc = calcularIMC();
        
        if(imc < 18.5)
        {
            return "Peso Insuficiente";
        }
        else
        {
            if(imc >=18.5 && imc<=24.9)
            {
                return "Peso normal";
            }
            else
            {
                if(imc >=25 && imc <=26.9)
                {
                    return "Superior a normal";
                }
                else{
                    return "Obesidad";
                }
            }
        }
    }
    
    
}
