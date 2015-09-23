package com.alda.modelo;

import javafx.fxml.FXML;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import com.alda.modelo.Interfaces.IOpciones;

public class Employee implements IOpciones {
	private final SimpleIntegerProperty idEmployee;
	private SimpleStringProperty name;
	private SimpleStringProperty lastName;
	private SimpleStringProperty secondLastName;
	private final SimpleStringProperty user;
	private final SimpleStringProperty key;
	private SimpleStringProperty type;
	private SimpleStringProperty curp;
	public String tipo;

	

	
	public Employee(int code,String name, String lastName,
			String secondLastName, String user,
			String key,String curp) {
		
		this.idEmployee= new SimpleIntegerProperty(code);
		this.name= new SimpleStringProperty("");
		this.lastName = new SimpleStringProperty("");
		this.secondLastName =  new SimpleStringProperty("");
		this.user =  new SimpleStringProperty("");
		this.key =  new SimpleStringProperty("");
		this.curp =  new SimpleStringProperty("");
	}
	
	public Employee(String name, String lastName,           //bcksjdbcjksdbcbsc
			String secondLastName,String curp, String user,
			String key, String type) {
		
		this.name= new SimpleStringProperty(name);
		this.lastName = new SimpleStringProperty(lastName);
		this.secondLastName =  new SimpleStringProperty(secondLastName);
		this.curp =  new SimpleStringProperty(curp);
		this.type =  new SimpleStringProperty(type);
		this.user =  new SimpleStringProperty(user);
		this.key =  new SimpleStringProperty(key);
		this.idEmployee= new SimpleIntegerProperty(-1);
	}
	
	
	
	
	////
	public Employee(int code,String name, String lastName,
			String secondLastName, String curp, String user, String key, String type) {
		
		this.idEmployee= new SimpleIntegerProperty(code);
		this.name= new SimpleStringProperty(name);
		this.lastName = new SimpleStringProperty(lastName);
		this.secondLastName =  new SimpleStringProperty(secondLastName);
		this.user =  new SimpleStringProperty(user);
		this.key =  new SimpleStringProperty(key);
		this.type =  new SimpleStringProperty(type);

		this.curp =  new SimpleStringProperty(curp);
	}
	
	
	public Employee(int code,String name, String lastName,
			String secondLastName) {
		
		this.idEmployee= new SimpleIntegerProperty(code);
		this.name= new SimpleStringProperty(name);
		this.lastName = new SimpleStringProperty(lastName);
		this.secondLastName =  new SimpleStringProperty(secondLastName);
		this.user =  new SimpleStringProperty("");
		this.key =  new SimpleStringProperty("");
		this.curp =  new SimpleStringProperty();
	}


	public Employee() {
		this.idEmployee = new SimpleIntegerProperty(-1);
		this.name = new SimpleStringProperty("");
		this.lastName = new SimpleStringProperty("");
		this.secondLastName = new SimpleStringProperty("");
		this.user =new SimpleStringProperty("");
		this.key =new SimpleStringProperty("");
		this.type =new SimpleStringProperty("");
		this.curp = new SimpleStringProperty("");
	}


	

	public Employee(int int1, String string, String string2) {
		this.idEmployee= new SimpleIntegerProperty(int1);
		this.user= new SimpleStringProperty(string);
		this.key = new SimpleStringProperty(string2);
	}

	public String getName() {
		return this.name.get().trim();
	}

	public void setName(String name) {
		this.name.set(name.trim());
	}

	public String getLastName() {
		return this.lastName.get().trim();
	}

	public void setLastName(String lastName) {
		this.lastName.set(lastName.trim());
	}

	public String getSecondLastName() {
		return this.secondLastName.get().trim();
	}

	public void setSecondLastName(String secondLastName) {
		this.secondLastName.set(secondLastName.trim());
	}

	public String getType() {
		return this.type.get().trim();
	}

	public void setType(String type) {
		this.type.set(type.trim());
	}

	public String getCurp() {
		return this.curp.get().trim();
	}

	public void setCurp(String curp) {
		this.curp.set(curp.trim());
	}

	public SimpleIntegerProperty getIdEmployee() {
		return idEmployee;
	}

	public String getUser() {
		return this.user.get().trim();
	}
	public void setUser(String user) {
		this.user.set(user.trim());
	}

