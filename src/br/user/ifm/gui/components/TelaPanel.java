package br.user.ifm.gui.components;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.*;
import java.awt.*;

public class TelaPanel extends JPanel implements ActionListener {
    private JPanel telas;
    private CardLayout controleTela;
    private JFrame janela;

    public TelaPanel(JPanel telas, JFrame janela) {
        this.telas = telas;
        this.controleTela = (CardLayout) telas.getLayout();
        this.janela = janela;
        this.setBackground(Color.decode("#202028"));
        this.setLayout(null);

        Image iconClose = new Image("window-close.png");
        iconClose.setBounds(1880, 0, 36, 36);

        Image iconMinimize = new Image("window-minimize.png");
        iconMinimize.setBounds(1820, 0, 36, 36);

        iconClose.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                janela.dispose();
            }
        });

        iconMinimize.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                janela.setState(JFrame.ICONIFIED);
            }
        });

        this.add(iconClose);
        this.add(iconMinimize);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        executarBotao(e);
    }

    protected void executarBotao(ActionEvent e) {

    }

    protected void trocarTela(String indentificador) {
        controleTela.show(telas, indentificador);
    }
    
}
