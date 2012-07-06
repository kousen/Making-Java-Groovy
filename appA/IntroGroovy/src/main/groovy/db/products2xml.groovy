/* ===================================================
 * Copyright 2012 Kousen IT, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ========================================================== */
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
