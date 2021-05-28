package xmlUtilities;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;

import model.Crs;
import model.Ping;

public class XMLutilities {

	public static <Object> Document objectToXml(Object obj) {
		Document dom = null;

		if (obj instanceof Ping) {
			dom = generatePingXml((Ping) obj);
		}
		else if(obj instanceof Crs)
		{
			dom = generateLoginRequestXml((Crs)obj);
		}
		else if(obj instanceof String)
		{
			dom = generateLoginResponseXml((String)obj);
		}
//		else
//		{
//			throw new AtmException("Unknown AtmObject");
//		}

		return dom;
	}

	public static Document generatePingXml(Ping p) {

		Document dom = null;

		// build the root element
		Element root = new Element("ping");
		Attribute version = new Attribute("version", "1.0");
		root.setAttribute(version);

		String pingIDGetter = String.format("%s", p.gettID());
		Attribute pin = new Attribute("IDping", pingIDGetter);
		root.setAttribute(pin);

		String xGetter = String.format("%f", p.getX());
		Attribute xcoo = new Attribute("x", xGetter);
		root.setAttribute(xcoo);

		String yGetter = String.format("%f", p.getY());
		Attribute ycoo = new Attribute("y", yGetter);
		root.setAttribute(ycoo);

		String dateGetter = String.format("%f", p.getY());
		Attribute date = new Attribute("date", dateGetter);
		root.setAttribute(date);

		dom = new Document(root);

		return dom;

	}
	private static Document generateLoginRequestXml(Crs cred)
	{
		Document dom = null;

		// build the root element
		Element root = new Element("login_request");
		Attribute version = new Attribute("version", "1.0");
		root.setAttribute(version);
		
		String mailGetter = String.format("%s", cred.getLogin() );
		Attribute pin = new Attribute("mail", mailGetter);
		root.setAttribute(pin);
		
		String pwGetter = String.format("%s", cred.getPw());
		Attribute account = new Attribute("password", pwGetter);
		root.setAttribute(account);

		dom = new Document(root);

		return dom;

	}
	private static Document generateLoginResponseXml(String response)
	{
		Document dom = null;

		// build the root element
		Element root = new Element("login_response");
		Attribute version = new Attribute("version", "1.0");
		root.setAttribute(version);
		if (String.format("%s", response )== "user not found") {
			Attribute resp = new Attribute("response", "user not found");
			root.setAttribute(resp);
		} else if (String.format("%s", response )== "invalid password") {
			Attribute resp = new Attribute("response", "invalid password");
			root.setAttribute(resp);
		} else {
			Attribute resp = new Attribute("response", response);
			root.setAttribute(resp);
		}
		

		dom = new Document(root);

		return dom;

	}
	

}
