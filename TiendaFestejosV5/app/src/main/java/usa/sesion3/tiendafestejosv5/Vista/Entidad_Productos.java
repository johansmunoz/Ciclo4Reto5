package usa.sesion3.tiendafestejosv5.Vista;

public class Entidad_Productos {

    int imagen_productos1;
    String titulo;
    String descripcion;
    //String url;

    public Entidad_Productos( int imagen_productos1, String titulo, String descripcion)//int imagen_productos1, , String url
    {
        this.imagen_productos1 = imagen_productos1;
        this.titulo = titulo;
        this.descripcion = descripcion;
        //this.url = url;
    }

    //Strpublic String getUrl() { return url; }

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
