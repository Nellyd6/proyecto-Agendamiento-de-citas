package application.model.Command;

public interface Command {

    /**
     * Método que ejecuta el comando.
     * Cada clase que implemente esta interfaz deberá proporcionar su propia
     * implementación del método execute para realizar una acción específica.
     */
    public void execute();
}