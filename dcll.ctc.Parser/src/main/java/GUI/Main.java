/**
 * 
 */
package GUI;


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
		parser.setInput("{Question 1 : Est ce que Binta doit se couper les cheveux : |type=\"()\"}\n" +
						"- Oui\n"+
						"- Non\n"+
						"+ Peut être\n"+
						"\n"+
						"{Question 2 : Cocher les bonnes reponses.|type=\"[]\"}\n" +
						"- Une reponse fausse\n"+
						"+ Une reponse juste\n"+
						"+ Une autre reponse juste\n"+
						"- Une autre reponse fausse\n"+
						"\n"+
						"{Question 2 : Cocher les bonnes reponses.|type=\"[]\"}\n" +
						"- Une reponse fausse\n"+
						"+ Une reponse juste\n"+
						"+ Une autre reponse juste\n"+
						"- Une autre reponse fausse\n");
		
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
					e.printStackTrace();
				} catch (BadSyntaxException e) {
					e.printStackTrace();
				}
            }
        });
	}
}
