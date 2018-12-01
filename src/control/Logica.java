package control;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import acceso.AlmacenContiguos;
import modelo.Libro;

public class Logica {
	private static final String RUTA_LIBROS = "Libros";
	private AlmacenContiguos <Libro>almacenContiguos;
	
	public Logica() {
		super();
		this.almacenContiguos = new AlmacenContiguos<>(RUTA_LIBROS);
	}

	public void altaLibro(Libro libro) {
		assert libro != null;
		almacenContiguos.guardar(libro);
	}

	public boolean borrarLibro(String isbn) {
		assert isbn.length()==13:"ISBN incorrecto";
		AlmacenContiguos<Libro> almacenTemporal = new AlmacenContiguos<>("librosAux");
		int i=0;
		Libro libro = (Libro) almacenContiguos.recuperar(i);
		while(almacenContiguos.recuperar(i)!=null){
			if(!libro.getIsbn().equals(isbn)) {
				almacenTemporal.guardar(libro);
			}
			i++;
			libro = (Libro) almacenContiguos.recuperar(i);
		}
		File librosAux = new File("librosAux");
		File libros = new File(RUTA_LIBROS);
		libros.delete();
		return librosAux.renameTo(new File(RUTA_LIBROS));
	}

	public ArrayList<Libro> getLibros() {
		return almacenContiguos.leer();
	}

	public boolean modificarLibro(Libro original,Libro modificado) {
		assert original != null && modificado != null:"algun libro para modificar ha llegado null";
		if(!original.esIgualQue(modificado)){
			borrarLibro(original.getIsbn());
			almacenContiguos.guardar(modificado);
			return true;
		}
		return false;
	}

	public Libro obtenerLibro(String isbn) {
		assert isbn.length()==13:"longitud isbn incorrecta";
		ArrayList<Libro> libros = almacenContiguos.leer();
		for (Libro libro : libros) {
			if(libro.getIsbn().equals(isbn)) {
				return libro;
			}
		}
		return null;
	}
}
