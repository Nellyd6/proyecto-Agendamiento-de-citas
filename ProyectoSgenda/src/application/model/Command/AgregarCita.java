package application.model.Command;

import application.model.Cita;
import application.model.Singleton.SpaUñas;

public class AgregarCita implements Command {
    
    private Cita cita;
    SpaUñas spa = SpaUñas.getInstancia();

    /**
     * Constructor para crear una nueva instancia de AgregarCita.
     *
     * @param spa   
     * @param cita la  cita que se agregará del spa.
     */
    public AgregarCita(Cita cita, SpaUñas spa) {
        this.cita = cita;
        this.spa= spa;
    }

    /**
     * Método que ejecuta el comando, agregando la cita al spa.
     */
    @Override
    public void execute() {
        spa.agregarCita(cita);;
    }

}
