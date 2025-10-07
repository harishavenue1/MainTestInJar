package org.example;

import org.testng.TestNG;

public class TestRunner {
    
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java -cp MainTestInJar-executable.jar org.example.TestRunner <suite>");
            System.out.println("Available suites: all, ui, api");
            return;
        }
        
        TestNG testng = new TestNG();
        String suite = args[0].toLowerCase();
        
        switch (suite) {
            case "ui":
                testng.setTestSuites(java.util.Arrays.asList("testng-ui.xml"));
                break;
            case "api":
                testng.setTestSuites(java.util.Arrays.asList("testng-api.xml"));
                break;
            case "all":
            default:
                testng.setTestSuites(java.util.Arrays.asList("testng.xml"));
                break;
        }
        
        testng.run();
    }
}