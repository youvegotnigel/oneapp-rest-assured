package ddt;

public class DataProvider {

    @org.testng.annotations.DataProvider(name = "dataForPost")
    public static Object[][] dataForPost() {
        return new Object[][]{
                {"ant-aal-aepz", "ant-aal-aepz", "8_5shift_D_2020-09-19"},
                {"ant-aal-aepz", "ant-aal-aepz", "8_5shift_D_2020-09-18"},
                {"ugl-ftml-unit1", "ugl-ftml-unit1", "day_shift_D_2020-09-19"},
                {"ugl-ftml-unit1", "ugl-ftml-unit1", "day_shift_D_2020-09-18"},
                {"bhg-knit", "bhg-knit", "day_shift_D_2020-09-18"},
                {"bhg-knit", "bhg-knit", "day_shift_D_2020-09-18"},
                {"pds-paba", "pds-paba", "day_shift_D_2020-09-18"},
                {"pds-paba", "pds-paba", "day_shift_D_2020-09-18"}
        };
    }

}
