/**
 * Created by manish_kumar9 on 11/02/16.
 */
import static spark.Spark.*;

public class HelloWorld {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }
}