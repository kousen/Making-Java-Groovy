package db

import groovy.sql.Sql
import groovy.xml.MarkupBuilder;

Sql sql = Sql.newInstance(url:'jdbc:h2:mem:',driver:'org.h2.Driver')

sql.execute '''
	create table product (
		id int primary key,
		name varchar(25),
		price double
	)
'''

sql.execute """
	insert into product values
	(1,'baseball',4.99),(2,'football',14.95),(3,'basketball',14.99)
"""
def builder = new MarkupBuilder()

builder.products {
	sql.eachRow("select * from product") { row ->  
		product(id:row.id) {
			name row.name
			price row.price
		}	
	}
}
