package efren.util.entidades;

public class SecPerfil extends EntityObjectSeguridades {
    private String nombre;

    private String descripcion;

    /**
     * SecSystem constructor comment.
     */
    public SecPerfil() {
        super();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String newValue) {
        this.nombre = newValue;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String newValue) {
        this.descripcion = newValue;
    }

}
