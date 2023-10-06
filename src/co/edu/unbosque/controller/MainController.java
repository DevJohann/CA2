package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.MultiplicarLargos;
import co.edu.unbosque.model.MultiplicarMatrices;
import co.edu.unbosque.view.MainView;

public class MainController implements ActionListener {

	private MainView MV;
	private MultiplicarLargos ML;

	private MultiplicarMatrices MM;

	public MainController() {
		MV = new MainView();
		MV.setSize(400, 300);
		MV.setVisible(true);
		ML = new MultiplicarLargos();
		MM = new MultiplicarMatrices();
		this.setListeners();
	}

	private void setListeners() {
		MV.getMulti().addActionListener(this);
		MV.getMulti().setActionCommand("Multiplicar");

		MV.getMulti2().addActionListener(this);
		MV.getMulti2().setActionCommand("Matrices");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {

		case "Multiplicar":
			BigInteger a = new BigInteger(JOptionPane.showInputDialog(null, "Ingrese el número b"));
			BigInteger b = new BigInteger(JOptionPane.showInputDialog(null, "Ingrese el número b"));
			BigInteger res = ML.ejecutar(a, b);
			System.out.println(res);
			break;

		case "Matrices":
			int rowsA = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las filas de la matriz A"));
			int colsA = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las columnas de la matriz A"));
			int rowsB = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las filas de la matriz B"));
			int colsB = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las columnas de la matriz B"));

			// Verificar si se pueden multiplicar (n x m, a x b | m = a )
			if (colsA != rowsB) {
				JOptionPane.showMessageDialog(null,
						"Error: No se pueden multiplicar\nLa cantidad de columnas de A debe ser igual a la cantidad de filas de B",
						"Error", JOptionPane.ERROR_MESSAGE);
				break;
			}

			// Llenado de matrices
			int[][] Mat_A = new int[rowsA][colsA];
			int[][] Mat_B = new int[rowsB][colsB];

			JOptionPane.showMessageDialog(null, "A continuación, ingrese los valores de la matriz A");
			for (int i = 0; i < rowsA; i++) {
				for (int j = 0; j < colsA; j++) {
					int val = Integer.parseInt(JOptionPane.showInputDialog("Valor de [" + i + "][" + j + "]"));
					Mat_A[i][j] = val;
				}
			}
			JOptionPane.showMessageDialog(null, "A continuación, ingrese los valores de la matriz B");
			for (int i = 0; i < rowsB; i++) {
				for (int j = 0; j < colsB; j++) {
					int val = Integer.parseInt(JOptionPane.showInputDialog("Valor de [" + i + "][" + j + "]"));
					Mat_B[i][j] = val;
				}
			}

			int[][] resMat = MM.multiplyWithoutDYV(Mat_A, Mat_B);

			System.out.println("Multiplicado: ");
			System.out.println("A:");
			for (int i = 0; i < rowsA; i++) {
				for (int j = 0; j < colsA; j++) {
					System.out.print("[" + Mat_A[i][j] + "]");
				}
				System.out.println();
			}
			System.out.println("B:");
			for (int i = 0; i < rowsB; i++) {
				for (int j = 0; j < colsB; j++) {
					System.out.print("[" + Mat_B[i][j] + "]");
				}
				System.out.println();
			}
			System.out.println("Res: ");

			for (int i = 0; i < resMat.length; i++) {
				for (int j = 0; j < resMat[0].length; j++) {
					System.out.print("[" + resMat[i][j] + "]");
				}
				System.out.println();
			}
			break;
		}
	}

}
