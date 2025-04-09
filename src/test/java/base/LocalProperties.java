package base;

import java.util.HashMap;
import java.util.Map;

public class LocalProperties {
    public static Map<String, String> map = new HashMap<>();

    public static String getBaseUrl() {
        return "https://staging11.shortest-route.com/qatest/home/login.jsp";
    }
    public static String getUsername() {
        return "anka.ivkovic@mapp.com";
    }
    public static String getPassword() {
        return "Mijija>2";
    }
}
