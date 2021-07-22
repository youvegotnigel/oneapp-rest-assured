package ddt;
import org.testng.annotations.DataProvider;

public class DataForTests {

    @DataProvider(name = "dataForGetSchedule")
    public static Object[][] dataForPost() {
        return new Object[][]{
//                {"ant-aal-aepz", "ant-aal-aepz", "8_5shift_D_2020-09-20"},
//                {"ant-aal-aepz", "ant-aal-aepz", "8_5shift_D_2020-09-19"},
//                {"ugl-ftml-unit1", "ugl-ftml-unit1", "day_shift_D_2020-09-20"},
//                {"ugl-ftml-unit1", "ugl-ftml-unit1", "day_shift_D_2020-09-19"},
//                {"bhg-knit", "bhg-knit", "day_shift_D_2020-09-20"},
//                {"bhg-knit", "bhg-knit", "day_shift_D_2020-09-19"},
//                {"bhg-knit", "bhg-knit", "day_shift_D_2020-09-18"},
//                {"pds-paba", "pds-paba", "day_shift_D_2020-09-20"},
                {"pds-paba", "pds-paba", "day_shift_D_2020-09-19"},
                {"pds-paba", "pds-paba", "day_shift_D_2020-09-18"}
        };
    }

}
