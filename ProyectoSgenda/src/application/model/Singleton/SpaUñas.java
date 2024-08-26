package application.model.Singleton;

import java.time.LocalDate;
import java.util.ArrayList;

import application.model.Cita;
import application.model.Cliente;
import application.model.Servicio;
import application.model.TipoServicio;

public class SpaUñas {
	 
	// Listas para almacenar citas
    private ArrayList<Cita> citas;
    
    // Constructor privado para evitar instanciación desde fuera
    private SpaUñas() {
        citas = new ArrayList<>();
    }
    
    // Clase interna estática que contiene la instancia única de SpaUñas
    private static class SpaUñasUnico {
        private static final SpaUñas INSTANCE = new SpaUñas();
    }
    
    // Método para obtener la instancia única de SpaUñas
    public static SpaUñas getInstancia() {
        return SpaUñasUnico.INSTANCE;
    }

    // Métodos para manejar productos
    public void agregarCita(Cita cita) {
        citas.add(cita);
    }
    
    public void eliminarCita(Cita cita) {
        citas.remove(cita);
    }
    
    public Cita recuperarCita(String fecha, String hora) {
        return citas.stream()
                    .filter(cita -> cita.getFecha().equals(fecha)&& 
                    cita.getHora().equals(hora))
                    .findFirst()
                    .orElse(null);  // Retorna null si no se encuentra ninguna cita
    }

    public Cita recuperarCliente(String id) {
        return citas.stream()
                    .filter(cita -> cita.getCliente().getId().equals(id))
                    .findFirst()
                    .orElse(null);  // Retorna null si no se encuentra ningun cliente
    }


    public void modificarCita(LocalDate fecha, String hora, Servicio servicio, TipoServicio tipoServicio,
    Cliente cliente ){
        Cita cita=recuperarCliente(cliente.getId());
        cita.setFecha(fecha);
        cita.setHora(hora);
        cita.setServicio(servicio);
        cita.setTipoServicio(tipoServicio);        
    }
    

    public ArrayList<Cita> getCita() {
        return citas;
    }

}
