package db

import groovy.sql.Sql

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

assert sql.rows('select * from product').size() == 3

List<Product> products = []
sql.eachRow('select * from product') { row ->
    products << new Product(id:row.id,name:row.name,price:row.price)        
} 
assert products.size() == 3

def params = [4,'soccer ball',16.99]
sql.execute 'insert into product(id,name,price) values(?,?,?)', params

def row = sql.firstRow('select * from product where id=?', 4)
assert row.id == 4
assert row.name == 'soccer ball'
assert row.price == 16.99

sql.close()