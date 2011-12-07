package mjg.pp.entities


import javax.xml.bind.annotation.XmlAccessType 
import javax.xml.bind.annotation.XmlAccessorType 

@XmlAccessorType(XmlAccessType.FIELD)
class Ingredient {
	String name
	double amount
	String units
}
