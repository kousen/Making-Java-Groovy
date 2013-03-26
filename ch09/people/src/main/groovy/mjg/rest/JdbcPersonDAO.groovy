package mjg.rest

import groovy.sql.Sql

@Singleton
class JdbcPersonDAO implements PersonDAO {
    static Sql sql = Sql.newInstance(url:'jdbc:h2:db', driver:'org.h2.Driver')

    static {
        sql.execute 'drop table if exists people'
        
        sql.execute '''
            create table people(
                id int auto_increment,
                first varchar(255) not null,
                last varchar(255) not null,
                primary key(id)
            );
        '''

        sql.execute """
            insert into people values (null, 'Jean-Luc', 'Picard'),
            (null, 'Johnathan', 'Archer'), (null, 'James', 'Kirk'),
            (null, 'Benjamin', 'Sisko'), (null, 'Kathryn', 'Janeway');
        """
    }

    List<Person> findAll() {
        String txt = 'select * from people'
        sql.rows(txt).collect { row -> new Person(id:row.id, first:row.first, last:row.last) }
    }

    Person findById(long id) {
        String txt = 'select * from people where id=?'
        def row = sql.firstRow(txt, [id])
        new Person(id:row.id, first:row.first, last:row.last)
    }

	List<Person> findByLastName(String name) {
        String txt = 'select * from people where last like ?'
        List<Person> customers = []
        customers += sql.rows(txt, "%$name%".toLowerCase()).collect { row -> 
            new Person(id:row.id, first:row.first, last:row.last) }
        customers += sql.rows(txt, "%$name%".toUpperCase()).collect { row ->
            new Person(id:row.id, first:row.first, last:row.last) }
        customers
    }

    Person create(Person p) {
        String txt = 'insert into people(id, first, last) values(?, ?, ?)'
        def keys = sql.executeInsert txt, [null, p.first, p.last]
        p.id = keys[0][0]
        return p
    }

    Person update(Person p) {
        String txt = 'update people set first=?, last=? where id=?'
        sql.execute txt, [p.first, p.last, p.id]
        return p
    }

    boolean delete(long id) {
        String txt = 'delete from people where id=?'
        int uc = sql.executeUpdate txt, [id]
        return uc == 1
    }
}
