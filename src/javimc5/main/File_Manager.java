package javimc5.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

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
				Elemento elem=new Elemento(Integer.parseInt(data[0]),data[1],data[2],data[3]);
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
		BufferedWriter out = null;
		for (Integer a : data.keySet()) {
			Elemento elem = data.get(a);
			try {
				out.write(elem.getId() + "|" + elem.getNombre() + "|" + elem.getDescripcion() + "|"
						+ elem.getCaracteristica());
				out.newLine();
			} catch (IOException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
		}
	}

}
