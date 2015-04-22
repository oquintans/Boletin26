package boletin26;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author oquintansocampo
 */
public class Bonoloto implements ActionListener {

    JFrame marco;
    JPanel panelA, panelB;
    JButton boton[][], boton1, boton2;
    JTextField nWin, nAcertado;
    JLabel premiados, aciertos;
    Integer[][] parrilla;
    String[] select = new String[6];
    int columnas = 5, filas = 10, cont, ac;
    int clicks = 0, iguales = 0, aux2 = 0;

    public Bonoloto() {
        marco = new JFrame(" Bonoloto");
        marco.setLayout(new BorderLayout());
        marco.add(this.Ficha(), BorderLayout.CENTER);
        marco.add(this.Botones(), BorderLayout.SOUTH);
        marco.setSize(800, 600);
        marco.setResizable(false);
        marco.setLocationRelativeTo(null);
        marco.setVisible(true);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JPanel Ficha() {
        panelA = new JPanel();
        parrilla = new Integer[filas][columnas];
        boton = new JButton[filas][columnas];
        panelA.setLayout(new GridLayout(filas, columnas, 2, 2));
        panelA.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        for (int i = 0; i < parrilla.length; i++) {
            ac = i;
            for (int j = 0; j < parrilla[i].length; j++) {
                boton[i][j] = new JButton(String.valueOf(ac));
                boton[i][j].addActionListener(this);
                panelA.add(boton[i][j]);
                ac = ac + filas;
            }
        }
        boton[0][0].setEnabled(false);
        boton[0][0].setText("BONOLOTO");
        parrilla[0][0] = 0;
        panelA.setSize(400, 300);
        return panelA;
    }

    public JPanel Botones() {

        panelB = new JPanel();
        boton1 = new JButton("Limpiar");
        boton2 = new JButton("Start");
        premiados = new JLabel("Numeros Premiados: ");
        aciertos = new JLabel("Aciertos: ");
        nWin = new JTextField(20);
        nAcertado = new JTextField(10);
        panelB.add(premiados);
        panelB.add(nWin);
        panelB.add(aciertos);
        panelB.add(nAcertado);
        boton1.addActionListener(this);
        boton2.setEnabled(false);
        panelB.add(boton1);
        boton2.addActionListener(this);
        panelB.add(boton2);

        panelB.setBounds(0, 500, 200, 150);
        return panelB;
    }

    public int[] ordenar(int[] aux) {
        for (int i = 0; i < aux.length - 1; i++) {
            for (int j = i; j < aux.length; j++) {
                if (aux[i] > aux[j]) {
                    int n = aux[i];
                    aux[i] = aux[j];
                    aux[j] = n;
                }
            }
        }
        return aux;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < parrilla.length; i++) {
            for (int j = 0; j < parrilla[i].length; j++) {
                if (e.getSource() == boton[i][j]) {
                    boton[i][j].setEnabled(false);
                    boton[i][j].setBackground(Color.red);
                    select[clicks] = (boton[i][j].getText());
                    clicks++;
                }
                if (clicks == 6) {
                    boton2.setEnabled(true);
                    for (int k = 0; k < parrilla.length; k++) {
                        for (int l = 0; l < parrilla[k].length; l++) {
                            boton[k][l].setEnabled(false);
                        }
                    }
                }
            }
        }

        if (e.getSource() == boton2) {
            aux2 = 1;
            String premio = "";
            int[] nPremiados = new int[6];
            boolean flag;
            iguales = 0;
            boton2.setEnabled(false);

            for (int j = 0; j < 6; j++) {
                do {
                    flag = false;
                    nPremiados[j] = 0;
                    int num = (int) (Math.random() * 49 + 1);
                    for (int i = 0; i < nPremiados.length - 1; i++) {
                        if (nPremiados[i] == num) {
                            flag = true;
                        }
                    }
                    nPremiados[j] = num;
                } while (flag);
            }
            this.ordenar(nPremiados);
            for (int i = 0; i < nPremiados.length; i++) {
                premio = premio + "  " + nPremiados[i];
            }
            nWin.setText(premio);
            for (int i = 0; i < select.length; i++) {
                for (int j = 0; j < select.length; j++) {
                    if (nPremiados[i] == Integer.parseInt(select[j])) {
                        iguales++;
                    }
                }
            }
            nAcertado.setText(String.valueOf(iguales));
            for (int i = 0; i < parrilla.length; i++) {
                for (int j = 0; j < parrilla[i].length; j++) {
                    for (int k = 0; k < nPremiados.length; k++) {
                        for (int l = 0; l < select.length; l++) {

                            if (String.valueOf(nPremiados[k]).equals(select[l])) {
                                if (boton[i][j].getText().equals(select[l])) {
                                    boton[i][j].setBackground(Color.green);
                                }
                            }
                        }
                    }
                }
            }
        }

        if (e.getSource() == boton1) {
            nWin.setText(null);
            nAcertado.setText(null);
            for (int i = 0; i < parrilla.length; i++) {
                for (int j = 0; j < parrilla[i].length; j++) {
                    boton[i][j].setEnabled(true);
                    boton[i][j].setBackground(null);
                    boton[0][0].setEnabled(false);
                    clicks = 0;
                    iguales = 0;
                    boton2.setEnabled(false);
                    aux2 = 0;
                }
            }
        }
    }
}
