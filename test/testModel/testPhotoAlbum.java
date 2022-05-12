package testModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Models.Color;
import Models.IShape;
import Models.Oval;
import Models.PhotoAlbum;
import Models.Rectangle;

public class testPhotoAlbum {

  private PhotoAlbum photoAlbum1;
  private PhotoAlbum photoAlbum2;
  private IShape shape1;
  private IShape shape2;
  private IShape shape3;
  private Color color1;
  private Color color2;
  private Color color3;
  private List<IShape> ShapesList1 = new ArrayList<>();

  /**
   * setUp() function creates objects.
   */

  @Before
  public void setUp() {
    this.color1 = new Color(180, 135, 110);
    this.color2 = new Color(100, 115, 85);
    this.shape1 = new Rectangle("R", 200, 200, color1, 50.0, 100.0);
    this.shape2 = new Oval("O", 500.0, 100.0, color2, 60.0, 30.0);
    this.photoAlbum1 = new PhotoAlbum();
  }

  /**
   * testIllegalConstructor1() function check the edge cases which should
   * raise an IllegalArgumentException.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor1() {
    this.color3 = new Color(1000, 115, 85);
  }

  /**
   * testCreateShape1() function check if the value returned by
   * createShape() is as required.
   */
  @Test
  public void testCreateShape1() {
    this.photoAlbum1.createShape("R", "rectangle", 200.0, 200.0, 50.0, 100.0, this.color1);
    this.photoAlbum1.createShape("O", "Oval", 500.0, 100.0, 60.0, 30.0, color2);
    assertEquals(this.photoAlbum1.getShapesList().toString(), this.ShapesList1.toString());
  }

  /**
   * testCreateShape2() function check if the value returned by
   * createShape() is as required.
   */
  @Test
  public void testCreateShape2() {
    assertNull(photoAlbum1.createShape("S", "Square", 500.0, 100.0, 60.0, 30.0, color2));
  }

  /**
   * testAddShapeToPhotoAlbum1() function check if the value returned by
   * AddShapeToPhotoAlbum() is as required.
   */
  @Test
  public void testAddShapeToPhotoAlbum1() {
    this.photoAlbum1.AddShapeToPhotoAlbum(this.shape1);
    this.ShapesList1.add(this.shape1);
    this.ShapesList1.add(this.shape2);
    this.photoAlbum1.AddShapeToPhotoAlbum(this.shape2);
    assertEquals(this.ShapesList1.size(), this.photoAlbum1.getShapesList().size());
  }
  /**
   * testRemoveShapeFromPhotoAlbum1() function check if the value returned by
   * removeShape() is as required.
   */
  @Test
  public void testRemoveShapeFromPhotoAlbum1() {
    this.photoAlbum1.AddShapeToPhotoAlbum(this.shape1);
    this.ShapesList1.add(this.shape1);
    this.ShapesList1.add(this.shape2);
    this.photoAlbum1.AddShapeToPhotoAlbum(this.shape2);
    assertEquals(this.photoAlbum1.getShapesList().toString(), this.ShapesList1.toString());
    this.photoAlbum1.removeShape(this.shape1);
    this.ShapesList1.remove(this.shape1);
    assertEquals(this.photoAlbum1.getShapesList().toString(), this.ShapesList1.toString());
  }

  /**
   * testRemoveShapeToPhotoAlbum2() function check the edge cases which should
   * raise an IllegalArgumentException.
   */

  @Test(expected = NullPointerException.class)
  public void testRemoveShapeToPhotoAlbum2() {
    photoAlbum1.removeShape(this.shape3);
  }

  /**
   * testGetShapesList() function check if the value returned by
   * getShapesList() is as required.
   */
  @Test
  public void testGetShapesList() {
    this.photoAlbum1.AddShapeToPhotoAlbum(this.shape1);
    this.ShapesList1.add(this.shape1);
    assertEquals(this.photoAlbum1.getShapesList().toString(), this.ShapesList1.toString());
    this.ShapesList1.add(this.shape2);
    this.photoAlbum1.AddShapeToPhotoAlbum(this.shape2);
    assertEquals(this.photoAlbum1.getShapesList().toString(), this.ShapesList1.toString());
  }

  /**
   * testIllegalGetShapeToPhotoAlbum2() function check the edge cases which should
   * raise an IllegalArgumentException.
   */

  @Test(expected = NullPointerException.class)
  public void testIllegalGetShapesList() {
    photoAlbum2.getShapesList();
  }

}
