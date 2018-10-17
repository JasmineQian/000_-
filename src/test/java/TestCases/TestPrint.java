package TestCases;


import baseReport.GenerateReporter;
import baseUtil.BaseDBConnect;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

@Listeners({GenerateReporter.class})
public class TestPrint {

    @Test
    public void Test01(){
        Reporter.log("<a href='http://www.baidu.com' target='blank'>baidu.com</a>");
        System.out.println("1111111111111");
    }

    @Test
    public void Test02(){
        Reporter.log("DDDDDDDDDD");
        Reporter.log("AAAAAAAAAAAA");
        System.out.println("22222222222");
    }


    @Test
    public void Test03() throws FileNotFoundException {
        Reporter.log("3333");
        System.out.println("333333333333");
        BaseDBConnect dbConnect = new BaseDBConnect();
        try {
            dbConnect.DBQuery("SELECT * FROM BCUSTOMER_MZN WHERE CST_MOBILE = '10000000000'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
