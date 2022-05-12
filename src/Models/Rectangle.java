package Models;

/**
 * Rectangle Class represents the Rectangle Shape.
 */
public class Rectangle extends AbstractShape {
  private double width;
  private double height;
  private double x;
  private double y;
  private Color color;
  private final String type = "rectangle";

  /**
   * Rectangle constructor is used to initialize the
   * rectangle shape.
   *
   * @param Name   of the rectangle.
   * @param x      x coordinate.
   * @param y      y coordinate.
   * @param color  color of the shape.
   * @param width  width of the shape.
   * @param height height of the shape.
   */
  public Rectangle(String Name, double x, double y,
                   Color color, double width, double height) {
    super(Name);
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.color = color;
  }

  /**
   * toString() function returns a string
   * represention of the Rectangle class,
   *
   * @return String representing the rectangle.
   */
  public String toString() {
    return "Name: " + this.getName() + "\n"
            + "Type: " + this.type + "\n"
            + "Min corner: "
            + "("
            + this.getX() + "," + this.getY() + ") "
            + "Width: "
            + this.getSize1()
            + ", Height: "
            + this.getSize2()
            + ", Color: " + this.getColor();
  }

  /**
   * getX() function returns the x of the rectangle.
   *
   * @return a double representing the X Coordinate.
   */
  public double getX() {
    return this.x;
  }

  /**
   * getY() function returns the y of the rectangle.
   *
   * @return a double representing the Y Coordinate.
   */
  public double getY() {
    return this.y;
  }

  /**
   * gettype() function returns the type.
   *
   * @return a String representing the rectangle.
   */
  @Override
  public String getType() {
    return "rectangle";
  }

  /**
   * move() function implements the way
   * for moving the rectangle around.
   *
   * @param x x coordinate of rectangle.
   * @param y y coordinate of rectangle.
   */
  public void move(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * resize() function is used to change
   * the width and height of the rectangle.
   *
   * @param width  width of the rectangle.
   * @param height height of the rectangle.
   */
  public void resize(double width, double height) {
    this.width = width;
    this.height = height;
  }

  /**
   * ChangeColor changes the color of the rectangle.
   *
   * @param color which is the color of the rectangle.
   */
  public void ChangeColor(Color color) {
    this.color = color;
  }

  /**
   * getColor() function gets the color of the rectangle.
   *
   * @return a color of the rectangle.
   */
  public Color getColor() {
    return this.color;
  }

  /**
   * getSize1() function returns the width of the rectangle.
   *
   * @return a double representing the width.
   */
  @Override
  public double getSize1() {
    return this.width;
  }
  /**
   * getSize2() function returns the height of the rectangle.
   *
   * @return a double representing the height.
   */
  @Override
  public double getSize2() {
    return this.height;
  }

}
