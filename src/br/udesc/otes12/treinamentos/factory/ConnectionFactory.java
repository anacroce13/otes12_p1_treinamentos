package br.udesc.otes12.treinamentos.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	// Nome do usuário do banco
	private static final String USERNAME = "root";
	
	// Senha do banco
	private static final String PASSWORD = "b9db9f36a4";
	
	// String de conexão
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/bd_otes12_treinamentos";
	
	/* 
	 * Conexão com o banco de dados
	 */
	
	public static Connection criarconexaoMySQL()  throws Exception {

		// Cria a conexão com o banco de dados MySQL
		Connection conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return conn;
	}
	
	public static void main(String[] args) throws Exception {
		
		// Instanciar conexão com o banco de dados
		Connection conn = criarconexaoMySQL();
		
		// Necessário transformar em singleton para evitar lentidão no servidor de banco de dados 
		if(conn!=null) {
			System.out.println("Conexão com o banco de dados já tinha sido instanciada.");
			conn.close();
		}
	}

}
