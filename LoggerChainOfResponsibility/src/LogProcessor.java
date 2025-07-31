public abstract class LogProcessor {
    public  static  int INFO =1;
    public  static  int ERROR =2;
    public  static  int DEBUG =3;

    LogProcessor nextLogProcessor;

    public LogProcessor(LogProcessor nextLogProcessor){
        this.nextLogProcessor = nextLogProcessor;
    }

    public abstract   void  log(int logLevel, String msg);
}
