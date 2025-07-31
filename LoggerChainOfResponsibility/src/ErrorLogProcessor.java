public class ErrorLogProcessor extends  LogProcessor{

    public ErrorLogProcessor(LogProcessor nextLogProcessor){
        super(nextLogProcessor);
    }
    @Override
    public void log(int logLevel, String msg) {
        if(logLevel==ERROR){
            System.out.println("ERROR "+msg);
        }
        else{
            super.nextLogProcessor.log(logLevel, msg);
        }
    }
}
