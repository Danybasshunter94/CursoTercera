package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

public class AccesoDatos {

	private Connection con;

	private String host = "localhost";
	private String bd = "information_schema";
	private String usuario = "root";
	private String clave = "123";
	private String consulta = "";

	public void getConexion() {

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + bd, usuario, clave);

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		System.out.println("Conexion establecida con la bd, " + bd);
	}

	public ArrayList<ArrayList<String>> consulta(String consulta) {
		ArrayList<ArrayList<String>> lista = new ArrayList<>();
		this.getConexion();
		try {
			Statement sentencia = (Statement) con.createStatement();
			ResultSet datos = sentencia.executeQuery(consulta);
			ResultSetMetaData rsmd = datos.getMetaData();
			int columnas = rsmd.getColumnCount();

			while (datos.next()) {
				ArrayList<String> registro = new ArrayList<>();
				for (int i = 1; i <= columnas; i++) {
					registro.add(datos.getString(i));
				}
				lista.add(registro);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}

	// Devuelve lista de bd de mysql local
	// sino se pone public, no sale en VISTA/VENTANA
	public ArrayList<String> getSchema() {
		ArrayList<String> listaBD = new ArrayList<>();
		getConexion();

		try {

			Statement stmt = con.createStatement();
			// recoger los datos
			ResultSet rs = stmt.executeQuery(
					"select schema_name from information_schema.schemata where schema_name not in ('mysql', 'information_schema', 'performance_schema')");
			String registro;

			// rs se va desplazando por los registros, y devuelve false, cuando
			// llegue al final
			while (rs.next()) {
				registro = rs.getString(1);
				listaBD.add(registro);
			}

		} catch (SQLException e) {

			System.out.println("Error SQL " + e.getMessage());

		}

		return listaBD;
	}

	/*
	 * Devuelve lista de tablas de una bd dada como parametro
	 */

	public ArrayList<String> getTablesSchema(String db) {
		ArrayList<String> listaTablas = new ArrayList<>();
		try {

			Statement stmt = con.createStatement();
			// recoger los datos
			ResultSet rs = stmt
					.executeQuery("select table_name from information_schema.tables where table_schema = '" + db + "'");
			String registro;

			// rs se va desplazando por los registros, y devuelve false, cuando
			// llegue al final
			while (rs.next()) {
				registro = rs.getString("table_name");
				listaTablas.add(registro);
			}

		} catch (SQLException e) {

			System.out.println("Error SQL " + e.getMessage());

		}
		return listaTablas;
	}

	/*
	 * Devuelve Listado de los registros de una bd.tabla dada como parametros
	 */

	public ArrayList<ArrayList<String>> getRegistrosTablaDB(String db, String tabla) {
		ArrayList<ArrayList<String>> registrosTabla = new ArrayList<ArrayList<String>>();

		try {

			Statement stmt = con.createStatement();
			// recoger los datos
			ResultSet rs = stmt.executeQuery("select * from " + db + "." + tabla);
			ArrayList<String> registro;

			// rs se va desplazando por los registros, y devuelve false, cuando
			// llegue al final
			while (rs.next()) {

				ResultSetMetaData md = rs.getMetaData();
				int nCols = md.getColumnCount();
				registro = new ArrayList<String>();

				
				for (int i = 1; i <= nCols; i++) {
					// recorremos el array de las columnas que nos van a
					// devolver
					
					//sino hay nada, te añade el nombre de los campo de las tablas
					if (registrosTabla.size() == 0) {
						registro.add(md.getColumnName(i));
						//si se cumple, lista todo los demas
					} else {
						registro.add(rs.getString(i));
					}

				}
				registrosTabla.add(registro);

			}

		} catch (SQLException e) {

			System.out.println("Error SQL " + e.getMessage());

		}
		return registrosTabla;
	}

	/*
	 * main
	 */
	public static void main(String[] args) {

		AccesoDatos acceso = new AccesoDatos();

		// acceso.getConexion();

		// hay que mostarlo con syso para que se vean
		System.out.println(acceso.getSchema());
		System.out.println();
		// hay que pasarle la tabla que queramos mostrar
		System.out.println(acceso.getTablesSchema("paro"));
		System.out.println();
		// tercer metodo doble array
		System.out.println(acceso.getRegistrosTablaDB("paro", "islas"));

	}

}
