/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import entidades.Negocio;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArchivoReporteBin implements IArchivo{
private File archivo;
private FileWriter aEscritura;
private Scanner aLectura;

    public ArchivoReporteBin() {
        this.archivo = new File("ReporteVentas.dat");
    }
    
    public ArchivoReporteBin(String name){
        this.archivo = new File(name);
    }

    /**
     * @return the archivo
     */
    public File getArchivo() {
        return archivo;
    }

    /**
     * @param archivo the archivo to set
     */
    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    /**
     * @return the aEscritura
     */
    public FileWriter getaEscritura() {
        return aEscritura;
    }

    /**
     * @param aEscritura the aEscritura to set
     */
    public void setaEscritura(FileWriter aEscritura) {
        this.aEscritura = aEscritura;
    }

    /**
     * @return the aLectura
     */
    public Scanner getaLectura() {
        return aLectura;
    }

    /**
     * @param aLectura the aLectura to set
     */
    public void setaLectura(Scanner aLectura) {
        this.aLectura = aLectura;
    }
    
    public Negocio leerCompetidor(String linea[]){
        Negocio n = new Negocio();
        n.setCogtienda(linea[0]);
        n.setNomtienda(linea[1]);
        n.setCiudad(linea[2]);
        n.setDpto(linea[3]);
        n.setNomproducto(linea[4]);
        n.setSubtotal(Integer.valueOf(linea[5]));
        n.setDescapli(Integer.valueOf(linea[6]));
        n.setToltal(Integer.valueOf(linea[7]));
        return n;
    }
    
    
    
    @Override
    public Negocio buscar(String cc) throws IOException{
        Negocio buscado = null;
        try {
            this.aLectura = new Scanner(this.archivo);
            while(this.aLectura.hasNext()){
                String linea[] = this.aLectura.nextLine().split(";");
                Negocio n = this.leerCompetidor(linea);
                if(n.getCogtienda().equals(buscado)){
                    buscado = n;
                    break;
                }
            }
            return buscado;
            
        } catch (FileNotFoundException ex) {
                throw new IOException("EL archivo no se encuentra o no pueder ser leido");
        }
        finally{
            if(this.aLectura!=null)
                this.aLectura.close();
        }
    }
    
    @Override
    public List<Negocio> leer() throws IOException{
       List<Negocio> lista = null;
        try {
            
            this.aLectura = new Scanner(this.archivo);
            lista = new ArrayList();
            while(this.aLectura.hasNext()){
                String linea[] = this.aLectura.nextLine().split(";");
                Negocio n = this.leerCompetidor(linea);
                lista.add(n);
            }
            
            return lista;
            
        } catch (FileNotFoundException ex) {
                throw new IOException("EL archivo no se encuentra o no pueder ser leido");
        }
        finally{
            if(this.aLectura!=null)
                this.aLectura.close();
        }
        
    }
    
    @Override
    public boolean escribir(Negocio n) throws IOException{
        PrintWriter escritor = null;
        try{
            this.aEscritura = new FileWriter(this.archivo,true); // edicio
            escritor = new PrintWriter(this.aEscritura);
            escritor.println(n.getDatosReporteText());
            return true;
        }catch(IOException ioe){
            throw new IOException("Error al abrir el archivo para escritura...");
           
        }
        finally{
            if(escritor!=null)
                escritor.close();
            
            if(this.aEscritura!=null){
                 this.aEscritura.close();
            }    
        }
    }
    
    
}
    

