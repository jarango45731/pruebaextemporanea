import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

enum Action {
	Suma,
	Resta,
	Multiplicacion,
	Division
}

public class MainApp {

	private JFrame frame;
	private JTextField textFieldNumero1;
	private JTextField textFieldNumero2;
	private JTextField textFieldResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp window = new MainApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainApp() {
		initialize();
	}
	
	private void runAction(Action action) {
		double numero1;
		double numero2;
		try {
			numero1 = Double.parseDouble(this.textFieldNumero1.getText());
			numero2 = Double.parseDouble(this.textFieldNumero2.getText());
		 } catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Número inválido");
	        return;
	    }
		double resultado = 0;
		switch(action) {
			case Suma:
				resultado = numero1 + numero2;
				break;
			case Resta:
				resultado = numero1 - numero2;
				break;
			case Multiplicacion:
				resultado = numero1 * numero2;
				break;
			case Division:
				resultado = numero1 / numero2;
				break;
		}
		this.textFieldResultado.setText(String.format ("%.3f", resultado));
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textFieldNumero1 = new JTextField();
		textFieldNumero1.setBounds(208, 29, 130, 26);
		frame.getContentPane().add(textFieldNumero1);
		textFieldNumero1.setColumns(10);
		
		JLabel lblPrimerNmero = new JLabel("Primer número");
		lblPrimerNmero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrimerNmero.setBounds(96, 34, 100, 16);
		frame.getContentPane().add(lblPrimerNmero);
		
		JLabel lblSegundoNmero = new JLabel("Segundo número");
		lblSegundoNmero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSegundoNmero.setBounds(82, 79, 114, 16);
		frame.getContentPane().add(lblSegundoNmero);
		
		textFieldNumero2 = new JTextField();
		textFieldNumero2.setColumns(10);
		textFieldNumero2.setBounds(208, 74, 130, 26);
		frame.getContentPane().add(textFieldNumero2);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblResultado.setBounds(82, 117, 114, 16);
		frame.getContentPane().add(lblResultado);
		
		textFieldResultado = new JTextField();
		textFieldResultado.setColumns(10);
		textFieldResultado.setEditable(false);
		textFieldResultado.setBounds(208, 112, 130, 26);
		frame.getContentPane().add(textFieldResultado);
		
		JButton buttonSumar = new JButton("+");
		buttonSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainApp.this.runAction(Action.Suma);
			}
		});
		buttonSumar.setBounds(108, 165, 54, 29);
		frame.getContentPane().add(buttonSumar);
		
		JButton buttonRestar = new JButton("-");
		buttonRestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainApp.this.runAction(Action.Resta);
			}
		});
		buttonRestar.setBounds(169, 165, 54, 29);
		buttonRestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainApp.this.runAction(Action.Resta);
			}
		});
		frame.getContentPane().add(buttonRestar);
		
		JButton btnMultiplicar = new JButton("x");
		btnMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainApp.this.runAction(Action.Multiplicacion);
			}
		});
		btnMultiplicar.setBounds(235, 165, 54, 29);
		frame.getContentPane().add(btnMultiplicar);
		
		JButton buttonDividir = new JButton("/");
		buttonDividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainApp.this.runAction(Action.Division);
			}
		});
		buttonDividir.setBounds(301, 165, 54, 29);
		frame.getContentPane().add(buttonDividir);
	}
}
