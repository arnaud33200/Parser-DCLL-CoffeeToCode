/**
 * 
 */
package GUI;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.tsaap.questions.Question;
import org.tsaap.questions.Quiz;

/**
 * @author alpha oumar binta diallo
 *
 */
public class Window extends JFrame {

	private static final long serialVersionUID = 1L;
	private Quiz quiz;
    private JButton bReset;
    private JButton bValider;
    private JScrollPane jScrollPane1, resScroll;
    private JTextArea information;
    private JPanel questionsPanel;
    private List<QuestionJPanel> panelList = new ArrayList<QuestionJPanel>();
    
    /**
     * Creates new form Window
     */
	public Window(Quiz quiz) {
		this.quiz = quiz;
		initComponents();
	}
	public static void show_error(String title, String message){
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
		System.exit(1);
	}
	/**
	 * This method is called from within the initComponents method to set up
	 * the questions of quiz with their formats.
	 */
	private void intializeQuizView() {
		for(Question question : quiz.getQuestionList()) {
			QuestionJPanel panel = null;
			switch(question.getQuestionType()) {
			case MultipleChoice:
				panel = new MultipleChoicePanel(question);
				break;
			case ExclusiveChoice:
				panel = new ExclusiveChoicePanel(question);
				break;
			default:
				throw new RuntimeException("Not implemented");
			}
			panelList.add(panel);
			questionsPanel.add(panel);
		}
	}	
	/**
     * This method is called from within the constructor to initialize the form.
     */
	private void initComponents() {
        bValider = new JButton();
        bReset = new JButton();
        jScrollPane1 = new JScrollPane();
        resScroll = new javax.swing.JScrollPane();
        information = new JTextArea();
        questionsPanel = new JPanel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Wikimedia Quiz");
        bValider.setText("Valider");
        bReset.setText("Réinitialiser");
        information.setEditable(false);
        information.setBackground(new java.awt.Color(0, 0, 0));
        information.setColumns(20);
        information.setForeground(new java.awt.Color(0, 153, 0));
        information.setRows(5);
      
        intializeQuizView();
        jScrollPane1.setViewportView(questionsPanel);
        resScroll.setViewportView(information);
        questionsPanel.setLayout(new BoxLayout(questionsPanel, BoxLayout.Y_AXIS));
        
        bValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bValiderActionPerformed(evt);
            }
        });
        bReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(bValider)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(bReset)
                .addGap(64, 64, 64))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(resScroll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(resScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bValider)
                    .addComponent(bReset))
                .addContainerGap())
        );

        pack();
    }
	/**
	 * this method compute the score
	 * @param evt
	 */
    private void bValiderActionPerformed(java.awt.event.ActionEvent evt) { 
    	String resultat = "";
    	int n = 1;
        for(QuestionJPanel question : panelList) {
        	float score = question.compute() * 100;
        	resultat += "- Question " + n + " -> " + score + " %\n";
        	n++;
        }
        information.append(resultat);
    }
    /**
     * this method reset the form
     * @param evt
     */
    private void bResetActionPerformed(java.awt.event.ActionEvent evt) {                                       
    	for(QuestionJPanel panel : panelList) {
			panel.reset();
		}
    	information.setText("");
    } 
}
