package main.java.org.lld.SingletonPattern;

public class AppConfiguration {
    private static AppConfiguration instance;
    private String apiKey;
    private String databaseURL;
    private String clusterURL;

    private AppConfiguration(){
        apiKey = "ASDAS-DASD-ASD-ASD-ASD";
        clusterURL = "https://google.com";
        databaseURL = "https://postgres:8000/asda0sd9a";
    }

    public static AppConfiguration getInstance(){
        if(instance==null){
            instance =  new AppConfiguration();
        }
        return instance;
    }


    public String getDatabaseURL() {
        return databaseURL;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getClusterURL() {
        return clusterURL;
    }

}
