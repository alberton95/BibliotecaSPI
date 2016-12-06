package bin;
import java.util.Date;

public class Locacao{
	
	String cupom;
	Date dataLocacao, dataPreviaDevolucao, dataRealDevolucao;
	Number multa;
	
	public Locacao(String cupom, Date dataLocacao, Date dataPreviaDevolucao, Date dataRealDevolucao, Number multa) {
		super();
		this.cupom = cupom;
		this.dataLocacao = dataLocacao;
		this.dataPreviaDevolucao = dataPreviaDevolucao;
		this.dataRealDevolucao = dataRealDevolucao;
		this.multa = multa;
	}
	public String getCupom() {
		return cupom;
	}
	public void setCupom(String cupom) {
		this.cupom = cupom;
	}
	public Date getDataLocacao() {
		return dataLocacao;
	}
	public void setDataLocacao(Date dataLocacao) {
		this.dataLocacao = dataLocacao;
	}
	public Date getDataPreviaDevolucao() {
		return dataPreviaDevolucao;
	}
	public void setDataPreviaDevolucao(Date dataPreviaDevolucao) {
		this.dataPreviaDevolucao = dataPreviaDevolucao;
	}
	public Date getDataRealDevolucao() {
		return dataRealDevolucao;
	}
	public void setDataRealDevolucao(Date dataRealDevolucao) {
		this.dataRealDevolucao = dataRealDevolucao;
	}
	public Number getMulta() {
		return multa;
	}
	public void setMulta(Number multa) {
		this.multa = multa;
	}
	
}
