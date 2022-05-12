package Models;

/**
 * IShape represents the IShape interface
 * and every child class implmenting it must
 * follow it.
 */
public interface IShape {
  /**
   * getType() function returns a String representing the
   * type of the shape.
   *
   * @return a String shows the type of the shape.
   */
  public String getType();

  /**
   * getName() function returns a String representing the
   * name of the shape.
   *
   * @return a String shows the name of the shape.
   */
  public String getName();

  /**
   * getX() function returns the x of the Oval.
   *
   * @return a double representing the X Coordinate.
   */
  public double getX();

  /**
   * getY() function returns the y of the Oval.
   *
   * @return a double representing the Y Coordinate.
   */
  public double getY();

  /**
   * getColor() function returns the color of the object.
   * @return a color of the object.
   */
  public Color getColor();
  /**
   * getSize1() function returns the Size1 of the Shape.
   *
   * @return a double representing the Size1.
   */
  public double getSize1();

  /**
   * getSize2() function returns the Size2 of the Shape.
   *
   * @return a double representing the Size2.
   */
  public double getSize2();

  /**
   * move() function implements the way
   * for moving the IShape around.
   *
   * @param x x coordinate of Shape.
   * @param y y coordinate of Shape.
   */
  public void move(double x, double y);

  /**
   * resize() function is used to change
   * the size1 and size2 Shape.
   *
   * @param size1  size1 of the Shape.
   * @param size2 size2 of the Shape.
   */
  public void resize(double size1, double size2);
  /**
   * ChangeColor changes the color of the rectangle.
   *
   * @param color which is the color of the rectangle.
   */
  public void ChangeColor(Color color);
}