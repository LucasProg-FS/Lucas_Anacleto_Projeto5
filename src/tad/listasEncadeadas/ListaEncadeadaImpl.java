package tad.listasEncadeadas;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ListaEncadeadaImpl<T extends Comparable<T>> implements ListaEncadeadaIF<T>{

	NodoListaEncadeada<T> cabeca = null;
	NodoListaEncadeada<T> cauda = null;

	public ListaEncadeadaImpl() {
		cabeca = new NodoListaEncadeada<T>();
		cauda = new NodoListaEncadeada<T>();
		cabeca.setProximo(cauda);
	}

	@Override
	public boolean isEmpty() {
		return cabeca.getProximo().equals(cauda);
	}

	@Override
	public int size() {
		int size = 0;
		NodoListaEncadeada<T> atual = cabeca.getProximo();
		while (!atual.equals(cauda)) {
			size++;
			atual = atual.getProximo();
		}
		return size;
	}

	@Override
	public NodoListaEncadeada<T> search(T chave) {
		NodoListaEncadeada<T> atual = cabeca.getProximo();
		while (!atual.equals(cauda)) {
			if (atual.getChave().equals(chave)) {
				return atual;
			}
			atual = atual.getProximo();
		}
		return null;
	}

	@Override
	public void insert(T chave) {
		NodoListaEncadeada<T> novoNo = new NodoListaEncadeada<T>(chave);
		NodoListaEncadeada<T> atual = cabeca;
		while (!atual.getProximo().equals(cauda)) {
			atual = atual.getProximo();
		}
		atual.setProximo(novoNo);
		novoNo.setProximo(cauda);
	}

	@Override
	public NodoListaEncadeada<T> remove(T chave) {
		NodoListaEncadeada<T> atual = cabeca.getProximo();
		NodoListaEncadeada<T> anterior = cabeca;
		while (!atual.equals(cauda)) {
			if (atual.getChave().equals(chave)) {
				anterior.setProximo(atual.getProximo());
				return atual;
			}
			anterior = atual;
			atual = atual.getProximo();
		}
		throw new NoSuchElementException("Elemento não encontrado na lista!");
	}

	@Override
	public T[] toArray(Class<T> clazz) {
		List<T> list = new ArrayList<>();
		NodoListaEncadeada<T> atual = cabeca.getProximo();
		while (atual != null && !atual.equals(cauda)) {
			list.add(atual.getChave());
			atual = atual.getProximo();
		}
		@SuppressWarnings("unchecked")
		T[] array = (T[]) java.lang.reflect.Array.newInstance(clazz, list.size());
		return list.toArray(array);
	}



	@Override
	public String imprimeEmOrdem() {
		StringBuilder sb = new StringBuilder();
		NodoListaEncadeada<T> atual = cabeca.getProximo();
		while (!atual.equals(cauda)) {
			sb.append(atual.getChave()).append(", ");
			atual = atual.getProximo();
		}
		return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "";
	}

	@Override
	public String imprimeInverso() {
		StringBuilder sb = new StringBuilder();
		imprimeInversoRecursivo(cabeca.getProximo(), sb);
		return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "";
	}

	private void imprimeInversoRecursivo(NodoListaEncadeada<T> nodo, StringBuilder sb) {
		if (nodo.equals(cauda)) {
			return;
		}
		imprimeInversoRecursivo(nodo.getProximo(), sb);
		sb.append(nodo.getChave()).append(", ");
	}

	@Override
	public NodoListaEncadeada<T> sucessor(T chave) {
		NodoListaEncadeada<T> atual = cabeca.getProximo();
		while (!atual.equals(cauda)) {
			if (atual.getChave().equals(chave)) {
				return atual.getProximo();
			}
			atual = atual.getProximo();
		}
		return null;
	}

	@Override
	public NodoListaEncadeada<T> predecessor(T chave) {
		NodoListaEncadeada<T> anterior = cabeca;
		NodoListaEncadeada<T> atual = cabeca.getProximo();
		while (!atual.equals(cauda)) {
			if (atual.getChave().equals(chave)) {
				return anterior;
			}
			anterior = atual;
			atual = atual.getProximo();
		}
		return null;
	}

	@Override
	public void insert(T chave, int index) {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("Índice fora dos limites da lista!");
		}
		NodoListaEncadeada<T> novoNo = new NodoListaEncadeada<T>(chave);
		NodoListaEncadeada<T> atual = cabeca;
		for (int i = 0; i < index; i++) {
			atual = atual.getProximo();
		}
		novoNo.setProximo(atual.getProximo());
		atual.setProximo(novoNo);
	}
}