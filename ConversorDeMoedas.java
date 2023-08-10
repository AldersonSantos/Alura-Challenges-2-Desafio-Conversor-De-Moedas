package br.com.challenge.one.conversor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * super class conversor de moedas.
 * 
 * @author Alderson Santos
 *
 */

public class ConversorDeMoedas extends JFrame implements ActionListener, KeyListener {

	private static final long serialVersionUID = -2549117556670083627L;
	private JMenuBar menuBar2, menuBar1;
	private JMenu menu1, menu2;
	private JMenuItem m1Real, m1Euro, m1Libra, m1PesoAr, m1PesoCl, m1Dolar, m2Real, m2Euro, m2Libra, m2PesoAr, m2PesoCl,
			m2Dolar;
	private JTextField campoTextUsuario;
	private JLabel campoConversao, rotuloInputUser, taxaConversao;
	private String inputText;
	private int numeroCaracteres;
	private JPanel painelTextUser, painelrotulo, painelMenu2, painelMenu1, painelRotulo1, painelTaxa;
	private JButton exit;

	private NumberFormat valorDouble;

	/**
	 * * construtor permite criar um Jframe
	 * 
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	// construtor
	public ConversorDeMoedas(int x, int y, int w, int h) {

		exibirMenu();
		// frame
		this.setSize(x, y);
		this.setLocation(w, h);
		this.setResizable(false);
		this.setTitle("Conversor De Moedas");

		// panel
		JPanel painel = new JPanel();
		painel.setBackground(Color.lightGray);
		Border borda = BorderFactory.createEmptyBorder();
		painel.setBorder(borda);
		this.add(painel);

		// tipo de String e quantidade
		campoTextUsuario.setDocument(new ImputNumbers(15, ImputNumbers.CampoTexto.INPUTVALOR));

		// fechar aplicacao
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * 
	 * Contem todos os componentes a ser exibito no Jframe: JMenuBar JMenuItem
	 * JLabel JPanel JTextField
	 */
	//
	public void exibirMenu() {

		// iniciarJMenuBar
		// menu1
		menuBar1 = new JMenuBar();
		m1Real = new JMenuItem("Brasil - Real".concat("   BRL"));
		m1Euro = new JMenuItem("Europa - Euro".concat("   EUR"));
		m1Libra = new JMenuItem("Reino Unido - Libra Esterlinas".concat("   GPB"));
		m1PesoAr = new JMenuItem("Argentina - Peso Argentino".concat("   ARS"));
		m1PesoCl = new JMenuItem("Chile - Peso Chileno".concat("   CLP"));
		m1Dolar = new JMenuItem("Estados Unidos - Dolar".concat("   USD"));

		// menu2
		menuBar2 = new JMenuBar();
		menuBar2.setBackground(Color.GRAY);
		m2Real = new JMenuItem("Brasil - Real".concat("   BRL"));
		m2Euro = new JMenuItem("Europa - Euro".concat("   EUR"));
		m2Libra = new JMenuItem("Reino Unido - Libra Esterlinas".concat("   GPB"));
		m2PesoAr = new JMenuItem("Argentina - Peso Argentino".concat("   ARS"));
		m2PesoCl = new JMenuItem("Chile - Peso Chileno".concat("   CLP"));
		m2Dolar = new JMenuItem("Estados Unidos - Dolar".concat("   USD"));

		// action
		m1Real.addActionListener(this);
		m1Euro.addActionListener(this);
		m1Libra.addActionListener(this);
		m1PesoAr.addActionListener(this);
		m1PesoCl.addActionListener(this);
		m1Dolar.addActionListener(this);
		m2Real.addActionListener(this);
		m2Euro.addActionListener(this);
		m2Libra.addActionListener(this);
		m2PesoAr.addActionListener(this);
		m2PesoCl.addActionListener(this);
		m2Dolar.addActionListener(this);

		// iniciar JMenu 1
		// nomeM1 = opcao1.getText();
		menu1 = new JMenu("De");
		menu1.setOpaque(true);
		menu1.setBackground(Color.lightGray);
		menu1.setFont(new Font("Arial", Font.BOLD, 12));

		menuBar1.add(menu1);
		menu1.add(m1Real);
		menu1.addSeparator();
		menu1.add(m1Euro);
		menu1.addSeparator();
		menu1.add(m1Libra);
		menu1.addSeparator();
		menu1.add(m1PesoAr);
		menu1.addSeparator();
		menu1.add(m1PesoCl);
		menu1.addSeparator();
		menu1.add(m1Dolar);

		// iniciar JMenu 2
		menu2 = new JMenu("Para");
		menu2.setOpaque(true);
		menu2.setBackground(Color.lightGray);
		menu2.setFont(new Font("Arial", Font.BOLD, 12));

		menuBar2.add(menu2);
		menu2.add(m2Real);
		menu2.addSeparator();
		menu2.add(m2Euro);
		menu2.addSeparator();
		menu2.add(m2Libra);
		menu2.addSeparator();
		menu2.add(m2PesoAr);
		menu2.addSeparator();
		menu2.add(m2PesoCl);
		menu2.addSeparator();
		menu2.add(m2Dolar);

		// JLabel valor conversao
		campoConversao = new JLabel();
		campoConversao.setForeground(Color.black);
		campoConversao.setFont(new Font("Arial", Font.BOLD, 45));
		campoConversao.setVisible(true);

		// JLabel digite valor
		rotuloInputUser = new JLabel();
		rotuloInputUser.setForeground(Color.black);
		rotuloInputUser.setText("Digite um valor válido e escolha a moeda");
		rotuloInputUser.setFont(new Font("Arial", Font.ITALIC, 12));
		rotuloInputUser.setVisible(true);

		// Jlabel taxa
		taxaConversao = new JLabel("1 BRL = 0.2584 BRL");
		taxaConversao.setForeground(Color.black);
		taxaConversao.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 11));
		taxaConversao.setVisible(true);

		// TTextField input user
		campoTextUsuario = new JTextField(10);
		campoTextUsuario.setBackground(null);
		campoTextUsuario.setBorder(null);
		campoTextUsuario.setForeground(Color.black);
		campoTextUsuario.setText("");
		campoTextUsuario.addKeyListener(this);

		// Jpainel
		painelMenu2 = new JPanel();
		painelMenu2.setSize(200, 25);
		painelMenu2.setLocation(50, 95);
		painelMenu2.setBackground(Color.lightGray);
		painelMenu2.setBorder(null);
		painelMenu2.setForeground(null);
		this.add(painelMenu2);
		painelMenu2.add(menuBar1);

		// Jpainel1
		painelMenu1 = new JPanel();
		painelMenu1.setSize(200, 25);
		painelMenu1.setLocation(50, 230);
		painelMenu1.setBackground(Color.lightGray);
		this.add(painelMenu1);
		painelMenu1.add(menuBar2);

		// Jpanel2
		painelRotulo1 = new JPanel();
		painelRotulo1.setSize(300, 40);
		painelRotulo1.setLocation(5, 190);
		painelRotulo1.setBackground(Color.lightGray);
		this.add(painelRotulo1);
		painelRotulo1.add(campoConversao);

		// JPanel4
		painelTaxa = new JPanel();
		painelTaxa.setSize(150, 25);
		painelTaxa.setLocation(75, 265);
		painelTaxa.setBackground(Color.lightGray);
		this.add(painelTaxa);
		painelTaxa.add(taxaConversao);

		// Jpanel3
		painelTextUser = new JPanel();
		painelTextUser.setSize(285, 40);
		painelTextUser.setLocation(145, 55);
		painelTextUser.setBackground(Color.lightGray);
		this.add(painelTextUser);
		painelTextUser.add(campoTextUsuario);

		// Jpanel4
		painelrotulo = new JPanel();
		painelrotulo.setSize(280, 20);
		painelrotulo.setLocation(15, 30);
		painelrotulo.setBackground(Color.lightGray);
		this.add(painelrotulo);
		painelrotulo.add(rotuloInputUser);

		// JButton sair
		exit = new JButton();
		exit.setBounds(267, 318, 30, 30);
		exit.setText("SAIR");
		Border borda = BorderFactory.createLineBorder(Color.DARK_GRAY, 1);
		exit.setBorder(borda);
		exit.setForeground(Color.LIGHT_GRAY);
		exit.setFont(new Font("Arial", Font.CENTER_BASELINE, 10));
		exit.setBackground(Color.gray);
		exit.setOpaque(true);
		exit.addActionListener(this);
		this.add(exit);

	}

	/**
	 * Aumenta e diminui fonte do JTextField e JLabel de acordo com a quantidade de
	 * caracteres digitados.
	 * 
	 */
	// dimunir font
	public void fontText() {

		if (numeroCaracteres <= 10) {
			campoConversao.setFont(new Font("Arial", Font.CENTER_BASELINE, 27));
			campoTextUsuario.setFont(new Font("Arial", Font.CENTER_BASELINE, 32));

		} else if (numeroCaracteres > 10) {
			campoConversao.setFont(new Font("Arial", Font.CENTER_BASELINE, 22));
			campoTextUsuario.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
		}

	}

	/**
	 * Faz a conversao de moedas. limita a quantidade da String ".". Apaga texto
	 * digitado pelo usuario se o valor digitado conter mais de 1 ".".
	 * 
	 *
	 */
	// conversor de moedas
	public void conversor() {

		// taxa
		// real
		double taxaCambioRealReal = Double.valueOf(1.00);
		double taxaCambioRealEuro = Double.valueOf(0.1912);
		double taxaCambioRealPesoAr = Double.valueOf(58.0304);
		double taxaCambioRealLibra = Double.valueOf(0.164);
		double taxaCambioRealPesoCl = Double.valueOf(177.3908);
		double taxaCambioRealDolar = Double.valueOf(0.2081);
		// real JLabel taxa
		String realReal = "1 BRL = 1.00 BRL";
		String realEuro = "1 BRL = 0.1912 EUR";
		String realPesoAr = "1 BRL = 58.0304 ARS";
		String realLibra = "1 BRL = 0.164 GPB";
		String realPesoCl = "1 BRL = 177.3908 CLP";
		String realDolar = "1 BRL = 0.2081 USD";

		// euro
		double taxaCambioEuroEuro = Double.valueOf(1.00);
		double taxaCambioEuroReal = Double.valueOf(5.2267);
		double taxaCambioEuroLibra = Double.valueOf(0.857);
		double taxaCambioEuroPesoAr = Double.valueOf(303.3058);
		double taxaCambioEuroPesoCl = Double.valueOf(927.1625);
		double taxaCambioEuroDolar = Double.valueOf(1.1019);
		// euro JLabel taxa
		String euroEuro = "1 EUR = 1.00 EUR";
		String euroReal = "1 EUR = 5.2267 BRL";
		String euroLibra = "1 EUR = 0.857 GPB";
		String euroPesoAr = "1 EUR = 303.3058 ARS";
		String euroPesoCl = "1 EUR = 927.1625 CLP";
		String euroDolar = "1 EUR = 1.1019 USD";

		// libra
		double taxaCambioLibraLibra = Double.valueOf(1.00);
		double taxaCambioLibraEuro = Double.valueOf(1.1669);
		double taxaCambioLibraReal = Double.valueOf(6.099);
		double taxaCambioLibraPesoAr = Double.valueOf(353.9282);
		double taxaCambioLibraPesoCl = Double.valueOf(1081.67);
		double taxaCambioLibraDolar = Double.valueOf(1.2857);
		// Libra JLabel taxa
		String libraLibra = "1 GPB = 1.00  GPB";
		String libraEuro = "1 GPB = 1.1669 EUR";
		String libraReal = "1 GPB = 6.099 BRL";
		String libraPesoAr = "1 GPB = 353.9282 ARS";
		String libraPesoCl = "1 GPB = 1081.67 CLP";
		String libraDolar = "1 GPB 1.2857 USD";

		// peso argentino
		double taxaCambioPesoArPesoAr = Double.valueOf(1.00);
		double taxaCambioPesoArReal = Double.valueOf(0.01723);
		double taxaCambioPesoArPesoCl = Double.valueOf(3.0566);
		double taxaCambioPesoArDolar = Double.valueOf(0.0036);
		double taxaCambioPesoArEuro = Double.valueOf(0.003297);
		double taxaCambioPesoArLibra = Double.valueOf(0.002826);
		// peso argentino JLabel taxa
		String pesoArPesoAr = "1 ARS = 1.00 ARS";
		String pPesoArReal = " 1 ARS = 0.01723 BRL";
		String pesoArPesoCl = "1 ARS = 3.0566 CLP";
		String pesoArDolar = "1 ARS = 0.0036 USD";
		String pesoArEuro = "1 ARS =  0.003297 EUR";
		String pesoArLibra = "1 ARS = 0.002826 GPB";

		// peso chileno
		double taxaCambioPesoClPesoCl = Double.valueOf(1.00);
		double taxaCambioPesoClReal = Double.valueOf(0.005637);
		double taxaCambioPesoClEuro = Double.valueOf(0.001079);
		double taxaCambioPesoClLibra = Double.valueOf(0.0009245);
		double taxaCambioPesoClPesoAr = Double.valueOf(0.3272);
		double taxaCambioPesoClDolar = Double.valueOf(0.001189);
		// peso chileno JLabel taxa
		String pesoClPesoCl = "1 CLP = 1.00 CLP";
		String pesoClReal = " 1 CLP = 0.005637 BRL";
		String pesoClPesoAr = "1 CLP = 0.3272 ARS";
		String pesoClDolar = "1 CLP =  0.001189 USD";
		String pesoClEuro = "1 CLP = 0.001079 EUR";
		String pesoClLibra = "1 CLP = 0.0009245 GPB";

		// dolar
		double taxaCambioDolarReal = Double.valueOf(4.7432);
		double taxaCambioDolarDolar = Double.valueOf(1.00);
		double taxaCambioDolarEuro = Double.valueOf(0.9075);
		double taxaCambioDolarLibra = Double.valueOf(0.7778);
		double taxaCambioDolarPesoAr = Double.valueOf(275.25);
		double taxaCambioDolarPesoCl = Double.valueOf(841.33);
		// dolar JLabel taxa
		String dolarReal = "1 USD =  4.7432 BRL";
		String dolarDolar = "1 USD = 1.00 USD";
		String dolarEuro = "1 USD  0.9075 EUR";
		String dolarLibra = " 1 USD = 0.7778 GPB";
		String dolarPesoAr = "1 USD = 275.25 ARS";
		String dolarPesoCl = "1 USD = 841.33 CLP";

		// conversor
		double conversor = Double.valueOf(0.0);
		String taxaConversor = "";

		// input user
		inputText = campoTextUsuario.getText();
		String text = campoTextUsuario.getText();
		String charPonto = ".";
		int index1 = text.indexOf(".");
		int index2 = text.lastIndexOf(".");

		// get texto
		numeroCaracteres = campoTextUsuario.getText().length();

		// verifivar se existe ponto na String
		boolean checkPonto = text.contentEquals(charPonto);

		// apagar o valor se houver mais de um "ponto"
		if (text.contains(charPonto)) {

			String pontoMax = text.substring(index1, index2);
			int t = pontoMax.length();

			if (t > 0) {

				for (int i = 0; i <= text.length(); i++) {

					campoTextUsuario.setText(new String(campoTextUsuario.getText()).replace(text, "0"));
					painelTextUser.setLocation(145, 55);
					campoTextUsuario.setSelectionStart(0);

				}
				// alerta valor inválido
				JOptionPane.showMessageDialog(campoConversao, "Digite novamente", "Valor inválido!",
						JOptionPane.ERROR_MESSAGE);

			}

		}

		// executar a conversao da moeda
		if (numeroCaracteres == 0) {

			conversor = Double.valueOf(0.0);

		} else if (checkPonto) {// apagar ponto

			campoTextUsuario.setText(new String(campoTextUsuario.getText()).replaceAll(text, ""));
			campoTextUsuario.setSelectionStart(0);

		} else {

			// real => real
			if (menu1.getText() == m1Real.getText() && menu2.getText() == m2Real.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioRealReal;
				taxaConversor = String.format(realReal);

			}

			// real => euro
			if (menu1.getText() == m1Real.getText() && menu2.getText() == m2Euro.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioRealEuro;
				taxaConversor = String.format(realEuro);

				// euro => real
			} else if (menu1.getText() == m1Euro.getText() && menu2.getText() == m2Real.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioEuroReal;
				taxaConversor = String.format(euroReal);
			}

			// real => libra
			if (menu1.getText() == m1Real.getText() && menu2.getText() == m2Libra.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioRealLibra;
				taxaConversor = String.format(realLibra);

			} else if (menu1.getText() == m1Libra.getText() && menu2.getText() == m2Real.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioLibraReal;
				taxaConversor = String.format(libraReal);
			}

			// real => PesoArgentino
			if (menu1.getText() == m1Real.getText() && menu2.getText() == m2PesoAr.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioRealPesoAr;
				taxaConversor = String.format(realPesoAr);

			} else if (menu1.getText() == m1PesoAr.getText() && menu2.getText() == m2Real.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioPesoArReal;
				taxaConversor = String.format(pPesoArReal);
			}

			// real => PesoChileno
			if (menu1.getText() == m1Real.getText() && menu2.getText() == m2PesoCl.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioRealPesoCl;
				taxaConversor = String.format(realPesoCl);

			} else if (menu1.getText() == m1PesoCl.getText() && menu2.getText() == m2Real.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioPesoClReal;
				taxaConversor = String.format(pesoClReal);
			}

			// real => Dolar
			if (menu1.getText() == m1Real.getText() && menu2.getText() == m2Dolar.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioRealDolar;
				taxaConversor = String.format(realDolar);

			} else if (menu1.getText() == m1Dolar.getText() && menu2.getText() == m2Real.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioDolarReal;
				taxaConversor = String.format(dolarReal);
			}

			// euro => euro
			if (menu1.getText() == m1Euro.getText() && menu2.getText() == m2Euro.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioEuroEuro;
				taxaConversor = String.format(euroEuro);
			}

			// euro => libra
			if (menu1.getText() == m1Euro.getText() && menu2.getText() == m2Libra.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioEuroLibra;
				taxaConversor = String.format(euroLibra);
			} else if (menu1.getText() == m1Libra.getText() && menu2.getText() == m2Euro.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioLibraEuro;
				taxaConversor = String.format(libraEuro);
			}

			// euro => peso argentino
			if (menu1.getText() == m1Euro.getText() && menu2.getText() == m2PesoAr.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioEuroPesoAr;
				taxaConversor = String.format(euroPesoAr);
			} else if (menu1.getText() == m1PesoAr.getText() && menu2.getText() == m2Euro.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioPesoArEuro;
				taxaConversor = String.format(pesoArEuro);
			}

			// euro => peso chileno
			if (menu1.getText() == m1Euro.getText() && menu2.getText() == m2PesoCl.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioEuroPesoCl;
				taxaConversor = String.format(euroPesoCl);
			} else if (menu1.getText() == m1PesoCl.getText() && menu2.getText() == m2Euro.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioPesoClEuro;
				taxaConversor = String.format(pesoClEuro);
			}

			// euro => Dolar
			if (menu1.getText() == m1Euro.getText() && menu2.getText() == m2Dolar.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioEuroDolar;
				taxaConversor = String.format(euroDolar);
			} else if (menu1.getText() == m1Dolar.getText() && menu2.getText() == m2Euro.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioDolarEuro;
				taxaConversor = String.format(dolarEuro);
			}

			// Libra => libra
			if (menu1.getText() == m1Libra.getText() && menu2.getText() == m2Libra.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioLibraLibra;
				taxaConversor = String.format(libraLibra);
			}

			// Libra => peso argentino
			if (menu1.getText() == m1Libra.getText() && menu2.getText() == m2PesoAr.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioLibraPesoAr;
				taxaConversor = String.format(libraPesoAr);
			} else if (menu1.getText() == m1PesoAr.getText() && menu2.getText() == m2Libra.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioPesoArLibra;
				taxaConversor = String.format(pesoArLibra);
			}

			// libra => peso chileno
			if (menu1.getText() == m1Libra.getText() && menu2.getText() == m2PesoCl.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioLibraPesoCl;
				taxaConversor = String.format(libraPesoCl);
			} else if (menu1.getText() == m1PesoCl.getText() && menu2.getText() == m2Libra.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioPesoClLibra;
				taxaConversor = String.format(pesoClLibra);
			}

			// libra => Dolar
			if (menu1.getText() == m1Libra.getText() && menu2.getText() == m2Dolar.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioLibraDolar;
				taxaConversor = String.format(libraDolar);
			} else if (menu1.getText() == m1Dolar.getText() && menu2.getText() == m2Libra.getText()) {

				conversor = Double.parseDouble(inputText) * taxaCambioDolarLibra;
				taxaConversor = String.format(dolarLibra);
			}

			// peso argentino => peso argentino
			if (menu1.getText() == m1PesoAr.getText() && menu2.getText() == m2PesoAr.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioPesoArPesoAr;
				taxaConversor = String.format(pesoArPesoAr);
			}

			// peso argentino => peso chileno
			if (menu1.getText() == m1PesoAr.getText() && menu2.getText() == m2PesoCl.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioPesoArPesoCl;
				taxaConversor = String.format(pesoArPesoCl);
			} else if (menu1.getText() == m1PesoCl.getText() && menu2.getText() == m2PesoAr.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioPesoClPesoAr;
				taxaConversor = String.format(pesoClPesoAr);
			}

			// peso argentino => Dolar
			if (menu1.getText() == m1PesoAr.getText() && menu2.getText() == m2Dolar.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioPesoArDolar;
				taxaConversor = String.format(pesoArDolar);
			} else if (menu1.getText() == m1Dolar.getText() && menu2.getText() == m2PesoAr.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioDolarPesoAr;
				taxaConversor = String.format(dolarPesoAr);
			}

			// peso chileno => peso chileno
			if (menu1.getText() == m1PesoCl.getText() && menu2.getText() == m2PesoCl.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioPesoClPesoCl;
				taxaConversor = String.format(pesoClPesoCl);
			}

			// peso chileno => Dolar
			if (menu1.getText() == m1PesoCl.getText() && menu2.getText() == m2Dolar.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioPesoClDolar;
				taxaConversor = String.format(pesoClDolar);
			} else if (menu1.getText() == m1Dolar.getText() && menu2.getText() == m2PesoCl.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioDolarPesoCl;
				taxaConversor = String.format(dolarPesoCl);
			}

			// peso Dolar => Dolar
			if (menu1.getText() == m1Dolar.getText() && menu2.getText() == m2Dolar.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioDolarDolar;
				taxaConversor = String.format(dolarDolar);
			}
		}

		// conversao com 2 casas decimais
		if (conversor < 1000) {
			valorDouble = new DecimalFormat("0.00");

		} else {

			valorDouble = new DecimalFormat("0,000.00");
		}

		// atualiza a conversao da moeda no JLabel
		campoConversao.setText(valorDouble.format(conversor));
		taxaConversao.setText(taxaConversor);

	}

	/**
	 * 
	 * detecta a escolha do usuario no JMenuItem e JMenuBar
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand() == exit.getActionCommand()) {
			System.exit(0);
		}

		if (m1Real.isArmed()) {
			menu1.setText(e.getActionCommand());
		}

		if (m1Euro.isArmed()) {
			menu1.setText(e.getActionCommand());
		}

		if (m1Libra.isArmed()) {
			menu1.setText(e.getActionCommand());
		}
		if (m1PesoAr.isArmed()) {
			menu1.setText(e.getActionCommand());
		}
		if (m1PesoCl.isArmed()) {
			menu1.setText(e.getActionCommand());
		}
		if (m1Dolar.isArmed()) {
			menu1.setText(e.getActionCommand());
		}

		if (m2Real.isArmed()) {
			menu2.setText(e.getActionCommand());
		}

		if (m2Euro.isArmed()) {
			menu2.setText(e.getActionCommand());
		}

		if (m2Libra.isArmed()) {
			menu2.setText(e.getActionCommand());
		}

		if (m2PesoAr.isArmed()) {
			menu2.setText(e.getActionCommand());
		}

		if (m2PesoCl.isArmed()) {
			menu2.setText(e.getActionCommand());
		}

		if (m2Dolar.isArmed()) {
			menu2.setText(e.getActionCommand());
		}

		conversor();
		fontText();
	}

	/**
	 * 
	 * move o JPanel texto usuario quando digita
	 * 
	 */
	@Override
	public void keyTyped(KeyEvent e) {

		// mover JTextField
		int jTexLocalX = painelTextUser.getLocation().x;
		int jTexLocalH = Integer.valueOf(55);
		int jTexLimiteL = Integer.valueOf(137);
		int jTexLimiteR = Integer.valueOf(25);
		int changeLocalX = jTexLocalX - 8;
		int changeLocalR = jTexLocalX + 8;

		// KeyEvent
		int x = KeyEvent.VK_BACK_SPACE;
		char t = e.getKeyChar();

		// code char key
		List<Number> number = new ArrayList<Number>();
		number.add(46);
		number.add(48);
		number.add(49);
		number.add(50);
		number.add(51);
		number.add(52);
		number.add(53);
		number.add(54);
		number.add(55);
		number.add(56);
		number.add(57);

		// mover se apertar key ou apagar string
		if (t == x && jTexLocalX <= jTexLimiteL) {

			painelTextUser.setLocation(changeLocalR, jTexLocalH);

		} else {

			for (Number ref : number) {

				if (t == ref.hashCode() && jTexLocalX >= jTexLimiteR) {

					painelTextUser.setLocation(changeLocalX, jTexLocalH);
				}
			}
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
