package mjg.rest

import groovy.sql.Sql

class JdbcCustomerDAO implements CustomerDAO {
    static Sql sql = Sql.newInstance(url:'jdbc:h2:mem:', driver:'org.h2.Driver')

    static {
        sql.execute '''
            create table customers(
                id int auto_increment,
                first varchar(255) not null,
                last varchar(255) not null,
                primary key(id)
            );
        '''

        sql.execute """
            insert into customers values (null, 'Jean-Luc', 'Picard'),
            (null, 'Johnathan', 'Archer'), (null, 'James', 'Kirk'),
            (null, 'Benjamin', 'Sisko'), (null, 'Kathryn', 'Janeway');
        """
    }

    List<Customer> findAll() {
        String txt = 'select * from customers'
        sql.rows(txt).collect { row -> new Customer(id:row.id, first:row.first, last:row.last) }
    }

    Customer findById(long id) {
        String txt = 'select * from customers where id=?'
        def row = sql.firstRow(txt, [id])
        new Customer(id:row.id, first:row.first, last:row.last)
    }

	List<Customer> findByLastName(String name) {
        String txt = 'select * from customers where last like ?'
        List<Customer> customers = []
        customers += sql.rows(txt, "%$name%".toLowerCase()).collect { row -> 
            new Customer(id:row.id, first:row.first, last:row.last) }
        customers += sql.rows(txt, "%$name%".toUpperCase()).collect { row ->
            new Customer(id:row.id, first:row.first, last:row.last) }
        customers
    }

    Customer create(Customer c) {
        String txt = 'insert into customers(id, first, last) values(?, ?, ?)'
        def keys = sql.executeInsert txt, [null, c.first, c.last]
        c.id = keys[0][0]
        return c
    }

    Customer update(Customer c) {
        String txt = 'update customers set first=?, last=? where id=?'
        sql.execute txt, [c.first, c.last, c.id]
        return c
    }

    boolean delete(long id) {
        String txt = 'delete from customers where id=?'
        int uc = sql.executeUpdate txt, [id]
        return uc == 1
    }
}
