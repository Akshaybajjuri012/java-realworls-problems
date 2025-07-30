package junitdemo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JunitAssertionDemo {
	@Test

	public void mytest1(){
		String obj1="junit";
		String obj2="junit";
		String obj3=new String("test");
		String obj4="test";
		String obj5=null;
		int var1=1;
		int var2=2;
		int[] arithmetic1= {1,2,3,4,5};
		int[] arithmetic2= {1,2,3,4,5};
		assertEquals(obj3,obj4);
		assertEquals(obj1,obj2);
		

	}

}
