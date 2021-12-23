import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;


class XSLT 
{
    public static void main ( String argv[] ) throws Exception {
	File stylesheet = new File("D:\\Web data Management\\project 7\\recipes.xsl");
	File xmlfile  = new File("D:\\Web data Management\\project 7\\recipes.xml");
	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	DocumentBuilder db = dbf.newDocumentBuilder();
	Document doc = db.parse(xmlfile);
	StreamSource stylesrc = new StreamSource(stylesheet);
	TransformerFactory tf = TransformerFactory.newInstance();
	Transformer transformer = tf.newTransformer(stylesrc);
	DOMSource source = new DOMSource(doc);
	StreamResult result = new StreamResult(System.out);
	transformer.transform(source,result);
    }
}
