/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import datos.*;
import datos.IArchivo;
import entidades.*;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author jcontreras
 */
public class RegistroReporte {
    private IArchivo datos;

    public RegistroReporte() {
        this.datos = new ArchivoReporteBin();
        
    }

    /**
     * @return the datos
     */
    public IArchivo getDatos() {
        return datos;
    }

    /**
     * @param datos the datos to set
     */
    public void setDatos(IArchivo datos) {
        this.datos = datos;
    }
       
    
    public Negocio buscar(String Cogtienda) throws IOException{
        return this.datos.buscar(Cogtienda);
    }
    public List<Negocio> leer() throws IOException{
        return this.datos.leer();
    }
    
    public boolean escribir(Negocio n) throws IOException{
        
        if(n.getCogtienda()==null || n.getCogtienda().trim().length()==0)
            throw new NullPointerException("La cedula no puede ser vacia"); 
                       
        return this.datos.escribir(n);
    }
    
}