	public String getKey() {
		return this.key.get().trim();
	}
	public void setKey(String key) {
		this.key.set(key.trim());
	}
	
	public String toString(){
		return (this.name.get().trim()+" "+this.lastName.get().trim()+" "+this.secondLastName.get()); 
		}

	@Override
	public boolean Eliminar() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException, SQLException,
			Exception {
		Conexion cdb= new Conexion();
		cdb.un_sql="update empleados2  set  activo = 'N' where idempleado="
				+this.idEmployee.get();
		cdb.un_st.execute(cdb.un_sql);	
		
		cdb.desconectar();

		
		return true;
		
		
	}

	@Override
	public boolean Buscar(int clave) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException, SQLException,
			Exception {
		// TODO Auto-generated method stub

		return false;
	}

	@Override
	public boolean Actualizar(Object E) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException, SQLException,
			Exception {
		Conexion cdb= new Conexion();
		cdb.un_sql="update empleados2  set  nombre = '"+this.getName()+"',"
				+ "apellidopaterno='"+this.getLastName()+"',"
						+ "apellidomaterno='"+this.getSecondLastName()+"',"
								+ " curp='"+this.getCurp()+"',"
										+ " usuario='"+this.getUser()+"',"
												+ "tipo='"+this.getType()+"'"
												+ "  where idempleado="
				+this.idEmployee.get();
		cdb.un_st.execute(cdb.un_sql);	
		
		cdb.desconectar();

		
		return true;
	}

	@Override
	public boolean Guardar() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException, SQLException,
			Exception {
		Random x= new Random();
		System.out.println("hola");
		String query="INSERT INTO empleados2 (idEmpleado, nombre, apellidopaterno, apellidomaterno, curp, usuario,  clave, tipo) Values";
		query+="(";
		query+=x.nextInt(100)+",'"+this.name.get().trim()+"',";
		query+="'"+this.lastName.get().trim()+"',";
		query+="'"+this.secondLastName.get().trim()+"',";
		query+="'"+this.curp.get().trim()+"',";
		query+="'"+this.user.get().trim()+"',";
		query+="encrypt('"+this.key.get().trim()+"','password','3des'),";
		query+="'"+this.type.get().trim()+"')";

		System.out.println(query);

Conexion cdb = new Conexion();
cdb.un_sql=query;		
System.out.print(cdb.un_sql);
cdb.un_st.execute(cdb.un_sql);
cdb.desconectar();

return true;
	}
	
	public List<Employee> Listar() throws ClassNotFoundException,SQLException{
		Conexion cdb= new Conexion();
		List<Employee> lst = new ArrayList<Employee>();
		cdb.un_sql="select idEmpleado, nombre, apellidopaterno, apellidomaterno, curp, usuario, clave, tipo from empleados2 where activo='s'  order by nombre";
		cdb.resultado=cdb.un_st.executeQuery(cdb.un_sql);
		while(cdb.resultado.next()){
			Employee obj = new Employee(
						cdb.resultado.getInt("idEmpleado"),
						cdb.resultado.getString("nombre"),
						cdb.resultado.getString("apellidopaterno"),
						cdb.resultado.getString("apellidomaterno"),
			            cdb.resultado.getString("curp"),
			            cdb.resultado.getString("usuario"),
			            cdb.resultado.getString("clave"),
			            cdb.resultado.getString("tipo"));
			lst.add(obj);
			obj=null;
			
		}
		cdb.desconectar();
		return lst;
	}


public Employee Validar() throws SQLException, Exception,ClassNotFoundException{
	Employee obj = null; 
	Conexion cdb = new Conexion(); 
	cdb.un_sql="select id, usuario, contrasena," 
	+ " tipo from data " 
			+ " where usuario='"+this.getUser()+"'" 
	+ " and contrasena='"+this.getKey()+"'";
	cdb.resultado=cdb.un_st.executeQuery(cdb.un_sql); 
	while(cdb.resultado.next()){ 
		obj = new Employee( 
				cdb.resultado.getInt("id"), 
				cdb.resultado.getString("usuario"), 
				cdb.resultado.getString("contrasena")); 
				String cadena=cdb.resultado.getString("tipo");
				System.out.println(cadena);
				tipo=cdb.resultado.getString("tipo");
		
		} 
	cdb.desconectar(); 
		return obj; 
		} 


public String devolver()
{
	return tipo;
}
} 



