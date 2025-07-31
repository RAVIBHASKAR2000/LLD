public class Main {
    public static void main(String[] args) {

        LogProcessor logger = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        logger.log(logger.ERROR, "exception message");

        logger.log(logger.INFO, "information message");
    }
}