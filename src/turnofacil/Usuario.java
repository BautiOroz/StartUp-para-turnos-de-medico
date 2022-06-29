package turnofacil;

public abstract class Usuario {
    private String usuario;
    private String clave;
    private String nombre;
    private String apellido;
    private final int DNI;

    public abstract void ejecuto();

    public Usuario(String usuario, String nombre, String apellido, int DNI, String clave) {
        this.usuario = usuario;
        this.clave = clave;
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
    }

    public String getUsuario() {
        return usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public boolean esClave(String clave){
        return this.clave.equals(clave); 
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDNI() {
        return DNI;
    }

    protected void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        try {
            Secretaria otro = (Secretaria)obj;
            return getUsuario() == otro.getUsuario();
        } catch (Exception e) {
            return false;
        }
    }
}
