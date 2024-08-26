package application.model;

import java.time.LocalDate;

public class Cita {
    private LocalDate fecha;
    private  String hora;
    private  Cliente cliente;
    private  Servicio servicio;
    private  TipoServicio tipoServicio;

	
	private Cita(CitaBuilder builder) {
        this.fecha = builder.fecha;
        this.hora = builder.hora;
        this.cliente = builder.cliente;
        this.servicio = builder.servicio;
        this.tipoServicio = builder.tipoServicio;
    }
   
	public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Servicio getServicio() {
        return servicio;
    }
    public void setServicio(Servicio servicio) {
        this.servicio= servicio;
    }
    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }
    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
    
    public static class CitaBuilder {
        private LocalDate fecha;
        private String hora;
        private Cliente cliente;
        private Servicio servicio;
        private TipoServicio tipoServicio;


		public CitaBuilder setFecha(LocalDate fecha) {
            this.fecha = fecha;
            return this;
        }

        public CitaBuilder setHora(String hora) {
            this.hora = hora;
            return this;
        }

        public CitaBuilder setCliente(Cliente cliente) {
            this.cliente = cliente;
            return this;
        }

        public CitaBuilder setServicio(Servicio servicio) {
            this.servicio = servicio;
            return this;
        }

        public CitaBuilder setTipoServicio(TipoServicio tipoServicio) {
            this.tipoServicio = tipoServicio;
            return this;
        }

        public Cita build() {
            return new Cita(this);
        }
    }
    @Override
    public String toString() {
    	return "Nombre:" + cliente.getNombre()+ "\nCedula:" + cliente.getId() +
    			"\nCelular:" +cliente.getTelefono() +"\nServicio:" +servicio+"\nTipo de Servicio:"+ tipoServicio+ "\nFecha:" + fecha+ "\nHora:" + hora;
    			
    }

}
