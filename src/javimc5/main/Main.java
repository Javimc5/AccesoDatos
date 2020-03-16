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

public class Main {

	private static File_Manager FManager = new File_Manager();
	private static BD_Manager BDManager = new BD_Manager();

	public static void main(String[] args) {
		int opcion = menu();
		while (opcion != 6) {
			switch (opcion) {
			case 1:
				print();
				break;
			case 2:
				newData();
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
			case 5:
				try {
					compare(FManager.leer(),BDManager.leer());
				} catch (SQLException e) {
					// TODO Bloque catch generado automáticamente
					e.printStackTrace();
				}
			}
		}
	}

	public static int menu() {
		Scanner in = new Scanner(System.in);
		int opcion = 0;
		while (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4) {
			System.out.println("Seleccione una opcion: ");
			System.out.println("1. Imprimir datos");
			System.out.println("2. Importar un dato");
			System.out.println("3. Pasar de fichero a BBDD");
			System.out.println("4. Pasar de BBDD a fichero");
			System.out.println("5. Comparar datos");
			System.out.println("6. Salir");
			opcion = in.nextInt();
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

	public static void newData() {
		Scanner in = new Scanner(System.in);
		System.out.println("Introduzca id: ");
		int id = in.nextInt();
		System.out.println("Introduzca nombre:");
		String nombre = in.nextLine();
		System.out.println("Introduzca descripcion:");
		String desc = in.nextLine();
		System.out.println("Introduzca caracteristicas:");
		String carac = in.nextLine();
		Elemento newElem = new Elemento(id, nombre, desc, carac);
		HashMap<Integer, Elemento> data = new HashMap<Integer, Elemento>();
		data.put(newElem.getId(), newElem);
		try {
			FManager.escribir(data);
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}
	
	public static void compare(HashMap<Integer,Elemento> a,HashMap<Integer,Elemento> b) {
		if(a.equals(b)) {
			System.out.println("Base de Datos actualizada.");
		}
		else
			System.out.println("La Base de Datos no esta actualizada.");
	}
}
