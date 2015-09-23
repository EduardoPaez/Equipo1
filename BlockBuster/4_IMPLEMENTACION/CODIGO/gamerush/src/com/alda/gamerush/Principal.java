package com.alda.gamerush;

import java.io.File;

import com.alda.controller.LoginController;
import com.alda.controller.PrincipalController;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Principal extends Application {
	ControllerWindow myWindows = new ControllerWindow();
	PrincipalController controladorPrincipal=null;
	AnchorPane container = null;

	static String screenLogin = "Login";
	public static String fileLogin = "login.fxml";
	
	public static String screenVentana = "tablero";
	public static String fileVentana = "empleados.fxml";
	
	

	Button btnLogin = null;	
	
	public static void main(String []args){
			launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		//Parent root = fxml.load();
	
		myWindows.loadScreen(Principal.screenVentana, Principal.fileVentana);

		
		myWindows.loadScreen(Principal.screenLogin, Principal.fileLogin);
		
		Stage primary= new Stage(StageStyle.UNDECORATED); 
		

		try{
	
			FXMLLoader miCargador= new FXMLLoader(getClass().getResource(Principal.fileLogin));
			AnchorPane frm= (AnchorPane)miCargador.load(); 
			LoginController controlador = miCargador.getController();
			primary.setScene(new Scene(frm)); 
			primary.setResizable(false);
			primary.initModality(Modality.APPLICATION_MODAL);
			primary.showAndWait(); 
			
			if (controlador.EmpleadoActual!=null){ 
				
				//myWindows.showScreen(Principal.screenVentana);	

				//btnLogin.setDisable(true);
				
				if(controlador.tipo.equals("Cajero"))
				{
					java.net.URL location = getClass().getResource("empleados.fxml");
					FXMLLoader fxml = new FXMLLoader(location);
					container = (AnchorPane) fxml.load();
					controladorPrincipal= fxml.getController();
					//initComponents();
					
					Group root = new Group();

					Scene scene= new Scene(root);
					//container.setCenter(myWindows);
					root.getChildren().add(container);
				
					primaryStage.setScene(scene);
					primaryStage.centerOnScreen();
					primaryStage.show();
				}else
				{
					java.net.URL location = getClass().getResource("administrador.fxml");
					FXMLLoader fxml = new FXMLLoader(location);
					container = (AnchorPane) fxml.load();
					controladorPrincipal= fxml.getController();
					//initComponents();
					
					Group root = new Group();

					Scene scene= new Scene(root);
					//container.setCenter(myWindows);
					root.getChildren().add(container);
				
					primaryStage.setScene(scene);
					primaryStage.centerOnScreen();
					primaryStage.show();
				}
				
				controladorPrincipal.asignarDatos(controlador.EmpleadoActual);

				} 
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}


		
	}
	
	/*private void initComponents(){
		container.setLeft(menu());	
	}
	
	private VBox menu(){
		VBox mnu = new VBox();
		mnu.setPadding(new Insets(4));
		mnu.setSpacing(10);
		
		String path= System.getProperty("user.dir");
		path+="/src/com/alda/facilito/icons/";
		

		
		btnLogin = new Button("Login");
		btnLogin.setPrefWidth(125);
		btnLogin.setPrefHeight(50);
		btnLogin.setTooltip(new Tooltip("Iniciar sesión"));
		btnLogin.setGraphicTextGap(1);
		btnLogin.setTooltip(new Tooltip("Ingresar"));
		btnLogin.setOnAction(new btnLogin_Click());

		

	
		mnu.getChildren().addAll(btnLogin);
		return mnu;
	}
	
	private class btnLogin_Click implements EventHandler<ActionEvent>{ 
		@Override
		public void handle(ActionEvent arg0) {

			
		}		
	}*/


}