package br.user.ifm.gui.components;

import java.awt.Color;

import javax.swing.JButton;

public class Buttom extends JButton {
    public Buttom(String text) {
        super(text);
        this.setBounds(1920 / 2, 600, 120, 60);
        this.setBackground(Color.decode("#6d5dd3"));
        this.setFocusPainted(false);
        this.setBorderPainted(false);
    }
}
