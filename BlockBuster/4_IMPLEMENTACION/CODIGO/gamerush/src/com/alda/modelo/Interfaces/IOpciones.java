package com.alda.modelo.Interfaces;


public interface IOpciones {
	boolean Eliminar() throws java.lang.ClassNotFoundException,
		java.lang.InstantiationException,
		java.lang.IllegalAccessException,
		java.sql.SQLException, Exception;



boolean Buscar(int clave) throws java.lang.ClassNotFoundException,
java.lang.InstantiationException,
java.lang.IllegalAccessException,
java.sql.SQLException, Exception;

boolean Actualizar (Object E) throws java.lang.ClassNotFoundException,
java.lang.InstantiationException,
java.lang.IllegalAccessException,
java.sql.SQLException, Exception;

boolean Guardar() throws java.lang.ClassNotFoundException,
java.lang.InstantiationException,
java.lang.IllegalAccessException,
java.sql.SQLException, Exception;

}