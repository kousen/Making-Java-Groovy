package mjg.ast.delegate

class ContactManager {
    def contacts = [:]
    
    def addContact(int key, String info) {
        contacts[key] = info
    }
    
    def findContact(int key) {
        contacts[key]
    }
}
