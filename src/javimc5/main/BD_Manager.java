package javimc5.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import Conexion.Conexion;

public class BD_Manager implements Manager{

	@Override
	public HashMap<Integer, Elemento> leer() throws SQLException {
		// TODO Auto-generated method stub
		Conexion conexion = new Conexion();
		Connection cn = conexion.conectar();
		Statement stm = cn.createStatement();
		ResultSet rs = stm.executeQuery("Select * from elementos");
		HashMap<Integer, Elemento> data=new HashMap<Integer,Elemento>();
		while(rs.next()) {
			int id = rs.getInt("id");
            String name = rs.getString("nombre");
            String desc = rs.getString("descripcion");
            String charac = rs.getString("caracteristica");
            data.put(id, new Elemento(id,name, desc, charac));
		}
		return data;
	}

	@Override
	public void escribir(HashMap<Integer, Elemento> data) throws SQLException {
		// TODO Auto-generated method stub
		Conexion conexion = new Conexion();
		Connection cn = conexion.conectar();
		Statement stm = cn.createStatement();
		
	}

}
