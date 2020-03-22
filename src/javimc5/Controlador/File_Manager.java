package javimc5.Controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

public class File_Manager implements Manager {

	@Override
	public HashMap<Integer, Elemento> leer() throws SQLException {
		// TODO Apéndice de método generado automáticamente
		HashMap<Integer, Elemento> elements = new HashMap<Integer, Elemento>();
		File file = new File("datos.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st;
			while ((st = br.readLine()) != null) {
				String[] data = st.split("\\|");
				Elemento elem = new Elemento(Integer.parseInt(data[0]), data[1], data[2], data[3]);
				elements.put(elem.getId(), elem);
			}
		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		return elements;
	}

	@Override
	public void escribir(HashMap<Integer, Elemento> data) throws SQLException {
		// TODO Apéndice de método generado automáticamente
		try {
			File file = new File("datos.txt");
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			for (Integer a : data.keySet()) {
				Elemento elem = data.get(a);
				out.write(elem.getId() + "|" + elem.getNombre() + "|" + elem.getDescripcion() + "|"
						+ elem.getCaracteristica());
				out.newLine();
			}
			out.close();
		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}

	public void escribirUno() {
		Scanner in = new Scanner(System.in);
		File file = new File("datos.txt");
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(file,true));
			System.out.println("Introduzca id: ");
			int id = Integer.parseInt(in.nextLine());
			System.out.println("Introduzca nombre:");
			String nombre = in.nextLine();
			System.out.println("Introduzca descripcion:");
			String desc = in.nextLine();
			System.out.println("Introduzca caracteristicas:");
			String carac = in.nextLine();
			out.write(id + "|" + nombre + "|" + desc + "|"
					+ carac);
			out.newLine();
			out.close();
		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}
	
	
}
