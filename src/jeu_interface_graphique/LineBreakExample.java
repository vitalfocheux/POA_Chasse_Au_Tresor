package jeu_interface_graphique;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class LineBreakExample {
    public static void main(String[] args) {
        // Créer une nouvelle instance de JFrame
        JFrame frame = new JFrame("Line Break Example");

        // Créer un JPanel avec un layout en FlowLayout
        JPanel panel = new JPanel(new FlowLayout());

        // Ajouter des JLabel avec un retour à la ligne
        panel.add(new JLabel("Label 1"));
        panel.add(new JLabel("Label 2"));
        panel.add(new JLabel("Label 3"));
        panel.add(new JLabel("Label 4"));

        // Insérer un composant spécial pour représenter le retour à la ligne
        JPanel lineBreakPanel = new JPanel();
        lineBreakPanel.setPreferredSize(new Dimension(0, 0)); // Taille nulle
        panel.add(lineBreakPanel);

        panel.add(new JLabel("Label 5"));
        panel.add(new JLabel("Label 6"));

        // Ajouter le JPanel à la fenêtre JFrame
        frame.getContentPane().add(panel);

        // Définir les dimensions de la fenêtre
        frame.pack();

        // Rendre la fenêtre visible
        frame.setVisible(true);

        // Terminer le programme lorsque la fenêtre est fermée
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
