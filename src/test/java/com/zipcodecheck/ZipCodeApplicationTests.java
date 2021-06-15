package com.zipcodecheck;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.zipcodecheck.ZipCode;
import com.zipcodecheck.ZipCodeFinder;

@SpringBootTest
class ZipCodeApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	
	@Test
	void test1() {
		ZipCodeFinder zipCodeFinder = new ZipCodeFinder();
		String input = "[94133,94133] [94200,94299] [94600,94699]";
		List<ZipCode> list = zipCodeFinder.findZipCodeRestrictions(input);
		assertEquals(3,list.size());
		assertTrue(list.toString().contains("[94133,94133]"));
		assertTrue(list.toString().contains("[94200,94299]"));
		assertTrue(list.toString().contains("[94600,94699]"));
	}
	
	@Test
	void test2() {
		ZipCodeFinder zipCodeFinder = new ZipCodeFinder();
		String input = "[94133,94133] [94200,94299] [94226,94399]";
		List<ZipCode> list = zipCodeFinder.findZipCodeRestrictions(input);
		assertEquals(2,list.size());
		assertTrue(list.toString().contains("[94133,94133]"));
		assertTrue(list.toString().contains("[sdfw342342,sdfsdf23424]"));		
	}
	
	
}
