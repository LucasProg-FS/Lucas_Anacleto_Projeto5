package tad.conjuntoDinamico;

import java.util.ArrayList;
import java.util.List;

public class MeuConjuntoDinamico<T extends Comparable<T>> implements ConjuntoDinamicoIF<T> {

	private List<T> conjunto;

	public MeuConjuntoDinamico() {
		conjunto = new ArrayList<>();
	}

	@Override
	public int tamanho() {
		return conjunto.size();
	}

	@Override
	public void inserir(T elemento) {
		conjunto.add(elemento);
	}

	@Override
	public T remover(T elemento) throws Exception {
		if (conjunto.contains(elemento)) {
			conjunto.remove(elemento);
			return elemento;
		} else {
			throw new Exception("Elemento não encontrado no conjunto");
		}
	}

	@Override
	public T buscar(T elemento) throws Exception {
		if (conjunto.contains(elemento)) {
			return elemento;
		} else {
			throw new Exception("Elemento não encontrado no conjunto");
		}
	}

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