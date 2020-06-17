package com.ecodeup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecodeup.conexion.Conexion;
import com.ecodeup.model.Tabla;

public class DAO {
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;
	
	//guardar
	public boolean guardar(Tabla tabla) throws SQLException {
		String sql = null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql = "INSERT INTO tabla (Id,Nombre, CUI, Carrera) VALUES (?,?,?,?)";
			statement = connection.prepareStatement(sql);
			
			statement.setString(1,null);
			statement.setString(2, tabla.getNombre());
			statement.setString(3, tabla.getCUI());
			statement.setString(4, tabla.getCarrera());
			
			estadoOperacion = statement.executeUpdate()>0;
			
			connection.commit();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		
		return estadoOperacion;
	}
	
	//editar tabla
	public boolean editar(Tabla tabla) throws SQLException {
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql="UPDATE tabla SET nombre=?, cui=? , carrera=? WHERE Id=? ";
			statement=connection.prepareStatement(sql);
			statement.setString(1, tabla.getNombre());
			statement.setString(2, tabla.getCUI());
			statement.setString(3, tabla.getCarrera());
			statement.setInt(4, tabla.getId());

			estadoOperacion = statement.executeUpdate()>0;
			connection.commit();
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		
		return estadoOperacion;
	}
	
	//eliminar
	public boolean eliminar(int idTabla) throws SQLException {
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		try {
			connection.setAutoCommit(false);
			sql="DELETE FROM tabla WHERE Id=?";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, idTabla);
			

			estadoOperacion = statement.executeUpdate()>0;
			connection.commit();
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		
		return estadoOperacion;
		
	}
	
	//obtener
	public List<Tabla> obtenerTablas() throws SQLException {
		ResultSet resultSet =null;
		List<Tabla> listaTabla = new ArrayList<>();
		
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		
		try {
			sql = "SELECT * FROM tabla";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				Tabla t = new Tabla();
				t.setId(resultSet.getInt(1));
				t.setNombre(resultSet.getString(2));
				t.setCUI(resultSet.getString(3));
				t.setCarrera(resultSet.getString(4));
				listaTabla.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaTabla;
	}
	
	//obtener Tabla
	public Tabla obtenerTabla(int idTabla) throws SQLException {
		ResultSet resultSet =null;
		Tabla t = new Tabla();
		
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		
		try {
			sql = "SELECT * FROM tabla WHERE Id=?";
			statement=connection.prepareStatement(sql);
			statement.setInt(1,idTabla);
			resultSet = statement.executeQuery(sql);
			
			if(resultSet.next()) {
				t.setId(resultSet.getInt(1));
				t.setNombre(resultSet.getString(2));
				t.setCUI(resultSet.getString(3));
				t.setCarrera(resultSet.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return t;
	}
	
	//obtener conexion
	private Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();
	}
}
