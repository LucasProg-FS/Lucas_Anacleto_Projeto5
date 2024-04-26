package tad.pilha;

public class MinhaPilha implements PilhaIF<Integer> {

	private int tamanho = 10;
	private Integer[] meusDados = null;
	private int topo = -1;

	/**
	 * Construtor que inicializa a pilha com um tamanho específico.
	 *
	 * @param tamanho o tamanho inicial da pilha.
	 */
	public MinhaPilha(int tamanho) {
		this.tamanho = tamanho;
		this.meusDados = new Integer[tamanho];
	}

	/**
	 * Construtor padrão que inicializa a pilha com tamanho 10.
	 */
	public MinhaPilha() {
		this.meusDados = new Integer[tamanho];
	}

	/**
	 * Empilha um item na pilha.
	 *
	 * @param item o item a ser empilhado.
	 * @throws PilhaCheiaException se a pilha estiver cheia.
	 */
	@Override
	public void empilhar(Integer item) throws PilhaCheiaException {
		if (topo == tamanho - 1) {
			throw new PilhaCheiaException();
		}
		topo++;
		meusDados[topo] = item;
	}

	/**
	 * Desempilha um item da pilha.
	 *
	 * @return o item desempilhado.
	 * @throws PilhaVaziaException se a pilha estiver vazia.
	 */
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

	/**
	 * Retorna o elemento no topo da pilha sem removê-lo.
	 *
	 * @return o elemento no topo da pilha.
	 */
	@Override
	public Integer topo() {
		if (isEmpty()) {
			return null;
		}
		return meusDados[topo];
	}

	/**
	 * Retorna uma nova pilha contendo os k elementos no topo da pilha atual.
	 *
	 * @param k o número de elementos a serem copiados para a nova pilha.
	 * @return uma nova pilha contendo os k elementos do topo da pilha atual.
	 */
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

	/**
	 * Verifica se a pilha está vazia.
	 *
	 * @return true se a pilha estiver vazia, caso contrário false.
	 */
	@Override
	public boolean isEmpty() {
		return topo == -1;
	}
}

