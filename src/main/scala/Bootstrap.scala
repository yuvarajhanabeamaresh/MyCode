//import scala.language.postfixOps
import java.io.StringReader

import javax.xml._
import javax.xml.parsers.DocumentBuilder
import org.w3c.dom._
import javax.xml.XMLConstants
import javax.xml.transform.stream.StreamResult
import javax.xml.transform.TransformerFactory
import javax.xml.xpath.XPath
import javax.xml.xpath.XPathConstants
import javax.xml.xpath.XPathFactory
import javax.xml.xpath.XPathExpression
import javax.xml.transform.dom.DOMSource
import org.xml.sax.InputSource

import scala.io.Source

object Bootstrap {

  def main (args:Array[String]): Unit = {

                                                                                 //Approach1
    //    val xmlDoc = <symbols>
    //          <symbol ticker="Cisco" ><units>100</units></symbol>
    //          <symbol ticker="Sandisk" ><units>315</units></symbol>
    //        </symbols>
    ////    val a =xmlDoc \\ "symbol"
    ////    println(a);

  val filePath ="F:/yuv/data.txt";                                               //Approach2
    val fileContent = Source.fromFile(filePath).getLines().mkString
 //println(fileContent)
   val dom = javax.xml.parsers.DocumentBuilderFactory.newInstance().newDocumentBuilder()
    val a = dom.parse(new InputSource(new StringReader(fileContent)))
    val xpath = XPathFactory.newInstance().newXPath();
    val exp = "/note/to";
    val  output = xpath.evaluate(exp,a,XPathConstants.STRING)
    println(output);
  }
}
