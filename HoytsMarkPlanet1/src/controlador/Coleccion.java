/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.Pelicula;

/**
 *
 * @author GOLDEN GAMERS
 */
public class Coleccion {//inicio clase
    //atributos
    ArrayList<Pelicula> listaPeliculas;
    
    //constructor

    public Coleccion() {
        this.listaPeliculas = new ArrayList<Pelicula> ();
    }
    
    //metodos
    public boolean agregar(Pelicula pelicula){
        return listaPeliculas.add(pelicula);
    }
    
    public String listarPeliculas (){
        String lista = "";
        for (Pelicula pelicula : listaPeliculas) {
            lista = lista + "\nId pelicula: " + pelicula.getIdPelicula()
                          + "\nTitulo pelicula: "+pelicula.getTitulo() 
                          + "\nDirector: " +pelicula.getDirector()
                          + "\nAnio: " + pelicula.getAnio() 
                          + "\nDuracion: " + pelicula.getDuracion() + " minutos" 
                          + "\nGenero: " + pelicula.getGenero()
                          + "\n-----------------------------------------------";
        }
        return lista;
    }
    
     public String mostrarDatos (int id){
        String lista = "";
        for (Pelicula pelicula : listaPeliculas) {
            if (pelicula.getIdPelicula() == (id)){
                lista = lista + "\nId pelicula: " + pelicula.getIdPelicula()
                          + "\nTitulo pelicula: "+pelicula.getTitulo() 
                          + "\nDirector: " +pelicula.getDirector()
                          + "\nAnio: " + pelicula.getAnio() 
                          + "\nDuracion: " + pelicula.getDuracion() + " minutos" 
                          + "\nGenero: " + pelicula.getGenero()
                          + "\n-----------------------------------------------";
            }
        }
        return lista;
    }
    //buscar para confirmar el id
    public boolean buscarIdPelicula (int Id){
        for (Pelicula pelicula : listaPeliculas) {
            if(pelicula.getIdPelicula()== (Id)){
                System.out.println("Pelicula encontrada" + pelicula.mostrarDatos());
                return true;
            }
        }
        System.out.println("NUEVO REGISTRO");
        return false;
    }
    
    //buscar para confirmar el id
    public boolean buscarModificar (int Id){
        for (Pelicula pelicula : listaPeliculas) {
            if(pelicula.getIdPelicula()== (Id)){
                System.out.println("Pelicula encontrada" + pelicula.mostrarDatos());
                return true;
            }
        }
        System.out.println("Pelicula no encontrada");
        return false;
    }

    public boolean eliminarPelicula (int id){
        for (Pelicula pelicula : listaPeliculas) {
            if(pelicula.getIdPelicula()== (id) ){
                listaPeliculas.remove(pelicula);
                System.out.println("pelicula ELIMINADA: " + id );
                return true;
        }
    }System.out.println("pelicula NO EXISTE");
    return false;
    
    }
    
    public boolean modificarTitulo (int id , String nuevoTitulo){
        for (Pelicula pelicula : listaPeliculas){
            if(pelicula.getIdPelicula() == (id)){
                System.out.println("El titulo de la pelicula : " +pelicula.getTitulo());
                pelicula.setTitulo(nuevoTitulo);
                System.out.println("Se ha modificado por : " +pelicula.getTitulo());
                System.out.println("");  
            }
        }
        return false;
    }
    
    public boolean modificarDirector (int id , String nuevoDirector){
        for (Pelicula pelicula : listaPeliculas){
            if(pelicula.getIdPelicula() == (id)){
                System.out.println("El Director de la pelicula : " +pelicula.getDirector());
                pelicula.setDirector(nuevoDirector);
                System.out.println("Se ha modificado por : " +pelicula.getDirector());
                System.out.println("");  
            }
        }
        return false;
    }

    public boolean modificarAnio (int id , String nuevoAnio){
        for (Pelicula pelicula : listaPeliculas){
            if(pelicula.getIdPelicula() == (id)){
                System.out.println("El Anio de la pelicula : " +pelicula.getAnio());
                pelicula.setAnio(Integer.parseInt(nuevoAnio));
                System.out.println("Se ha modificado por : " +pelicula.getAnio());
                System.out.println("");  
            }
        }
        return false;
    }
    
    public boolean modificarDuracion (int id , String nuevaDuracion){
        for (Pelicula pelicula : listaPeliculas){
            if(pelicula.getIdPelicula() == (id)){
                System.out.println("La duracion de la pelicula : " +pelicula.getDuracion());
                pelicula.setDuracion(Integer.parseInt(nuevaDuracion));
                System.out.println("Se ha modificado por : " +pelicula.getDuracion());
                System.out.println("");  
            }
        }
        return false;
    }
    
    public boolean modificarGenero (int id , String nuevoGenero){
        for (Pelicula pelicula : listaPeliculas){
            if(pelicula.getIdPelicula() == (id)){
                System.out.println("El genero de la pelicula : " +pelicula.getGenero());
                pelicula.setGenero(nuevoGenero);
                System.out.println("Se ha modificado por : " +pelicula.getGenero());
                System.out.println("");  
            }
        }
        return false;
    }
    
}//fin clase
