/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bd;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import modelo.Pelicula;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
/**
 *
 * @author GOLDEN GAMERS
 */
public class ConexionBd {//inicio clase
    private Connection conn = null;

    public ConexionBd (){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviesdb","root","");
            System.out.println("Base de Datos Conectada");
        }catch (Exception ex){
            System.out.println("ERROR en conexion con base de datos, Verifique que XAMPP este ejecutandose"+ ex); 
        }
    }
    
    ////-----------------------------------------------------------------metodos
    
    //agregar
    public void agregar(Pelicula pelicula, JTextArea textoAgregar) {
        try {
            if (pelicula.getIdPelicula() == 0 
                    || pelicula.getTitulo().isEmpty()
                    || pelicula.getDirector().isEmpty()
                    || pelicula.getAnio() == 0
                    || pelicula.getDuracion() == 0 
                    || pelicula.getGenero().isEmpty()) {
                JOptionPane.showMessageDialog(null, "HAY CAMPOS SIN DATOS O VALORES INCORRECTOS, DEBES LLENARLOS", "Error", JOptionPane.ERROR_MESSAGE); 
            } else {
                String sql = "INSERT INTO `movie`(`id_pelicula`, `titulo`, `director`, `anio`, `duracion`, `genero`) VALUES (?,?,?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setInt(1, 0);
                ps.setString(2, pelicula.getTitulo());
                ps.setString(3, pelicula.getDirector());
                ps.setInt(4, pelicula.getAnio());
                ps.setInt(5, pelicula.getDuracion());
                ps.setString(6, pelicula.getGenero());

                ps.executeUpdate();

                System.out.println("Pelicula agregada");
                textoAgregar.setText("PELICULA AGREGADA");
            }
        } catch (Exception e) {
            System.out.println("Error al agregar pelicula" + e);
            textoAgregar.setText("Error al agregar pelicula");
        }
    }

     //buscar
    public Pelicula buscar(int idPelicula) {
        Pelicula peliculaEncontrada = null;
        try {
        String sql = "SELECT * FROM `movie` WHERE `id_pelicula` = ?";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setInt(1, idPelicula);
        
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            peliculaEncontrada = new Pelicula(
                rs.getInt("id_pelicula"),
                rs.getString("titulo"),
                rs.getString("director"),
                rs.getInt("anio"),
                rs.getInt("duracion"),
                rs.getString("genero")
            );
        }
        }catch (Exception e) {
        System.out.println("Error al buscar pelicula: " + e); 
    }
    return peliculaEncontrada;
    }

    //listar
    public String listar (){
        String sql = "SELECT * FROM movie";
        System.out.println(sql);
        return "";
    }
    
    //eliminar
    public void eliminar(String idPelicula, JTextArea textoElimnar) {
        try {
            String sql = "DELETE FROM movie WHERE id_pelicula = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(idPelicula));

            int filasEliminadas = ps.executeUpdate();

            if (filasEliminadas > 0) {
                System.out.println("ELIMINADO CORRECTAMENTE");
                textoElimnar.setText("PELICULA DE ID: " + idPelicula + " ELIMINADO CORRECTAMENTE ");
            } else {
                System.out.println("NO SE ENCONTRO EL ID.");
                textoElimnar.setText("NO SE ENCONTRO EL ID DE LA PELICULA. " + idPelicula);
            }
            }catch (Exception e) {
            System.out.println("Error al intentar eliminar: " + e);
            textoElimnar.setText("Error al intentar eliminar: " );
            }
    }
    
    //modifcar
    public void modificarTitulo(int idPelicula, String nuevoTitulo) {
        try {
            String sqlBuscar = "SELECT * FROM movie WHERE `id_pelicula` = ?";
            PreparedStatement psBuscar = conn.prepareStatement(sqlBuscar);
            psBuscar.setInt(1, idPelicula);

            try (ResultSet resultSet = psBuscar.executeQuery()) {
                if (resultSet.next()) {

                    String sqlModificar = "UPDATE `movie` SET `titulo`=? WHERE id_pelicula=?";
                    PreparedStatement psModificar = conn.prepareStatement(sqlModificar);

                    psModificar.setString(1, nuevoTitulo);
                    psModificar.setInt(2, idPelicula);

                    int filasActualizadas = psModificar.executeUpdate();

                    if (filasActualizadas > 0) {
                        System.out.println("SE MODIFICO EL TITULO");
                    } else {
                        System.out.println("No se encontro el id para modificar el titulo.");
                    }
                } else {
                    System.out.println("No se encontro el id para modificar.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error al intentar buscar y modificar el titulo " + e);
        }
    }
    
    public void modificarDirector(int idPelicula, String nuevoDirector) {
        try {
            String sqlBuscar = "SELECT * FROM movie WHERE `id_pelicula` = ?";
            PreparedStatement psBuscar = conn.prepareStatement(sqlBuscar);
            psBuscar.setInt(1, idPelicula);

            try (ResultSet resultSet = psBuscar.executeQuery()) {
                if (resultSet.next()) {

                    String sqlModificar = "UPDATE `movie` SET `director`=? WHERE id_pelicula=?";
                    PreparedStatement psModificar = conn.prepareStatement(sqlModificar);

                    psModificar.setString(1, nuevoDirector);
                    psModificar.setInt(2, idPelicula);

                    int filasActualizadas = psModificar.executeUpdate();

                    if (filasActualizadas > 0) {
                        System.out.println("SE MODIFICO EL director");
                    } else {
                        System.out.println("No se encontro el id para modificar el director.");
                    }
                } else {
                    System.out.println("No se encontro id para modificar.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error al intentar buscar y modificar el director " + e);
        }
    }
    
    public void modificarAnio(int idPelicula, int nuevoAnio) {
        try {
            String sqlBuscar = "SELECT * FROM movie WHERE `id_pelicula` = ?";
            PreparedStatement psBuscar = conn.prepareStatement(sqlBuscar);
            psBuscar.setInt(1, idPelicula);

            try (ResultSet resultSet = psBuscar.executeQuery()) {
                if (resultSet.next()) {

                    String sqlModificar = "UPDATE `movie` SET `anio`=? WHERE id_pelicula=?";
                    PreparedStatement psModificar = conn.prepareStatement(sqlModificar);

                    psModificar.setInt(1, nuevoAnio);
                    psModificar.setInt(2, idPelicula);

                    int filasActualizadas = psModificar.executeUpdate();

                    if (filasActualizadas > 0) {
                        System.out.println("SE MODIFICO EL ANIO");
                    } else {
                        System.out.println("No se encontro id para modificar el ANIO.");
                    }
                } else {
                    System.out.println("No se encontro el id.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error al intentar buscar y modificar el ANIO " + e);
        }
    }

    public void modificarDuracion(int idPelicula, int nuevaDuracion) {
        try {
            String sqlBuscar = "SELECT * FROM movie WHERE `id_pelicula` = ?";
            PreparedStatement psBuscar = conn.prepareStatement(sqlBuscar);
            psBuscar.setInt(1, idPelicula);

            try (ResultSet resultSet = psBuscar.executeQuery()) {
                if (resultSet.next()) {

                    String sqlModificar = "UPDATE `movie` SET `duracion`=? WHERE id_pelicula=?";
                    PreparedStatement psModificar = conn.prepareStatement(sqlModificar);

                    psModificar.setInt(1, nuevaDuracion);
                    psModificar.setInt(2, idPelicula);

                    int filasActualizadas = psModificar.executeUpdate();

                    if (filasActualizadas > 0) {
                        System.out.println("SE MODIFICO EL DURACION");
                    } else {
                        System.out.println("No se encontro id para modificar LA DURACION.");
                    }
                } else {
                    System.out.println("No se encontro el id.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error al intentar buscar y modificar el DURACION " + e);
        }
    }
    
    public void modificarGenero(int idPelicula, String nuevoGenero) {
        try {
            String sqlBuscar = "SELECT * FROM movie WHERE `id_pelicula` = ?";
            PreparedStatement psBuscar = conn.prepareStatement(sqlBuscar);
            psBuscar.setInt(1, idPelicula);
            try (ResultSet resultSet = psBuscar.executeQuery()) {
                if (resultSet.next()) {
                    String sqlModificar = "UPDATE `movie` SET `genero`=? WHERE id_pelicula=?";
                    PreparedStatement psModificar = conn.prepareStatement(sqlModificar);

                    psModificar.setString(1, nuevoGenero);
                    psModificar.setInt(2, idPelicula);

                    int filasActualizadas = psModificar.executeUpdate();

                    if (filasActualizadas > 0) {
                        System.out.println("SE MODIFICO El genero");
                    } else {
                        System.out.println("No se encontro el id para modificar el genero.");
                    }
                } else {
                    System.out.println("No se encontro el id.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error al intentar buscar y modificar el genero " + e);
        }
    }
    
    public String filtrarPorAnio(String anioStr) {  
        try {
            int anio = Integer.parseInt(anioStr);
            String sql = "SELECT * FROM movie WHERE anio = ?";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, anio);
                try (ResultSet rs = ps.executeQuery()) {

                    StringBuilder mensaje = new StringBuilder("Resultados de la busqueda por anio:\n");

                    boolean encontradas = false;

                    while (rs.next()) {
                        encontradas = true;
                        mensaje.append("ID: ").append(rs.getInt("id_pelicula")).append(", ");
                        mensaje.append("Título: ").append(rs.getString("titulo")).append(", ");
                        mensaje.append("Director: ").append(rs.getString("director")).append(", ");
                        mensaje.append("Año: ").append(rs.getInt("anio")).append(", ");
                        mensaje.append("Duración: ").append(rs.getInt("duracion")).append(" minutos, ");
                        mensaje.append("Género: ").append(rs.getString("genero")).append("\n");
                    }

                    if (!encontradas) {
                        mensaje.append("No se encontraron peliculas para el anio ").append(anio).append(".\n");
                    }

                    return mensaje.toString();
                }
            }
        } catch (NumberFormatException e) {
            return "Debes ingresar un valor numerico para filtrar por anio.";
        } catch (SQLException e) {
            System.out.println("Error al filtrar peliculas por anio: " + e);
            return "Error al obtener datos por anio.";
        }
    }


    
    public String filtrarPorGenero(String genero) {
        try {
            String sql = "SELECT * FROM movie WHERE `genero` = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, genero);
            ResultSet rs = ps.executeQuery();

            StringBuilder mensaje = new StringBuilder("Resultados de la busqueda por genero:\n");

            boolean encontradas = false; 

            while (rs.next()) {
                encontradas = true;
                mensaje.append("ID: ").append(rs.getInt("id_pelicula")).append(", ");
                mensaje.append("Título: ").append(rs.getString("titulo")).append(", ");
                mensaje.append("Director: ").append(rs.getString("director")).append(", ");
                mensaje.append("Año: ").append(rs.getInt("anio")).append(", ");
                mensaje.append("Duración: ").append(rs.getInt("duracion")).append(" minutos, ");
                mensaje.append("Género: ").append(rs.getString("genero")).append("\n");
            }

            if (!encontradas) {
                mensaje.append("No se encontraron peliculas para el genero ").append(genero).append(".\n");
            }

            return mensaje.toString();
        } catch (SQLException e) {
            System.out.println("Error al listar peliculas por genero: " + e);
            return "Error al obtener datos por genero.";
        }
    }


    public Connection getConectarDB(){
       return conn;
    }
     
    
}//fin clase
