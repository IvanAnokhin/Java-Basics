import java.util.Date;
import java.util.List;
import redis.clients.jedis.Jedis;
//import redis.clients.jedis.ScanResult;
//import redis.clients.jedis.Tuple;
import redis.clients.jedis.resps.ScanResult;
import redis.clients.jedis.resps.Tuple;
public class WebsiteLog {
    private Jedis client;
    List<Tuple> result;
    public WebsiteLog(Jedis client) {
        this.client = client;
    }
    public void start() {
        init();
        print();
    }
    private void init() {
        removeKey();
        for (int i = 1; i <= 20; i++) {
            client.zadd("Users", new Date().getTime(), String.valueOf(i));
        }
        ScanResult<Tuple> users = client.zscan("Users", "0");
        result = users.getResult();
    }
    private void print() {
        for (Tuple user : result) {
            System.out.println("User " + user.getElement());
            try {
                Thread.sleep(1000);
                if (Math.random() < 0.10) {
                    bill();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        print();
    }
    private void bill() throws InterruptedException {
        int i = (int) (0 + result.size() * Math.random());
        String element = result.get(i).getElement();
        System.out.println("User " + element + " paid for a paid service");
        System.out.println("User " + element);
        Thread.sleep(1000);

    }
    private void removeKey() {
        client.del("Users");
    }
}