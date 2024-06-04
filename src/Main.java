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
		int opcion4 = 0;
		int opcion5 = 0;
		String[] opciones = {
				"Equipos","Jugar Partido","Salir"	
			};
			
			do {
				opcion = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, opciones, opciones[0]);
				switch (opcion) {
				case 0:
					//Modificacion de Equipos
					do {
						String[] opciones4 = {
							"Elegir Equipo","Agregar Equipo","Eliminar Equipo","Ver Lista de Equipos","Salir"
						};
						opcion4 = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, opciones4, opciones4[0]);
						switch (opcion4) {
						case 0:
							//Modificacion de Jugadores dentro de cada Equipo
							int equipoElegido= elegirEquipo(nuevo.getEquipos());
							JOptionPane.showMessageDialog(null, "Usted seleccionó al equipo:"+nuevo.getEquipos().get(equipoElegido));
							String[] opciones2 = {
									"Agregar Jugadores Manualmente","Agregar Jugadores Aleatorio","Eliminar Jugadores","Ver Jugadores","Salir"	
								};
							do {
								opcion2 = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, opciones2, opciones2[0]);
								
								switch (opcion2) {
								case 0:
									//Agregar jugadores manualmente
									nuevo.getEquipos().get(equipoElegido).agregarJugadoresManual();
									break;

								case 1:
									//Agregar jugadores aleatorio
									int cantidad2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de jugadores"));
									nuevo.getEquipos().get(equipoElegido).agregarJugadoresAleatorio(cantidad2);
									JOptionPane.showMessageDialog(null, nuevo.getEquipos().get(equipoElegido).getPlantel());
									break;
								case 2:
									//Eliminar a un jugador
									nuevo.getEquipos().get(equipoElegido).eliminarJugador();
									break;
								case 3:
									//Distintos tipos de ver Jugadores
									String[] opciones3 = {
										"Buscar por nombre","Ver Lista de Jugadores","Cantidad total de Jugadores"
									};
									opcion3 = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, opciones3, opciones3[0]);
									switch (opcion3) {
									case 0:
										//Buscar un Jugador por nombre
										nuevo.getEquipos().get(equipoElegido).buscarJugador();
										break;

									case 1:
										//Ver el Plantel
										JOptionPane.showMessageDialog(null, nuevo.getEquipos().get(equipoElegido).getPlantel());
										break;
									case 2:
										//Ver Cantidad de Jugadores
										nuevo.getEquipos().get(equipoElegido).cantJugadores();
										break;
									}
								}
									
							} while (opcion2!=4);
						case 1:
							//Agregar Equipo
							nuevo.agregarEquipo();
							break;
						case 2:
							//Eliminar Equipo
							break;
						case 3:
							//Distintos tipos de ver Equipos
							do {
								String[] opciones5 = {
									"Buscar Equipo por nombre","Ver la lista de Equipos","Ver cantidad de Equipos","Volver Atras"	
								};
								opcion5 = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, opciones5, opciones5[0]);
								switch (opcion5) {
								case 0:
									//Buscar Equipo por nombre
									break;

								case 1:
									//Ver la lista de Equipos
									break;
								case 2:
									//Ver cantidad de Equipos
									break;
								}
								
							}while(opcion5!=3);
							break;
						}
					}while(opcion4!=4);
					
					break;

				case 1:
					//Jugar Partido
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

		
	
	
	

