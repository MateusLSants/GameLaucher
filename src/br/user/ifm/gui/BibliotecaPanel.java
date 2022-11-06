package br.user.ifm.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.json.JSONArray;
import org.json.JSONObject;

import br.user.ifm.gui.components.Buttom;
import br.user.ifm.gui.components.ImageCovers;
import br.user.ifm.gui.components.TelaPanel;
import br.user.ifm.models.Game;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import java.awt.Color;
import java.awt.event.MouseAdapter;

public class BibliotecaPanel extends TelaPanel { 
    private ArrayList<Game> games;
    private JPanel grid;
    private ImageCovers coverFundo;
    private Game gameSelected;
    private JLabel labelGame;
    private Buttom buttomPlay;

    public BibliotecaPanel(JPanel telas, JFrame janela) {
        super(telas, janela);
        this.games = new ArrayList<Game>();

        grid = new JPanel(new FlowLayout(FlowLayout.LEFT, 22, 22));
        grid.setBackground(Color.decode("#202028"));

        loadGames();
        showGames();

        JScrollPane scrollPane = new JScrollPane(grid);
        scrollPane.setBounds(50, 550, 1820, 450);

        buttomPlay = new Buttom("PLAY");
        buttomPlay.setFont(new Font("Roboto", Font.PLAIN, 30));
        buttomPlay.setBounds(50, 450, 160, 80);
        buttomPlay.setForeground(Color.WHITE);
        buttomPlay.setVisible(false);

        labelGame = new JLabel("");
        labelGame.setBounds(50, 50, 1000, 100);

        Font font = labelGame.getFont();
        labelGame.setFont(new Font("Roboto", font.BOLD, 40));
        labelGame.setForeground(Color.WHITE);
        labelGame.setVisible(false);


        this.add(scrollPane);
        this.add(labelGame);
        this.add(buttomPlay);
        
    }

    private void showGames() {
        int posiX = 50;
        int posiY = 50;
        final int POSI_MAX_X = 1300;

       for (Game game : games) {
        String icone = game.getIcone();
        ImageCovers cover = new ImageCovers(icone);
        cover.setBounds(posiX, posiY, 600, 900);

        posiX += 20 + 600;
        if (posiX > POSI_MAX_X) {
            posiY += 50;
        }

       cover.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {   
                String path = game.getCaminho();
                selectGame(game);
               
            }      
       });

        grid.add(cover);
       }
    }   
    
    private void selectGame(Game game) {
        gameSelected = game;

        buttomPlay.setVisible(true);
        labelGame.setText(game.getNome());
        labelGame.setVisible(true);

        String fundo = game.getFundo();
        switchBackgroundCover(fundo);

        repaint();
        revalidate();
        
    }

    private void switchBackgroundCover(String image) {
        if (coverFundo != null) {
            remove(coverFundo);
        }
        coverFundo = new ImageCovers(image);
        coverFundo.setBounds(0, 0, 1920, 1080);
        add(coverFundo);
        
    }

    private void loadGames() {
        String jsonString = readJsonGames();
        JSONArray jsonArray = new JSONArray(jsonString);
        
        
        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject gameObject = (JSONObject) jsonArray.get(i);
            games.add(new Game(gameObject));
        }
    }

    private void runGame(String path) {
        File file = new File(path);
        String rootPath = file.getAbsolutePath();
        System.out.println(rootPath);
    }

    public void executarBotao(ActionEvent e) {
        trocarTela("Tela Login");
    }

    private String readJsonGames() {
        File fileJson = new File("games.json");
        StringBuilder contentJson = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileJson));
            
            String line = reader.readLine();
            while(line != null) {
                contentJson.append(line);

                line = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {

            e.printStackTrace();
        }

        return contentJson.toString();
    }
   
}
