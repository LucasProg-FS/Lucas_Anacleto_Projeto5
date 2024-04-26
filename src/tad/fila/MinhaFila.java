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

	public MinhaFila(int tamanhoInicial) {
		tamanho = tamanhoInicial;
		meusDados = new Integer[tamanho];
	}

	public MinhaFila() {
		this(10); // Tamanho padrão de 10 se não for especificado
	}

	@Override
	public void enfileirar(Integer item) throws FilaCheiaException {
		if (isFull()) {
			throw new FilaCheiaException();
		}
		meusDados[cauda] = item;
		cauda = (cauda + 1) % tamanho; // Avança a cauda e aplica circularidade
	}

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

	@Override
	public Integer verificarCauda() {
		if (isEmpty()) {
			return null;
		}
		return meusDados[(cauda - 1 + tamanho) % tamanho];
	}

	@Override
	public Integer verificarCabeca() {
		if (isEmpty()) {
			return null;
		}
		return meusDados[cabeca];
	}

	@Override
	public boolean isEmpty() {
		return cabeca == cauda;
	}

	@Override
	public boolean isFull() {
		return (cauda + 1) % tamanho == cabeca;
	}
}

