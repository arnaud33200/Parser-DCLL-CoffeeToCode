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
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(
			        new FileInputStream(
			        new File("test.txt"))));
			String line, str = "";
			try {
				while((line = br.readLine()) != null){
					str += line + "\n";
				}
			} catch (IOException e) {
				e.printStackTrace();
				Window.show_error("Lecture Fichier source", e.getMessage());
			}
			parser.setInput(str);
		} catch (FileNotFoundException e1) {
			Window.show_error("Chargement Fichier source", e1.getMessage());
		}
		
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
					Window.show_error("Parser", e.getMessage());
				} catch (BadSyntaxException e) {
					Window.show_error("Parser", e.getMessage());
				}
            }
        });
	}
}
