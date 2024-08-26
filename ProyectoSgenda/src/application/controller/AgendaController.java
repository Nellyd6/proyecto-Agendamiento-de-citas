package application.controller;


import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import application.model.Cita;
import application.model.Cliente;
import application.model.Servicio;
import application.model.TipoServicio;
import application.model.Command.Command;
import application.model.Command.EliminarCita;
import application.model.Command.Invoker;
import application.model.Singleton.SpaUñas;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class AgendaController {
	
	private ArrayList<Cita>citas = new ArrayList<>();
	 // Obteniendo la instancia única de SpaUñas
    private SpaUñas spa = SpaUñas.getInstancia();
    private Invoker invoker;
	
    // Constructor
    public AgendaController() {
        this.invoker = new Invoker();
    }
	
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

   

    @FXML
    private ComboBox<Servicio> boxServicio;

    @FXML
    private Button btnAgendar;

    @FXML
    private Button btnCancelarCita;

    @FXML
    private Button btnEditarCita;

    @FXML
    void execute(ActionEvent event) {
        //obtener el elemento de la interfaz de usuario
        Object source = event.getSource();
        if (source == btnAgendar) {
            crearCita(event);
        } else if (source == btnCancelarCita) {
           cancelarCita(event);
        }
        else if (source == btnEditarCita) {
            cancelarCita(event);
        }
    }
  

    @FXML
    private ComboBox<TipoServicio> comboTipoServicio;

    @FXML
    private ComboBox<String> combohora;

    @FXML
    private DatePicker fecha;

    @FXML
    private ImageView imagenView;

    @FXML
    private TextField txtCelular;
    
    @FXML
    private TextField txtId;


    @FXML
    private TextField txtNombre;

    @FXML
    private Label txtTipoServicio;
    
    

    @FXML
    void cancelarCita(ActionEvent event) {
    	
    	 String id= JOptionPane.showInputDialog(null,"Ingrese el ID de la cita que desea cancelar:", "Cancelar Cita", 
    			JOptionPane.QUESTION_MESSAGE);


      
        
        // Verificar que el ID es numérico
        if (!id.trim().matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un ID numérico válido.");
            return;
        }
            // Buscar la cita en la lista de citas usando el ID
            Cita citaAEliminar = null;
            for (Cita cita : citas) {
                if (cita.getCliente().getId().equals(id.trim())) {
                    citaAEliminar = cita;
                    break;
                }
            }

            // Si se encuentra la cita, eliminarla
            if (citaAEliminar != null) {
                citas.remove(citaAEliminar);
                JOptionPane.showMessageDialog(null, "¡La cita ha sido cancelada exitosamente!\n" + citaAEliminar);
            } else {
                // Si no se encuentra la cita, mostrar un mensaje de error
                JOptionPane.showMessageDialog(null, "No se encontró una cita con el ID proporcionado.");
            }
             

     	 
        
  
     	Cliente cliente = new Cliente.ClienteBuilder()
     			
                 .setId(id)
                
                 .build();

     	
     	Cita nuevaCita = new Cita.CitaBuilder()
     			
                 .setCliente(cliente)
                 
                 .build();
     	


             Command agregarCommand = new EliminarCita(nuevaCita, spa);
             invoker.recibirOperacion(agregarCommand);
             invoker.realizarOperaciones();


     	JOptionPane.showMessageDialog(null, "¡Eliminó su cita exitosamente! \n" + nuevaCita);
     	
     	// util para cuando se agende la cita, los campos queden en blanco nuevamente
     	txtNombre.clear();
     	txtId.clear();
     	txtCelular.clear();
     	boxServicio.setValue(null);
     	comboTipoServicio.setValue(null);
     	fecha.setValue(null);
     	combohora.setValue(null);
     	
     }
    

   
    @FXML
    void crearCita(ActionEvent event) {
    	String nombre = txtNombre.getText();
    	String id = txtId.getText();
    	String celular = txtCelular.getText();
    	Servicio servicio =boxServicio.getValue();
    	TipoServicio tipoServicio = comboTipoServicio.getValue();
    	LocalDate fechaCita = fecha.getValue();
    	String hora = (String) combohora.getValue();
    	
    	//Un if para que valide si un campo esta vacio, si lo esta manda un mensaje de error, sino; imprime un Joption con los datos agregados.
    	 if (nombre == null || id == null || celular == null || servicio == null || tipoServicio == null || fechaCita == null || hora == null) {
             
    		 JOptionPane.showMessageDialog(null,"Por favor, complete todos los campos.");
             return;
         }
    	 
    	 
    	 
    	Cliente cliente = new Cliente.ClienteBuilder()
    			.setNombre(nombre)
                .setId(id)
                .setTelefono(celular)
                .build();

    	
    	Cita nuevaCita = new Cita.CitaBuilder()
    			.setFecha(fechaCita)
                .setHora(hora)
                .setCliente(cliente)
                .setServicio(servicio)
                .setTipoServicio(tipoServicio)
                .build();
    	
    	citas.add(nuevaCita);

    	JOptionPane.showMessageDialog(null, "¡Agendo su cita exitosamente! \n" + nuevaCita);
    	
    	// util para cuando se agende la cita, los campos queden en blanco nuevamente
    	txtNombre.clear();
    	txtId.clear();
    	txtCelular.clear();
    	boxServicio.setValue(null);
    	comboTipoServicio.setValue(null);
    	fecha.setValue(null);
    	combohora.setValue(null);
    	
    	
    }
    
    	
  	
    
    @FXML
    void editarCita(ActionEvent event) {
    	
    	

    }

    @FXML
    void limpiarDatos(ActionEvent event) {

    }
    @FXML
    void listaServicios(ActionEvent event) {
    	
    	//LlenarCombo(boxServicio, servicios);
    	
    }
    public static void LlenarCombo(ComboBox<String>llenarCombo, ObservableList<String>infoCombo) {
		llenarCombo. setItems(infoCombo);
	}
   

	@FXML
    void initialize() {
		boxServicio.getItems().addAll(Servicio.MANICURE, Servicio.PEDICURE);
		comboTipoServicio.getItems().addAll(TipoServicio.ACRILICO,TipoServicio.SEMIPERMANENTE,TipoServicio. TRADICIONAL, TipoServicio.PRESSON);
		combohora.getItems().addAll("8:00 am","10:00 pm","2:00 pm","4:00 pm");
		
		//Para permitir que en los campos Id y celular solamente se pueda ingresar digitos
		
		txtId.textProperty().addListener(new ChangeListener<String>() {
			@Override
			  public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
              
                if (!newValue.matches("\\d*")) {
                   
                    txtId.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

       
        txtCelular.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
              
                if (!newValue.matches("\\d*")) {
                   
                    txtCelular.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
			
		});
        
        
        //Aqui, se configuró para que al presionar enter se pase al siguiente campo.
        configurarEnter(txtNombre, txtId );
        configurarEnter(txtId, txtCelular);
        configurarEnter(txtCelular, boxServicio);
        configurarEnter(boxServicio, comboTipoServicio);
        configurarEnter(comboTipoServicio, fecha);
        configurarEnter(fecha, combohora);
	}
        
        private void configurarEnter(TextField campoActual, TextField siguienteCampo) {
            campoActual.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    siguienteCampo.requestFocus(); 
                    event.consume(); 
                }
            });
        }

        
        private void configurarEnter(TextField campoActual, ComboBox<?> siguienteCampo) {
            campoActual.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    siguienteCampo.requestFocus();
                    event.consume(); 
                }
            });
    }

        private void configurarEnter(ComboBox<?>  campoActual, ComboBox<?> siguienteCampo) {
            campoActual.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    siguienteCampo.requestFocus();
                    event.consume(); 
                }
            });
    }
        private void configurarEnter(ComboBox<?>  campoActual,DatePicker siguienteCampo) {
            campoActual.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    siguienteCampo.requestFocus();
                    event.consume(); 
                }
            });
    }

        private void configurarEnter(DatePicker campoActual, ComboBox<?> siguienteCampo) {
            campoActual.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    siguienteCampo.requestFocus();
                    event.consume(); 
                }
            });
    }
		


}

