package application.model.Command;

import application.model.Cita;
import application.model.Singleton.SpaUñas;

public class EliminarCita implements Command {

    private Cita cita;
    SpaUñas spa = SpaUñas.getInstancia();

    /**
     * Constructor para crear una nueva instancia de EliminarCita.
     *
     * @param spa   
     * @param cita la  cita que se eliminará del spa.
     */
    public EliminarCita(Cita cita, SpaUñas spa) {
        this.cita = cita;
        this.spa= spa;
    }

    /**
     * Método que ejecuta el comando, eliminando la cita del spa.
     */
    @Override
    public void execute() {
        spa.eliminarCita(cita);;
    }
    
}
