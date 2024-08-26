package application.model;


	
	public interface ClienteBuilder {

	    void nombre(String nombre);
	    void telefono(String telefono);
	    void id(String id);

	    Cliente build();
	}

