import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {
        // List of tables to fetch data from
        String[] tables = {"employees", "departments", "projects"};

        // Thread-safe map to store the results
        ConcurrentHashMap<String, String> results = new ConcurrentHashMap<>();

        // Latch to wait for all threads to finish
        CountDownLatch latch = new CountDownLatch(tables.length);

        // Start a thread for each table
        for (String table : tables) {
            DatabaseFetcher fetcher = new DatabaseFetcher(table, results, latch);
            fetcher.start();
        }

        // Wait for all threads to complete
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the results in the correct order
        for (String table : tables) {
            System.out.println(results.get(table));
        }
    }
}
