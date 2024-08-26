package application.model;



	public class Cliente {
		
	    private String nombre;
	    private String telefono;
	    private String id;
	    
	    
	    
	    private Cliente(ClienteBuilder builder) {
			
			this.nombre = builder.nombre;
			this.telefono = builder.telefono;
			this.id = builder.id;
		}
		public String getNombre() {
	        return nombre;
	    }
	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }
	    public String getTelefono() {
	        return telefono;
	    }
	    public void setTelefono(String telefono) {
	        this.telefono = telefono;
	    }
	    public String getId() {
	        return id;
	    }
	    public void setId(String id) {
	        this.id = id;
	    }
	    public static class ClienteBuilder {
	        private String nombre;
	        private String telefono;
	        private String id;

	        public ClienteBuilder setNombre(String nombre) {
	            this.nombre = nombre;
	            return this;
	        }

	        public ClienteBuilder setTelefono(String telefono) {
	            this.telefono = telefono;
	            return this;
	        }

	        public ClienteBuilder setId(String id) {
	            this.id = id;
	            return this;
	        }

	        public Cliente build() {
	            return new Cliente(this);
	        }
	    }
	    
	}
