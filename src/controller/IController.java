package controller;

import java.io.FileNotFoundException;

/**
 * The interface Controller.
 */
public interface IController {

  /**
   * The main driver for the controller to run the model and view.
   *
   * @throws FileNotFoundException the file not found exception
   */
  void go() throws FileNotFoundException;

}
