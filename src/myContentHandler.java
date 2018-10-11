/*
  Created by shaun on 25/09/2018.
  This file implements a content handler for the SAX processor
 */
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;

/**
  DefaultHandler is the handler that SAX provides to give call backs to the EntityResolver, DTDHandler, ContentHandler and ErrorHandler
  This example uses it to take advantage of the startElement method of the ContentHandler.  StartElement is called
  when SAX finds a new element in the parser.
 It is worth checking the SAX documentation to see how the documentation relates to this example.
 https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html
 The important thing to note is that the DefaultHandler does nothing except implements the callbacks.  It is this
 class that extends the default and overrides the methods of DefaultHandler to achieve some useful functionality.
 */
public class myContentHandler extends DefaultHandler {
    private int count = 0;
    Locator locator;

    public void setDocumentLocator(Locator locator){
        this.locator = locator;
    }
    public void startDocument(){
        System.out.println("Starting the document");
    }
    public void startElement(String uri,
                             String localName,
                             String qualNam,
                             Attributes attribs) {
            System.out.print("Start tag: ");
            System.out.println(qualNam);
            for (int i = 0; i < attribs.getLength(); i++) {
                System.out.print("Attribute: ");
                System.out.print(attribs.getQName(i));
                System.out.print(" = ");
                System.out.println(attribs.getValue(i));
            }
            showSpecifics();
    }

    /* The characters method is called when there are characters between nodes.
       Inspection of the characters, their location and number is not wholly intuitive and so experimentation is advised
       if you plan to make use of this method.
       The output created this method is verbose so I have commented it out for brevity, but to make use simply uncomment.
     */
    /*    public void characters(char[] charArray, int start, int length){
        String charString = new String(charArray, start, length);
        charString = charString.replaceAll("\n", "[cr]");
        charString = charString.replaceAll(" ", "[blank]");
        System.out.println(length + "characters: ");
        System.out.println(charString);
    }
*/
    public void endElement(String Uri,
                           String localName,
                           String qualName){
        System.out.print("End Tag: ");
        System.out.println(qualName);
    }
    public void endDocument(){
        System.out.println("Sleep tight!  but Notice that I'm case sensitive too");
    }

    public void showSpecifics(){
        System.out.println("    Line: " + locator.getLineNumber());
        System.out.println("    Column: " + locator.getColumnNumber());
        System.out.println("    Document: " + locator.getSystemId());
        System.out.println("    publicID: " + locator.getPublicId());
    }
}
