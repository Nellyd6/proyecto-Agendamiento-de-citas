package application.model;

public class DirectorCliente {
	
	private ClienteBuilder builder;

    /**
     * Constructor de la clase DirectorCliente.
     * 
     * @param builder El builder que se utilizará para construir el objeto Cliente.
     */
    public DirectorCliente(ClienteBuilder builder) {
        this.builder = builder;
    }

    /**
     * Método para construir un objeto Cliente con los atributos especificados.
     * 
     * @param nombre    El nombre del cliente.
     * @param telefono  El teléfono del cliente.
     * @param id        El identificador del cliente.
     * @return          El objeto Cliente construido con los atributos especificados.
     */
    public Cliente construirCliente(String nombre, String telefono, String id) {
        builder.nombre(nombre);
        builder.telefono(telefono);
        builder.id(id);
        return builder.build();
    }

}
