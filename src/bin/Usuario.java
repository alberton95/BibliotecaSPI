package bin;
import java.util.Date;

public class Usuario {

	String cpf, nome, rua, bairro, cidade, matricula;
	String periodo;
	String inicioCurso;
	String terminoCurso;

	public Usuario(String cpf, String nome, String rua, String bairro, String cidade, String matricula, String periodo,
			String inicioCurso, String terminoCurso) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.matricula = matricula;
		this.periodo = periodo;
		this.inicioCurso = inicioCurso;
		this.terminoCurso = terminoCurso;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getInicioCurso() {
		return inicioCurso;
	}
	public void setInicioCurso(String inicioCurso) {
		this.inicioCurso = inicioCurso;
	}
	public String getTerminoCurso() {
		return terminoCurso;
	}
	public void setTerminoCurso(String terminoCurso) {
		this.terminoCurso = terminoCurso;
	}

	
	
}
