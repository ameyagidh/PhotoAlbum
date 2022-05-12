package Models;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Color class represents the color values
 * as red, green and blue (r,g,b).
 */
public class Color {

  private double red;
  private double green;
  private double blue;

  /**
   * Color constructor initializes
   * the colors.
   *
   * @param red   represents the red color value.
   * @param green represents the green color value.
   * @param blue  represents the blue color value.
   */
  public Color(double red, double green, double blue) throws IllegalArgumentException {
    if (red < 0 || red > 255
            || green < 0 || green > 255
            || blue < 0 || blue > 255) {
      throw new IllegalArgumentException("Range of Red Green Blue values should be "
              + "between 0 to 255.");
    }
    this.red = red;
    this.green = green;
    this.blue = blue;

  }

  /**
   * getBlue() function helps to obtain the
   * blue color value.
   *
   * @return    double representing the blue color value.
   */
  public double getBlue() {
    return blue;
  }

  /**
   * getGreen() function helps to obtain the
   * green color value.
   *
   * @return    double representing the green color value.
   */
  public double getGreen() {
    return green;
  }

  /**
   * getRed() function helps to obtain the
   * red color value.
   *
   * @return    double representing the red color value.
   */
  public double getRed() {
    return red;
  }

  /**
   * toString() function returns a String value
   * representing the color.
   *
   * @return    String representing the color.
   */
  @Override
  public String toString() {
    DecimalFormat df = new DecimalFormat("#,##0.0");
    df.setRoundingMode(RoundingMode.HALF_UP);
    return "(" + df.format(this.getRed()) + ","
            + df.format(this.getGreen()) + ","
            + df.format(this.getBlue()) + ")";
  }
}
