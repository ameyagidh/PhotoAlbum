package View;

import Controller.ControlledShapes;

/**
 * IView Interface lists the protocols the
 * classes implementing it must adhere to.
 */
public interface IView {

  /**
   * draw_view() function is used
   * to draw the shapes on the frame.
   */
  public void draw_view();

  /**
   * SetC() function passes the controller to the view.
   *
   * @param controller which is of type ControlledShapes.
   */
  public void SetC(ControlledShapes controller);
  public IView getWebView_obj();
}
