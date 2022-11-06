package br.user.ifm.gui.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Image extends JLabel {
    public Image(String nome) {
        super();
        ImageIcon icon = new ImageIcon(Image.class.getResource("/icons/" + nome));
        setIcon(icon);
        repaint();

        
    }
}
