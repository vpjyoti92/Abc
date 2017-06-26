package Test;

import java.io.IOException;

public class SampleJavaTest {
private static Process process;
private static String APPIUMSERVERSTART = "C:/Program Files (x86)/Appium/Appium.exe";    

public static void startAppiumServer() throws IOException, InterruptedException {
    Runtime runtime = Runtime.getRuntime();
    process = runtime.exec(APPIUMSERVERSTART);
    Thread.sleep(5000);
    if (process != null) {
        System.out.println("Appium server started");
    }
}

public static void stopAppiumServer() throws IOException {
    if (process != null) {
        process.destroy();
    }
    System.out.println("Appium server stop");
}

public static void main(String args[]) throws IOException, InterruptedException {        
    startAppiumServer();
    
    stopAppiumServer();
}
}