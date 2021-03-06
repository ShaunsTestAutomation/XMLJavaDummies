
import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;

public class CountSheep {
    static public void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        XMLReader xmlReader = saxParser.getXMLReader();

        xmlReader.setContentHandler(new myContentHandler());

        xmlReader.parse(new File("..\\..\\..\\Resources\\Sheep.xml").toString());
    }
}
