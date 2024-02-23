package model;

/**
 * The interface Shape.
 */
public interface IShape {
  /**
   * Gets name.
   *
   * @return the name
   */
  String getName();

  /**
   * Gets center x.
   *
   * @return the center x
   */
  double getCenterX();

  /**
   * Gets center y.
   *
   * @return the center y
   */
  double getCenterY();

  /**
   * Sets center x.
   *
   * @param newX the new x
   */
  void setCenterX(double newX);

  /**
   * Sets center y.
   *
   * @param newY the new y
   */
  void setCenterY(double newY);

  /**
   * Gets size x.
   *
   * @return the size x
   */
  double getSizeX();

  /**
   * Gets size y.
   *
   * @return the size y
   */
  double getSizeY();

  /**
   * Sets size x.
   *
   * @param newX the new x
   */
  void setSizeX(double newX);

  /**
   * Sets size y.
   *
   * @param newY the new y
   */
  void setSizeY(double newY);

  /**
   * Gets color.
   *
   * @return the color
   */
  Color getColor();

  /**
   * Change color.
   *
   * @param red   the red
   * @param green the green
   * @param blue  the blue
   */
  void changeColor(double red, double green, double blue);

  /**
   * Copy the current state of the shape.
   *
   * @return the shape copy
   */
  IShape copyShape();
}
