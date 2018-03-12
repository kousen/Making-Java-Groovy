package service

import groovy.sql.Sql
import beans.Stadium

def stadiums = [
        new Stadium(name: 'Angel Stadium', street: '2000 Gene Autry Way', city: 'Anaheim', state: 'CA', team: 'ana'),
        new Stadium(name: 'Chase Field', street: '401 East Jefferson Street', city: 'Phoenix', state: 'AZ', team: 'ari'),
        new Stadium(name: 'Turner Field', street: '755 Hank Aaron Drive', city: 'Atlanta', state: 'GA', team: 'atl'),
        new Stadium(name: 'Oriole Park', street: '333 West Camden Street', city: 'Baltimore', state: 'MD', team: 'bal'),
        new Stadium(name: 'Fenway Park', street: '4 Yawkey Way', city: 'Boston', state: 'MA', team: 'bos'),
        new Stadium(name: 'U.S. Cellular Field', street: '333 West 35th Street', city: 'Chicago', state: 'IL', team: 'cha'),
        new Stadium(name: 'Wrigley Field', street: '1060 West Addison Street', city: 'Chicago', state: 'IL', team: 'chn'),
        new Stadium(name: 'Great American Ball Park', street: '100 Joe Nuxhall Way', city: 'Cincinnati', state: 'OH', team: 'cin'),
        new Stadium(name: 'Progressive Field', street: '2401 Ontario Street', city: 'Cleveland', state: 'OH', team: 'cle'),
        new Stadium(name: 'Coors Field', street: '2001 Blake Street', city: 'Denver', state: 'CO', team: 'col'),
        new Stadium(name: 'Comerica Park', street: '2100 Woodward Avenue', city: 'Detroit', state: 'MI', team: 'det'),
        new Stadium(name: 'Sun Life Stadium', street: '2267 NW 199th Street', city: 'Miami Gardens', state: 'FL', team: 'flo'),
        new Stadium(name: 'Minute Maid Park', street: '501 Crawford Street', city: 'Houston', state: 'TX', team: 'hou'),
        new Stadium(name: 'Kauffman Stadium', street: 'One Royal Way', city: 'Kansas City', state: 'MO', team: 'kca'),
        new Stadium(name: 'Dodger Stadium', street: '1000 Elysian Park Avenue', city: 'Dodgertown', state: 'CA', team: 'lan'),
        new Stadium(name: 'Miller Park', street: 'One Brewers Way', city: 'Milwaukee', state: 'WI', team: 'mil'),
        new Stadium(name: 'Target Field', street: '1 Twins Way', city: 'Minneapolis', state: 'MN', team: 'min'),
        new Stadium(name: 'Yankee Stadium', street: 'East 161st Street & River Avenue', city: 'New York', state: 'NY', team: 'nya'),
        new Stadium(name: 'Citi Field', street: '126th St. and Roosevelt Ave', city: 'Flushing', state: 'NY', team: 'nyn'),
        new Stadium(name: 'O.co Coliseum', street: '7000 Coliseum Way', city: 'Oakland', state: 'CA', team: 'oak'),
        new Stadium(name: 'Citizens Bank Park', street: 'One Citizens Bank Way', city: 'Philadelphia', state: 'PA', team: 'phi'),
        new Stadium(name: 'PNC Park', street: '115 Federal Street', city: 'Pittsburgh', state: 'PA', team: 'pit'),
        new Stadium(name: 'PETCO Park', street: '19 Tony Gwynn Drive', city: 'San Diego', state: 'CA', team: 'sdn'),
        new Stadium(name: 'Safeco Field', street: '1516 First Avenue S', city: 'Seattle', state: 'WA', team: 'sea'),
        new Stadium(name: 'AT&T Park', street: '24 Willie Mays Plaza', city: 'San Francisco', state: 'CA', team: 'sfn'),
        new Stadium(name: 'Busch Stadium', street: '700 Clark Avenue', city: 'St. Louis', state: 'MO', team: 'sln'),
        new Stadium(name: 'Tropicana Field', street: 'One Tropicana Drive', city: 'St. Petersburg', state: 'FL', team: 'tba'),
        new Stadium(name: 'Rangers Ballpark in Arlington', street: 'Ballpark Way', city: 'Arlington', state: 'TX', team: 'tex'),
        new Stadium(name: 'Rogers Centre', street: 'One Blue Jays Way', city: 'Toronto', state: 'ON', team: 'tor'),
        new Stadium(name: 'Nationals Park', street: '1500 South Capitol Street SE', city: 'Washington', state: 'DC', team: 'was')]

Sql db = Sql.newInstance(
        url: 'jdbc:h2:build/baseball', driver: 'org.h2.Driver')

db.execute "DROP TABLE IF EXISTS stadium;"
db.execute '''
    CREATE TABLE stadium(
        id INT NOT NULL AUTO_INCREMENT,
        name VARCHAR(200) NOT NULL,
        team CHAR(3) NOT NULL,
        latitude DOUBLE,
        longitude DOUBLE,
        PRIMARY KEY(id)
    );
'''

Geocoder geo = new Geocoder()
stadiums.each { s ->
    geo.fillInLatLng s
    sleep 20
    println s
    db.execute """
        insert into stadium(name,team,latitude,longitude)
        values(${s.name},${s.team},${s.latitude},${s.longitude});
    """
}

assert db.rows('SELECT * FROM stadium').size() == stadiums.size()
db.eachRow('SELECT latitude,longitude FROM stadium') { row ->
    assert row.latitude > 25 && row.latitude < 48
    assert row.longitude > -123 && row.longitude < -71
}
