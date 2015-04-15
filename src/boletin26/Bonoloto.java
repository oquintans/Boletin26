/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin26;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
    Integer[][] parrilla;
    int columnas = 5, filas = 10, cont, ac;

    public Bonoloto() {
        marco = new JFrame(" Bonoloto");
        marco.setLayout(new BorderLayout());        
        marco.add(this.Ficha(),BorderLayout.CENTER);
        marco.add(this.Botones(),BorderLayout.SOUTH);
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
        nWin = new JTextField(10);
        nAcertado = new JTextField(10);
        panelB.add(nWin);
        panelB.add(nAcertado);
        panelB.add(boton1);
        panelB.add(boton2);

        panelB.setBounds(0, 500, 200, 150);
        return panelB;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (boton == e.getSource()) {

        }
    }

}
