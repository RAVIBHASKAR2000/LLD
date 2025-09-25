package main.java.org.lldProblemStatements.RateLimiter;

public class Request {
    private String clientID;
    private Method requestMethod;
    public enum Method{GET,POST,PUT,DELETE,PATCH};
    private String endpoint;

    public Request(String clientID, String endpoint, Method method) {
        this.clientID = clientID;
        this.endpoint = endpoint;
        this.requestMethod = method;
    }

    public String getClientID() {
        return clientID;
    }

    public Method getRequestMethod() {
        return requestMethod;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
