package mjg

import groovy.sql.Sql

class SqlProductDAO implements ProductDAO {
    Sql sql = Sql.newInstance(url:'jdbc:h2:mem:',driver:'org.h2.Driver')

    SqlProductDAO() {
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
    }

    List<Product> getAllProducts() {
        sql.rows('select * from product').collect { row ->
            new Product(
                row.collectEntries { k,v -> [k.toLowerCase(), v] }   
            )
        }
    }

    Product findProductById(int id) {
        def row = sql.firstRow('select * from product where id=?', id)
        return new Product( row.collectEntries { k,v -> [k.toLowerCase(), v] } );
	}

    void insertProduct(Product p) {
        def params = [p.id, p.name, p.price]
        sql.execute 'insert into product(id,name,price) values(?,?,?)', params
    }

    void deleteProduct(int id) {
        sql.execute 'delete from product where id=?', id
    }
}
