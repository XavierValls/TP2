
public class Jugador {

	private String nombre;
	private String posicion;
	private int nroCamiseta;
	private static int num;
	private int edad;
	private double peso;
	private double altura;
	private int categoria;
	private String pais;
	
	public Jugador(String nombre, String posicion, int nroCamiseta, int edad, double peso, double altura,
			int categoria,String pais) {
		super();
		this.nombre = nombre;
		this.posicion = posicion;
		this.nroCamiseta = nroCamiseta;
		this.edad = edad;
		this.peso = peso;
		this.altura = altura;
		this.categoria = categoria;
		this.pais = pais;
	}


	
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getPosicion() {
		return posicion;
	}



	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}



	public int getNroCamiseta() {
		return nroCamiseta;
	}



	public void setNroCamiseta(int nroCamiseta) {
		this.nroCamiseta = nroCamiseta;
	}



	public static int getNum() {
		return num;
	}



	public static void setNum(int num) {
		Jugador.num = num;
	}



	public int getEdad() {
		return edad;
	}



	public void setEdad(int edad) {
		this.edad = edad;
	}



	public double getPeso() {
		return peso;
	}



	public void setPeso(double peso) {
		this.peso = peso;
	}



	public double getAltura() {
		return altura;
	}



	public void setAltura(double altura) {
		this.altura = altura;
	}



	public int getCategoria() {
		return categoria;
	}



	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}



	public boolean AgregarJugador() {
		return true;
	}
	



	public String getPais() {
		return pais;
	}



	public void setPais(String pais) {
		this.pais = pais;
	}



	@Override
	public String toString() {
		return "\nJugador [nombre=" + nombre + ", posicion=" + posicion + ", nroCamiseta=" + nroCamiseta + ", edad="
				+ edad + ", peso=" + peso + ", altura=" + altura + ", categoria=" + categoria + ", pais=" + pais + "]";
	}




	
	
	
	
}
