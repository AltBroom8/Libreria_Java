package Controller;

import Model.Libro;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.Date;

public class DBManager {
    static Connection conexion;
    String url = "jdbc:mysql://localhost:3306/practica6";
    String user = "carlos";
    String password = "1234";
    public static String actualUser="";
    public DBManager() {
        try {
            conexion = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean login(String username, String password) {
        String query = "SELECT * FROM user WHERE username = ? AND password = ?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                actualUser=username;
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void insertLibro( int ID, String titulo, String autor, int anioPublicacion, String genero, Double precio) {
        try {
            String query = "INSERT INTO libro (ID, titulo, autor, anioPublicacion, genero,precio,editorialID) VALUES (?, ?, ?, ?, ?, ?, ?)";
            Random random = new Random();
            int edId = random.nextInt(9) + 1;

            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setInt(1, ID);
                preparedStatement.setString(2, titulo);
                preparedStatement.setString(3, autor);
                preparedStatement.setInt(4, anioPublicacion);
                preparedStatement.setString(5, genero);
                preparedStatement.setDouble(6, precio);
                preparedStatement.setInt(7, edId);


                int filasAfectadas = preparedStatement.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Libro insertado correctamente en la base de datos.");
                } else {
                    System.out.println("No se pudo insertar el libro en la base de datos.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static Libro[] listaLibros(){

        try(Statement statement = conexion.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM LIBRO")) {
            List<Libro> libros = new ArrayList<>();

            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String titulo = resultSet.getString("titulo");
                String autor = resultSet.getString("autor");
                int anioPublicacion = resultSet.getInt("anioPublicacion");
                String genero = resultSet.getString("genero");
                Double precio = resultSet.getDouble("precio");
                int editorialID = resultSet.getInt("editorialID");

                Libro libro = new Libro(ID, titulo, autor, anioPublicacion, genero, precio, editorialID);
                libros.add(libro);
            }

            return libros.toArray(new Libro[libros.size()]);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Libro findLibroByID(int ID) {
        Libro l;
        String query = "SELECT * FROM LIBRO WHERE id=?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, ID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                     l= new Libro(resultSet.getInt("id"), resultSet.getString("titulo"),
                            resultSet.getString("autor"), resultSet.getInt("anioPublicacion"),
                            resultSet.getString("genero"),resultSet.getDouble("precio"),
                            resultSet.getInt("editorialID"));
                     return l;
                } else {
                    System.out.println("No se encontró ningún libro con el título proporcionado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void updateLibro(Libro libro){
        try {
            String query = "UPDATE  libro SET titulo = ?,autor = ?,anioPublicacion=?,genero =?,precio = ? where id = ?";

            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {

                preparedStatement.setString(1, libro.getTitulo());
                preparedStatement.setString(2, libro.getAutor());
                preparedStatement.setInt(3, libro.getAnioPublicacion());
                preparedStatement.setString(4, libro.getGenero());
                preparedStatement.setDouble(5, libro.getPrecio());
                preparedStatement.setInt(6, libro.getID());
                int filasAfectadas = preparedStatement.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Libro insertado correctamente en la base de datos.");
                } else {
                    System.out.println("No se pudo insertar el libro en la base de datos.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static int findLibroByString(String nombre) {
            String query = "SELECT * FROM LIBRO WHERE titulo=?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setString(1, nombre);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int id = resultSet.getInt("ID");
                        return id;
                    } else {
                        System.out.println("No se encontró ningún libro con el título proporcionado.");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return -1;
    }
    public static void borraLibro(int ID){
        try {
            String query = "DELETE FROM LIBRO WHERE ID=?";

            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setInt(1, ID);
                int filasAfectadas = preparedStatement.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Libro borrado correctamente en la base de datos.");
                } else {
                    System.out.println("No se pudo borrar el libro en la base de datos.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static int getUserById(String username){
        String query = "SELECT * FROM user WHERE USERNAME=?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("ID");
                    return id;
                } else {
                    System.out.println("No se encontró ningún libro con el título proporcionado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void altaTransaccion(int libroID, int usuarioID, String tipo_transaccion){
        try {
            String query = "INSERT INTO transaccion (fechaVenta, libroID, usuarioID, tipo_transaccion) VALUES (?, ?, ?, ?)";
            Random random = new Random();
            Date fecha = Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
            java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());

            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setDate(1, (java.sql.Date) sqlDate);
                preparedStatement.setInt(2, libroID);
                preparedStatement.setInt(3, usuarioID);
                preparedStatement.setString(4, tipo_transaccion);
                int filasAfectadas = preparedStatement.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Libro insertado correctamente en la base de datos.");
                } else {
                    System.out.println("No se pudo insertar el libro en la base de datos.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
