package javimc5.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import Conexion.Conexion;

public class main {

	public static void main(String[] args) {
		int opcion=menu();
		if(opcion==1) {
			try {
				imprimir();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(opcion==2) {
			try {
				LeerBBDD();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(opcion==3) {
			try {
				leerFichero();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(opcion==4) {
			try {
				importarDatosFichero();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	private static void importarDatosFichero() throws IOException, SQLException {
		Conexion conexion = new Conexion();
		Connection cn = conexion.conectar();
		Statement stm = cn.createStatement();
		File file = new File("datos.txt");
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		String st; 
		  while ((st = br.readLine()) != null) {
			  String[] data = st.split("\\|");
			  String query="Insert into elementos (nombre,descripcion,caracteristica) values ('"+data[1]+"','"+data[2]+"','"+data[3]+"')";
			  stm.executeUpdate(query);
		  }
	}

	private static HashMap<Integer,Elemento> leerFichero() throws IOException {
		HashMap<Integer,Elemento> data=new HashMap<Integer,Elemento>();
		File file = new File("datos.txt");
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		String st; 
		  while ((st = br.readLine()) != null) {
			  
		  }
		    
		return null; 	   
	}

	private static void LeerBBDD() throws SQLException {
		Conexion conexion = new Conexion();
		Connection cn = conexion.conectar();
		Statement stm = cn.createStatement();
		ResultSet rs = stm.executeQuery("Select * from elementos");
		List<String> data = new ArrayList<String>();
		System.out.println();
		while(rs.next()) {
			int id = rs.getInt("id");
            String name = rs.getString("nombre");
            String desc = rs.getString("descripcion");
            String charac = rs.getString("caracteristica");
            data.add(id + "|" + name + "|" + desc + "|" + charac);
		}
		EscribirFichero(data, "datos.txt");
	}
	private static void EscribirFichero(List<String> list, String path) {
        BufferedWriter out = null;
        try {
                File file = new File(path);
                out = new BufferedWriter(new FileWriter(file, false));
                for (String s : list) {
                        out.write(s);
                        out.newLine();

                }
                out.close();
        } catch (IOException e) {
        }
}

	private static void imprimir() throws SQLException {
		Conexion conexion = new Conexion();
		Connection cn = conexion.conectar();
		Statement stm = cn.createStatement();
		ResultSet rs = stm.executeQuery("Select * from elementos");
		System.out.println();
		while(rs.next()) {
			System.out.println(rs.getInt("id")+" "+rs.getString("nombre"));
			System.out.println(rs.getString("descripcion"));
			System.out.println(rs.getString("caracteristica"));
			System.out.println("*****************************************************************************************");
		}
		
	}

	public static int menu() {
		Scanner in=new Scanner(System.in);
		int opcion=0;
		while(opcion!=1&&opcion!=2 && opcion!=3&&opcion!=4) {
		System.out.println("Seleccione una opcion: ");
		System.out.println("1. Imprimir.");
		System.out.println("2. Copiar a fichero.");
		System.out.println("3. Leer de fichero");
		System.out.println("4. Importar a la base de datos.");
		opcion=in.nextInt();
		}
		return opcion;
	
	}

}
