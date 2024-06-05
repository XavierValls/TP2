import java.util.LinkedList;

import javax.swing.JOptionPane;

public class GestorEquipos {

	private LinkedList<Equipo> equipos = new LinkedList<Equipo>();
	
	
	public GestorEquipos() {

	}


	public LinkedList<Equipo> getEquipos() {
		return equipos;
	}




	public void setEquipos(LinkedList<Equipo> equipos) {
		this.equipos = equipos;
	}
	

	@Override
	public String toString() {
		return "GestorEquipos [equipos=" + equipos + "]";
	}


	public Equipo JugarPartido(Equipo equipo1, Equipo equipo2) {
		if (equipo1.getPlantel().size() >= 8 && equipo2.getPlantel().size() >= 8) {
			JOptionPane.showMessageDialog(null, "El partido comenzara pronto");
			int goles1;
			int goles2;

			do {
				goles1 = (int)(Math.random()*5);
				goles2 = (int)(Math.random()*5);
				if (goles1==goles2) {
					
				} 
			
			}while(goles1==goles2);
			
			if(goles1>goles2) {
				return equipo1;
			} else {
				return equipo2;
			}
			

		} else {
			JOptionPane.showMessageDialog(null, "No hay jugadores suficientes");
		}
		return null;
	}
	
	public void agregarEquipo() {
		String nombreEquipo = JOptionPane.showInputDialog("Ingrese el nombre del Equipo");
		String ciudadEquipo = JOptionPane.showInputDialog("Ingrese la ciudad del Equipo"); 
		Equipo nuevo = new Equipo(nombreEquipo,ciudadEquipo);
		if (this.getEquipos().isEmpty()) {
			this.getEquipos().add(nuevo);
		} else {
			boolean flag = true;
			for (Equipo equipos : this.getEquipos()) {
				if (equipos.getNombre().equalsIgnoreCase(nuevo.getNombre())) {
					JOptionPane.showMessageDialog(null, "Este nombre ya existe");
					flag = false;
					break;
				}
			}
			if (flag) {
				this.getEquipos().add(nuevo);
			} else {
				JOptionPane.showMessageDialog(null, "No se pudo agregar el equipo, el nombre ya existe");
			}

		}
	}
	
	public void buscarEquipo() {
		if (!this.equipos.isEmpty()) {
			String buscar = JOptionPane.showInputDialog("Ingrese el nombre del Equipo");
			String[] nombreEquipo = new String[this.equipos.size()];
			for (int i = 0; i < this.equipos.size(); i++) {
				nombreEquipo[i] = this.equipos.get(i).getNombre();
			}
			for (Equipo equipos : equipos) {
				if (equipos.getNombre().equalsIgnoreCase(buscar)) {
					JOptionPane.showMessageDialog(null, equipos);
					break;
				} else {
					JOptionPane.showMessageDialog(null, "No se encontro un Equipo con ese nombre");
					break;
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "No existe ningun equipo");
		}
	}
	
	public void cantEquipos() {
		if (!this.equipos.isEmpty()) {
			JOptionPane.showMessageDialog(null, "La cantidad de Equipos es: " + this.equipos.size());
		} else {
			JOptionPane.showMessageDialog(null, "No hay ningun Equipo");
		}
	}
	
	public void verEquipos() {
		JOptionPane.showMessageDialog(null, this.equipos);
	}
	
	public void eliminarEquipo() {
		while (!this.equipos.isEmpty()) {
			String[] opciones = new String[this.equipos.size()];
	        for (int i = 0; i < this.equipos.size(); i++) {
	            opciones[i] = this.equipos.get(i).getNombre();
	        }
	        String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione un Equipo para eliminar:",
	                "Eliminar Jugador", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
	        if (seleccion != null) {
	            for (Equipo equipos : this.equipos) {
	                if (equipos.getNombre().equals(seleccion)) {
	                	this.equipos.remove(equipos);
	                    JOptionPane.showMessageDialog(null, "Equipo eliminado: " + equipos.getNombre());
	                    break;
	                }
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún Equipo.");
	            break;
	        }
	    }
		if (this.equipos.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay Equipos para eliminar");

		}
    }
}
