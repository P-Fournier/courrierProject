package LetterTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import CourrierProject.City;
import Letter.Letter;

public class CityTest {
	
	MockInhabitant sender = new MockInhabitant ("sender",null);
	MockInhabitant receiver = new MockInhabitant ("receiver",null);
	MockRegisterableContent content = new MockRegisterableContent();
	
	/**
	 * create a city with some letter in the post box
	 * @return the city
	 */
	public City createCityWithLetter (){
		City test = new City ("cityTest");
		for (int i=0 ; i<5 ;i++){
			test.getPostbox().add(new MockLetter(sender,receiver,content));
		}
		return test;
	}
	
	/**
	 * create a city with an empty postbox
	 * @return the city
	 */
	public City createCityWithoutLetter (){
		City test = new City ("cityTest");
		return test;
	}
	
	@Test
	public void postBoxEmptyTest() {
		City empty = createCityWithoutLetter();
		City notEmpty = createCityWithLetter();
		
		assertTrue(empty.postboxEmty());
		assertFalse(notEmpty.postboxEmty());
	}
	
	@Test
	public void distributeLettersTest(){
		City test = createCityWithLetter();
		ArrayList<Letter<?>> letters = new ArrayList<Letter<?>>(test.getPostbox());
		
		test.distributeLetters();
		
		assertTrue(test.getPostbox().isEmpty());
		
		for (Letter<?> l : letters){
			MockLetter letter = (MockLetter) l;
			assertTrue(letter.isDeal());
		}
	}

}
