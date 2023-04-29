import org.json.simple.JSONObject;
import java.io.FileWriter;
public class JSONCreator {
    public JSONCreator() {
    }
    public void writeInJSONFile(JSONObject object, String path) throws Exception {
        FileWriter file = new FileWriter(path);
        file.write(object.toJSONString());
        file.flush();
        file.close();
    }
}