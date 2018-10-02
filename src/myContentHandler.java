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

    public void startElement(String uri,
                             String localName,
                             String qualNam,
                             Attributes attribs) {
        if (qualNam.equals("Sheep") || qualNam.equals("sheep"))
            System.out.println(++count + " qualNam:" + qualNam + " localName:" + localName + "Attribs:" + attribs.getLength());
        //Checking to see whehter there are any attritute values and print them to stdout if there are any
        if (attribs.getLength() > 0) {
            for (int i = 0; i < attribs.getLength(); i++) {
                System.out.println(attribs.getValue(i));
            }
        }
        System.out.println();
    }


    public void endDocument(){
        System.out.println("Sleep tight!");
    }
}
