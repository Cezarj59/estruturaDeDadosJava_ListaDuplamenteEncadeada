package listaDuplamenteEncadeada;

public class Main {

	public static void main(String[] args) {

		ListaDuplamenteEncadeada<String> minhaListaEncadeada = new ListaDuplamenteEncadeada<>();

		// add um item na lista
		minhaListaEncadeada.add("c1");
		minhaListaEncadeada.add("c2");
		minhaListaEncadeada.add("c3");
		minhaListaEncadeada.add("c4");
		minhaListaEncadeada.add("c5");
		minhaListaEncadeada.add("c6");
		minhaListaEncadeada.add("c7");

		System.out.println(minhaListaEncadeada);

		// removendo um item
		minhaListaEncadeada.remove(3);

		// adicionando item usando sobrecarga
		minhaListaEncadeada.add(3, "99");

		System.out.println(minhaListaEncadeada);
		System.out.println(minhaListaEncadeada.get(3));
		
		
	}

}
