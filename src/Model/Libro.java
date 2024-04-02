package Model;

public class Libro {
    int ID;
    String titulo;
    String autor;
    int anioPublicacion;
    String genero;
    Double precio;
    int editorialID;

    public int getID() {
        return ID;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public String getGenero() {
        return genero;
    }

    public Double getPrecio() {
        return precio;
    }

    public int getEditorialID() {
        return editorialID;
    }



    public Libro(int ID, String titulo, String autor, int anioPublicacion, String genero, Double precio, int editorialID) {
        this.ID = ID;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.genero = genero;
        this.precio = precio;
        this.editorialID = editorialID;
    }
}
