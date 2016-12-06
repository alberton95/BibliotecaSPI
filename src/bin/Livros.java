package bin;

public class Livros {

	int codLivro, volume;
	String isbn, disponivel, autor;
	
	public Livros(int codLivro, int volume, String isbn, String disponivel, String autor) {
		super();
		this.codLivro = codLivro;
		this.volume = volume;
		this.isbn = isbn;
		this.disponivel = disponivel;
		this.autor = autor;
	}
	public int getCodLivro() {
		return codLivro;
	}
	public void setCodLivro(int codLivro) {
		this.codLivro = codLivro;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getDisponivel() {
		return disponivel;
	}
	public void setDisponivel(String disponivel) {
		this.disponivel = disponivel;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	
	
}
