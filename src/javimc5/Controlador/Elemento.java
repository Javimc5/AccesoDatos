package javimc5.Controlador;

public class Elemento {
	private int id;
	private String nombre;
	private String descripcion;
	private String caracteristica;
	
	public Elemento(int id,String nombre, String descripcion, String caracteristica) {
		super();
		this.id=id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.caracteristica = caracteristica;
	}

	public Elemento(int id,String nombre) {
		super();
		this.id=id;
		this.nombre = nombre;
		descripcion=null;
		caracteristica=null;
	}

	public Elemento(int id,String nombre, String descripcion) {
		super();
		this.id=id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		caracteristica=null;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}
	
}
