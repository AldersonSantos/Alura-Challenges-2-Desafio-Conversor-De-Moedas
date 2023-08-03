package br.com.challenge.one.conversor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * super class conversor de moedas.
 * 
 * @author Alderson Santos
 *
 */

public class ConversorDeMoedas extends JFrame implements ActionListener {

	private static final long serialVersionUID = -2549117556670083627L;
	private JMenuBar menuBar2, menuBar1;
	private JMenu menu1, menu2;
	private JMenuItem m1Real, m1Euro, m1Libra, m1PesoAr, m1PesoCl, m1Dolar, m2Real, m2Euro, m2Libra, m2PesoAr, m2PesoCl,
			m2Dolar;
	private JTextField campoTextUsuario;
	private JLabel campoConversao, campoFormatInput, rotuloInputUser, taxaConversao;
	private String inputText;
	private int numeroCaracteres;
	JPanel painelTextUser, painelrotulo, painelMenu2, painelMenu1, painelRotulo1, painelTaxa;

	double textUsuario = 0.0;

	JButton buttonCe;

	/**
	 * construtor permite criar um Jframe
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
		this.getContentPane().add(painel);
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
		menu1.setIcon(null);
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

		// JLabel
		campoFormatInput = new JLabel();
		campoFormatInput.setBackground(null);
		campoFormatInput.setBorder(null);
		campoFormatInput.setFont(new Font("Arial", Font.BOLD, 30));
		// campoFormatInput.addKeyListener( this);

		// add JLabel
		campoConversao = new JLabel();
		campoConversao.setBackground(Color.blue);
		campoConversao.setForeground(Color.black);
		campoConversao.setFont(new Font("Arial", Font.BOLD, 45));
		campoConversao.setVisible(true);

		// JLabel digite valor
		rotuloInputUser = new JLabel();
		rotuloInputUser.setForeground(Color.black);
		rotuloInputUser.setText("Digite um valor válido e escolha a moeda");
		rotuloInputUser.setFont(new Font("Arial", Font.BOLD, 12));
		rotuloInputUser.setVisible(true);
		// rotuloInputUser.setBounds(200, 520, 123, 123);

		// Jlabel taxa
		taxaConversao = new JLabel("1 BRL = 0.2584 BRL");
		// taxaConversao.setBackground(Color.blue);
		taxaConversao.setForeground(Color.black);
		taxaConversao.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 11));
		taxaConversao.setVisible(true);

		// TTextField
		campoTextUsuario = new JTextField(10);
		campoTextUsuario.setBackground(null);
		campoTextUsuario.setBorder(null);
		campoTextUsuario.setFont(new Font("Arial", Font.BOLD, 55));
		campoTextUsuario.setForeground(null);
		campoTextUsuario.setText("1");
		// campoTextUsuario.setNavigationFilter(null);

		// Jpainel
		painelMenu2 = new JPanel();
		painelMenu2.setSize(200, 25);
		painelMenu2.setLocation(5, 95);
		painelMenu2.setBackground(Color.lightGray);
		painelMenu2.setBorder(null);
		painelMenu2.setForeground(null);
		this.add(painelMenu2);
		painelMenu2.add(menuBar1);

		// Jpainel1
		painelMenu1 = new JPanel();
		painelMenu1.setSize(200, 25);
		painelMenu1.setLocation(5, 230);
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
		painelTaxa.setLocation(5, 265);
		painelTaxa.setBackground(Color.lightGray);

		this.add(painelTaxa);
		painelTaxa.add(taxaConversao);

		// Jpanel3
		painelTextUser = new JPanel();
		painelTextUser.setSize(300, 40);
		painelTextUser.setLocation(5, 55);
		painelTextUser.setBackground(Color.lightGray);
		this.add(painelTextUser);
		painelTextUser.add(campoTextUsuario);

		// Jpanel4
		painelrotulo = new JPanel();
		painelrotulo.setSize(400, 50);
		painelrotulo.setLocation(-50, 30);
		painelrotulo.setBackground(Color.lightGray);
		this.add(painelrotulo);
		painelrotulo.add(rotuloInputUser);

	}

	/**
	 * Aumenta e diminui fonte do JTextField e JLabel de acordo com a quantidade de
	 * caracteres digitados.
	 * 
	 */
	// dimunir font
	public void fontText() {

		if (numeroCaracteres <= 10) {

			campoConversao.setFont(new Font("Arial", Font.BOLD, 35));
			campoTextUsuario.setFont(new Font("Arial", Font.CENTER_BASELINE, 40));

		} else

			campoConversao.setFont(new Font("Arial", Font.BOLD, 22));
		campoTextUsuario.setFont(new Font("Arial", Font.BOLD, 30));

	}

