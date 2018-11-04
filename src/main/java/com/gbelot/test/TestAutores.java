package com.gbelot.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.gbelot.models.Autor;
import com.gbelot.models.Libro;

public class TestAutores {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("aplicacion");
	
	public static void main(String[] args) {
		crearDatos();
		imprimirDatos();
	}
	
	static void crearDatos() {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Autor autor1 = new Autor(1L, "Salvador Dali", "España");
		Autor autor2 = new Autor(2L, "Dante Aligery", "Italia");
		Autor autor3 = new Autor(3L, "Robert Kyyosaky", "USA");
		
		em.persist(autor1);
		em.persist(autor2);
		em.persist(autor3);		
		
		em.persist(new Libro(1L, "De los Males del Arte", autor1));
		em.persist(new Libro(2L, "La Divina Comedia", autor2));
		em.persist(new Libro(3L, "Padre Rico, Padre pobre", autor3));
		em.persist(new Libro(4L, "Catch Flow", autor3));
		
		em.getTransaction().commit();
		
		em.close();
	}
	
	static void imprimirDatos() {
		EntityManager em = emf.createEntityManager();
		
		Autor autor = em.find(Autor.class, 3L);
		
		List<Libro> libros = autor.getLibros();
		for (Libro libro: libros) {
			System.out.println(libro.toString());
		}
				
		System.out.println(autor);
		
		em.close();
	}

}
