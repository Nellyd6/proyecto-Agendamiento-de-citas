package application.model.Command;

import java.time.LocalDate;

import application.model.Cliente;
import application.model.Servicio;
import application.model.TipoServicio;
import application.model.Singleton.SpaUñas;

public class ActualizarCita implements Command {
	   LocalDate fecha;
	    String hora;
	    Servicio servicio;
	    TipoServicio tipoServicio;
	    Cliente cliente;
	    SpaUñas spa = SpaUñas.getInstancia();

	    
	    /**
	     * Constructor para crear una nueva instancia de ActualizarCita.
	     *
	     * @param spa   
	     * @param cita la  cita que se actualizará del spa.
	     */
	    public ActualizarCita(LocalDate fecha, String hora, Servicio servicio, TipoServicio tipoServicio, Cliente cliente,
	            SpaUñas spa) {
	        this.fecha = fecha;
	        this.hora = hora;
	        this.servicio = servicio;
	        this.tipoServicio = tipoServicio;
	        this.cliente = cliente;
	        this.spa = spa;
	    }


	    /**
	     * Método que ejecuta el comando, actualizar la cita al spa.
	     */
	    @Override
	    public void execute() {
	        spa.modificarCita(fecha,hora,servicio,tipoServicio,cliente);
	    }

}
