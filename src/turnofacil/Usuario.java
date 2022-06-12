package turnofacil;

public abstract class Usuario {
    private final String usuario;
    private String clave;

    public abstract void ejecuto();

    public Usuario(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    public String getUsuario() {
        return usuario;
    }

    public boolean esClave(String clave){
        return (this.clave.equals(clave)); 
    }

    protected void setClave(String clave) {
        this.clave = clave;
    }
}
