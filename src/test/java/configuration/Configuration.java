package configuration;

public class Configuration {
    public static final String MAIN_ADMIN_EMAIL = System.getProperty("email", new MainAdmin().getEmail());
    public static final String MAIN_ADMIN_PASSWORD = System.getProperty("password", new MainAdmin().getPassword());

    public static final String BASE_URL = "https://scc.stage.pricemds.com/";
    public static final String API_SERVER = "https://api.scc.stage.pricemds.com";
    public static final String BROWSER = "chrome";
    public static final String BROWSER_SIZE = "1920x1080";
    public static final int TIMEOUT = 10_000;

}
