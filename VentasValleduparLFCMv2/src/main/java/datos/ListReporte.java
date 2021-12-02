/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import entidades.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jcontreras
 */
public class ListReporte implements IArchivo, Serializable{
    private List<Negocio> lista;

    public ListReporte() {
        this.lista = new ArrayList();
    }
    
    
    @Override
    public Negocio buscar(String Cogtienda) throws IOException {
        
        for(Negocio n : this.lista){
            if(n.getCogtienda().equals(Cogtienda)){
                return n;
            }
        }
        return null;
    }

    @Override
    public List<Negocio> leer() throws IOException {
        return this.lista;
    }

    @Override
    public boolean escribir(Negocio n) throws IOException {
        
        return this.lista.add(n);
    }
    
}