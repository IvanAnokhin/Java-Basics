package core;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class MetroMap {
    private final JSONObject metroObject;
    public MetroMap(JSONObject stationsObject, JSONArray linesArray, JSONArray connectionsArray) {
        metroObject = new JSONObject();
        metroObject.put("stations", stationsObject);
        metroObject.put("lines", linesArray);
        metroObject.put("connections", connectionsArray);
    }
    public JSONObject getMetroObject() {
        return metroObject;
    }
}