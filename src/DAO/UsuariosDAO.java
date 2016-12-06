package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import ConexaoBD.ConnectionFactory;
import bin.Usuario;

public class UsuariosDAO {


	public static void insereUsuarios(String cpf, String nome, String rua, String bairro, String cidade, String matricula, String periodo,
			String inicioCurso, String terminoCurso) throws SQLException {

		// CONECTANDO COM O BANCO DE DADOS
		Connection con = new ConnectionFactory().getConnection();
		// CRIA UM COMANDO QUERY SQL
		try {
			String sql = "INSERT INTO usuario(cpf, matricula,nome,rua,cidade,bairro, periodo, inicioCurso, terminoCurso)" +
					" VALUES(?,?,?,?,?,?,?,?,?)";
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1, cpf);
			comando.setString(2, matricula);
			comando.setString(3, nome);
			comando.setString(4, rua);
			comando.setString(5, cidade); 
			comando.setString(6, bairro);
			comando.setString(7, periodo);
			comando.setString(8, inicioCurso);
			comando.setString(9, terminoCurso);
			comando.execute();
			JOptionPane.showMessageDialog(null, "Usuário cadastrado!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Usuário não cadastrado! \n Já existe um usuário com o Código Informado.");
		}
		con.close();
	}

	public static void editarUsuarios(String cpf, String nome, String rua, String bairro, String cidade, String matricula, String periodo,
			String inicioCurso, String terminoCurso) throws SQLException{
		Connection con = new ConnectionFactory().getConnection();	
			String sql = "UPDATE usuario SET matricula=?, nome=?,rua=?,cidade=?, bairro=?,periodo=?,inicioCurso=?,terminoCurso=? WHERE cpf=?";
			PreparedStatement comando = con.prepareStatement(sql);

			// SETA O WHERE DO UPDATE - PARA EDITAR OS DADOS DO USUÁRIO ATRAVÉS DO CPF INFORMADO
			comando.setString(9, cpf);
			// SETA OS NOVOS VALORES
			comando.setString(1, matricula);
			comando.setString(2, nome);
			comando.setString(3, rua);
			comando.setString(4, cidade); 
			comando.setString(5, bairro);
			comando.setString(6, periodo);
			comando.setString(7, inicioCurso);
			comando.setString(8, terminoCurso);


			// EXECUTA O CÓDIGO E FECHA A CONEXÃO
			comando.execute();
			comando.close(); 
			JOptionPane.showMessageDialog(null, "Usuário editado com sucesso!");
	}

	public static boolean checaCpf(String cpf) throws SQLException{
		Connection con = new ConnectionFactory().getConnection();
		// CRIA UM COMANDO QUERY SQL
		String sql = "SELECT * from usuario where cpf = "+cpf;
		PreparedStatement comando = con.prepareStatement(sql);
		ResultSet resultado = comando.executeQuery(sql);
		if(resultado.next()){
			return true;
		}else{
			return false;	
		}
		
	}
	
	public static void consultaUsuarios(String cpf) throws SQLException{
		// CONECTANDO COM O BANCO DE DADOS
		Connection con = new ConnectionFactory().getConnection();
		// CRIA UM COMANDO QUERY SQL
		String sql = "SELECT * from usuario where cpf = "+cpf;
		PreparedStatement comando = con.prepareStatement(sql);
		ResultSet resultado = comando.executeQuery(sql);
		String saida = "";
		while(resultado.next()){
			saida+= "Nome: " +resultado.getString("nome")  + "\n " + 
					"CPF: " + resultado.getString("cpf") + "\n " + 
					"Matrícula: " +resultado.getString("matricula")  + "\n " + 
					"Rua: " +resultado.getString("rua")   + "\n " +  
					"Cidade: " +resultado.getString("cidade")  + "\n " + 
					"Bairro: " +resultado.getString("bairro")  + "\n " + 
					"Periodo: " +resultado.getString("periodo")  + "\n " + 
					"Data de Inicio do Curso: " +resultado.getString("inicioCurso")  + "\n " + 
					"Data de Termino do Curso :" +resultado.getString("terminoCurso")  + "\n "
					;
		}

		if(saida!=""){
			JOptionPane.showMessageDialog(null, saida);
		}else{
			JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
		}
		con.close();
	}

	public static void excluirUsuarios(String cpf) throws SQLException{
		// CONECTANDO COM O BANCO DE DADOS
		Connection con = new ConnectionFactory().getConnection();

		int resposta = JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir o usuário?", "Excluir Usuário", JOptionPane.YES_NO_OPTION);
		if (resposta == JOptionPane.YES_OPTION) {
			// CRIA UM COMANDO QUERY SQL
			String sql = "DELETE FROM usuario WHERE cpf=?";
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1, cpf);

			int deletado = comando.executeUpdate();
			if (deletado > 0) {
				JOptionPane.showMessageDialog(null, "Usuario deletado com sucesso!");
			}else{
				JOptionPane.showMessageDialog(null, "Erro durante a exclusão!");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Você cancelou a exclusão!");
		}
		con.close();

	}

}
