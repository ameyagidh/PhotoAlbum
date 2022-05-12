package Models;

/**
 * Oval Class represents the Oval Shape.
 */
public class Oval extends AbstractShape {
  private double radius1;
  private double radius2;
  private double x;
  private double y;
  private Color color;
  private final String type = "oval";

  /**
   * Oval constructor is used to create an Oval Shape.
   *
   * @param Name    name of the shape.
   * @param x       x coordinate of the shape.
   * @param y       y coordinate of the shape.
   * @param color   color coordinate of the shape.
   * @param radius1 radius1 coordinate of the shape.
   * @param radius2 radius2 coordinate of the shape.
   */

  public Oval(String Name, double x, double y,
              Color color, double radius1, double radius2) {
    super(Name);
    this.x = x;
    this.y = y;
    this.radius1 = radius1;
    this.radius2 = radius2;
    this.color = color;
  }

  /**
   * toString() function returns a string
   * represention of the Oval class,
   *
   * @return String representing the Oval.
   */
  public String toString() {
    String str = "Name: " + this.getName() + "\n"
            + "Type: " + this.type + "\n"
            + "Center: "
            + "("
            + this.getX() + "," + this.getY() + ") "
            + "X radius: "
            + this.getSize1()
            + ", Y radius: "
            + this.getSize2()
            + ", Color: " + this.getColor();
    return str;
  }

  /**
   * getX() function returns the x of the Oval.
   *
   * @return a double representing the X Coordinate.
   */
  public double getX() {
    return this.x;
  }

  /**
   * getY() function returns the y of the Oval.
   *
   * @return a double representing the Y Coordinate.
   */
  public double getY() {
    return this.y;
  }

  /**
   * getSize1() function returns the Radius1 of the Oval.
   *
   * @return a double representing the radius1.
   */
  public double getSize1() {
    return radius1;
  }

  /**
   * getSize2() function returns the Radius2 of the Oval.
   *
   * @return a double representing the Radius2.
   */
  public double getSize2() {
    return radius2;
  }

  /**
   * gettype() function returns the type.
   *
   * @return a String representing the Oval.
   */
  public String getType() {
    return "oval";
  }

  /**
   * move() function implements the way
   * for moving the Oval around.
   *
   * @param x x coordinate of Oval.
   * @param y y coordinate of Oval.
   */
  public void move(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * resize() function is used to change
   * the radius1 and radius2 of the Oval.
   *
   * @param radius1 radius1 of the Oval.
   * @param radius2 radius2 of the Oval.
   */
  public void resize(double radius1, double radius2) {
    this.radius1 = radius1;
    this.radius2 = radius2;
  }

  /**
   * ChangeColor changes the color of the Oval.
   *
   * @param color which is the color of the Oval.
   */
  public void ChangeColor(Color color) {
    this.color = color;
  }

  /**
   * getColor() function gets the color of the Oval.
   *
   * @return a color of the Oval.
   */
  public Color getColor() {
    return color;
  }
}
