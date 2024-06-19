import java.time.LocalDate;

public class Partido {
	private Equipo equipo1;
	private Equipo equipo2;
	private int goles1;
	private int goles2;
	private String fase;
	private LocalDate fecha;
	private static int cantPartidos = 1;
	private String estado;
	public Partido(Equipo equipo1, Equipo equipo2) {
		super();
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.goles1 = 0;
		this.goles2 = 0;
		fase = GenerarFase();
		fecha = GenerarFecha();
		this.estado = "Pendiente";

	}
	
	
	
	@Override
	public String toString() {
		return "Enfrentamiento: " + equipo1.getNombre() + " VS " + equipo2.getNombre() + " Resultado: " + goles1 + " : " + goles2
				+ ", fase=" + fase + ", fecha=" + fecha + ", estado="+ estado + " ]\n";
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public Equipo getEquipo1() {
		return equipo1;
	}



	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}



	public Equipo getEquipo2() {
		return equipo2;
	}



	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}



	public int getGoles1() {
		return goles1;
	}



	public void setGoles1(int goles1) {
		this.goles1 = goles1;
	}



	public int getGoles2() {
		return goles2;
	}



	public void setGoles2(int goles2) {
		this.goles2 = goles2;
	}



	public String getFase() {
		return fase;
	}



	public void setFase(String fase) {
		this.fase = fase;
	}



	public LocalDate getFecha() {
		return fecha;
	}



	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}



	public static int getCantPartidos() {
		return cantPartidos;
	}



	public static void setCantPartidos(int cantPartidos) {
		Partido.cantPartidos = cantPartidos;
	}



	public String GenerarFase() {
		if (cantPartidos <=4) {
			return "Cuartos";
		} else if(cantPartidos>4 && cantPartidos <=6) {
			return "Semifinal";
		} else {
			return "Final";
		}
	}
	
	public LocalDate GenerarFecha() {
		if (cantPartidos <=4) {
			return LocalDate.now();
		} else if(cantPartidos>4 && cantPartidos <=6) {
			return LocalDate.now().plusDays(3);
		} else {
			return LocalDate.now().plusDays(5);
		}
	}
	
	public Equipo DeterminarGanador() {
		if (goles1>goles2) {
			return equipo1;
		} else {
			return equipo2;
		}
	}

	




}
