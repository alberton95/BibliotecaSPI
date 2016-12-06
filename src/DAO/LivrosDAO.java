package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ConexaoBD.ConnectionFactory;
import bin.Livros;

public class LivrosDAO {

	public static void consultarLivros() throws SQLException{
		// CONECTANDO COM O BANCO DE DADOS
		Connection con = new ConnectionFactory().getConnection();

		// CRIA A CAIXA DE PERGUNTA PARA CONSULTA POR ID OU AUTORES:

		int opcao = 0;

		while(opcao != 15){

			try {

				opcao = Integer.parseInt(JOptionPane.showInputDialog(""
						+ "Digite a Opção Desejada: \n 1: Consultar Livro através do Código\n" +
						"2: Consultar Livro através dos Autores"));	


				switch(opcao){
				case 1:
					String codLivro = JOptionPane.showInputDialog(null, "Digite o código do Livro", "Consultar Livro", JOptionPane.QUESTION_MESSAGE);
					String sql = "SELECT * from livro where codLivro = "+codLivro;
					PreparedStatement comando = con.prepareStatement(sql);
					ResultSet resultado = comando.executeQuery(sql);
					String saida = "";
					while(resultado.next()){
						saida+= "Código do Livro: " +resultado.getInt("codLivro")  + "\n " + 
								"Volume: " + resultado.getInt("volume") + "\n " + 
								"ISBN: " +resultado.getInt("isbn")  + "\n " + 
								"Disponibilidade: " +resultado.getString("disponivel")  + "\n " +  
								"Autor: " +resultado.getString("autor")  + "\n " 
								;
					}
					
					if(saida!=""){
						JOptionPane.showMessageDialog(null, saida);
					}else{
						JOptionPane.showMessageDialog(null, "Nenhum livro com código informado foi encontrado!");
					}

					break;
					

				case 2:
					String autor = JOptionPane.showInputDialog(null, "Digite o autor do Livro", "Consultar Livro", JOptionPane.QUESTION_MESSAGE);
					String querysql = "SELECT * from livro where autor like '%" +autor+"%'";
					PreparedStatement comandosql = con.prepareStatement(querysql);
					ResultSet resultadoselect = comandosql.executeQuery(querysql);
					String saidaa = "";
					while(resultadoselect.next()){
						saidaa+= "Código do Livro: " +resultadoselect.getInt("codLivro")  + "\n " + 
								"Volume: " + resultadoselect.getInt("volume") + "\n " + 
								"ISBN: " +resultadoselect.getInt("isbn")  + "\n " + 
								"Disponibilidade: " +resultadoselect.getString("disponivel")  + "\n " +  
								"Autor: " +resultadoselect.getString("autor")  + "\n \n " 
								;
					}
					if(saidaa!=""){
						JOptionPane.showMessageDialog(null, saidaa);
					}else{
						JOptionPane.showMessageDialog(null, "Nenhum livro do autor informado foi encontrado!");
					}
	
					break;


				default:JOptionPane.showConfirmDialog(null, "Opção Inválida");
				break;
				}


			} catch (Exception ex) {

				JOptionPane.showConfirmDialog(null, "Você fechou a operação!");
				break;

			}
		}
	}

	public static void insereLivros(int codLivro, int volume, String isbn, char disponivel, String autor) throws SQLException {
		// CONECTANDO COM O BANCO DE DADOS
		Connection con = new ConnectionFactory().getConnection();
		// CRIA UM COMANDO QUERY SQL
		try {
			String sql = "INSERT INTO livro(codLivro, volume,isbn,disponivel,autor)" +
					" VALUES(?,?,?,?,?)";
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setInt(1, codLivro);
			comando.setInt(2, volume);
			comando.setString(3, isbn);
			comando.setString(4, String.valueOf(disponivel));
			comando.setString(5, autor); 
			comando.execute();
			JOptionPane.showMessageDialog(null, "Livro cadastrado!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Livro com código informado já cadastrado!");
		}

		// EXECUTA A FECHA A CONEXÃO.
		con.close();
	}
	
	public static void excluirLivros(String codigoLivro) throws SQLException{
		// CONECTANDO COM O BANCO DE DADOS
		Connection con = new ConnectionFactory().getConnection();
		
		int resposta = JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir o Livro?", "Excluir Livro", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
    		// CRIA UM COMANDO QUERY SQL
    		String sql = "DELETE FROM livro WHERE codLivro=?";
    		PreparedStatement comando = con.prepareStatement(sql);
    		comando.setString(1, codigoLivro);
    		 
    		int deletado = comando.executeUpdate();
    		if (deletado > 0) {
    			JOptionPane.showMessageDialog(null, "Livro deletado com sucesso!","OK!",JOptionPane.INFORMATION_MESSAGE);
    		}else{
    			JOptionPane.showMessageDialog(null, "Erro durante a exclusão!","ERRO!",JOptionPane.INFORMATION_MESSAGE);
    		}
        }
        else {
           JOptionPane.showMessageDialog(null, "Você cancelou a exclusão!");
        }
		con.close();
	}

	public static boolean checacodLivro(int editacodLivro) throws SQLException{
		Connection con = new ConnectionFactory().getConnection();
		// CRIA UM COMANDO QUERY SQL
		String sql = "SELECT * from livro where codLivro = "+editacodLivro;
		PreparedStatement comando = con.prepareStatement(sql);
		ResultSet resultado = comando.executeQuery(sql);
		if(resultado.next()){
			return true;
		}else{
			return false;	
		}
		
	}

	public static void editarLivros(int codLivro, int volume, String isbn, char disponivel, String autor) throws SQLException{
		Connection con = new ConnectionFactory().getConnection();	
			String sql = "UPDATE livro SET isbn=?, volume=?,disponivel=?,autor=? WHERE codLivro=?";
			PreparedStatement comando = con.prepareStatement(sql);

			// SETA O WHERE DO UPDATE - PARA EDITAR OS DADOS DO USUÁRIO ATRAVÉS DO CPF INFORMADO
			comando.setInt(5, codLivro);
			// SETA OS NOVOS VALORES
			comando.setString(1, isbn);
			comando.setInt(2, volume);
			comando.setString(3, String.valueOf(disponivel));
			comando.setString(4, autor); 

			// EXECUTA O CÓDIGO E FECHA A CONEXÃO
			comando.execute();
			comando.close(); 
			JOptionPane.showMessageDialog(null, "Livro editado com sucesso!");
	}

	public static boolean checaLivroDisponivel(int editacodLivro) throws SQLException{
		Connection con = new ConnectionFactory().getConnection();
		// CRIA UM COMANDO QUERY SQL
		String sql = "SELECT * from livro where disponivel = 'S' and codLivro = "+editacodLivro;
		PreparedStatement comando = con.prepareStatement(sql);
		ResultSet resultado = comando.executeQuery(sql);
		if(resultado.next()){
			return true;
		}else{
			return false;	
		}
		
	}
	
}


