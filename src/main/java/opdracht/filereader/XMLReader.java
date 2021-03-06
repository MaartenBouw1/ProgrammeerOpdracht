package opdracht.filereader;

import opdracht.Transaction;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLReader {

    public List<Transaction> getTransactions(File fXmlFile) {
        List<Transaction> transactions = new ArrayList<>();
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("record");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nNode;

                    int reference = Integer.parseInt(element.getAttribute("reference"));
                    String accountNumber = element.getElementsByTagName("accountNumber").item(0).getTextContent();
                    float startBalance = Float.parseFloat(element.getElementsByTagName("startBalance").item(0).getTextContent());
                    float mutation = Float.parseFloat(element.getElementsByTagName("mutation").item(0).getTextContent());
                    float endBalance = Float.parseFloat(element.getElementsByTagName("endBalance").item(0).getTextContent());
                    String description = element.getElementsByTagName("description").item(0).getTextContent();

                    Transaction transaction = new Transaction(reference, accountNumber, startBalance, mutation, endBalance, description);
                    transactions.add(transaction);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transactions;
    }
}

