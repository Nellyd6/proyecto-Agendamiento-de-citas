package application.model;

	
	public interface CitaBuilder {
	    
	    void fecha(String fecha);
	    void hora(String hora);
	    void cliente(Cliente cliente);
	    void servicio(Servicio servicio);
	    void tipoServicio(TipoServicio tipoServicio);

	    Cita build();
	    
	}


