package taller_ultimo_arranque.modelos;

public class Persona {
    private String idpersona;
    private String nombre;
    private String telefono;
    private String correo;
    
    public Persona() {
}
    
public Persona (String idpersona, String nombre, String telefono, String correo) {
    this.idpersona = idpersona;
    this.nombre = nombre;
    this.telefono = telefono;
    this.correo = correo;
}

public String getIdpersona() {
        return idpersona;
}

public void setIdpersona (String idpersona) {
        this.idpersona = idpersona;
}

public String getNombre() {
        return nombre;
}

public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}

