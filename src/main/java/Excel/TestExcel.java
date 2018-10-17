package Excel;

import org.testng.annotations.Test;

public class TestExcel {

    @Test(priority = 1)
    private void Testold()
    {
        WriteExcel aaa = new WriteExcel();
        aaa.WriteExcelxls();

    }

    @Test(priority = 2)
    public void Testnew()
    {
        WriteExcel aaa = new WriteExcel();
        aaa.WriteExcelxlsx();

    }
}
