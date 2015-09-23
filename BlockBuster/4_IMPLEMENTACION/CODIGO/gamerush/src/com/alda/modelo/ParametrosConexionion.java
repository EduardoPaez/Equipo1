package com.alda.modelo;

import java.io.FileInputStream;
import java.util.Properties;

public class ParametrosConexionion {
String ip;
String puerto;
String baseDatos;
String usuario;
String contraseña;
String PATH= System.getProperty("user.dir");
public String getIp() {
	return ip;
}
public String getPuerto() {
	return puerto;
}
public String getBaseDatos() {
	return baseDatos;
}
public String getUsuario() {
	return usuario;
}
public String getContraseña() {
	return contraseña;
}

public void asignarParametros(){
	try{
		Properties propiedades = new Properties();
		PATH=PATH+"\\src\\com\\alda\\modelo\\conexion.properties";
		FileInputStream entrada = new FileInputStream(PATH);
		propiedades.load(entrada);
		contraseña = propiedades.getProperty("CONTRASENA");
		usuario = propiedades.getProperty("USUARIO");
		baseDatos= propiedades.getProperty("BASEDATOS");
		ip= propiedades.getProperty("IP");
		puerto=propiedades.getProperty("PUERTO");
	}catch(Exception e){
		System.out.print(e.getMessage());
	}
}



}
