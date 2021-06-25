package scriptsTestNG;

import org.testng.annotations.Test;


public class ClassTwoSample {
  @Test
  public void methodOne() {
	  long id = Thread.currentThread().getId();
	  System.out.println("Method One " + id);
  }
  
  @Test
  public void methodTwo() {
	  long id = Thread.currentThread().getId();
	  System.out.println("Method Two " + id);
  }
  
  @Test
  public void methodThreee() {
	  long id = Thread.currentThread().getId();
	  System.out.println("Method Three " + id);
  }
}
