package listaDuplamenteEncadeada;

public class ListaDuplamenteEncadeada<T> {

	private NoDuplo<T> primeiroNo;
	private NoDuplo<T> ultimoNo;

	private int tamanhoLista;

	public ListaDuplamenteEncadeada() {
		this.primeiroNo = null;
		this.ultimoNo = null;
		this.tamanhoLista = 0;
	}

	public T get(int index) {
		return this.getNo(index).getConteudo();

	}

	public void add(T elemento) {
		// Cria um novo nó com o elemento dado
		NoDuplo<T> novoNo = new NoDuplo<>(elemento);

		// Define o próximo nó do novo nó como nulo (já que este será o último nó)
		novoNo.setNoProximo(null);

		// Define o nó anterior do novo nó como o último nó da lista atual
		novoNo.setNoPrevio(ultimoNo);

		// Se a lista está vazia, define o primeiro nó como o novo nó
		if (primeiroNo == null) {
			primeiroNo = novoNo;
		}

		// Se a lista não está vazia, define o próximo nó do último nó como o novo nó
		if (ultimoNo != null) {
			ultimoNo.setNoProximo(novoNo);
		}

		// Define o último nó da lista como o novo nó e incrementa o tamanho da lista
		ultimoNo = novoNo;
		tamanhoLista++;
	}

	public void add(int index, T elemento) {
		// Obtém o nó na posição especificada pelo índice
		NoDuplo<T> noAuxiliar = getNo(index);

		// Cria um novo nó com o elemento dado e define seu próximo nó como o nó obtido
		// anteriormente
		NoDuplo<T> novoNo = new NoDuplo<>(elemento);
		novoNo.setNoProximo(noAuxiliar);

		// Atualiza o nó anterior e próximo ao novo nó para incluir o novo nó na lista
		if (novoNo.getNoProximo() != null) {
			novoNo.setNoPrevio(noAuxiliar.getNoPrevio());
			novoNo.getNoProximo().setNoPrevio(novoNo);
		} else {
			novoNo.setNoPrevio(ultimoNo);
			ultimoNo = novoNo;
		}

		// Atualiza o primeiro nó da lista se o índice for 0, caso contrário atualiza o
		// próximo nó do nó anterior
		if (index == 0) {
			primeiroNo = novoNo;
		} else {
			novoNo.getNoPrevio().setNoProximo(novoNo);
		}

		// Incrementa o tamanho da lista para refletir a adição do novo elemento
		tamanhoLista++;
	}

	public void remove(int index) {
		// Se o índice for zero, o primeiro nó é removido
		if (index == 0) {
			primeiroNo = primeiroNo.getNoProximo();
			// Se ainda houver nós na lista, defina o nó anterior ao primeiro como nulo
			if (primeiroNo != null) {
				primeiroNo.setNoPrevio(null);
			}
		} else {
			// Se não for o primeiro nó, obtemos o nó que será removido
			NoDuplo<T> noAuxiliar = getNo(index);
			// Definimos o nó anterior ao nó removido como o nó posterior ao nó removido
			noAuxiliar.getNoPrevio().setNoProximo(noAuxiliar.getNoProximo());
			// Se o nó removido não for o último, definimos o nó posterior ao nó removido
			// como o nó anterior ao nó removido
			if (noAuxiliar != ultimoNo) {
				noAuxiliar.getNoProximo().setNoPrevio(noAuxiliar.getNoPrevio());
			} else {
				// Se o nó removido for o último, definimos o último nó como o nó anterior ao nó
				// removido
				ultimoNo = noAuxiliar;
			}
		}

		// Reduzimos o tamanho da lista após a remoção
		this.tamanhoLista--;
	}

	private NoDuplo<T> getNo(int index) {
		// Começa pelo primeiro nó
		NoDuplo<T> noAuxiliar = primeiroNo;

		// Percorre a lista até o índice desejado ou até chegar ao final da lista
		for (int i = 0; (i < index) && (noAuxiliar != null); i++) {
			noAuxiliar = noAuxiliar.getNoProximo();
		}

		// Retorna o nó correspondente ao índice (ou nulo se o índice for inválido)
		return noAuxiliar;
	}

	public int size() {
		return tamanhoLista;
	}

	@Override
	public String toString() {
	    // Cria uma variável para armazenar a string que será retornada
	    String strRetorno = "";

	    // Cria uma variável para apontar para o primeiro nó da lista
	    NoDuplo<T> noAuxiliar = primeiroNo;
	    
	    // Itera sobre a lista até o fim
	    for (int i = 0; i < size(); i++) {
	        // Concatena a string que representa o conteúdo do nó atual
	        strRetorno += "[No{conteudo=" + noAuxiliar.getConteudo() + "}]--->";
	        // Aponta para o próximo nó da lista
	        noAuxiliar = noAuxiliar.getNoProximo();
	    }
	    
	    // Concatena a string "null" ao final da lista
	    strRetorno += "null";
	    
	    // Retorna a string que representa a lista
	    return strRetorno;
	}


}
