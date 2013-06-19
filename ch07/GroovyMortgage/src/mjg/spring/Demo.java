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
package mjg.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {
        ApplicationContext ctx = 
            new FileSystemXmlApplicationContext(
                    "resources/applicationContext.xml");
        Evaluator e = null;
        boolean ok;
        
        for (int i = 0; i < 10; i++) {
            e = (Evaluator) ctx.getBean("groovyEvaluator");
            ok = e.approve(null);
            System.out.println(ok ? "approved" : "denied");
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        
        ((FileSystemXmlApplicationContext) ctx).close();
    }
}
