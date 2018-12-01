package control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Libro;
import vista.LogicaGrafica;

public class ListenerBotonAlta implements ActionListener{
	
	private Logica logica;
	private LogicaGrafica logicaGrafica;
	
	public ListenerBotonAlta(Logica logica,LogicaGrafica logicaGrafica) {
		super();
		this.logica = logica;
		this.logicaGrafica = logicaGrafica;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Libro libro = logicaGrafica.crearLibro(logica.getLibros(),true);
		if (libro!= null) {
			logica.altaLibro(libro);
			logicaGrafica.pintarLista(logica.getLibros());
			logicaGrafica.resetearInformacion();
			logicaGrafica.mostrarMensajeError("libro añadido", false);
		}
	}

}
