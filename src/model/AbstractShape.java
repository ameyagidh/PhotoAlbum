package model;

import java.util.Objects;

/**
 * The type Abstract shape.
 */
public abstract class AbstractShape implements IShape {
  private final String name;
  private double centerX;
  private double centerY;
  private double sizeX;
  private double sizeY;
  private Color color;


  /**
   * Instantiates a new Abstract shape.
   *
   * @param name    the name
   * @param centerX the center x position of the shape
   * @param centerY the center y position of the shape
   * @param sizeX   the size of the shape along the X plane
   * @param sizeY   the size of the shape along the Y plane
   * @param color   the color of the shape
   * @throws IllegalArgumentException the illegal argument exception
   */
  public AbstractShape(String name, double centerX, double centerY,
                       double sizeX, double sizeY, Color color) throws IllegalArgumentException {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("Name must be valid");
    }
    this.name = name;
    this.centerX = centerX;
    this.centerY = centerY;
    this.sizeX = sizeX;
    this.sizeY = sizeY;
    this.color = color;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public double getCenterX() {
    return this.centerX;
  }

  @Override
  public void setCenterX(double newX) {
    this.centerX = newX;
  }

  @Override
  public double getCenterY() {
    return this.centerY;
  }

  @Override
  public void setCenterY(double newY) {
    this.centerY = newY;
  }

  @Override
  public double getSizeX() {
    return this.sizeX;
  }

  @Override
  public void setSizeX(double newX) {
    this.sizeX = newX;
  }

  @Override
  public double getSizeY() {
    return this.sizeY;
  }

  @Override
  public void setSizeY(double newY) {
    this.sizeY = newY;
  }

  @Override
  public Color getColor() {
    return this.color;
  }

  @Override
  public void changeColor(double red, double green, double blue) {
    this.color = new Color(red, green, blue);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AbstractShape that = (AbstractShape) o;
    return Double.compare(that.centerX, centerX) == 0 && Double.compare(that.centerY, centerY) == 0
            && Double.compare(that.sizeX, sizeX) == 0 && Double.compare(that.sizeY, sizeY) == 0
            && name.equals(that.name) && color.equals(that.color);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, centerX, centerY, sizeX, sizeY, color);
  }
}
