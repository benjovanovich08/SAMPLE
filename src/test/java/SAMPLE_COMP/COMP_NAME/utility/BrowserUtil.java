package SAMPLE_COMP.COMP_NAME.utility;

public class BrowserUtil {

    public static void sleep(int millisecs){
        try {
            Thread.sleep(millisecs);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
