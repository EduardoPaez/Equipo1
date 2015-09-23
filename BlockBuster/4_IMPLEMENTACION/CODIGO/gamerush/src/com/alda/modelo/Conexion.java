package com.alda.modelo;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Conexion {
	public Connection conexion=null;
	public Statement un_st=null;
	public DatabaseMetaData dbmd;
	public String un_sql;
	public ResultSet resultado=null;
	public Conexion() throws ClassNotFoundException, SQLException{
		ParametrosConexionion op = new ParametrosConexionion();
		op.asignarParametros();
		System.out.println("123"+op.getIp());
		Class.forName("org.postgresql.Driver");
		System.out.println("samuel");
		
//problema		
		System.out.println(op.getIp());
		System.out.println(op.getPuerto());
		System.out.println(op.getBaseDatos());
		System.out.println(op.getUsuario());
		System.out.println(op.getContraseña());
		conexion= DriverManager.getConnection("jdbc:postgresql://"+op.getIp()+":"+op.getPuerto()+"/"+op.getBaseDatos()+"",""+op.getUsuario()
				+"",""+op.getContraseña()+"");
		dbmd=conexion.getMetaData();
		System.out.println("Garcia");
		un_st=conexion.createStatement();
		System.out.println("Rodriguez");
		
	}
	public void desconectar(){
		try{
			conexion.close();
		}catch(Exception ex){
			ex.getMessage();
		}
	}
	

}
