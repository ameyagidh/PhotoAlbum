package testModel;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Models.Color;

public class testColor {
  private Color color1;
  private Color color2;
  private Color color3;

  /**
   * setUp() function creates objects.
   */

  @Before
  public void setUp() {
    this.color1 = new Color(180, 135, 110);
    this.color2 = new Color(100, 115, 85);

  }

  /**
   * testIllegealConstructor1() function check the edge cases which should
   * raise an IllegalArgumentException.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor1() {
    this.color3 = new Color(1000, 115, 85);
  }

  /**
   * testGetRed() function check if the value returned by
   * getRed() is as required.
   */
  @Test
  public void testGetRed() {
    assertEquals(180, this.color1.getRed(), 0);
    assertEquals(100, this.color2.getRed(), 0);
  }

  /**
   * testGetBlue() function check if the value returned by
   * getBlue() is as required.
   */
  @Test
  public void testGetBlue() {
    assertEquals(110, this.color1.getBlue(), 0);
    assertEquals(115, this.color2.getGreen(), 0);
  }

  /**
   * testGetGreen() function check if the value returned by
   * getGreen() is as required.
   */
  @Test
  public void testGetGreen() {
    assertEquals(135, this.color1.getGreen(), 0);
    assertEquals(115, this.color2.getGreen(), 0);
  }

  /**
   * testToString() function check if the value returned by
   * toString() is as required.
   */
  @Test
  public void testToString() {
    assertEquals("(180.0,135.0,110.0)", this.color1.toString());
    assertEquals("(100.0,115.0,85.0)", this.color2.toString());
  }
}