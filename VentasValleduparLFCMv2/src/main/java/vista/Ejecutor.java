/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import entidades.Negocio;
import java.io.IOException;
import modelo.RegistroReporte;

/**
 *
 * @author jcontreras
 */
public class Ejecutor {
    public static void main(String[] args) {
       RegistroReporte registro1 = new RegistroReporte();
       
       Negocio rep1 = new Negocio("Urt32","Eltiendas","Valledupar","Cesar","Pcgamer",3000,20,2980);       
       Negocio rep2 = new Negocio("Mort34","Elceular","Medellin","Antioquia","Xiamo mi 9",2000,10,1990); 
            
     try{         
         registro1.escribir(rep1);
         registro1.escribir(rep2);
     }catch(IOException ioe){
            System.out.println(ioe);  
             
          
     }
     Consulta Ventana = new Consulta(null,true);
         
    }    
    
}
