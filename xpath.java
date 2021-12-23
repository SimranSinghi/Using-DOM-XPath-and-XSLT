import javax.xml.xpath.*;
import org.xml.sax.InputSource;
import org.w3c.dom.*;

class XPATH 
{
    static void print ( Node e ) 
    {
		if (e instanceof Text)
	    	{	System.out.print(((Text) e).getData());	}
		else 
		{
	    	NodeList c = e.getChildNodes();
	    	System.out.print("<"+e.getNodeName());
	    	NamedNodeMap attributes = e.getAttributes();
	    	for (int i = 0; i < attributes.getLength(); i++)
				System.out.print(" "+attributes.item(i).getNodeName()
				 +"=\""+attributes.item(i).getNodeValue()+"\"");
	    	System.out.print(">");
	    	for (int k = 0; k < c.getLength(); k++)
				print(c.item(k));
	    	System.out.print("</"+e.getNodeName()+">");
		}
    }

    static void eval ( String query, String document ) throws Exception 
    {
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		InputSource inputSource = new InputSource(document);
		NodeList result = (NodeList) xpath.evaluate(query,inputSource,XPathConstants.NODESET);
		for (int i = 0; i < result.getLength(); i++)
	    	print(result.item(i));
		System.out.println();
    }   

    public static void main ( String[] args ) throws Exception 
    {	
		System.out.println("XPath query 1: All articles whose one of the authors is David Maier: \n");
    	eval("//SigmodRecord/issue/articles/article[authors/author='David Maier']/title", "SigmodRecord.xml");	

    	System.out.println("XPath query 2: All articles whose first author is David Maier: \n");
    	eval("//SigmodRecord/issue/articles/article[authors/author[@position='00']='David Maier']/title","SigmodRecord.xml");
		
    	System.out.println("XPath query 3: All articles whose authors include David Maier and Stanley B. Zdonik: \n");
    	eval("//SigmodRecord/issue/articles/article[authors/author='David Maier' and authors/author='Stanley B. Zdonik']/title","SigmodRecord.xml");
    	
    	System.out.println("XPath query 4: All articles with Volume 19 and Number 2 \n");
    	eval("//SigmodRecord/issue[volume=19 and number=2]/articles/article/title", "SigmodRecord.xml");
    	
    	System.out.println("XPath query 5: All titles and init/end pages of articles with Volume 19/Number 2 whose authors include Jim Gray:\n");
    	eval("//SigmodRecord/issue[volume=19 and number=2]/articles/article/title | //SigmodRecord/issue[volume=19 and number=2]/articles/article/initPage | //SigmodRecord/issue[volume=19 and number=2]/articles/article/endPage","SigmodRecord.xml");
    	
    	System.out.println("XPath query 6: All titles and init/end pages of articles with Volume 19/Number 2 whose authors include David Maier:\n");    	
    	eval("//SigmodRecord/issue[articles/article/authors/author='David Maier']/volume | //SigmodRecord/issue[articles/article/authors/author='David Maier']/number", "SigmodRecord.xml"); 	
    }
}
