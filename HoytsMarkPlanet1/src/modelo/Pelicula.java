/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author GOLDEN GAMERS
 */
public class Pelicula {
    private int idPelicula;
    private String titulo;
    private String director;
    private int anio;
    private int duracion;
    private String genero;

    public Pelicula() {
    }

    public Pelicula(int idPelicula, String titulo, String director, int anio, int duracion, String genero) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.director = director;
        this.anio = anio;
        this.duracion = duracion;
        this.genero = genero;
    }
    
    public String mostrarDatos (){
        System.out.println("ID PELICULA: " + this.getIdPelicula());
        System.out.println("TITULO     : " + this.getTitulo());
        System.out.println("DIRECTOR   : " + this.getDirector());
        System.out.println("ANIO       : " + this.getAnio());
        System.out.println("DURACION   : " + this.getDuracion());
        System.out.println("GENERO     : " + this.getGenero());
        return null;
    }
    
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "idPelicula=" + idPelicula + ", titulo=" + titulo + ", director=" + director + ", anio=" + anio + ", duracion=" + duracion + ", genero=" + genero + '}';
    }
    
    
    
}
