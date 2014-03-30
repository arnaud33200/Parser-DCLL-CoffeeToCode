/**
 * 
 */
package GUI;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import dcll.ctc.dcll.ctc.Parser.NoInputException;
import dcll.ctc.dcll.ctc.Parser.BadSyntaxException;
import dcll.ctc.dcll.ctc.Parser.WikiversityParser;

/**
 * @author alpha oumar binta diallo
 *
 */
public class Main {

	public static void main(String[] args) {
		final WikiversityParser parser = new WikiversityParser();
		parser.setInput(load_file());
		
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
					new Window(parser.parse()).setVisible(true);
				} catch (NoInputException e) {
					show_error("Parser", e.getMessage());
				} catch (BadSyntaxException e) {
					show_error("Parser", e.getMessage());
				}
            }
        });
	}
	public static void show_error(String title, String message){
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
		System.exit(1);
	}
	/**
	 * Method to set the file to use for the test,
	 *  a default is used if it is not specified
	 * @return String, the file content
	 */
	@SuppressWarnings("resource")
	private static String load_file() {
		BufferedReader br;
		JFileChooser chooser = new JFileChooser();
		String line, output = "", fileName = "File_Test/test.txt";
		
        int res = chooser.showOpenDialog(null);
        if(res == JFileChooser.APPROVE_OPTION){
            File file = chooser.getSelectedFile();
            fileName = file.getPath();
        }else{
        	JOptionPane.showMessageDialog(null, "Vous avez annuler l'operation,\n"
        			+ "le fichier par défaut sera chargé", 
                    "Choix du fichier", JOptionPane.WARNING_MESSAGE);
        }
		try {
			br = new BufferedReader(new InputStreamReader(
			        new FileInputStream(
			        new File(fileName))));
			try {
				while((line = br.readLine()) != null){
					output += line + "\n";
				}
			} catch (IOException e) {
				e.printStackTrace();
				show_error("Lecture Fichier test", e.getMessage());
			}
		} catch (FileNotFoundException e1) {
			show_error("Chargement Fichier test", e1.getMessage());
		}
		
		return output;
	}
}
