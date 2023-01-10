package com.example.demoLab;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoLabApplicationTests {

	@Test
	@Order(1)
	public void secondTest(){
		System.out.println("Second Test");
	}
	@Test
	@Order(2)
	public void firstTest(){
		System.out.println("First Test");
	}

	private class Address{

		private String city;
		private String street;
		private String house;

		private Address(String city, String street, String house) {
			this.city = city;
			this.street = street;
			this.house = house;
		}

		public String getCity() {
			return city;
		}

		public String getStreet() {
			return street;
		}
		public String getHouse() {
			return house;
		}
	}
	@Test
	@Order(3)
	public void whenTestAddressReturnCorrectValues(){
		Address address = new Address("Днепр","Соборная", "8");
		assertAll("Full Check",
				() -> assertEquals("Днепр",address.getCity()),
				() -> assertEquals("Соборная",address.getStreet()),
				() -> assertEquals("8",address.getHouse())
		);
	}

	Calculator calculator;

	@BeforeAll
	public static void initAll(){
		System.out.println("Run Once...");

	}
	@AfterAll
	public static void DestroyAll(){
		System.out.println("Stop Once...");
	}
	@BeforeEach
	public void init(){
		//	System.out.println("Run test...");
		calculator = new Calculator();
	}

	@AfterEach
	public void destroy(){
		//	System.out.println("Stop test...");
	}
	@ParameterizedTest
	@ValueSource(ints = {1,3,5,7,9,0,-9})
	public void whenUseWithParam(int num) {
		System.out.println(num);

	}

	@ParameterizedTest
	@CsvSource({
			"1,7",
			"2,6",
			"4,4",
			"9,-1"
	})
	public void whenUseWithParam2(int a,int b) {
		int result = calculator.add(a,b);
		assertEquals(8, result);
		assertNotNull(a);
	}
	@Test
	public void whenUseAddGetCorrectSum() {

		int result = calculator.add(3, 5);
		assertEquals(8, result);
		result = calculator.add(2, 3);
		assertEquals(5, result);
	}
	@Test
	public void whenUseSubGetCorrectSub() {

		int result = calculator.sub(3, 5);
		assertEquals(-2, result);
		result = calculator.sub(2, 3);
		assertEquals(-1, result);
	}
	@Test
	public void whenUseAddGetCorrectMult() {

		int result = calculator.mult(3, 5);
		assertEquals(15, result);
		result = calculator.mult(2, 3);
		assertEquals(6, result);
	}
	@Test
	public void whenUseAddGetCorrectDiv() {

		Double result = calculator.div(15, 5);
		assertEquals(3, result);
		result = calculator.div(30, 3);
		assertEquals(10, result);
	}
	@Test
	@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
	public void whenExecTimeMore1s() throws InterruptedException {
		Thread.sleep(100);
	}




}
