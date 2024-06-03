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
}