	/**
	 * Faz a conversao de moedas. limita a quantidade da String ".". Apaga texto
	 * digitado pelo usuario se o valor digitado conter mais de 1 ".".
	 * 
	 * @return
	 */
	// conversor de moedas
	public double conversor() {

		// taxa
		// real
		double taxaCambioRealReal = 1.00;
		double taxaCambioRealEuro = 0.1912;
		double taxaCambioRealPesoAr = 58.0304;
		double taxaCambioRealLibra = 0.164;
		double taxaCambioRealPesoCl = 177.3908;
		double taxaCambioRealDolar = 0.2081;
		// real JLabel taxa
		String realreal = "1 BRL = 1.00 BRL";
		String realeuro = "1 BRL = 0.1912 EUR";
		String realPesoAr = "1 BRL = 58.0304 ARS";
		String realLibra = "1 BRL = 0.164 GPB";
		String realPesoCl = "1 BRL = 177.3908 CLP";
		String realDolar = "1 BRL = 0.2081 USD";

		// euro
		double taxaCambioEuroEuro = 1.00;
		double taxaCambioEuroReal = 5.2267;
		double taxaCambioEuroLibra = 0.857;
		double taxaCambioEuroPesoAr = 303.3058;
		double taxaCambioEuroPesoCl = 927.1625;
		double taxaCambioEuroDolar = 1.1019;
		// euro JLabel taxa
		String euroEuro = "1 EUR = 1.00 EUR";
		String euroReal = "1 EUR = 5.2267 BRL";
		String euroLibra = "1 EUR = 0.857 GPB";
		String euroPesoAr = "1 EUR = 303.3058 ARS";
		String euroPesoCl = "1 EUR = 927.1625 CLP";
		String euroDolar = "1 EUR = 1.1019 USD";

		// libra
		double taxaCambioLibraLibra = 1.00;
		double taxaCambioLibraEuro = 1.1669;
		double taxaCambioLibraReal = 6.099;
		double taxaCambioLibraPesoAr = 353.9282;
		double taxaCambioLibraPesoCl = 1081.67;
		double taxaCambioLibraDolar = 1.2857;
		// Libra JLabel taxa
		String libraLibra = "1 GPB = 1.00  GPB";
		String libraEuro = "1 GPB = 1.1669 EUR";
		String libraReal = "1 GPB = 6.099 BRL";
		String libraPesoAr = "1 GPB = 353.9282 ARS";
		String libraPesoCl = "1 GPB = 1081.67 CLP";
		String libraDolar = "1 GPB 1.2857 USD";

		// peso argentino
		double taxaCambioPesoArPesoAr = 1.00;
		double taxaCambioPesoArReal = 0.01723;
		double taxaCambioPesoArPesoCl = 3.0566;
		double taxaCambioPesoArDolar = 0.0036;
		double taxaCambioPesoArEuro = 0.003297;
		double taxaCambioPesoArLibra = 0.002826;
		// peso argentino JLabel taxa
		String pesoArPesoAr = "1 ARS = 1.00 ARS";
		String pPesoArReal = " 1 ARS = 0.01723 BRL";
		String pesoArPesoCl = "1 ARS = 3.0566 CLP";
		String pesoArDolar = "1 ARS = 0.0036 USD";
		String pesoArEuro = "1 ARS =  0.003297 EUR";
		String pesoArLibra = "1 ARS = 0.002826 GPB";

		// peso chileno
		double taxaCambioPesoClPesoCl = 1.00;
		double taxaCambioPesoClReal = 0.005637;
		double taxaCambioPesoClEuro = 0.001079;
		double taxaCambioPesoClLibra = 0.0009245;
		double taxaCambioPesoClPesoAr = 0.3272;
		double taxaCambioPesoClDolar = 0.001189;
		// peso chileno JLabel taxa
		String pesoClPesoCl = "1 CLP = 1.00 CLP";
		String pesoClReal = " 1 CLP = 0.005637 BRL";
		String pesoClPesoAr = "1 CLP = 0.3272 ARS";
		String pesoClDolar = "1 CLP =  0.001189 USD";
		String pesoClEuro = "1 CLP = 0.001079 EUR";
		String pesoClLibra = "1 CLP = 0.0009245 GPB";

		// dolar
		double taxaCambioDolarReal = 4.7432;
		double taxaCambioDolarDolar = 1.00;
		double taxaCambioDolarEuro = 0.9075;
		double taxaCambioDolarLibra = 0.7778;
		double taxaCambioDolarPesoAr = 275.25;
		double taxaCambioDolarPesoCl = 841.33;
		// dolar JLabel taxa
		String dolarReal = "1 USD =  4.7432 BRL";
		String dolarDolar = "1 USD = 1.00 USD";
		String dolarEuro = "1 =  0.9075 EUR";
		String dolarLibra = " 1 USD = 0.7778 GPB";
		String dolarPesoAr = "1 USD = 275.25 ARS";
		String dolarPesoCl = "1 USD = 841.33 CLP";

		// conversor
		double conversor = 0.0;
		String taxaConversor = "";

		// input user
		inputText = campoTextUsuario.getText();
		String text = campoTextUsuario.getText();
		String charPonto = ".";
		int index1 = text.indexOf(".");
		int index2 = text.lastIndexOf(".");
		// verifivar se existe ponto na String
		boolean checkPonto = text.contentEquals(charPonto);

		
		// get texto		
		numeroCaracteres = campoTextUsuario.getText().length();
		
		// moeda	
		NumberFormat valorDouble = NumberFormat.getNumberInstance(getLocale());
		

		// apagar o valor se houver mais de um "ponto"
		if (text.contains(charPonto)) {

			String pontoMax = text.substring(index1, index2);
			int t = pontoMax.length();

			if (t > 0) {

				for (int i = 0; i <= text.length(); i++) {

					campoTextUsuario.setText(new String(campoTextUsuario.getText()).replace(text, "0"));
					campoTextUsuario.setSelectionStart(0);

				}

			}

		}

		// executar a conversao da moeda

		// apagar ponto
		if (checkPonto) {

			campoTextUsuario.setText(new String(campoTextUsuario.getText()).replaceAll(text, ""));
			campoTextUsuario.setSelectionStart(0);

		} else if (numeroCaracteres == 0) {

			conversor = 0;

		} else {

			// real => real
			if (menu1.getText() == m1Real.getText() && menu2.getText() == m2Real.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioRealReal;
				taxaConversor = String.format(realreal);

			}

			// real => euro
			if (menu1.getText() == m1Real.getText() && menu2.getText() == m2Euro.getText()) {

				conversor = Double.parseDouble(campoTextUsuario.getText()) * taxaCambioRealEuro;
				taxaConversor = String.format(realeuro);

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

		// atualiza a conversao da moeda no JLabel
		campoConversao.setText(valorDouble.format(conversor));
		taxaConversao.setText(taxaConversor);

		return conversor;

	}

	/**
	 * 
	 * detecta a escolha do usuario no JMenuItem e JMenuBar
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

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

}
