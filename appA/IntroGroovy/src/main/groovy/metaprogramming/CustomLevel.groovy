package metaprogramming

import java.util.logging.Level;

class CustomLevel extends Level {
    CustomLevel(String name, int val) {
        super(name,val)
    }
}
