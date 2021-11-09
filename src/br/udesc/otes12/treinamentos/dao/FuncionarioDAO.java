package br.udesc.otes12.treinamentos.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.udesc.otes12.treinamentos.factory.ConnectionFactory;
import br.udesc.otes12.treinamentos.model.Funcionario;

public class FuncionarioDAO {

		public void criar(Funcionario func) {
			
			String sql = "INSERT INTO funcionario(departamento_id, nome, dt_contratacao, qt_total_horas_treinamento) VALUES (?, ?, ?, ?)";
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				// instanciar conexão com banco
				conn = ConnectionFactory.criarconexaoMySQL();
				
				// Prepared statement e parâmetros para inserir no banco
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, func.getDepartamentoId());
				pstmt.setString(2, func.getNome());
				pstmt.setDate(3, (Date) func.getDtContratacao());
				pstmt.setDouble(4, func.getQtTotalHorasTreinamento());
				
				// rodar a query
				pstmt.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public List<Funcionario> listar() {
			
			List<Funcionario> funcionarios = new ArrayList<Funcionario>();
			
			String sql = "SELECT * FROM funcionario f";
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			try {
				conn = ConnectionFactory.criarconexaoMySQL();
				
				// Prepared statement para rodar a consulta no banco
				pstmt = conn.prepareStatement(sql);
				rset = pstmt.executeQuery();
				
				// Percorrer cada linha do resultset
				while (rset.next()) {

					// Criar objeto para receber dados
					Funcionario func = new Funcionario();
					
					// Transferir campos do resultset para o objeto criado
					func.setId(rset.getInt("id"));
					func.setDepartamentoId(rset.getInt("departamento_id"));
					func.setNome(rset.getString("nome"));
					func.setDtContratacao(rset.getDate("dt_contratacao"));
					func.setQtTotalHorasTreinamento(rset.getDouble("qt_total_horas_treinamento"));
					
					// adicionar objeto na lista de retorno
					funcionarios.add(func);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return funcionarios;
		}
		
		public Funcionario lerDados(int id) {
			
			String sql = "SELECT * FROM funcionario f WHERE f.id = ?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			Funcionario func = new Funcionario();
			
			try {
				conn = ConnectionFactory.criarconexaoMySQL();
				
				// Prepared statement com parâmetro de Id (chave primária)
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				rset = pstmt.executeQuery(); 
				
				// posicionar cursor na primeira linha do resultset
				rset.absolute(1);
				
				// Transferir campos do resultset para o objeto criado
				func.setId(rset.getInt("id"));
				func.setDepartamentoId(rset.getInt("departamento_id"));
				func.setNome(rset.getString("nome"));
				func.setDtContratacao(rset.getDate("dt_contratacao"));
				func.setQtTotalHorasTreinamento(rset.getDouble("qt_total_horas_treinamento"));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return func;
		}
		
		public void atualizar(Funcionario func) {
			
			String sql = "UPDATE funcionario f SET f.departamento_id = ?, f.nome = ?, dt_contratacao = ?, qt_total_horas_treinamento = ?"
					   + "WHERE id = ?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				conn = ConnectionFactory.criarconexaoMySQL();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, func.getDepartamentoId());
				pstmt.setString(2, func.getNome());
				pstmt.setDate(3, (Date) func.getDtContratacao());
				pstmt.setDouble(4, func.getQtTotalHorasTreinamento());
				pstmt.setInt(5, func.getId());
				pstmt.execute(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void excluir(int id) {
			
			String sql = "DELETE FROM funcionario f WHERE f.id = ?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				conn = ConnectionFactory.criarconexaoMySQL();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				pstmt.execute(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
