/*
  Created by shaun on 25/09/2018.
  This file implements a content handler for the SAX processor
 */
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

/**
  DefaultHandler is the handler that SAX provides to give call backs to the EntityResolver, DTDHandler, ContentHandler and ErrorHandler
  This example uses it to take advantage of the startElement method of the ContentHandler.  StartElement is called
  when SAX finds a new element in the parser.
 */
public class myContentHandler extends DefaultHandler {
    private int count = 0;

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
    }

    public void characters(char[] charArray, int start, int length){
        String charString = new String(charArray, start, length);
        charString = charString.replaceAll("\n", "[cr]");
        charString = charString.replaceAll(" ", "[blank]");
        System.out.println(length + "characters: ");
        System.out.println(charString);
    }

    public void endElement(String Uri,
                           String localName,
                           String qualName){
        System.out.print("End Tag: ");
        System.out.println(qualName);
    }
    public void endDocument(){
        System.out.println("Sleep tight!  but Notice that I'm case sensitive too");
    }
}
