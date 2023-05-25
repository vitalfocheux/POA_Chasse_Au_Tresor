package jeu_interface_graphique;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class ScrollablePanelExample {
    public static void main(String[] args) {
        // Créer une nouvelle instance de JFrame
        JFrame frame = new JFrame("Scrollable Panel Example");

        // Créer un JPanel avec un layout
        JPanel contentPanel = new JPanel(new FlowLayout());

        // Ajouter des composants (dans cet exemple, nous ajoutons 20 boutons)
        for (int i = 1; i <= 20; i++) {
            JButton button = new JButton("Bouton " + i);
            contentPanel.add(button);
        }

        // Créer une instance de JScrollPane en utilisant le JPanel comme contenu
        JScrollPane scrollPane = new JScrollPane(contentPanel);

        // Définir la taille préférée du JScrollPane
        scrollPane.setPreferredSize(new Dimension(400, 300));

        // Ajouter le JScrollPane à la fenêtre JFrame
        frame.getContentPane().add(scrollPane);

        // Définir les dimensions de la fenêtre
        frame.pack();

        // Rendre la fenêtre visible
        frame.setVisible(true);

        // Terminer le programme lorsque la fenêtre est fermée
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
