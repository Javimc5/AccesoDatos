package javimc5.Vista;

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
import javimc5.Controlador.BD_Manager;
import javimc5.Controlador.Elemento;
import javimc5.Controlador.File_Manager;

public class Main {

	private static File_Manager FManager = new File_Manager();
	private static BD_Manager BDManager = new BD_Manager();

	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		int opcion =0;
		while (opcion != 5) {
			opcion = menu();
			switch (opcion) {
			case 1:
				print();
				break;
			case 2:
				System.out.println("Donde quieres insertar datos: ");
				System.out.println("1. Base de Datos");
				System.out.println("2. Fichero");
				int opc=Integer.parseInt(in.nextLine());
				if(opc==1)
					FManager.escribirUno();
				if(opc==2)
					BDManager.escribirUno();
				break;
			case 3:
				try {
					BDManager.escribir(FManager.leer());
				} catch (SQLException e) {
					// TODO Bloque catch generado automáticamente
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					FManager.escribir(BDManager.leer());
				} catch (SQLException e) {
					// TODO Bloque catch generado automáticamente
					e.printStackTrace();
				}
				break;
			
			}
			System.out.println(opcion);
		}
	}

	public static int menu() {
		Scanner in = new Scanner(System.in);
		int opcion = 0;
		while (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4 && opcion!=5) {
			System.out.println("Seleccione una opcion: ");
			System.out.println("1. Imprimir datos");
			System.out.println("2. Importar un dato");
			System.out.println("3. Pasar de fichero a BBDD");
			System.out.println("4. Pasar de BBDD a fichero");
			System.out.println("5. Salir");
			opcion=in.nextInt();
			
		}
		return opcion;
	}

	public static void print() {
		try {
			HashMap<Integer, Elemento> data = FManager.leer();
			for (Integer a : data.keySet()) {
				Elemento elem = data.get(a);
				System.out.println(elem.getId() + "|" + elem.getNombre() + "|" + elem.getDescripcion() + "|"
						+ elem.getCaracteristica());
			}
			
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}


	
//	public static void compare(HashMap<Integer,Elemento> a,HashMap<Integer,Elemento> b) {
//		System.out.println(a.toString());
//		System.out.println(b.toString());
//		if(a.equals(b)) {
//			System.out.println("Base de Datos actualizada.");
//		}
//		else
//			System.out.println("La Base de Datos no esta actualizada.");
//	}
}
