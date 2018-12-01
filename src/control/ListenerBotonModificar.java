package control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Libro;
import vista.LogicaGrafica;

public class ListenerBotonModificar implements ActionListener{

	private Logica logica;
	private LogicaGrafica logicaGrafica;
	
	public ListenerBotonModificar(Logica logica, LogicaGrafica logicaGrafica) {
		super();
		this.logica = logica;
		this.logicaGrafica = logicaGrafica;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		logicaGrafica.resetearMensajeError();
		Libro libroOriginal = obtenerLibroSeleccionado();
		sacarLibroDeLibros();
		Libro libroModificado = obtenerLibroModificado();
		logica.modificarLibro(libroOriginal, libroModificado);
		logicaGrafica.resetearInformacion();
		logicaGrafica.pintarLista(logica.getLibros());
		logicaGrafica.mostrarMensajeError("libro modificado", false);
	}

	private Libro obtenerLibroModificado() {
		return logicaGrafica.crearLibro(logica.getLibros(),false);
	}

	private void sacarLibroDeLibros() {
		logica.borrarLibro(logicaGrafica.obtenerIsbn());
	}

	private Libro obtenerLibroSeleccionado() {
		return logica.getLibros().get(logicaGrafica.getPosicionLibroActual());
	}

}
