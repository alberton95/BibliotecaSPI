package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import ConexaoBD.ConnectionFactory;

public class LocacaoDAO {

	public static void criarLocacao(String cpf, int codLivro, String cupom, String dataLocacao, String dataPreviaDevolucao) throws SQLException {
		// CONECTANDO COM O BANCO DE DADOS
		Connection con = new ConnectionFactory().getConnection();
		// CRIA UM COMANDO QUERY SQL
		try {
			String sql = "INSERT INTO locacao(codLivro, cpf, cupom, dataLocacao, dataPreviaDevolucao) VALUES (?,?,?,?,?)";
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setInt(1, codLivro);
			comando.setString(2, cpf);
			comando.setString(3, cupom);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			sdf.setLenient(false);
			try {
			  Date data = sdf.parse(dataLocacao);
			  Date data2 = sdf.parse(dataPreviaDevolucao);
			  comando.setString(4, dataLocacao);
			  comando.setString(5, dataPreviaDevolucao); 
			  comando.execute();
			  JOptionPane.showMessageDialog(null, "O livro foi alugado com sucesso!");
			} catch(ParseException e) {
			  // se cair aqui, a data é inválida
				JOptionPane.showMessageDialog(null, "Data Inválida!");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"O livro não foi alugado!");
		}

		// EXECUTA A FECHA A CONEXÃO.
		con.close();
	}
	
	public static void devolverLivro(String cupom) throws SQLException{
		// CONECTANDO COM O BANCO DE DADOS
		Connection con = new ConnectionFactory().getConnection();
		
		int resposta = JOptionPane.showConfirmDialog(null, "Deseja mesmo devolver o Livro?", "Devolver Livro", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
    		// CRIA UM COMANDO QUERY SQL
    		String sql = "DELETE FROM locacao WHERE cupom=?";
    		PreparedStatement comando = con.prepareStatement(sql);
    		comando.setString(1, cupom);
    		 
    		int deletado = comando.executeUpdate();
    		if (deletado > 0) {
    			JOptionPane.showMessageDialog(null, "Livro devolvido com sucesso!","OK!",JOptionPane.INFORMATION_MESSAGE);
    		}else{
    			JOptionPane.showMessageDialog(null, "Erro! \n O livro não foi devolvido!","ERRO!",JOptionPane.INFORMATION_MESSAGE);
    		}
        }
        else {
           JOptionPane.showMessageDialog(null, "Você cancelou a operação!");
        }
		con.close();
	}
	
}
