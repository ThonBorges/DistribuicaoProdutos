package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProdutoUsado extends Produto {

	private LocalDate data;
	
	public ProdutoUsado() {
		super();
	}
	
	public ProdutoUsado(String nome, Double preco, LocalDate data) {
		super(nome, preco);
		this.data = data;
	}
	
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public String etiquetaPreco() {
		return getNome() 
				+ " (usado) $ " 
				+ String.format("%.2f", getPreco())
				+ " (Data Fabricação: "
				+ data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
				+ ") ";
	}
}
