package mjg.bank

Account a1 = new Account(1, 100)
Account a2 = new Account(2, 100)
def accounts = [1:a1, 2:a2]
int nextId = 3

def mock = [findAccountById: { int id -> accounts[id] },
            findAllAccounts: { -> accounts.values() },
            createNewAccount: { double bal -> nextId++ },
            deleteAccount: { int id -> } ] as AccountDAO

assert mock.findAccountById(1) == a1
mock.findAllAccounts().each {
    assert accounts.containsValue(it)
}
assert 3 == mock.createNewAccount(200)
assert !mock.deleteAccount(3)