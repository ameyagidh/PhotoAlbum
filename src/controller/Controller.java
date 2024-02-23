package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.Color;
import model.IAlbum;
import view.IView;

/**
 * The type Controller.
 */
public class Controller implements IController {
  private final IAlbum model;
  private final IView view;
  private final String inputFileName;

  /**
   * Instantiates a new Controller.
   *
   * @param inputFileName the input file name
   * @param model         the model
   * @param view          the view
   */
  public Controller(String inputFileName, IAlbum model, IView view) {
    this.model = model;
    this.view = view;
    this.inputFileName = inputFileName;
  }

  @Override
  public void go() throws FileNotFoundException {
    Scanner scanner = new Scanner(new File(this.inputFileName));
    while (scanner.hasNext()) {
      switch (scanner.next().toLowerCase()) {
        case "#" -> scanner.nextLine();
        case "shape" -> this.model.createShape(scanner.next(), scanner.next(),
                scanner.nextDouble(), scanner.nextDouble(),
                scanner.nextDouble(), scanner.nextDouble(),
                new Color(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble()));
        case "move" -> this.model.move(scanner.next(), scanner.nextDouble(), scanner.nextDouble());
        case "resize" ->
                this.model.resize(scanner.next(), scanner.nextDouble(), scanner.nextDouble());
        case "color" ->
                this.model.changeColor(scanner.next(), scanner.nextDouble(), scanner.nextDouble(),
                        scanner.nextDouble());
        case "remove" -> this.model.removeShape(scanner.next());
        case "snapshot" -> this.model.takeSnapshot(scanner.nextLine());
      }
    }
    this.view.loadModel(this.model);
  }

}
