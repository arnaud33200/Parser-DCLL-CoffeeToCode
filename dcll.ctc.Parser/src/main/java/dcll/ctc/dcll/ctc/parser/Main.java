package dcll.ctc.dcll.ctc.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.swing.JFileChooser;

/**
 * @author alpha oumar binta diallo
 */
public final class Main {
    /**
     * the default file test.
     */
    private static final String FILE_TEST = "File_Test/test.txt";

    /**
     * Default constructor.
     */
    private Main() {
    }

    /**
     * @param args the args.
     */
    public static void main(final String[] args) {
        WikiversityParser parser = new WikiversityParser();
        parser.setInput(getFileContent(FILE_TEST));
        try {
            parser.parse();
        } catch (NoInputException e) {
            e.printStackTrace();
        } catch (BadSyntaxException e) {
            e.printStackTrace();
        }
    }
    /**
     * Method to set the file to use for the test, a default is used if it is
     * not specified.
     * @return String, the file content
     */
    public static String getFilePath() {
        JFileChooser chooser = new JFileChooser();

        int res = chooser.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            return file.getPath();
        } else {
            return FILE_TEST;
        }
    }

    /**
     * @param fileName
     *            the file name.
     * @return String
     */
    public static String getFileContent(final String fileName) {
        BufferedReader br = null;
        String line, output = "";
        try {
            try {
                br = new BufferedReader(new InputStreamReader(
                        new FileInputStream(new File(fileName)), "UTF-8"));
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
            try {
                while ((line = br.readLine()) != null) {
                    output += line + "\n";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }
}
