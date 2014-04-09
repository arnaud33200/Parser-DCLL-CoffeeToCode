package dcll.ctc.dcll.ctc.Parser.test;

import org.tsaap.questions.QuestionType;
import org.tsaap.questions.impl.DefaultQuiz;

import dcll.ctc.dcll.ctc.parser.BadSyntaxException;
import dcll.ctc.dcll.ctc.parser.NoInputException;
import dcll.ctc.dcll.ctc.parser.Parser;
import dcll.ctc.dcll.ctc.parser.WikiversityParser;
import junit.framework.TestCase;

public class WikiversityParserTest extends TestCase{

	public void testWikiversityParser() throws NoInputException, BadSyntaxException{
		Parser p = new WikiversityParser();
		assertNotNull(p);
		WikiversityParser p2=new WikiversityParser();
		p2.setInput("{C'est le type par défaut des questions d'un quiz."
				+ " Vous n'êtes pas obligé de terminer \nl'intitulé par :|type=\"[]\"}"
				+ "\n+ Les lignes suivantes sont des propositions\n"
				+ "+ justes ou\n"
				+ "- fausses.\n"
				+ "\n"
				+ "{ L'intitulé d'une question à choix unique se termine systématiquement par |type=\"()\"}"
				+ "\n- elle contient des propositions"
				+ "\n- fausses"
				+ "\n+ et une unique proposition juste.");
		assertNull(p2.getQuiz());
		DefaultQuiz dq=(DefaultQuiz) p2.parse();
		assertNotNull(dq);
	}

	public void testCheckInputFormat1() throws BadSyntaxException, NoInputException {
		int retourEx=0;
		WikiversityParser p=new WikiversityParser();
		p.setInput("");
		try{
			p.parse();
		} catch (NoInputException n){
			retourEx=1;
		}
		assertEquals(retourEx,1);

		p.setInput("{ L'intitulé d'une question à choix unique se termine"
				+ ""
				+ " systématiquement par |type=\"()\""
				+ " \n- elle contient des propositions \n"
				+ " - fausses \n + et une unique proposition juste.");
		try{
			p.parse();}
		catch (BadSyntaxException n){
			retourEx=2;
		}
		assertEquals(retourEx,2);
	}

	public void testCheckInputFormat2() throws BadSyntaxException, NoInputException {
		int retourEx=0;
		WikiversityParser p=new WikiversityParser();

		p.setInput("{ L'intitulé d'une question à choix unique se termine systématiquement par"
				+ " |type= } \n"
				+ "- elle contient des propositions \n "
				+ "- fausses \n "
				+ "+ et une unique proposition juste.");
		try{
			p.parse();}
		catch (BadSyntaxException n){
			retourEx=3;
		}
		assertEquals(retourEx,3);

		p.setInput("{|type=\"()\"}"
				+ " \n- elle contient des propositions \n - fausses \n + et une unique proposition juste.");
		try{
			p.parse();}
		catch (BadSyntaxException n){
			retourEx=4;
		}
		assertEquals(retourEx,4);
	}

	public void testCheckInputFormat3() throws BadSyntaxException, NoInputException {
		int retourEx=0;
		WikiversityParser p=new WikiversityParser();

		p.setInput("{ L'intitulé d'une question à choix unique se termine systématiquement par |type=\"()\"}\n"
				+ "\n");
		try {p.parse();

		}
		catch (BadSyntaxException n){
			retourEx=5;
		}
		assertEquals(retourEx,5);
		
		p.setInput("{ L'intitulé d'une question à choix unique se termine systématiquement par |type=\"()\"}\n"
				+ "- fausses \n- fausses\n");
		try{
			p.parse();}
		catch (BadSyntaxException n){
			retourEx=6;
		}
		assertEquals(retourEx,6);

	}
	public void testgetQuestionType() throws StringIndexOutOfBoundsException{
		WikiversityParser p=new WikiversityParser();
		QuestionType q=null;
		q =p.getQuestionType("{C'est le type par défaut des questions d'un quiz. "
				+ "Vous n'êtes pas obligé de terminer l'intitulé par :|type=\"[]\"}"
				+ "\n+ Les lignes suivantes sont des propositions"
				+ "+ justes ou"
				+ "- fausses.");
		
		assertEquals(q,QuestionType.MultipleChoice);
		q =p.getQuestionType("{C'est le type par défaut des questions d'un quiz. "
				+ "Vous n'êtes pas obligé de terminer l'intitulé par :|type=\"hhh\"}"
				+ "\n+ Les lignes suivantes sont des propositions"
				+ "+ justes ou"
				+ "- fausses.");
		assertEquals(q,QuestionType.Undefined);
	}



}
