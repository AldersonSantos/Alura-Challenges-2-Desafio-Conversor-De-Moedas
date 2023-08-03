package br.com.challenge.one.conversor;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * Limita quantidade de caracteres.
 * @author Alderson Santos
 *
 */
public class ImputNumbers extends PlainDocument {

	private static final long serialVersionUID = 1L;

	// Enum com tipo de dados da classe
	public enum CampoTexto {

		INPUTVALOR;
	}

	// variáveis
	private int maxCaracters;
	private CampoTexto texto;

	/**
	 * construtor
	 * @param maxCaracters
	 * @param texto
	 */
	// construtor
	public ImputNumbers(int maxCaracters, CampoTexto texto) {
		this.maxCaracters = maxCaracters;
		this.texto = texto;

	}

	/**
	 * Configura o regex para aceitar numero  de 1-9 e ponto.
	 * Limita a quantidade de caracteres digitado pelo usuario.	 
	 * 
	 */
	// configurar tipo de caracteres e quantidade da String
	@Override
	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {

		if (str == null || getLength() == maxCaracters) {
			return;
		}
		int totalCaracteres = getLength() + str.length();

		// filtro de caracters
		String regex = "";
		switch (texto) {
		case INPUTVALOR:
			regex = "[^0-9.]";
			break;

		}
		str = str.replaceAll(regex, "");

		if (totalCaracteres <= maxCaracters) {

			super.insertString(offs, str, a);
		} else {

			String maxCaracters = str.substring(0, totalCaracteres);
			super.insertString(offs, maxCaracters, a);
		}

	}

}
