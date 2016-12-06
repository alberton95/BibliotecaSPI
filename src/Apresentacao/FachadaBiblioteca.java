package Apresentacao;
import java.sql.SQLException;
import java.util.Date;
import DAO.LivrosDAO;
import DAO.LocacaoDAO;
import DAO.UsuariosDAO;
import bin.Livros;

public class FachadaBiblioteca {

	LivrosDAO livro = new LivrosDAO();
	UsuariosDAO usuario = new UsuariosDAO();
	LocacaoDAO locacao = new LocacaoDAO();
	
	public void inserirLivros(int codLivro, int volume, String isbn, char disponivel, String autor) throws SQLException{
		livro.insereLivros(codLivro, volume, isbn, disponivel, autor);
	}
	
	public void inserirUsuarios(String cpf, String nome, String rua, String bairro, String cidade, String matricula, String periodo,
			String inicioCurso, String terminoCurso) throws SQLException{
		UsuariosDAO.insereUsuarios(cpf,nome,rua,bairro,cidade,matricula,periodo,inicioCurso,terminoCurso);
	}
	
	public void consultarUsuarios(String cpf) throws SQLException{
		UsuariosDAO.consultaUsuarios(cpf);
	}
	
	public void excluirUsuarios(String excluir) throws SQLException{
		UsuariosDAO.excluirUsuarios(excluir);
	}
	
	public void excluirLivros(String excluir) throws SQLException{
		LivrosDAO.excluirLivros(excluir);
	}
	
	public void consultarLivros() throws SQLException{
		LivrosDAO.consultarLivros();
	}
	
	public void editarUsuarios(String cpf, String editanome, String editarua, String editabairro, String editacidade, String editamatricula, String editaperiodo, String editainicioCurso, String editaterminoCurso) throws SQLException{
		UsuariosDAO.editarUsuarios(cpf,editanome,editarua,editabairro,editacidade,editamatricula,editaperiodo,editainicioCurso,editaterminoCurso);
	}
	
	public void editarLivros(int editacodLivro, int volume, String isbn, char disponivel, String autor) throws SQLException{
		LivrosDAO.editarLivros(editacodLivro, volume, isbn, disponivel, autor);
	}
	
	public void realizarLocacao(String cpf, int codLivro, String cupom, String dataLocacao, String dataPreviaDevolucao) throws SQLException{
		LocacaoDAO.criarLocacao(cpf, codLivro, cupom, dataLocacao, dataPreviaDevolucao);
	}
	
	public void devolverLivro(String cupom) throws SQLException{
		LocacaoDAO.devolverLivro(cupom);
	}
	

}
