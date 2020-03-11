package javimc5.main;

import java.sql.SQLException;
import java.util.HashMap;

public interface Manager {
	public HashMap<Integer, Elemento> leer() throws SQLException;
		
	public void escribir(HashMap<Integer, Elemento> data) throws SQLException;
}
