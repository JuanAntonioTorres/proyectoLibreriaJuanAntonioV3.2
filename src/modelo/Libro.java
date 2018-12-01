package modelo;

import java.io.Serializable;

public class Libro implements Serializable{
	private static final long serialVersionUID = 1L;
	private String titulo;
	private String autor;
	private String tema;
	private int numPaginas;
	private String isbn;
	private String formato;
	private String estado;
	private int unidades;
	private String editorial;
	
	public Libro(String[]datos) {
		super();
		this.titulo = datos[0];
		this.autor =datos[1];
		this.editorial = datos[2];
		this.tema = datos[3];
		this.numPaginas = Integer.parseInt(datos[4]);
		this.formato = datos[5];
		this.estado = datos[6];
		this.isbn = datos[7];
		this.unidades = Integer.parseInt(datos[8]);
	}

	public boolean esIgualQue(Libro libro) {
		if(this.autor.equals(libro.getAutor()))return false;
		if(this.editorial.equals(libro.getEditorial()))return false;
		if(this.estado.equals(libro.getEstado()))return false;
		if(this.formato.equals(libro.getFormato()))return false;
		if(this.numPaginas==libro.getNumPaginas())return false;
		if(this.tema.equals(libro.getTema()))return false;
		if(this.titulo.equals(libro.getTitulo()))return false;
		return (this.unidades==libro.getUnidades());
	}

	public String getIsbn() {
		return isbn;
	}
	
	public int getUnidades() {
		return unidades;
	}

	public String getTitulo() {
		return titulo;
	}
	public String getAutor() {
		return autor;
	}
	public String getTema() {
		return tema;
	}
	public int getNumPaginas() {
		return numPaginas;
	}
	public String getFormato() {
		return formato;
	}
	public String getEstado() {
		return estado;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public String getEditorial() {
		return editorial;
	}

}
