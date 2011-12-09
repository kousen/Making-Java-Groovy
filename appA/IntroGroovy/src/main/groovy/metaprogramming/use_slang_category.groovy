package metaprogramming

import java.util.logging.Level;
import java.util.logging.Logger

class SlangCategory {
    static String fyi(Logger self, String msg) {
        return self.log(new CustomLevel('FYI',Level.INFO.intValue()),msg)
    }
    static String lol(Logger self, String msg) {
        return self.log(new CustomLevel('LOL',Level.WARNING.intValue()),msg)
    }
}

Logger log = Logger.getLogger(this.class.name)
use(SlangCategory) {
    log.fyi 'this seems okay'
    log.lol('snicker')
}