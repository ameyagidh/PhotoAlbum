package model;

/**
 * The type Rectangle.
 */
public class Rectangle extends AbstractShape {
  /**
   * Instantiates a new Rectangle.
   *
   * @param name       the name
   * @param minCornerX the min corner x
   * @param minCornerY the min corner y
   * @param width      the width
   * @param height     the height
   * @param color      the color
   */
  public Rectangle(String name, double minCornerX, double minCornerY,
                   double width, double height, Color color) {
    super(name, minCornerX, minCornerY, width, height, color);
  }

  /**
   * Instantiates a copy of the current Rectangle.
   *
   */
  @Override
  public IShape copyShape() {
    return new Rectangle(getName(), getCenterX(), getCenterY(),
            getSizeX(), getSizeY(), getColor().copyColor());
  }

  @Override
  public String toString() {
    return "Name: " + getName() + "\n"
            + "Type: Rectangle\n"
            + "Min corner: (" + getCenterX() + ", " + getCenterY() + ")"
            + ", Width: " + getSizeX() + ", "
            + "Height: " + getSizeY() + ", "
            + getColor() + "\n\n";
  }
}
