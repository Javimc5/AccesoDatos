package javimc5.Controlador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;

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
		stm.executeUpdate("Delete from elementos");
		for (Integer a : data.keySet()) {
			Elemento elem=data.get(a);
			stm.executeUpdate("Insert into elementos (nombre,descripcion,caracteristica) values ('"+elem.getNombre()+"','"+elem.getDescripcion()+"','"+elem.getCaracteristica()+"')");
		}
	}
	
	public void escribirUno() {
		Scanner in = new Scanner(System.in);
		try {
			Conexion conexion = new Conexion();
			Connection cn = conexion.conectar();
			Statement stm = cn.createStatement();
			System.out.println("Introduzca id: ");
			int id = Integer.parseInt(in.nextLine());
			System.out.println("Introduzca nombre:");
			String nombre = in.nextLine();
			System.out.println("Introduzca descripcion:");
			String desc = in.nextLine();
			System.out.println("Introduzca caracteristicas:");
			String carac = in.nextLine();
			stm.executeUpdate("Insert into elementos (nombre,descripcion,caracteristica) values ('"+nombre+"','"+desc+"','"+carac+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
