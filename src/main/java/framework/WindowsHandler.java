package framework;

import java.util.ArrayList;

public class WindowsHandler {

    public static void switchBetweenTabs(int tabNum){
        ArrayList<String> tabs = new ArrayList<String> (BasePage.driver.getWindowHandles());
        BasePage.driver.switchTo().window(tabs.get(tabNum));
    }

    public static int getNumOfBrowserTabs(){
        return BasePage.driver.getWindowHandles().size();
    }

    public static void closeTab(){
        BasePage.driver.close();
    }

    public static void closeTabsExceptOne(){
        ArrayList<String> tabs = new ArrayList<String> (BasePage.driver.getWindowHandles());
        int numOfTabs = getNumOfBrowserTabs();

        for(int tabNum = 0; tabNum < numOfTabs - 1; tabNum++){
            BasePage.driver.switchTo().window(tabs.get(tabNum));
            closeTab();
            BasePage.driver.switchTo().window(tabs.get(tabNum));
        }
    }
}
