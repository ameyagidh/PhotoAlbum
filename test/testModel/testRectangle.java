package testModel;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Models.Color;
import Models.Rectangle;

public class testRectangle {

  private Rectangle rectangle1;
  private Rectangle rectangle2;
  private Color color1;
  private Color color2;

  /**
   * setUp() function creates objects.
   */

  @Before
  public void setUp() {
    this.color1 = new Color(180, 135, 110);
    this.rectangle1 = new Rectangle("R", 200, 120, color1, 50.0, 100.0);
    this.color2 = new Color(180, 135, 110);
    this.rectangle2 = new Rectangle("R", 210, 234, color2, 50.0, 100.0);
  }

  /**
   * testGetX() function check if the value returned by
   * getX() is as required.
   */
  @Test
  public void testGetX() {
    assertEquals(200, this.rectangle1.getX(), 0);
    assertEquals(210, this.rectangle2.getX(), 0);
  }

  /**
   * testGetY() function check if the value returned by
   * getY() is as required.
   */
  @Test
  public void testGetY() {
    assertEquals(120, this.rectangle1.getY(), 0);
    assertEquals(234, this.rectangle2.getY(), 0);
  }

  /**
   * testGetWidth() function check if the value returned by
   * getWidth() is as required.
   */
  @Test
  public void testGetWidth() {
    assertEquals(50, this.rectangle1.getSize1(), 0);
    assertEquals(50, this.rectangle2.getSize2(), 0);
  }

  /**
   * testGetHeight() function check if the value returned by
   * getHeight() is as required.
   */
  @Test
  public void testGetHeight() {
    assertEquals(100, this.rectangle1.getSize1(), 0);
    assertEquals(100, this.rectangle2.getSize2(), 0);
  }

  /**
   * testGetType() function check if the value returned by
   * getType() is as required.
   */
  @Test
  public void testGetType() {
    assertEquals("rectangle", this.rectangle1.getType());
    assertEquals("rectangle", this.rectangle2.getType());

  }

  /**
   * testMove() function check if the value returned by
   * Move() is as required.
   */
  @Test
  public void testMove() {
    this.rectangle1.move(70, 45);
    assertEquals(70, this.rectangle1.getX(), 0);
    assertEquals(45, this.rectangle1.getY(), 0);
    this.rectangle2.move(87, 245);
    assertEquals(87, this.rectangle2.getX(), 0);
    assertEquals(245, this.rectangle2.getY(), 0);

  }

  /**
   * testChangeColor() function check if the value returned by
   * ChangeColor() is as required.
   */
  @Test
  public void testChangeColor() {
    this.rectangle1.ChangeColor(this.color2);
    assertEquals(this.color2, this.rectangle1.getColor());
    this.rectangle2.ChangeColor(this.color1);
    assertEquals(this.color1, this.rectangle2.getColor());
  }

  /**
   * testGetColor() function check if the value returned by
   * GetColor() is as required.
   */
  @Test
  public void testGetColor() {
    assertEquals(this.color1, this.rectangle1.getColor());
    assertEquals(this.color2, this.rectangle2.getColor());
  }

}