package com.alda.gamerush;

import java.util.HashMap;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class ControllerWindow extends AnchorPane  {
	private HashMap<String,Node>Screens= new HashMap<>();
	
	public ControllerWindow (){
		super();
		
	}
	public void addWindow(String option, Node screenFXML){
		Screens.put(option,screenFXML);
		
	}
	public Node getWindow(String option){
		return Screens.get(option);
		
	}
	public boolean loadScreen(String option, String root){
		
	
	
	try{
		FXMLLoader myLoader = new FXMLLoader(getClass().getResource(root));
		Parent windowLoad = (Parent)myLoader.load();
		//IControllerWindow controllerWindow = myLoader.getController();
		addWindow(option, windowLoad);
			return true;
	
	}catch(Exception e){
		System.out.println("option=>"+option+"<===>");
		return false;
	}
	}
	public boolean download(String option){
		if(Screens.remove(option)==null){
			System.out.println("No existe ventana, loco");
			return false;
			
		}else{
				return true;
			}
	}
	public boolean showScreen(final String option)
	{
		System.out.println(Screens.get(option)+ "===");
		if(Screens.get(option)!=null)
		{
			final DoubleProperty opacity = opacityProperty();
			System.out.println("ingreso");
			if(!getChildren().isEmpty())
			{
			Timeline time=new Timeline(
					new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
					new KeyFrame(new Duration(1000), new EventHandler<ActionEvent>(){
						
						public void handle(ActionEvent event)
						{
							getChildren().remove(0);
							getChildren().add(0, Screens.get(option));
							Timeline input= new Timeline(
									new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
									new KeyFrame(new Duration(800), new KeyValue(opacity, 1.0)));
							input.play();
						}	
					}, new KeyValue(opacity, 0.0)));
					time.play();
			}else{
				setOpacity(0.0);
				getChildren().add(Screens.get(option));
				Timeline input=new Timeline(
						new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
						new KeyFrame(new Duration(2500), new KeyValue(opacity, 1.0)));
				input.play();
			}
			return true;
		}else{
			System.out.println("No se puede cargar el archivo");
			return false;
		}
	}
}
