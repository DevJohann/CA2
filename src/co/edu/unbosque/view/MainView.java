package co.edu.unbosque.view;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainView extends JFrame {

	private JButton multi;
	private JButton multi2;

	public MainView() {
		setComponents();
		configure();
	}

	private void setComponents() {
		multi = new JButton("Multiplicación de números grandes");
		multi.setBounds(70, 60, 240, 22);
		this.add(multi);

		multi2 = new JButton("Multiplicacion de matrices");
		multi2.setBounds(70, 140, 240, 22);
		this.add(multi2);
	}

	private void configure() {
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Taller 2 CA");
	}

	public JButton getMulti() {
		return multi;
	}

	public void setMulti(JButton multi) {
		this.multi = multi;
	}

	public JButton getMulti2() {
		return multi2;
	}

	public void setMulti2(JButton multi2) {
		this.multi2 = multi2;
	}

}
