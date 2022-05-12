package testModel;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Models.Color;
import Models.Oval;

public class testOval {
  private Oval Oval1;
  private Oval Oval2;
  private Color color1;
  private Color color2;

  /**
   * setUp() function creates objects.
   */

  @Before
  public void setUp() {
    this.color1 = new Color(180, 135, 110);
    this.Oval1 = new Oval("O", 200, 120, color1, 50.0, 100.0);
    this.color2 = new Color(180, 135, 110);
    this.Oval2 = new Oval("O", 210, 234, color2, 50.0, 100.0);
  }

  /**
   * testGetX() function check if the value returned by
   * getX() is as required.
   */
  @Test
  public void testGetX() {
    assertEquals(200, this.Oval1.getX(), 0);
    assertEquals(210, this.Oval2.getX(), 0);
  }

  /**
   * testGetY() function check if the value returned by
   * getY() is as required.
   */
  @Test
  public void testGetY() {
    assertEquals(120, this.Oval1.getY(), 0);
    assertEquals(234, this.Oval2.getY(), 0);
  }

  /**
   * testGetRadius1() function check if the value returned by
   * getRadius1() is as required.
   */
  @Test
  public void testGetRadius1() {
    assertEquals(50, this.Oval1.getSize1(), 0);
    assertEquals(50, this.Oval2.getSize2(), 0);
  }

  /**
   * testGetRadius2() function check if the value returned by
   * getRadius2() is as required.
   */
  @Test
  public void testGetRadius2() {
    assertEquals(100, this.Oval1.getSize1(), 0);
    assertEquals(100, this.Oval2.getSize2(), 0);
  }

  /**
   * testGetType() function check if the value returned by
   * getType() is as required.
   */
  @Test
  public void testGetType() {
    assertEquals("oval", this.Oval1.getType());
    assertEquals("oval", this.Oval2.getType());

  }

  /**
   * testMove() function check if the value returned by
   * Move() is as required.
   */
  @Test
  public void testMove() {
    this.Oval1.move(70, 45);
    assertEquals(70, this.Oval1.getX(), 0);
    assertEquals(45, this.Oval1.getY(), 0);
    this.Oval2.move(87, 245);
    assertEquals(87, this.Oval2.getX(), 0);
    assertEquals(245, this.Oval2.getY(), 0);

  }

  /**
   * testChangeColor() function check if the value returned by
   * ChangeColor() is as required.
   */
  @Test
  public void testChangeColor() {
    this.Oval1.ChangeColor(this.color2);
    assertEquals(this.color2, this.Oval1.getColor());
    this.Oval2.ChangeColor(this.color1);
    assertEquals(this.color1, this.Oval2.getColor());
  }

  /**
   * testGetColor() function check if the value returned by
   * GetColor() is as required.
   */
  @Test
  public void testGetColor() {
    assertEquals(this.color1, this.Oval1.getColor());
    assertEquals(this.color2, this.Oval2.getColor());
  }
}
