package com.alda.controller;
import java.net.URL;
import java.util.ResourceBundle;

import com.alda.modelo.Employee;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {
	 @FXML private TextField txtUsuario;
	 @FXML private TextField txtClave;
	 @FXML private Button btnAcceso;
	 @FXML private Button btnCerrar; 
	 @FXML private Label lblMensaje; 
	 public Employee EmpleadoActual=null; 
	 public String tipo;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblMensaje.setText("");		
		
	}

	
	 public void Validar() throws Exception{ 
		try{ 
			if(this.txtUsuario.getText().trim().length()>0){ 
				if(this.txtClave.getText().trim().length()>0){ 
					lblMensaje.setText(""); 
					Employee oEmpleado = new Employee(); 
					oEmpleado.setUser(this.txtUsuario.getText());
					oEmpleado.setKey(this.txtClave.getText()); 
					EmpleadoActual=oEmpleado.Validar(); 
					if(EmpleadoActual==null){ 
						lblMensaje.setText("Credenciales no válidas."); 
						}else{ 
							Stage stage = (Stage)btnCerrar.getScene().getWindow(); 
							stage.hide(); 
							tipo=oEmpleado.tipo;
							System.out.println(tipo);
							
							} 
					oEmpleado=null; 
					}else{ 
						throw new Exception("Favor de ingresar la clave."); 
						} 
				}else{ 
					throw new Exception("Favor de ingresar el usuario.");
				} 
			}catch(Exception e){ 
				lblMensaje.setText(e.getMessage()); 
				} 
		} 
	 
	 
	 public void Cerrar() throws Throwable{ 
		 Stage stage = (Stage) btnCerrar.getScene().getWindow(); 
		 stage.close(); }
			
	
		
	 }

