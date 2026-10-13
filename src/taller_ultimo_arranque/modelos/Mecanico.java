package taller_ultimo_arranque.modelos;

public class Mecanico extends Persona {
    private String especialidad;

   
    public Mecanico() {
        super();
    }
   
    public Mecanico(String idPersona, String nombre, String telefono, String correo, String especialidad) {
        super(idPersona, nombre, telefono, correo);
        this.especialidad = especialidad;
    }

        public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}