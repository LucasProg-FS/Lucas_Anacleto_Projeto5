package tad.fila;

/**
 * Fila deve ser implementada com array fixo e estratégia circular
 * de gerenciamento de apontadores de cauda e cabeça.
 * @author fabioleite
 *
 */
public class MinhaFila implements FilaIF<Integer> {

	private int tamanho = 10;
	private int cauda = 1;
	private int cabeca = 0;
	private Integer[] meusDados = null;

	public MinhaFila(int tamanhoInicial) {
		tamanho = tamanhoInicial;
		meusDados = new Integer[tamanho];
	}

	public MinhaFila() {
		meusDados = new Integer[tamanho];
	}

	@Override
	public void enfileirar(Integer item) throws FilaCheiaException {
		if (isFull()) {
			throw new FilaCheiaException();
		}
		cauda = (cauda + 1) % tamanho;
		meusDados[cauda] = item;
	}


	@Override
	public Integer desenfileirar() {
		throw new UnsupportedOperationException("Implementar");
	}

	@Override
	public Integer verificarCauda() {
		throw new UnsupportedOperationException("Implementar");
	}

	@Override
	public Integer verificarCabeca() {
		throw new UnsupportedOperationException("Implementar");
	}

	@Override
	public boolean isEmpty() {
		throw new UnsupportedOperationException("Implementar");
	}

	@Override
	public boolean isFull() {
		throw new UnsupportedOperationException("Implementar");
	}

}
