package dcll.ctc.dcll.ctc.parser.gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import dcll.ctc.dcll.ctc.parser.BadSyntaxException;
import dcll.ctc.dcll.ctc.parser.NoInputException;
import dcll.ctc.dcll.ctc.parser.WikiversityParser;

/**
 * @author alpha oumar binta diallo
 */
public final class Main {
    /**
     * Default constructor.
     */
    private Main() { }
    /**
     * @param args the args.
     */
    public static void main(final String[] args) {
        final WikiversityParser parser = new WikiversityParser();
        parser.setInput(loadFile());

        try {
            for (UIManager.LookAndFeelInfo info : javax.swing.UIManager
                    .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Window(parser.parse()).setVisible(true);
                } catch (NoInputException e) {
                    showError("Parser", e.getMessage());
                } catch (BadSyntaxException e) {
                    showError("Parser", e.getMessage());
                }
            }
        });
    }

    /**
     * @param title the dialog title
     * @param message the message to show
     */
    public static void showError(final String title, final String message) {
        JOptionPane.showMessageDialog(null, message, title,
                JOptionPane.ERROR_MESSAGE);
        System.exit(1);
    }

    /**
     * Method to set the file to use for the test, a default is used if it is
     * not specified.
     * @return String, the file content
     */
    private static String loadFile() {
        BufferedReader br = null;
        JFileChooser chooser = new JFileChooser();
        String line, output = "", fileName = "File_Test/test.txt";

        int res = chooser.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            fileName = file.getPath();
        } else {
            JOptionPane.showMessageDialog(null,
                    "Vous avez annuler l'operation,\n"
                            + "le fichier par défaut sera chargé",
                    "Choix du fichier", JOptionPane.WARNING_MESSAGE);
        }
        try {
            try {
                br = new BufferedReader(new InputStreamReader(
                        new FileInputStream(
                        new File(fileName)),
                        "UTF-8"));
            } catch (UnsupportedEncodingException e1) {
                showError("Lecture Fichier test", e1.getMessage());
            }
            try {
                while ((line = br.readLine()) != null) {
                    output += line + "\n";
                }
            } catch (IOException e) {
                showError("Lecture Fichier test", e.getMessage());
            }
        } catch (FileNotFoundException e1) {
            showError("Chargement Fichier test", e1.getMessage());
        }
        try {
            br.close();
        } catch (IOException e) {
            showError("Fermeture Fichier test", e.getMessage());
        }
        return output;
    }
}
