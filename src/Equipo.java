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
		return "\nEquipo [nombre=" + nombre + ", ciudad=" + ciudad + ", plantel=" + plantel + "]";
	}
	
	public void agregarJugadoresAleatorio(int cant) {
	    if (cant > 0) {
	        for (int i = 0; i < cant; i++) {
	            boolean flag = false;
	            int camiseta;
	            do {
	                camiseta = (int)(Math.random() * 99 + 1);
	                flag = true;
	                for (Jugador jugador : this.getPlantel()) {
	                    if (jugador.getNroCamiseta() == camiseta) {
	                        flag = false;
	                        break;
	                    }
	                }
	            } while (!flag);

	            this.getPlantel().add(new Jugador("nombre" + (i + 1), "posicion", camiseta, 20, 70, 1.83, 1, "Pais"));
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "La cantidad tiene que ser mayor que 0");
	    }
	}


	
	public void agregarJugadoresManual() {
		String nombreJugador = JOptionPane.showInputDialog("Ingrese el nombre del jugador");
		int numeroCamiseta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de jugador"));
		Jugador nuevo = new Jugador(nombreJugador, "posicion",numeroCamiseta, 20, 70, 1.83,1, "Pais");
		if (this.getPlantel().isEmpty()) {
			this.getPlantel().add(nuevo);
		} else {
			boolean flag = true;
			for (Jugador jugador : this.getPlantel()) {
				if (jugador.getNombre().equalsIgnoreCase(nuevo.getNombre())) {
					JOptionPane.showMessageDialog(null, "Este nombre ya existe");
					flag = false;
					break;
				} else if (jugador.getNroCamiseta() == nuevo.getNroCamiseta()) {
					JOptionPane.showMessageDialog(null, "Este numero ya existe");
					flag = false;
					break;
				}
				
			}
			if (flag) {
				this.getPlantel().add(nuevo);
			} else {
				JOptionPane.showMessageDialog(null, "No se pudo agregar el jugador");
			}

		}
	}
	public void eliminarJugador() {
		while (!this.plantel.isEmpty()) {
			String[] opciones = new String[this.plantel.size()];
	        for (int i = 0; i < this.plantel.size(); i++) {
	            opciones[i] = this.plantel.get(i).getNombre();
	        }
	        String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione un jugador para eliminar:",
	                "Eliminar Jugador", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
	        if (seleccion != null) {
	            for (Jugador jugador : this.plantel) {
	                if (jugador.getNombre().equals(seleccion)) {
	                	this.plantel.remove(jugador);
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
		if (!this.plantel.isEmpty()) {
			String buscar = JOptionPane.showInputDialog("Ingrese el nombre del jugador");
			String[] nombreJugadores = new String[this.plantel.size()];
			for (int i = 0; i < this.plantel.size(); i++) {
	            nombreJugadores[i] = this.plantel.get(i).getNombre();
			}
			for (Jugador jugador : this.plantel) {
				if (jugador.getNombre().equalsIgnoreCase(buscar)) {
					JOptionPane.showMessageDialog(null, jugador);
				} else if (buscar!=null){
					JOptionPane.showMessageDialog(null, "El jugador no se encontro en el plantel");
				} else {
					JOptionPane.showMessageDialog(null, "No ingreso un nombre. Saliendo...");
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "No hay jugadores en el plantel");
		}
	}
	
	public void cantJugadores() {
		if (!this.plantel.isEmpty()) {
			JOptionPane.showMessageDialog(null, "La cantidad de Jugadores del plantel es: " + this.plantel.size());
		} else {
			JOptionPane.showMessageDialog(null, "El plantel no cuenta con Jugadores");
		}
	}
	
	public void verJugadores() {
		if (!this.plantel.isEmpty()) {
			JOptionPane.showMessageDialog(null, this.plantel);
		} else {
			JOptionPane.showMessageDialog(null, "No hay jugadores en el plantel");
		}
	}
	public int generarNivel() {
		int nivel = (int)(Math.random()*3+1);
		return nivel;
	}
}
