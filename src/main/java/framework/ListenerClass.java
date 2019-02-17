package framework;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ListenerClass extends TestListenerAdapter {

    @Override
    public void onTestStart(ITestResult tr) {
        log(String.format("Test Started %s....", tr.getName()));
    }

    @Override
    public void onTestSuccess(ITestResult tr) {

        log(String.format("Test '%s' PASSED", tr.getName()));
        System.out.println(".....");
    }

    @Override
    public void onTestFailure(ITestResult tr) {

        log(String.format("Test '%s' FAILED", tr.getName()));
        System.out.println(".....");
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        log("Test '" + tr.getName() + "' SKIPPED");
        System.out.println(".....");
    }

    private void log(String methodName) {
        System.out.println(methodName);
    }

}
