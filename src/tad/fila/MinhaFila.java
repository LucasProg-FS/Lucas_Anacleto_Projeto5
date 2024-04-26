package tad.fila;

/**
 * Fila deve ser implementada com array fixo e estratégia circular
 * de gerenciamento de apontadores de cauda e cabeça.
 * @author fabioleite
 *
 */
public class MinhaFila implements FilaIF<Integer> {

	private int tamanho;
	private int cauda = 0;
	private int cabeca = 0;
	private Integer[] meusDados;

	/**
	 * Construtor que inicializa a fila com um tamanho específico.
	 *
	 * @param tamanhoInicial o tamanho inicial da fila.
	 */
	public MinhaFila(int tamanhoInicial) {
		tamanho = tamanhoInicial;
		meusDados = new Integer[tamanho];
	}

	/**
	 * Construtor padrão que inicializa a fila com tamanho 10.
	 */
	public MinhaFila() {
		this(10); // Tamanho padrão de 10 se não for especificado
	}


	/**
	 * Adiciona um item à fila.
	 *
	 * @param item o item a ser enfileirado na fila.
	 * @throws FilaCheiaException se a fila estiver cheia.
	 */
	@Override
	public void enfileirar(Integer item) throws FilaCheiaException {
		if (isFull()) {
			throw new FilaCheiaException();
		}
		meusDados[cauda] = item;
		cauda = (cauda + 1) % tamanho; // Avança a cauda e aplica circularidade
	}

	/**
	 * Remove e retorna o elemento na frente da fila.
	 *
	 * @return o elemento desenfileirado.
	 * @throws FilaVaziaException se a fila estiver vazia.
	 */
	@Override
	public Integer desenfileirar() throws FilaVaziaException {
		if (isEmpty()) {
			throw new FilaVaziaException("A fila está vazia");
		}
		Integer item = meusDados[cabeca];
		meusDados[cabeca] = null; // Remove o item da fila
		cabeca = (cabeca + 1) % tamanho; // Avança a cabeça e aplica circularidade
		return item;
	}

	/**
	 * Retorna o elemento na cauda da fila sem removê-lo.
	 *
	 * @return o elemento na cauda da fila.
	 */
	@Override
	public Integer verificarCauda() {
		if (isEmpty()) {
			return null;
		}
		return meusDados[(cauda - 1 + tamanho) % tamanho];
	}

	/**
	 * Retorna o elemento na cabeça da fila sem removê-lo.
	 *
	 * @return o elemento na cabeça da fila.
	 */
	@Override
	public Integer verificarCabeca() {
		if (isEmpty()) {
			return null;
		}
		return meusDados[cabeca];
	}

	/**
	 * Verifica se a fila está vazia.
	 *
	 * @return true se a fila estiver vazia, caso contrário false.
	 */
	@Override
	public boolean isEmpty() {
		return cabeca == cauda;
	}

	/**
	 * Verifica se a fila está cheia.
	 *
	 * @return true se a fila estiver cheia, caso contrário false.
	 */
	@Override
	public boolean isFull() {
		return (cauda + 1) % tamanho == cabeca;
	}
}

