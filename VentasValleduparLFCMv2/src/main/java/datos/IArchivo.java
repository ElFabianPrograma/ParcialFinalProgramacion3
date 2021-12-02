/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import entidades.Negocio;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author jcontreras
 */
public interface IArchivo {
    
    public Negocio buscar(String Cogtienda) throws IOException;
    public List<Negocio> leer() throws IOException;
    public boolean escribir(Negocio n) throws IOException;    
    
}
   