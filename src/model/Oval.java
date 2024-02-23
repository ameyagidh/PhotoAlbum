package model;

/**
 * The type Oval.
 */
public class Oval extends AbstractShape {

  /**
   * Instantiates a new Oval.
   *
   * @param name    the name
   * @param centerX the center x
   * @param centerY the center y
   * @param radiusX the radius x
   * @param radiusY the radius y
   * @param color   the color
   */
  public Oval(String name, double centerX, double centerY, double radiusX, double radiusY, Color color) {
    super(name, centerX, centerY, radiusX, radiusY, color);
  }

  @Override
  public IShape copyShape() {
    return new Oval(getName(), getCenterX(), getCenterY(),
            getSizeX(), getSizeY(), getColor().copyColor());
  }

  @Override
  public String toString() {
    return "Name: " + getName() + "\n"
            + "Type: Oval\n"
            + "Center: (" + getCenterX() + ", " + getCenterY() + ")"
            + ", X radius: " + getSizeX() + ", "
            + "Y radius: " + getSizeY() + ", "
            + getColor() + "\n\n";
  }
}
