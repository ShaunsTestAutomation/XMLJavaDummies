import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;

public class CallSax {
    static public void main(String[] args) throws SAXException, ParserConfigurationException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        XMLReader xmlReader = saxParser.getXMLReader();

        xmlReader.setContentHandler(new myContentHandler());

        xmlReader.parse(new File("..\\..\\..\\Resources\\Sins.xml").toString());
        //Don't forget that now we have declared our parser (xmlReader) we could re-use it over and over again
        //e.g.
        xmlReader.parse(new File("..\\..\\..\\Resources\\Sheep.xml").toString());
    }
}
