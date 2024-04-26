package tad.conjuntoDinamico;

import java.util.ArrayList;
import java.util.List;

public class MeuConjuntoDinamico<T extends Comparable<T>> implements ConjuntoDinamicoIF<T> {

	private List<T> conjunto;

	/**
	 * Construtor padrão que inicializa o conjunto como uma lista vazia.
	 */
	public MeuConjuntoDinamico() {
		conjunto = new ArrayList<>();
	}

	/**
	 * Retorna o número de elementos no conjunto.
	 */
	@Override
	public int tamanho() {
		return conjunto.size();
	}

	/**
	 * Insere um elemento no conjunto.
	 *
	 * @param elemento o elemento a ser inserido no conjunto.
	 */
	@Override
	public void inserir(T elemento) {
		conjunto.add(elemento);
	}

	/**
	 * Remove um elemento do conjunto.
	 *
	 * @param elemento o elemento a ser removido do conjunto.
	 * @return o elemento removido do conjunto.
	 * @throws Exception se o elemento não estiver presente no conjunto.
	 */
	@Override
	public T remover(T elemento) throws Exception {
		if (conjunto.contains(elemento)) {
			conjunto.remove(elemento);
			return elemento;
		} else {
			throw new Exception("Elemento não encontrado no conjunto");
		}
	}

	/**
	 * Busca por um elemento no conjunto.
	 *
	 * @param elemento o elemento a ser buscado no conjunto.
	 * @return o elemento buscado.
	 * @throws Exception se o elemento não estiver presente no conjunto.
	 */
	@Override
	public T buscar(T elemento) throws Exception {
		if (conjunto.contains(elemento)) {
			return elemento;
		} else {
			throw new Exception("Elemento não encontrado no conjunto");
		}
	}

	/**
	 * Retorna o elemento mínimo presente no conjunto.
	 *
	 * @return o elemento mínimo no conjunto.
	 * @throws Exception se o conjunto estiver vazio.
	 */
	@Override
	public T minimum() throws Exception {
		if (conjunto.isEmpty()) {
			throw new Exception("Conjunto vazio");
		}
		T min = conjunto.get(0);
		for (T elemento : conjunto) {
			if (elemento.compareTo(min) < 0) {
				min = elemento;
			}
		}
		return min;
	}

	/**
	 * Retorna o elemento máximo presente no conjunto.
	 *
	 * @return o elemento máximo no conjunto.
	 * @throws Exception se o conjunto estiver vazio.
	 */
	@Override
	public T maximum() throws Exception {
		if (conjunto.isEmpty()) {
			throw new Exception("Conjunto vazio");
		}
		T max = conjunto.get(0);
		for (T elemento : conjunto) {
			if (elemento.compareTo(max) > 0) {
				max = elemento;
			}
		}
		return max;
	}

	/**
	 * Retorna o sucessor de um elemento no conjunto.
	 *
	 * @param elemento o elemento cujo sucessor será procurado.
	 * @return o sucessor do elemento especificado.
	 * @throws Exception se o conjunto estiver vazio.
	 */
	@Override
	public T sucessor(T elemento) throws Exception {
		if (conjunto.isEmpty()) {
			throw new Exception("Conjunto vazio");
		}
		T sucessor = null;
		for (T e : conjunto) {
			if (e.compareTo(elemento) > 0 && (sucessor == null || e.compareTo(sucessor) < 0)) {
				sucessor = e;
			}
		}
		return sucessor;
	}

	/**
	 * Retorna o predecessor de um elemento no conjunto.
	 *
	 * @param elemento o elemento cujo predecessor será procurado.
	 * @return o predecessor do elemento especificado.
	 * @throws Exception se o conjunto estiver vazio.
	 */
	@Override
	public T predecessor(T elemento) throws Exception {
		if (conjunto.isEmpty()) {
			throw new Exception("Conjunto vazio");
		}
		T predecessor = null;
		for (T e : conjunto) {
			if (e.compareTo(elemento) < 0 && (predecessor == null || e.compareTo(predecessor) > 0)) {
				predecessor = e;
			}
		}
		return predecessor;
	}
}