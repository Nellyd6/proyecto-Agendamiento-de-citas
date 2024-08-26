package application.model;


	
	public class DirectorCita {
	    
	    public CitaBuilder builder;

	    public DirectorCita(CitaBuilder builder){
	        this.builder = builder;
	    }

	    public Cita construirCita(String fecha,String hora,Cliente cliente,Servicio servicio,
	        TipoServicio tipoServicio){

	        builder.fecha(fecha);
	        builder.hora(hora);
	        builder.cliente(cliente);
	        builder.servicio(servicio);
	        builder.tipoServicio(tipoServicio);

	        return builder.build();
	    }

	}



