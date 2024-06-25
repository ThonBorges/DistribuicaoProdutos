package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Produto;
import entities.ProdutoImportado;
import entities.ProdutoUsado;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Produto> lista = new ArrayList<>();
		
		System.out.println("Digite o número de produtos: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Dados do produto #" + i + ": ");
			System.out.print("Produto comum(c), usado(u) ou importado(i)? Digite apenas a letra correspondente ao tipo do produto: ");
			char tipoProduto = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Preço: ");
			double preco = sc.nextDouble();
			
			if(tipoProduto == 'u') {
				System.out.print("Data de Fabricação: (DD/MM/YYYY)");
				LocalDate data = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				
				Produto prod = new ProdutoUsado(nome, preco, data);
				lista.add(prod);
				
			} else if (tipoProduto == 'i') {
				System.out.print("Taxa Importação: ");
				double taxaImportacao = sc.nextDouble();
				
				Produto prod = new ProdutoImportado(nome, preco, taxaImportacao);
				lista.add(prod);
				
			} else {
				
				Produto prod = new Produto(nome, preco);
				lista.add(prod);
			}
		}
		
		System.out.println();
		System.out.println("ETIQUETAS DE PRODUTOS: ");
		for (Produto prod : lista) {
			System.out.println(prod.etiquetaPreco());
		}
		
		
		
		sc.close();
	}

}
