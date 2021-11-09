package br.udesc.otes12.treinamentos.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	// Nome do usu�rio do banco
	private static final String USERNAME = "root";
	
	// Senha do banco
	private static final String PASSWORD = "b9db9f36a4";
	
	// String de conex�o
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/bd_otes12_treinamentos";
	
	/* 
	 * Conex�o com o banco de dados
	 */
	
	public static Connection criarconexaoMySQL()  throws Exception {

		// Cria a conex�o com o banco de dados MySQL
		Connection conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return conn;
	}
	
	public static void main(String[] args) throws Exception {
		
		// Instanciar conex�o com o banco de dados
		Connection conn = criarconexaoMySQL();
		
		// Necess�rio transformar em singleton para evitar lentid�o no servidor de banco de dados 
		if(conn!=null) {
			System.out.println("Conex�o com o banco de dados j� tinha sido instanciada.");
			conn.close();
		}
	}

}
