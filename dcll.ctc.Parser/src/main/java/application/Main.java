/**
 * 
 */
package application;


import application.view.Window;

/**
 * @author alpha oumar binta diallo
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final WikiversityParser parser = new WikiversityParser();
		parser.setInput("{Question 1 : Selon vous, H Brada the accelerometer est : |type=\"()\"}\n" +
						"- Marocain\n"+
						"- Algerien\n"+
						"+ Espagnole\n"+
						"\n"+
						"{Question 2 : Cocher les bonnes reponses.|type=\"[]\"}\n" +
						"- Une reponse fausse\n"+
						"+ Une reponse juste\n"+
						"+ Une autre reponse juste\n"+
						"- Une autre reponse fausse\n");
		
		//Do not modify this code please, it's 04:25 and I have not slept since yesterday. so b** please
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
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
					new Window(parser.parse()).setVisible(true);
				} catch (NoInputException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BadSyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        //end
	}
}
