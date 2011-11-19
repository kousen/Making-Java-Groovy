package ast.delegate

class Phone {
    def dial(String number) { "dialing $number" }
}

class Camera {
    def takePicture() { "taking picture" }
}

class SmartPhone {
    @Delegate Phone phone
    @Delegate Camera camera
}

SmartPhone sp = new SmartPhone(phone:new Phone(),camera:new Camera())
assert sp.dial('555-1234') == 'dialing 555-1234'
assert sp.takePicture() == 'taking picture'