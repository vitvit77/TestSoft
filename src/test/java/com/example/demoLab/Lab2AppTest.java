package com.example.demoLab;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.security.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;


@SpringBootTest
public class Lab2AppTest {
    NewCalculator newCalculator;


    @BeforeEach
    public void init(){
        //	System.out.println("Run test...");
        newCalculator= new NewCalculator();
    }
    @AfterEach
    public void destroy() {
        System.out.println("Finish test.");
    }

    @Test
    @Disabled
    public void whenUseFactorialCorrectValue() {

        Long result = newCalculator.Factorial(3);
        assertEquals(6, result);
        result = newCalculator.Factorial(6);
        assertEquals(720, result);
    }
    @Test
    @Order(6)
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    public void whenExecTimeMore1s() throws InterruptedException {
        Thread.sleep(100);
    }

    @ParameterizedTest
    @Order(5)
    @ValueSource(ints = {3,9,27,0,-3})
    public void whenUseWithParam(int num) {
        System.out.println(num);
        assertTrue(num>0);
    }

    @ParameterizedTest
    @Order(4)
    @DisplayName("Example of calculating the square root and its value")
    @CsvSource({
            "2,4",
            "3,9",
            "4,16",
            "5,25"
    })
    public void whenUseWithParam2RootSquare(int a,int b) {
        double result = newCalculator.RootSquare(b);
        assertEquals(a, result);

    }

    @ParameterizedTest
    @NullSource
    @Order(3)
    void testMethodNullSource(Integer argument) {
        assertTrue(argument == null);
    }
    enum Cars {
        VOLVO,OPEL,MAZDA,TOYOTA,FORD,TESLA
    }
    @ParameterizedTest
    @EnumSource(Cars.class)
    @Order(2)
    void testCarsBeginNameT(Cars cars){
        assertNotNull(cars);
    }
    @ParameterizedTest
    @MethodSource("DayOfMonth")
    @Order(1)
    void testWithMethodSource(int day , String month) {
        assertFalse(31==day);
    }

    static Stream<Arguments> DayOfMonth() {
        return Stream.of(arguments(31, "January"),
                arguments(28, "February"),
                arguments(31, "March"),
                arguments(30, "April"),
                arguments(31, "May"),
                arguments(30, "June"),
                arguments(31, "July"),
                arguments(31, "August"),
                arguments(30, "September"),
                arguments(31, "October"),
                arguments(30, "November"),
                arguments(31, "December"));
    }

    private class Sitizen{

        private String Name;
        private String MiddleName;
        private String LastName;
        private String INN;

        private Sitizen(String Name, String MiddleName, String LastName, String INN) {
            this.Name = Name;
            this.MiddleName = MiddleName;
            this.LastName = LastName;
            this.INN = INN;
        }

        public String getName() {
            return Name;
        }

        public String getMiddleName() {
            return MiddleName;
        }
        public String getLastName() {
            return LastName;
        }
        public String getINN() {
            return INN;
        }
    }
    @Test
    @Order(7)
    public void whenTestSitizenReturnCorrectValues(){
        Lab2AppTest.Sitizen Sitizen = new Lab2AppTest.Sitizen("Виталий","Владимирович", "Дашкевич", "24695204433");
        assertAll("Full Check",
                () -> assertEquals("Виталий",Sitizen.getName()),
                () -> assertEquals("Владимирович",Sitizen.getMiddleName()),
                () -> assertEquals("Дашкевич",Sitizen.getLastName()),
                () -> assertEquals("24695204433" ,Sitizen.getINN())
        );
    }

    @Test
    @Order(8)
    @DisplayName("Test time max 5 sec")
    public void whenTestAssertingTimeout() {
        assertTimeout(
                ofSeconds(5),
                () -> {
                    // пауза в одну секунду
                    Thread.sleep(4900);
                }
        );
    }


    @Test
    void exceptionTesting() {
        List<String> emptyList = new ArrayList<>();
        Optional<String> opt = emptyList.stream().findFirst();
        assertThrows(NoSuchElementException.class, () -> opt.get());

    }

}
