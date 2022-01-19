package utilities;

import java.util.HashMap;
import java.util.Map;
import enums.Context;

public class ScenarioContext {
	private  Map<String, Object> scenarioContext;

    public ScenarioContext(){
        scenarioContext = new HashMap<String, Object>();
    }

    public void setValues(Context key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public Object getValues(Context key){
        return scenarioContext.get(key.toString());
    }

    public Boolean isContains(Context key){
        return scenarioContext.containsKey(key.toString());
    }


}
