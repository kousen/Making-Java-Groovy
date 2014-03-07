/* ===================================================
 * Copyright 2012 Kousen IT, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ========================================================== */
package metaprogramming

import java.util.logging.*

Logger.metaClass.methodMissing = { String name, args ->
    println "inside methodMissing with $name"
    int val = Level.WARNING.intValue() +
            (Level.SEVERE.intValue() - Level.WARNING.intValue()) * Math.random()
    def level = new CustomLevel(name.toUpperCase(),val)
    def impl = { Object... varArgs ->
        delegate.log(level,varArgs[0])
    }
    Logger.metaClass."$name" = impl
    impl args
}


Logger log = Logger.getLogger(this.class.name)
log.wtf 'no effin way'
log.whoa 'dude, seriously'
log.rofl "you're kidding, right?"
log.rofl 'rolling on the floor laughing'
log.whatever 'heavy sigh'
log.hi 'hello'
log.dude 'what up?'