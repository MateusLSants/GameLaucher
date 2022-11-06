package br.user.ifm.gui.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageCovers extends JLabel {
    public ImageCovers(String nome) {
        super();
        ImageIcon icon = new ImageIcon(ImageCovers.class.getResource("/covers/" + nome));
        setIcon(icon);
        repaint();
    }
}
