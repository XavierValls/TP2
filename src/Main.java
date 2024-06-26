
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		GestorEquipos nuevo = new GestorEquipos();
		nuevo.getEquipos().add(new Equipo("Boca","La boca")); 
		nuevo.getEquipos().add(new Equipo("River","Nuñez"));
		nuevo.getEquipos().add(new Equipo("Lanus","Lanus"));
		nuevo.getEquipos().add(new Equipo("Velez","Liniers"));
		nuevo.getEquipos().add(new Equipo("Chacarita","San Martin"));
		nuevo.getEquipos().add(new Equipo("Newells","Rosario"));
		nuevo.getEquipos().add(new Equipo("Talleres","Cordoba"));
		nuevo.getEquipos().add(new Equipo("Belgrano","Cordoba"));
		for (Equipo equipo : nuevo.getEquipos()) {
			equipo.agregarJugadoresAleatorio(11);
		} 
		nuevo.CrearFixture();
		
		int opcion;
		int opcion2;
		int opcion3;
		int opcion4;
		int opcion5;
		int opcion6;
		

		String[] opciones = {
				"Equipos","Jugar Partido","Ver Partidos","Salir"	
			};
			do {
				opcion = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, opciones, opciones[0]);
				switch (opcion) {
				case 0:
					//Modificacion de Equipos
					String[] opciones4 = {
							"Modificar Equipos","Agregar Equipo","Eliminar Equipo","Ver Lista de Equipos","Salir"
						};
					do {
						opcion4 = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, opciones4, opciones4[0]);
						switch (opcion4) {
						case 0:
							//Modificacion de Jugadores dentro de cada Equipo
							Equipo equipoElegido = elegirEquipo(nuevo.getEquipos());
							JOptionPane.showMessageDialog(null, "Usted seleccionó al equipo:"+equipoElegido);
							String[] opciones2 = {
									"Agregar Jugadores Manualmente","Agregar Jugadores Aleatorio","Eliminar Jugadores","Ver Jugadores","Volver Atras"	
								};
							do {
								opcion2 = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, opciones2, opciones2[0]);
								
								switch (opcion2) {
								case 0:
									//Agregar jugadores manualmente
									equipoElegido.agregarJugadoresManual();
									break;

								case 1:
									//Agregar jugadores aleatorio
									int cantidad2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de jugadores"));
									equipoElegido.agregarJugadoresAleatorio(cantidad2);
									JOptionPane.showMessageDialog(null, equipoElegido.getPlantel());
									break;
								case 2:
									//Eliminar a un jugador
									equipoElegido.eliminarJugador();
									break;
								case 3:
									//Distintos tipos de ver Jugadores
									String[] opciones3 = {
										"Buscar por nombre","Ver Lista de Jugadores","Cantidad total de Jugadores","Volver Atras"
									};
									do {
										opcion3 = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, opciones3, opciones3[0]);
										switch (opcion3) {
										case 0:
											//Buscar un Jugador por nombre
											equipoElegido.buscarJugador();
											break;
										case 1:
											//Ver el Plantel
											equipoElegido.verJugadores();
											break;
										case 2:
											//Ver Cantidad de Jugadores
											equipoElegido.cantJugadores();
											break;
										}
									}while(opcion3!=3);
								}	
							} while (opcion2!=4);
						break;
						case 1:
							//Agregar Equipo
							nuevo.agregarEquipo();
							break;
						case 2:
							//Eliminar Equipo
							nuevo.eliminarEquipo();
							break;
						case 3:
							//Distintos tipos de ver Equipos
							String[] opciones5 = {
									"Buscar Equipo por nombre","Ver la lista de Equipos","Ver cantidad de Equipos","Volver Atras"	
								};
							do {
								opcion5 = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, opciones5, opciones5[0]);
								switch (opcion5) {
								case 0:
									//Buscar Equipo por nombre
									nuevo.buscarEquipo();
									break;

								case 1:
									//Ver la lista de Equipos
									nuevo.verEquipos();
									break;
								case 2:
									//Ver cantidad de Equipos
									nuevo.cantEquipos();
									break;
								}
							}while(opcion5!=3);
						}
					}while(opcion4!=4);
				break;
				case 1:
					//Jugar Partido
					if (Partido.getCantPartidos()<=4) {
						JOptionPane.showMessageDialog(null, nuevo.JugarPartido(elegirPartido(nuevo.getPartidos())));
					}
					if (Partido.getCantPartidos()> 4 && Partido.getCantPartidos() <= 6) {
						Partido semis = new Partido(elegirEquipoSemis(nuevo.getGanadores()),elegirEquipoSemis(nuevo.getGanadores()));
						JOptionPane.showMessageDialog(null, nuevo.JugarPartido(semis));
					}
					if(Partido.getCantPartidos()>6) {
						Partido finall = new Partido(elegirEquipoFinal(nuevo.getFinalistas()),elegirEquipoFinal(nuevo.getFinalistas()));
						JOptionPane.showMessageDialog(null, nuevo.JugarPartido(finall));
					}
					
					break;
				case 2:
					if (Partido.getCantPartidos()==1) {
						JOptionPane.showMessageDialog(null, "No se jugo ningun partido aun");
					} else {
						JOptionPane.showMessageDialog(null, nuevo.getHistorial());
					}
				}
			} while(opcion!=3);
	}
	public static Equipo elegirEquipo(LinkedList<Equipo> equipos) {
		String[] arregloEquipo = new String[equipos.size()];
		for (int i = 0; i < arregloEquipo.length; i++) {
			arregloEquipo[i] = equipos.get(i).getNombre();
		}
		int opcion = JOptionPane.showOptionDialog(null, "Seleccione los equipos", null, 0, 0, null, arregloEquipo,
				arregloEquipo);
		Equipo seleccionado = equipos.get(opcion);
		equipos.remove(seleccionado);
		return seleccionado;
	}
	
	public static Equipo elegirEquipoSemis(LinkedList<Equipo> ganadores) {
		String[] arregloEquipo = new String[ganadores.size()];
		for (int i = 0; i < arregloEquipo.length; i++) {
			arregloEquipo[i] = ganadores.get(i).getNombre();
		}
		int opcion = JOptionPane.showOptionDialog(null, "Seleccione los equipos\n Fase: Semifinales" , null, 0, 0, null, arregloEquipo,
				arregloEquipo);
		Equipo seleccionado = ganadores.get(opcion);
		ganadores.remove(seleccionado);
		return seleccionado;
	}
	
	public static Equipo elegirEquipoFinal(LinkedList<Equipo> finalistas) {
		String[] arregloEquipo = new String[finalistas.size()];
		for (int i = 0; i < arregloEquipo.length; i++) {
			arregloEquipo[i] = finalistas.get(i).getNombre();
		}
		int opcion = JOptionPane.showOptionDialog(null, "Partido Final!! \nSeleccione los equipos", null, 0, 0, null, arregloEquipo,
				arregloEquipo);
		Equipo seleccionado = finalistas.get(opcion);
		finalistas.remove(seleccionado);
		return seleccionado;
	}
	
	public static Partido elegirPartido(LinkedList<Partido> partidos) {
		String[] arregloPartidos = new String[partidos.size()];
		for (int i = 0; i < arregloPartidos.length; i++) {
			arregloPartidos[i] = partidos.get(i).toString();
		}
		int opcion = JOptionPane.showOptionDialog(null, "Seleccione los equipos", null, 0, 0, null, arregloPartidos,
				arregloPartidos);
		Partido seleccionado = partidos.get(opcion);
		partidos.remove(seleccionado);
		return seleccionado;
	}
	
	
	

	
}

		
	
	
	

