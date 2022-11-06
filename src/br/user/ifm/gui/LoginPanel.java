package br.user.ifm.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.user.ifm.gui.components.Buttom;
import br.user.ifm.gui.components.TelaPanel;

import java.awt.event.*;

public class LoginPanel extends TelaPanel {
    private Buttom buttonLogin;

    public LoginPanel(JPanel telas, JFrame janela) {
        super(telas, janela);
        JLabel menssagem = new JLabel("Conteudo da messagem Login Panel");

        JTextField txtLogin = new JTextField();
        txtLogin.setBounds(910, 420, 220, 30);

        JTextField txtPassword = new JTextField();
        txtPassword.setBounds(910, 480, 220, 30);

        buttonLogin = new Buttom("Fazer login");
        buttonLogin.addActionListener(this);


        this.add(menssagem);
        this.add(buttonLogin);
        this.add(txtLogin);
        this.add(txtPassword);
          
    }

    public void executarBotao(ActionEvent e) {
        trocarTela("Tela Principal");
    }
}
