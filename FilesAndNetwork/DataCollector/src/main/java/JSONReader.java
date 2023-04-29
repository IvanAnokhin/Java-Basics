import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
public class JSONReader {
    public void getAmountOfStations(String path) throws Exception {
        JSONParser parser = new JSONParser();
        Object object = parser.parse(new FileReader(path));
        JSONObject metroJsonObject = (JSONObject) object;
        JSONObject stationsObj = (JSONObject) metroJsonObject.get("stations");
        stationsObj.keySet().forEach(k -> {
            JSONArray stationsArray = (JSONArray) stationsObj.get(k);
            System.out.println("Линия " + k + ". Количество станций: " + stationsArray.size() + ".");
        });
    }
}