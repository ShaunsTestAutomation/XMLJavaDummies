import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;

public class CallSax {
    static public void main(String[] args) throws SAXException, ParserConfigurationException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        XMLReader xmlReader = saxParser.getXMLReader();

        xmlReader.setContentHandler(new myContentHandler());

        //Try to create a new parser from filename passed by command line argument at a fixed location
        try {
            xmlReader.parse(new File("..\\..\\..\\Resources\\" + args[0]).toString());
        }
        catch (SAXException s){
            System.out.println("Theres been a big mistake!");
            s.printStackTrace();
        }
        catch (FileNotFoundException e){
            System.out.println("You supplied a filename that does not exist in the resources folder...");
            System.out.println("Program is terminating; please re-run with a valid file name");
            System.out.println("syntax is:");
            System.out.println("java CallSax <filename>");
            System.exit(1);
        }
        //xmlReader.parse(new File("..\\..\\..\\Resources\\Sins.xml").toString());
        //Don't forget that now we have declared our parser (xmlReader) we could re-use it over and over again
        //e.g.
        //xmlReader.parse(new File("..\\..\\..\\Resources\\Sheep.xml").toString());
    }
}
