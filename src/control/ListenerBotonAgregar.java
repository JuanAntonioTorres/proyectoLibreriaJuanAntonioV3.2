package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Libro;
import vista.LogicaGrafica;

public class ListenerBotonAgregar implements ActionListener {

	
	private Logica logica;
	private LogicaGrafica logicaGrafica;
	
	public ListenerBotonAgregar(Logica logica, LogicaGrafica logicaGrafica) {
		super();
		this.logica = logica;
		this.logicaGrafica = logicaGrafica;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String isbn = logicaGrafica.obtenerIsbn();
		int unidadesMas=logicaGrafica.obtenerUnidades();
		unidadesMas = controlarNegativos(unidadesMas);
		if(unidadesMas>0) {
			aniadirUnidades(isbn,unidadesMas);
		}
	}

	private void aniadirUnidades(String isbn,int unidadesMas) {
		Libro libro = logica.obtenerLibro(isbn);
		logica.borrarLibro(libro.getIsbn());
		libro.setUnidades(libro.getUnidades()+unidadesMas);
		logica.altaLibro(libro);
		logicaGrafica.pintarLista(logica.getLibros());
		logicaGrafica.resetearInformacion();
		logicaGrafica.pintarLibro(logica.obtenerLibro(libro.getIsbn()));
		logicaGrafica.mostrarMensajeError("unidades añadidas", false);
	}

	private int controlarNegativos(int unidadesMas) {
		if(unidadesMas<0) {
			unidadesMas=0;
			logicaGrafica.mostrarMensajeError("No me pongas numeros negativos", true);
		}
		return unidadesMas;
	}

}
