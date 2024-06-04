import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		GestorEquipos nuevo = new GestorEquipos();
		Equipo boca = new Equipo("Boca","La boca");
		Equipo river = new Equipo("River","Nuñez");
		nuevo.getEquipos().add(river);
		nuevo.getEquipos().add(boca);
		int opcion = 0;
		int opcion2 = 0;
		int opcion3 = 0;
		String[] opciones = {
				"Elegir Equipo","Jugar Partido","Salir"	
			};
			
			do {
				opcion = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, opciones, opciones[0]);
				switch (opcion) {
				case 0:
					int equipoElegido= elegirEquipo(nuevo.getEquipos());
					JOptionPane.showMessageDialog(null, "Usted seleccionó al equipo:"+nuevo.getEquipos().get(equipoElegido));
					String[] opciones2 = {
							"Agregar Jugadores Manualmente","Agregar Jugadores Aleatorio","Eliminar Jugadores","Ver Jugadores","Salir"	
						};
					do {
						opcion2 = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, opciones2, opciones2[0]);
						
						switch (opcion2) {
						case 0:
							nuevo.getEquipos().get(equipoElegido).agregarJugadoresManual();

							break;

						case 1:
							int cantidad2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de jugadores"));
							nuevo.getEquipos().get(equipoElegido).agregarJugadoresAleatorio(cantidad2);
							JOptionPane.showMessageDialog(null, nuevo.getEquipos().get(equipoElegido).getPlantel());
							break;
						case 2:
							nuevo.getEquipos().get(equipoElegido).eliminarJugador();
							break;
						case 3:
							String[] opciones3 = {
								"Buscar por nombre","Ver Lista de Jugadores"
							};
							opcion3 = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, opciones3, opciones3[0]);
							switch (opcion3) {
							case 0:
								nuevo.getEquipos().get(equipoElegido).buscarJugador();
								break;

							case 1:
								JOptionPane.showMessageDialog(null, nuevo.getEquipos().get(equipoElegido).getPlantel());
								break;
							}

							break;
						}
							
					} while (opcion2!=4);
					break;

				case 1:
					JOptionPane.showMessageDialog(null,"El ganador fué: "+ nuevo.JugarPartido(nuevo.getEquipos().get(elegirEquipo(nuevo.getEquipos())), nuevo.getEquipos().get(elegirEquipo(nuevo.getEquipos()))));
					break;
				}
	
			} while(opcion!=2);
	}
	public static int elegirEquipo(LinkedList<Equipo> equipos) {
		String[] arregloEquipo = new String[equipos.size()];
		for (int i = 0; i < arregloEquipo.length; i++) {
			arregloEquipo[i] = equipos.get(i).getNombre();
		}
		int seleccionado = JOptionPane.showOptionDialog(null, "Seleccione los equipos", null, 0, 0, null, arregloEquipo,
				arregloEquipo);
		return seleccionado;
	}

	
}

		
	
	
	

