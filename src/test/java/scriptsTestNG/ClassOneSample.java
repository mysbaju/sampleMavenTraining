package scriptsTestNG;

import org.testng.annotations.Test;

public class ClassOneSample {
	@Test
	  public void methodOne() {
		  long id = Thread.currentThread().getId();
		  System.out.println("Class One " + id);
	  }
	  
	  @Test
	  public void methodTwo() {
		  long id = Thread.currentThread().getId();
		  System.out.println("Class Two " + id);
	  }
	  
	  @Test
	  public void methodThreee() {
		  long id = Thread.currentThread().getId();
		  System.out.println("Class Three " + id);
	  }
}
