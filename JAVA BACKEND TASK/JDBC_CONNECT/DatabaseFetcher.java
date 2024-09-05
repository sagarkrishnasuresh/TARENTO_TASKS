import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class DatabaseFetcher extends Thread {
    private String tableName;
    private ConcurrentHashMap<String, String> results;
    private CountDownLatch latch;

    public DatabaseFetcher(String tableName, ConcurrentHashMap<String, String> results, CountDownLatch latch) {
        this.tableName = tableName;
        this.results = results;
        this.latch = latch;
    }

    @Override
    public void run() {
        String url = "jdbc:postgresql://localhost:5432/TARENTO-TASK";
        String user = "postgres";
        String password = "1234";

        StringBuilder result = new StringBuilder();

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            String query = "SELECT * FROM " + tableName;
            ResultSet resultSet = statement.executeQuery(query);

            result.append("Data from table ").append(tableName).append(":\n");
            int columnCount = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    result.append(resultSet.getString(i)).append("\t\t");
                }
                result.append("\n");
            }
            results.put(tableName, result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            latch.countDown();
        }
    }
}
