package Apresentacao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import ConexaoBD.ConnectionFactory;
import DAO.LivrosDAO;
import DAO.UsuariosDAO;
import bin.Usuario;

public class BibliotecaPrincipal {

	public static void main(String[] args) throws SQLException {

		FachadaBiblioteca fachada = new FachadaBiblioteca();
		LivrosDAO livro = new LivrosDAO();

		int opcao = 0;

		while(opcao != 15){

			try {
				while(true){
					try {
						opcao = Integer.parseInt(JOptionPane.showInputDialog(null,""
								+ "Gerenciar Alugueis de Livro:\n" +
								"1 - Alugar Livro\n" +
								"2 - Devolver Livro\n" +
								"3 - Cobrar Multa por Atraso\n" +
								"---------------------\n" +
								"Gerenciar Usu�rios:\n" +
								"4 - Cadastrar Usu�rios\n" +
								"5 - Consultar Usu�rios\n" +
								"6 - Editar Usu�rios\n" +
								"7 - Excluir Usu�rios\n" +
								"---------------------\n" +
								"Gerenciar Livros:\n" +
								"8 - Cadastrar Livros\n" +
								"9 - Consultar Livros\n" +
								"10 - Editar Livros\n" +
								"11 - Excluir Livros\n" +
								"---------------------\n" +
								"Outras Op��es:\n" +
								"15 - Finalizar","Biblioteca SPI", JOptionPane.QUESTION_MESSAGE));	
								break;
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,"Opera��o Inv�lida");
					}
				}	


				switch(opcao){ 
				case 1:
					String alugacpf = JOptionPane.showInputDialog(null, "Digite o seu CPF:", "Alugar Livro", JOptionPane.QUESTION_MESSAGE);
					boolean resultadoAluga = UsuariosDAO.checaCpf(alugacpf);
					if(resultadoAluga==true){
						int alugacodLivro = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o c�digo do Livro: "));
						boolean resultadoAluga2 = LivrosDAO.checacodLivro(alugacodLivro);
						boolean resultadodisp = LivrosDAO.checaLivroDisponivel(alugacodLivro);
						if(resultadoAluga2==true && resultadodisp == true){
						String cupom = JOptionPane.showInputDialog(null, "Digite o cupom:", "Alugar Livro", JOptionPane.QUESTION_MESSAGE);
						String dataLocacao = JOptionPane.showInputDialog(null, "Digite a data de loca��o:", "Alugar Livro", JOptionPane.QUESTION_MESSAGE);
						String dataPreviaDevolucao = JOptionPane.showInputDialog(null, "Digite a data Pr�via de Devolu��o:", "Alugar Livro", JOptionPane.QUESTION_MESSAGE);
						fachada.realizarLocacao(alugacpf,alugacodLivro, cupom, dataLocacao, dataPreviaDevolucao);
						}else{
							JOptionPane.showMessageDialog(null, "O livro informado n�o existe ou n�o est� disponivel para loca��o!");
						}
					}else{
						JOptionPane.showMessageDialog(null, "O Usu�rio do CPF informado n�o existe!");
					}
					break;

				case 2:

					System.out.println("Voc� digitou 2");
					break;

				case 3:

					System.out.println("Voc� digitou 3");

					break;

				case 4:

					String cpf = JOptionPane.showInputDialog(null, "Digite o seu CPF:", "Cadastrar Usu�rio", JOptionPane.QUESTION_MESSAGE);
					String nome = JOptionPane.showInputDialog(null, "Digite o seu nome:", "Cadastrar Usu�rio", JOptionPane.QUESTION_MESSAGE);
					String rua = JOptionPane.showInputDialog(null, "Digite sua rua:", "Cadastrar Usu�rio", JOptionPane.QUESTION_MESSAGE);
					String bairro = JOptionPane.showInputDialog(null, "Digite o seu bairro:", "Cadastrar Usu�rio", JOptionPane.QUESTION_MESSAGE);
					String cidade = JOptionPane.showInputDialog(null, "Digite a sua cidade:", "Cadastrar Usu�rio", JOptionPane.QUESTION_MESSAGE);
					String matricula = JOptionPane.showInputDialog(null, "Digite a sua matr�cula:", "Cadastrar Usu�rio", JOptionPane.QUESTION_MESSAGE);
					String periodo = JOptionPane.showInputDialog(null, "Digite o seu periodo atual:", "Cadastrar Usu�rio", JOptionPane.QUESTION_MESSAGE);
					String inicioCurso = JOptionPane.showInputDialog(null, "Digite a data de inicio do Curso: (DD MM AAAA):", "Cadastrar Usu�rio", JOptionPane.QUESTION_MESSAGE);
					String terminoCurso = JOptionPane.showInputDialog(null, "Digite a data de termino do Curso: (DD MM AAAA):", "Cadastrar Usu�rio", JOptionPane.QUESTION_MESSAGE);
					fachada.inserirUsuarios(cpf, nome, rua, bairro, cidade, matricula, periodo,
							inicioCurso, terminoCurso);
					break;

				case 5:

					String consultacpf = JOptionPane.showInputDialog(null, "Digite seu CPF:", "Consultar Usu�rio", JOptionPane.QUESTION_MESSAGE);
					fachada.consultarUsuarios(consultacpf);
					break;
					
				case 6:
					String editacpf = JOptionPane.showInputDialog(null, "Digite o seu CPF do Usu�rio � ser editado:", "Editar Usu�rio", JOptionPane.QUESTION_MESSAGE);
					UsuariosDAO usuario = new UsuariosDAO();
					boolean resultado = usuario.checaCpf(editacpf);
					if(resultado==true){
						String editanome = JOptionPane.showInputDialog(null, "Digite o novo nome:", "Editar Usu�rio", JOptionPane.QUESTION_MESSAGE);
						String editarua = JOptionPane.showInputDialog(null, "Digite sua rua:", "Editar Usu�rio", JOptionPane.QUESTION_MESSAGE);
						String editabairro = JOptionPane.showInputDialog(null, "Digite o seu bairro:", "Editar Usu�rio", JOptionPane.QUESTION_MESSAGE);
						String editacidade = JOptionPane.showInputDialog(null, "Digite a sua cidade:", "Editar Usu�rio", JOptionPane.QUESTION_MESSAGE);
						String editamatricula = JOptionPane.showInputDialog(null, "Digite a sua matr�cula:", "Editar Usu�rio", JOptionPane.QUESTION_MESSAGE);
						String editaperiodo = JOptionPane.showInputDialog(null, "Digite o seu periodo atual:", "Editar Usu�rio", JOptionPane.QUESTION_MESSAGE);
						String editainicioCurso = JOptionPane.showInputDialog(null, "Digite a data de inicio do Curso: (DD MM AAAA):", "Editar Usu�rio", JOptionPane.QUESTION_MESSAGE);
						String editaterminoCurso = JOptionPane.showInputDialog(null, "Digite a data de termino do Curso: (DD MM AAAA):", "Editar Usu�rio", JOptionPane.QUESTION_MESSAGE);
						fachada.editarUsuarios(editacpf, editanome, editarua, editabairro, editacidade, editamatricula, editaperiodo,
								editainicioCurso, editaterminoCurso);
					}else{
						JOptionPane.showMessageDialog(null, "Usu�rio n�o encontrado!");
					}
					break;
					
				case 7:
					
					String exclusaoUsuario = JOptionPane.showInputDialog(null, "Digite o CPF do Usu�rio a ser excluido:", "Excluir Usu�rio", JOptionPane.QUESTION_MESSAGE);
					fachada.excluirUsuarios(exclusaoUsuario);
					break;

				case 8:

					int codLivro = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o c�digo do Livro: "));
					int volume = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o volume: "));
					String isbn = JOptionPane.showInputDialog(null, "Digite o isbn:", "Cadastrar Livros", JOptionPane.QUESTION_MESSAGE);
					char disponivel = JOptionPane.showInputDialog(null, "Disponivel?: ").charAt(0);;
					String autor = JOptionPane.showInputDialog(null, "Digite o autor:", "Cadastrar Livros", JOptionPane.QUESTION_MESSAGE);
					fachada.inserirLivros(codLivro, volume, isbn, disponivel, autor);
					break;

				case 9:
					
					fachada.consultarLivros();
					break;
					
				case 10:
					
					int editacodLivro = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o C�digo do Livro � ser editado:", "Editar Livro", JOptionPane.QUESTION_MESSAGE));
					LivrosDAO livrofunc = new LivrosDAO();
					boolean resultadoChecaCod = livrofunc.checacodLivro(editacodLivro);
					if(resultadoChecaCod==true){
						int editavolume = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o volume: "));
						String editaisbn = JOptionPane.showInputDialog(null, "Digite o isbn:", "Cadastrar Livros", JOptionPane.QUESTION_MESSAGE);
						char editadisponivel = JOptionPane.showInputDialog(null, "Disponivel?: ").charAt(0);;
						String editaautor = JOptionPane.showInputDialog(null, "Digite o autor:", "Cadastrar Livros", JOptionPane.QUESTION_MESSAGE);
						fachada.editarLivros(editacodLivro, editavolume, editaisbn, editadisponivel, editaautor);
					}else{
						JOptionPane.showMessageDialog(null, "Livro n�o encontrado!");
					}
					break;
					
				case 11:
					
					String exclusaoLivro = JOptionPane.showInputDialog(null, "Digite o c�digo do Livro a ser excluido:", "Excluir Livro", JOptionPane.QUESTION_MESSAGE);
					fachada.excluirLivros(exclusaoLivro);
					break;
					
				case 15:

					System.out.println("Sistema encerrado!");

					break;

				default:JOptionPane.showConfirmDialog(null, "Opera��o Invalida");
				break;
				}


			} catch (Exception ex) {
				JOptionPane.showConfirmDialog(null, "Opera��o Invalida");
				break;
			}

		}
	}
}