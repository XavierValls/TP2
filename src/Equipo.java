import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Equipo {

	private String nombre;
	private String ciudad;
	private LinkedList<Jugador> plantel = new LinkedList<Jugador>();
	
	public Equipo(String nombre, String ciudad) {
		super();
		this.nombre = nombre;
		this.ciudad = ciudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public LinkedList<Jugador> getPlantel() {
		return plantel;
	}

	public void setPlantel(LinkedList<Jugador> plantel) {
		this.plantel = plantel;
	}

	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", ciudad=" + ciudad + ", plantel=" + plantel + "]";
	}
	
	public void agregarJugadoresAleatorio(int cant) {

		for (int i = 0; i < cant; i++) {
			boolean flag = true;
			do {
				int camiseta = (int) (Math.random() * 99 + 1);

				for (Jugador jugador : this.getPlantel()) {
					if (jugador.getNroCamiseta() == camiseta) {
						flag = false;
					}
				}
				if (flag) {
					this.getPlantel().add(new Jugador("nombre", "posicion", camiseta, 20, 70, 1.83,1,"Pais"));
				}
			} while (flag == false);

		}
		

	}
	public void agregarJugadoresManual() {
		int numeroCamiseta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de jugador"));
		Jugador nuevo = new Jugador("nombre", "posicion",numeroCamiseta, 20, 70, 1.83,1, "Pais");
		if (this.getPlantel().isEmpty()) {
			this.getPlantel().add(nuevo);
		} else {
			boolean flag = true;
			for (Jugador jugador : this.getPlantel()) {
				if (jugador.getNroCamiseta() == nuevo.getNroCamiseta()) {
					JOptionPane.showMessageDialog(null, "Este numero ya existe");
					flag = false;
					break;
				}
			}
			if (flag) {
				this.getPlantel().add(nuevo);
			} else {
				JOptionPane.showMessageDialog(null, "No se pudo agregar el jugador, el numero ya existe");
			}

		}
	}
	public void eliminarJugador() {
		while (!this.plantel.isEmpty()) {
			String[] opciones = new String[plantel.size()];
	        for (int i = 0; i < plantel.size(); i++) {
	            opciones[i] = plantel.get(i).getNombre();
	        }
	        String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione un jugador para eliminar:",
	                "Eliminar Jugador", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
	        if (seleccion != null) {
	            for (Jugador jugador : plantel) {
	                if (jugador.getNombre().equals(seleccion)) {
	                    plantel.remove(jugador);
	                    JOptionPane.showMessageDialog(null, "Jugador eliminado: " + jugador.getNombre());
	                    break;
	                }
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún jugador.");
	            break;
	        }
	    }
		if (this.plantel.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay jugadores en el plantel");

		}
    }
	
	
	public void buscarJugador() {
		String buscar = JOptionPane.showInputDialog("Ingrese el nombre del jugador");
		if (buscar!=null) {
			String[] nombreJugadores = new String[plantel.size()];
			for (int i = 0; i < plantel.size(); i++) {
	            nombreJugadores[i] = plantel.get(i).getNombre();
			}
			for (Jugador jugador : plantel) {
				if (jugador.getNombre().equalsIgnoreCase(buscar)) {
					JOptionPane.showMessageDialog(null, jugador);
				} else {
					JOptionPane.showMessageDialog(null, "El jugador no se encontro en el plantel");
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debe ingresar un nombre");
		}
	}

	
	
	
}
