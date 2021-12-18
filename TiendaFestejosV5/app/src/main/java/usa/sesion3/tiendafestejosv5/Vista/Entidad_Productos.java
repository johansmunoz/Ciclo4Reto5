package usa.sesion3.tiendafestejosv5.Vista;

public class Entidad_Productos {

    int imagen_productos1;
    String titulo;
    String descripcion;
    String url;

    public Entidad_Productos( String titulo, String descripcion, String url)//int imagen_productos1, ,
    {
        //this.imagen_productos1 = imagen_productos1;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url = url;
    }

    public String getUrl() { return url; }

    public Integer getImagen_productos1() {
        return imagen_productos1;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
