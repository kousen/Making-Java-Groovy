package xml

import javax.xml.XMLConstants
import javax.xml.transform.stream.StreamSource
import javax.xml.validation.Schema
import javax.xml.validation.SchemaFactory
import javax.xml.validation.Validator;

String base = 'src/main/groovy/xml'

// validates against a DTD
String fileName = "$base/booksWithDTD.xml"
def root = new XmlSlurper(true,true).parse(fileName)

// validates against a schema
String file = "$base/books.xml"
String xsd = "$base/books.xsd"
SchemaFactory factory = 
	SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
Schema schema = factory.newSchema(new File(xsd))
Validator validator = schema.newValidator()
validator.validate(new StreamSource(new FileReader(file)))