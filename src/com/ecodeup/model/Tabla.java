package com.ecodeup.model;

public class Tabla {
	private int Id;
	private String Nombre;
	private String CUI;
	private String Carrera;
	public Tabla(int id, String nombre, String cUI, String carrera) {
		super();
		Id = id;
		Nombre = nombre;
		CUI = cUI;
		Carrera = carrera;
	}
	
	public Tabla() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getCUI() {
		return CUI;
	}

	public void setCUI(String cUI) {
		CUI = cUI;
	}

	public String getCarrera() {
		return Carrera;
	}

	public void setCarrera(String carrera) {
		Carrera = carrera;
	}

	@Override
	public String toString() {
		return "Tabla [Id=" + Id + ", Nombre=" + Nombre + ", CUI=" + CUI + ", Carrera=" + Carrera + "]";
	}
	
	
	
}
