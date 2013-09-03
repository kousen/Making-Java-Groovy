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
package mjg.aspects

import java.util.logging.Logger

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before

@Aspect
class UpdateReporter {
    Logger log = Logger.getLogger(UpdateReporter.class.name)
    
    @Before("execution(void set*(*))")
    void reportOnSet(JoinPoint jp) {
        String method = jp.signature.name
        String property = (method - 'set')[0].toLowerCase() + 
            (method - 'set')[1..-1]
        def current = jp.target."$property"
        log.info "About to change $property from $current to ${jp.args[0]}"
    }
}
