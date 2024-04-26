package tad.pilha;

class No {
	Integer valor;
	No proximo;

	public No(Integer valor) {
		this.valor = valor;
		this.proximo = null;
	}
}

public class MinhaPilhaEncadeada implements PilhaIF<Integer> {

	private No topo;

	public MinhaPilhaEncadeada() {
		this.topo = null;
	}

	@Override
	public void empilhar(Integer item) throws PilhaCheiaException {
		No novoNo = new No(item);
		novoNo.proximo = topo;
		topo = novoNo;
	}

	@Override
	public Integer desempilhar() throws PilhaVaziaException {
		if (isEmpty()) {
			throw new PilhaVaziaException("A pilha está vazia");
		}
		Integer valorRemovido = topo.valor;
		topo = topo.proximo;
		return valorRemovido;
	}

	@Override
	public Integer topo() {
		if (isEmpty()) {
			return null;
		}
		return topo.valor;
	}

	@Override
	public PilhaIF<Integer> multitop(int k) {
		if (isEmpty() || k <= 0) {
			return new MinhaPilhaEncadeada();
		}
		MinhaPilhaEncadeada subPilha = new MinhaPilhaEncadeada();
		No atual = topo;
		int count = 0;
		while (atual != null && count < k) {
			try {
				subPilha.empilhar(atual.valor);
			} catch (PilhaCheiaException e) {
				// Não deve ocorrer, pois estamos criando uma nova pilha
			}
			atual = atual.proximo;
			count++;
		}
		return subPilha;
	}

	@Override
	public boolean isEmpty() {
		return topo == null;
	}
}
