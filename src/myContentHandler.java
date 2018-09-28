/**
 * Created by shaun on 25/09/2018.
 */
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

public class myContentHandler extends DefaultHandler{
    int count = 0;

    public void startElement(String uri,
                             String localName,
                             String qualNam,
                             Attributes attibs){
        if (qualNam.equals("Sheep") || qualNam.equals("sheep"))
            System.out.println(++count + " qualNam:" + qualNam.toString() + " localName:" + localName.toString());
    }

    public void endDocument(){
        System.out.println("Sleep tight!");
    }
}
