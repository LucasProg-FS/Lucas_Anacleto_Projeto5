package tad.fila;

class No {
	Integer valor;
	No proximo;

	public No(Integer valor) {
		this.valor = valor;
		this.proximo = null;
	}
}

public class MinhaFilaEncadeada implements FilaIF<Integer> {

	private No cabeca;
	private No cauda;

	public MinhaFilaEncadeada() {
		this.cabeca = null;
		this.cauda = null;
	}

	@Override
	public void enfileirar(Integer item) throws FilaCheiaException {
		No novoNo = new No(item);
		if (cauda == null) {
			cabeca = novoNo;
			cauda = novoNo;
		} else {
			cauda.proximo = novoNo;
			cauda = novoNo;
		}
	}

	@Override
	public Integer desenfileirar() throws FilaVaziaException {
		if (isEmpty()) {
			throw new FilaVaziaException("A fila está vazia");
		}
		Integer valorRemovido = cabeca.valor;
		cabeca = cabeca.proximo;
		if (cabeca == null) {
			cauda = null;
		}
		return valorRemovido;
	}

	@Override
	public Integer verificarCauda() {
		if (isEmpty()) {
			return null;
		}
		return cauda.valor;
	}

	@Override
	public Integer verificarCabeca() {
		if (isEmpty()) {
			return null;
		}
		return cabeca.valor;
	}

	@Override
	public boolean isEmpty() {
		return cabeca == null;
	}

	@Override
	public boolean isFull() {
		return false; // Fila encadeada não tem limite de capacidade
	}
}
