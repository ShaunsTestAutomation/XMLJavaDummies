/*
  Created by shaun on 06/10/2018.
  This class allows custom error handling to give more control over the reporting of errors.
  This should allow more meaningful error reporting instead of relying on stock error messages from SAX
 */
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

public class MyErrorHandler extends DefaultHandler{
    public void warning(SAXParseException e){
        System.out.println("Warning:");
        showSpecifics(e);
        System.out.println();
    }
    public void error(SAXParseException e){
        System.out.println("Error:");
        showSpecifics(e);
        System.out.println();
    }
    public void fatalError(SAXParseException e){
        System.out.println("Fatal error:");
        showSpecifics(e);
        System.out.println();
    }
    private void showSpecifics(SAXParseException e){
        System.out.println(e.getMessage());
        System.out.println("    Line " + e.getLineNumber());
        System.out.println("    Column " + e.getColumnNumber());
        System.out.println("    Document " + e.getSystemId());
    }
}
