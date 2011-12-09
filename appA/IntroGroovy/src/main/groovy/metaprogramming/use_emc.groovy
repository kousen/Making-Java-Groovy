package metaprogramming

import java.util.logging.*

Logger.metaClass.methodMissing = { String name, args ->
    def impl = { Object... varArgs ->
        int val = Level.WARNING.intValue() +
            (Level.SEVERE.intValue() - Level.WARNING.intValue()) * Math.random()
        def level = new CustomLevel(name.toUpperCase(),val)
        delegate.log(level,varArgs[0])
    }
    Logger.metaClass."$name" = impl
    impl args
}


Logger log = Logger.getLogger(this.class.name)
log.wtf 'no effin way'
log.whoa 'dude, seriously'
log.rofl "you're kidding, right?"