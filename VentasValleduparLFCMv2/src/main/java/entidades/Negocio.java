/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;

/**
 *
 * @author jcontreras
 */
public class Negocio implements Serializable {
     private String Cogtienda;
    private String Nomtienda;
    private String Ciudad;
    private String dpto;
    private String Nomproducto;
    private int subtotal;
    private int descapli;
    private int toltal;

    public Negocio(String Cogtienda, String Nomtienda, String Ciudad, String dpto, String Nomproducto, int subtotal, int descapli, int toltal) {
        this.Cogtienda = Cogtienda;
        this.Nomtienda = Nomtienda;
        this.Ciudad = Ciudad;
        this.dpto = dpto;
        this.Nomproducto = Nomproducto;
        this.subtotal = subtotal;
        this.descapli = descapli;
        this.toltal = toltal;
    }
    
        
public Negocio(){

}    

    public String getCogtienda() {
        return Cogtienda;
    }

    public void setCogtienda(String Cogtienda) {
        this.Cogtienda = Cogtienda;
    }

    public String getNomtienda() {
        return Nomtienda;
    }

    public void setNomtienda(String Nomtienda) {
        this.Nomtienda = Nomtienda;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getDpto() {
        return dpto;
    }

    public void setDpto(String dpto) {
        this.dpto = dpto;
    }

    public String getNomproducto() {
        return Nomproducto;
    }

    public void setNomproducto(String Nomproducto) {
        this.Nomproducto = Nomproducto;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public int getDescapli() {
        return descapli;
    }

    public void setDescapli(int descapli) {
        this.descapli = descapli;
    }

    public int getToltal() {
        return toltal;
    }

    public void setToltal(int toltal) {
        this.toltal = toltal;
    }

public String getDatosReporteText(){ //Urt32;elttiendas;valledupar;Cesar;Pcgamer;3000;20;2980
    
     return this.Cogtienda+";"+
             this.Nomtienda+";"+
             this.Ciudad+";"+
             this.dpto+";"+
             this.Nomproducto+";"+
             this.subtotal+";"+
             this.descapli+";"+
             this.toltal;
}
    
}
