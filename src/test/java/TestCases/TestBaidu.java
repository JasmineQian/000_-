package TestCases;


import baseReport.GenerateReporter;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners({GenerateReporter.class})
public class TestBaidu {

    @Test
    public void a(){
        Reporter.log("<a href='http://www.baidu.com' target='blank'>baidu.com</a>");
        System.out.println("111");
    }

    @Test(enabled=false,dependsOnMethods="a")
    @Parameters("param")
    public void b(String s){
        Assert.assertEquals(s,"dataxml");

    }
    @Test(enabled=true,dependsOnMethods="e")
    public void c(){
        Assert.assertEquals(2,2);
    }


    @Test(description="测试方法 DDD")
    public void d() {
        Reporter.log("DDDDDDDDDD");
        Reporter.log("AAAAAAAAAAAA");
        System.out.println("Verify.verifyEquals(2,2)");
        Assert.assertEquals(2,2);
    }

    @Test(description="98788",groups="test",invocationCount=1,dependsOnMethods="d")
    public void e() {
        Reporter.log("EEEEEEEEEEEEEEEEE");
        Assert.assertEquals(1,2);
        System.out.println("Verify.verifyEquals(2,2)");
    }

}
