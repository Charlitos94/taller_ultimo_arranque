package taller_ultimo_arranque.modelos;

public class Cliente extends Persona {
    private String nit;
    private String direccion;
    
    public Cliente() {
        super();
    }
    public Cliente(String idPersona, String nombre, String telefono, String correo, String nit, String direccion) {
        super(idPersona, nombre, telefono, correo);
        this.nit = nit;
        this.direccion = direccion;
    }
    
  public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }  
    
}
