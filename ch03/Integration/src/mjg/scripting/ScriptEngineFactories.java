package mjg.scripting;

import java.util.List;
import java.util.logging.Logger;

import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

public class ScriptEngineFactories {
    private static Logger log = Logger.getLogger(ScriptEngineFactories.class.getName());
    
    public static void main(String[] args) {
        List<ScriptEngineFactory> factories =
            new ScriptEngineManager().getEngineFactories();
        for (ScriptEngineFactory factory : factories) {
            log.info("lang name: " + factory.getLanguageName());
            log.info("lang version: " + factory.getLanguageVersion());
            log.info("engine version: " + factory.getEngineVersion());
            log.info("engine name: " + factory.getEngineName());
            log.info(factory.getNames().toString());
        }
    }
}
