import mjg.*

class BootStrap {
    GeocoderService geocoderService

    def init = { servletContext ->
        Quest quest = new Quest(name:'Seek the grail')
            .addToTasks(name:'Run away from killer rabbit')
            .addToTasks(name:'Answer the bridgekeeper',priority:1)
            .addToTasks(name:'Defeat the Black Knight',completed:true)
            .save(failOnError:true)
        Castle camelot = new Castle(name:'Camelot',city:'Marlborough',state:'CT')
            .addToKnights(title:'King',name:'Arthur',quest:quest)
            .addToKnights(title:'Sir', name:'Launcelot',quest:quest)
            .addToKnights(title:'Sir', name:'Robin',quest:quest)
        geocoderService.fillInLatLng(camelot)
        camelot.save(failOnError:true)
    }
    def destroy = {
    }
}
