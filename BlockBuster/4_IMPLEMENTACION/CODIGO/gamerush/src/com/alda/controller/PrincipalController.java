package com.alda.controller;

import java.net.URL;
import java.util.ResourceBundle;
import com.alda.modelo.Employee;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class PrincipalController implements Initializable{ 
	@FXML private Label lblUsuario;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblUsuario.setText("");		
	} 
	public void asignarDatos(Employee objeto){ 
		lblUsuario.setText(objeto.toString().trim());
		}
	
	 public void limpiarDatos(){ 
		 lblUsuario.setText(""); 
		 }
}
