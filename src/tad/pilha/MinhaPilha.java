package tad.pilha;

public class MinhaPilha implements PilhaIF<Integer> {

	private int tamanho = 10;
	private Integer[] meusDados = null;
	private int topo = -1;

	public MinhaPilha(int tamanho) {
		this.tamanho = tamanho;
		this.meusDados = new Integer[tamanho];
	}

	public MinhaPilha() {
		this.meusDados = new Integer[tamanho];
	}

	@Override
	public void empilhar(Integer item) throws PilhaCheiaException {
		if (topo == tamanho - 1) {
			throw new PilhaCheiaException();
		}
		topo++;
		meusDados[topo] = item;
	}

	@Override
	public Integer desempilhar() throws PilhaVaziaException {
		if (isEmpty()) {
			throw new PilhaVaziaException();
		}
		Integer item = meusDados[topo];
		meusDados[topo] = null;
		topo--;
		return item;
	}

	@Override
	public Integer topo() {
		if (isEmpty()) {
			return null;
		}
		return meusDados[topo];
	}

	@Override
	public PilhaIF<Integer> multitop(int k) {
		if (isEmpty() || k <= 0) {
			return new MinhaPilha();
		}
		MinhaPilha subPilha = new MinhaPilha(k);
		int count = 0;
		int index = topo;
		while (count < k && index >= 0) {
			try {
				subPilha.empilhar(meusDados[index]);
			} catch (PilhaCheiaException e) {
				// Não deve ocorrer, pois estamos criando uma nova pilha com tamanho k
			}
			index--;
			count++;
		}
		return subPilha;
	}

	@Override
	public boolean isEmpty() {
		return topo == -1;
	}
}

