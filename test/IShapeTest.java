import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import model.Color;
import model.IShape;
import model.Oval;
import model.Rectangle;

/**
 * The type Shape test.
 */
public class IShapeTest {
  private IShape rectangle;
  private IShape oval;
  private Color color1;
  private Color color2;

  /**
   * Sets up.
   */
  @Before
  public void setUp() {
    color1 = new Color(1, 0, 0);
    color2 = new Color(0, 0, 1);

    rectangle = new Rectangle("R", 0, 0, 10, 5, color1);
    oval = new Oval("O", 0, 0, 60, 30, color2);

  }

  /**
   * Test get name.
   */
  @Test
  public void testGetName() {
    assertEquals("R", rectangle.getName());
    assertEquals("O", oval.getName());
  }

  /**
   * Test null name.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullName() {
    IShape errorShape = new Rectangle(null, 0, 0, 5, 2.5, color1);
  }

  /**
   * Test empty name.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyName() {
    IShape errorShape = new Rectangle("", 0, 0, 100, 50, color1);
  }

  /**
   * Test get center x.
   */
  @Test
  public void testGetCenterX() {
    assertEquals(0, rectangle.getCenterX(), 0.001);
    assertEquals(0, oval.getCenterX(), 0.001);
  }

  /**
   * Test get center y.
   */
  @Test
  public void testGetCenterY() {
    assertEquals(0, rectangle.getCenterY(), 0.001);
    assertEquals(0, oval.getCenterY(), 0.001);
  }

  /**
   * Test set center x.
   */
  @Test
  public void testSetCenterX() {
    rectangle.setCenterX(99);
    assertEquals(99, rectangle.getCenterX(), 0.001);

    oval.setCenterX(100);
    assertEquals(100, oval.getCenterX(), 0.001);
  }

  /**
   * Test set center y.
   */
  @Test
  public void testSetCenterY() {
    rectangle.setCenterY(55);
    assertEquals(55, rectangle.getCenterY(), 0.001);

    oval.setCenterY(20);
    assertEquals(20, oval.getCenterY(), 0.001);
  }

  /**
   * Test get size x.
   */
  @Test
  public void testGetSizeX() {
    assertEquals(10, rectangle.getSizeX(), 0.001);
    assertEquals(60, oval.getSizeX(), 0.001);
  }

  /**
   * Test get size y.
   */
  @Test
  public void testGetSizeY() {
    assertEquals(5, rectangle.getSizeY(), 0.001);
    assertEquals(30, oval.getSizeY(), 0.001);
  }

  /**
   * Test set size x.
   */
  @Test
  public void testSetSizeX() {
    rectangle.setSizeX(100);
    assertEquals(100, rectangle.getSizeX(), 0.001);

    oval.setSizeX(999);
    assertEquals(999, oval.getSizeX(), 0.001);
  }

  /**
   * Test set size y.
   */
  @Test
  public void testSetSizeY() {
    rectangle.setSizeY(25);
    assertEquals(25, rectangle.getSizeY(), 0.001);

    oval.setSizeY(23);
    assertEquals(23, oval.getSizeY(), 0.001);
  }

  /**
   * Test get color.
   */
  @Test
  public void testGetColor() {
    assertEquals("Color: (1.0, 0.0, 0.0)", rectangle.getColor().toString());
    assertEquals("Color: (0.0, 0.0, 1.0)", oval.getColor().toString());
  }

  /**
   * Test change color.
   */
  @Test
  public void testChangeColor() {
    rectangle.changeColor(0, 1, 0);
    assertEquals("Color: (0.0, 1.0, 0.0)", rectangle.getColor().toString());

    oval.changeColor(255, 255, 255);
    assertEquals("Color: (255.0, 255.0, 255.0)", oval.getColor().toString());
  }

  /**
   * Test negative change color.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeChangeColor() {
    rectangle.changeColor(0, -1, 0);
  }

  /**
   * Test copy shape.
   */
  @Test
  public void testCopyShape() {
    IShape rectangleCopy = rectangle.copyShape();
    assertEquals(rectangleCopy, rectangle);

    IShape ovalCopy = oval.copyShape();
    assertEquals(ovalCopy, oval);
  }

  /**
   * Test updated copy shape.
   */
  @Test
  public void testUpdatedCopyShape() {
    IShape rectangleCopy = rectangle.copyShape();
    assertEquals(rectangleCopy, rectangle);
    rectangle.setCenterX(10);
    assertNotEquals(rectangleCopy, rectangle);

    IShape ovalCopy = oval.copyShape();
    assertEquals(ovalCopy, oval);
    ovalCopy.changeColor(255, 0, 0);
    assertNotEquals(ovalCopy, oval);
  }
}