package com.gbelot.test;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.gbelot.models.Direccion;
import com.gbelot.models.Empledo;

public class TestEmpleados {

	@SuppressWarnings("unused")
	private static EntityManager manager;
		
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("aplicacion");
	
	public static void main(String[] args) {
		insertInicial();
		imprimirTodo();	
	}

	private static void insertInicial() {
		EntityManager man = emf.createEntityManager();
		Empledo e = new Empledo(10L, "Perez", "Gerardo", LocalDate.of(1979, 5, 10),
				new Direccion(15L, "Barrio Altos de la Hoya", "FM", "Tegucigalpa", "Honduras"));

		man.getTransaction().begin();
		man.persist(e);
		man.getTransaction().commit();
		man.close();
	}
	
	@SuppressWarnings("unchecked")
	private static void imprimirTodo(){
		EntityManager man = emf.createEntityManager();

		List<Empledo> emps = (List<Empledo>) man.createQuery("FROM Empledo").getResultList();	
		System.out.println("En esta base de datos hay " + emps.size() + " Empleados");
		for (Empledo emp: emps) {
			System.out.println(emp.toString());
		}
		man.close();
	}

}
