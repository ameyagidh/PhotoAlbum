package model;

import java.util.Objects;

/**
 * The type Color.
 */
public class Color {
  private final double red;
  private final double green;
  private final double blue;

  /**
   * Instantiates a new Color.
   *
   * @param red   the red
   * @param green the green
   * @param blue  the blue
   */
  public Color(double red, double green, double blue) {
    if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
      throw new IllegalArgumentException("Color values can only be between 0 - 255!");
    }
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  /**
   * Gets red.
   *
   * @return the red
   */
  public double getRed() {
    return red;
  }

  /**
   * Gets green.
   *
   * @return the green
   */
  public double getGreen() {
    return green;
  }

  /**
   * Gets blue.
   *
   * @return the blue
   */
  public double getBlue() {
    return blue;
  }

  /**
   * Copy color.
   *
   * @return the color
   */
  public Color copyColor() {
    return new Color(getRed(), getGreen(), getBlue());
  }

  @Override
  public String toString() {
    return "Color: "
            + "(" + getRed()
            + ", " + getGreen()
            + ", " + getBlue()
            + ")";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Color color = (Color) o;
    return Double.compare(color.red, red) == 0
            && Double.compare(color.green, green) == 0
            && Double.compare(color.blue, blue) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(red, green, blue);
  }
}
