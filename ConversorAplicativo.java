package br.com.challenge.one.conversor;

/**
 * Executa o conversor de moedas.
 * @author Alderson Santos
 *
 */
public class ConversorAplicativo {	
	
	/**
	 * Executa o conversor de moedas.
	 * @param args
	 */
	public static void main(String[] args) {
		
		//JFrame
		ConversorDeMoedas app = new ConversorDeMoedas(326,400, 400,20);		
		app.setVisible(true);
		
	//conversor metodo
		app.actionPerformed(null);
		app.conversor();		
		
	}

}
