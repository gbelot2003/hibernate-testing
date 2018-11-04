package com.gbelot.test;

import java.util.Collection;

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

		Autor autor1 = new Autor(1L, "Salvador Dali", "España");
		Autor autor2 = new Autor(2L, "Dante Aligery", "Italia");
		Autor autor3 = new Autor(3L, "Robert Kyyosaky", "USA");
		
		Libro libro1 = new Libro(1L, "De los Males del Arte");
		Libro libro2 = new Libro(2L, "La Divina Comedia");
		Libro libro3 = new Libro(3L, "Padre Rico, Padre pobre");
		Libro libro4 = new Libro(4L, "Catch Flow"); 
				
		autor1.getLibros().add(libro1);
		autor2.getLibros().add(libro2);
		autor3.getLibros().add(libro3);
		autor3.getLibros().add(libro4);
		
		libro1.setAutor(autor1);
		libro2.setAutor(autor2);
		libro3.setAutor(autor3);
		libro4.setAutor(autor3);
		
		em.getTransaction().begin();
		
		em.persist(autor1);
		em.persist(autor2);
		em.persist(autor3);
		
		em.persist(libro1);
		em.persist(libro2);
		em.persist(libro3);
		em.persist(libro4);
		
		em.getTransaction().commit();
		
		em.close();
	}
	
	static void imprimirDatos() {
		EntityManager em = emf.createEntityManager();
		
		Autor autor = em.find(Autor.class, 3L);
		Collection<Libro> libros = autor.getLibros();
		int sizeLibros = libros.size();
		em.close();
		
		System.out.println("No. de Libros de autor son " + sizeLibros);
		System.out.println(autor);
		
		for (Libro libro: libros) {
			System.out.println(libro.toString());
		}
				
		
		
	}

}
