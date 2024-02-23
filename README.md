# PhotoAlbum

Photo album is a project made in java which uses swing and html, Css to build a swing (Graphical) view and a web view. A text file, type of view web or graphical, output file(For web view) and the dimensions are the input. As an output we see the photoAlbum made by using the given text file input.
PhotoAlbum uses the concepts of Object Oriented programming such as 
A) SOLID 
1. Single Responsibility
2. Open/Closed
3. Liskov Substitution
4. Interface Segregation
5. Dependency Inversion

B) (MVC) Model View Controller (Model-View-Controller Pattern is also known as the MVC pattern. This pattern is employed to divide the concerns of an application. Model - Model depicts a data-carrying object or Java POJO. Additionally, if its data changes, it may have logic to update the controller. View - View is a representation of how the model's data is visualized.)

C) Inheritance (A new class can be derived from an existing class by inheritance. In Java, classes may inherit or acquire the properties and methods of other classes. A subclass is a class that has been derived from another class, whereas a superclass is a class from which a subclass has been derived.)

D) Abstract classes (A class that has been declared abstract is one that may or may not have abstract methods. Although they cannot be created from scratch, abstract classes can be subclassed. When a subclass of an abstract class is created, it typically offers implementations for each of the parent class's abstract methods.) and 

E) Interfaces (a collection of methods and constant variables are contained in an abstract type.)

## Demo On Youtube

Youtube Video Link https://youtu.be/gvLs8VI4-dM

## Installation
Clone the repository as git clone https://github.com/ameyagidh/PhotoAlbum.git

### Requirements:-

 1. Java (Version 16 or higher)
 2. Java integrated development environment (IDE) preffered(Intellij).
 3. Unzip the file "fall_2021_final_project".
 4. Run the file PhotoAlbumMain.java by giving the desired configurations as inputs such as :- -in resources/face_sun.txt -v web -out Face.html 1000 1000.

## UML
![UML](https://github.com/ameyagidh/PhotoAlbum/assets/65457905/1803a23a-7983-4114-b8f1-30032252f28f)

# Shapes Photo Album MVC

This project adopts a comprehensive MVC design, consisting of a model responsible for managing and manipulating data, a view for presenting the data and user interface, and a controller to govern the application logic.

## MVC Overview

<p><a href="https://commons.wikimedia.org/wiki/File:MVC-Process.svg#/media/File:MVC-Process.svg"><img src="https://upload.wikimedia.org/wikipedia/commons/a/a0/MVC-Process.svg" alt="MVC-Process.svg" width="436" height="480"></a><br></p>

The image above provides an overview of the MVC design structure that should be followed. Below, I will outline how I divided the MVC components.

- ### Model
    - AlbumModel
- ### View
    - SwingView
    - SVGView
- ### Controller
    - Controller

## Model

### AlbumModel

The AlbumModel functions as the model component of the MVC architecture and contains the necessary data for the view. Several enhancements were made, allowing snapshots to provide additional data essential for creating a precise view.

## View

### SwingView

This view utilizes Java's Swing package to create a graphical user interface (GUI). The GUI displays each snapshot's ID, description, and shapes captured at the time of the snapshot. Users can specify the GUI's size by providing width and height parameters in the command line arguments. If no dimensions are specified, a default window size of 1000x1000 is created. The GUI includes buttons for navigating between snapshots, selecting a new snapshot, and quitting the program. When users click the next or previous button, a new snapshot is loaded, and both the graphic panel and snapshot ID panel are updated and repainted with the new data. Additionally, users can select a specific snapshot from a list of all available snapshots, and the GUI will be updated accordingly.

### SVGView

This view employs HTML to enable users to access all snapshots via a webpage. Unlike viewing one snapshot at a time, all snapshots are displayed on the webpage, separated by borders. Each snapshot includes the ID, description, timestamp, and shapes within a canvas. Users have the option to specify the canvas size using command line arguments, with a default size of 1000x1000 if no dimensions are provided. This view is achieved by constructing a string using a StringBuilder, which is then inserted into an HTML file specified by the user or given a default name. The shapes themselves are depicted using SVG generated from the model's data.

## Controller

### Controller

This component serves as the primary control mechanism of the program, determining which data to load, how to process it, and in what format it should be represented. The controller receives the input text file and scans it for keywords that are then passed to the model for the creation and modification of shapes, as well as for determining when to take a snapshot. After processing and loading all the data into the model, the controller loads the view with the model to visualize its representation.

# UML Diagram
The UML diagram illustrates a total of 2 interfaces and 6 classes, providing a clearer understanding of the design when categorized into three distinct sections.
- Shape
- Snapshot
- Photo Album

## Shapes

In this section, the objective was to allow users to create shapes with specific attributes.

### IShape:

This serves as the interface for the shapes, encompassing all the methods required for the model.

### AbstractShape:

This abstract class provides the getters and setters for the shape, enabling specific shapes to utilize this superclass instead of implementing their own methods. Additionally, having this abstract class allowed for shorter concrete shape classes and facilitated the addition of more concrete shapes with ease.

### Rectangle and Oval:

These are the two concrete shape classes within the program. They include a `copyShape()` method, which enables the model to obtain a snapshot of the current shape attributes. Additionally, a `toString()` method was implemented to facilitate the description of the shapes.

## Snapshot

This class functions to capture a snapshot of the current shapes in the photo album. Each snapshot includes a description, a unique snapshot ID, and a timestamp indicating when the snapshot was taken. The class features a constructor and a `toString()` method, as its primary purpose is to supply the model with a Snapshot element for processing.

## Photo Album

This served as the primary model responsible for processing shapes, including tasks such as moving, resizing, deleting, and capturing snapshots.

### IAlbum:

This interface serves as a blueprint for the AlbumModel, containing all the methods that will be utilized by the AlbumModel or any other model implementing this interface.

### AlbumModel:

This class serves as the concrete implementation of the photo album model. It enables the creation, addition, movement, resizing, and color changing of shapes. When shapes are added to the photo album, this class manages the data using a Linked HashMap, preserving the order of insertion with each shape easily retrievable using its name as the key. Additionally, the class handles the process of taking snapshots, obtaining IDs, and managing all data within a Linked HashMap to maintain order, facilitating the retrieval of any snapshot using its assigned ID. Instead of using an extended timestamp, I opted to utilize Java's UUID class to assign a unique ID to each snapshot. This decision was made to address the issue of potential overwriting of snapshots due to duplicate keys, especially when the program runs rapidly. Furthermore, the photo album can be reset, clearing all snapshots and shapes from the album to start afresh.

## Screenshots:-
#### Gif of the graphical view using difffernet input text files.
![Shapesgif](https://user-images.githubusercontent.com/65457905/190865625-27cd4fe2-de7f-457c-80da-a049c8f83c31.gif)
![PlayGroundgif](https://user-images.githubusercontent.com/65457905/190865626-3665a229-449b-4678-9d1f-9c7ad111319b.gif)
![Buildingsgif](https://user-images.githubusercontent.com/65457905/190865628-bbba8e8d-a3ab-4f3e-bbe5-cb2bc0c856e9.gif)

### Graphical View for face_sun.txt
![FaceGraphicalView](https://user-images.githubusercontent.com/65457905/190865443-5b1983bc-d3ea-4c5a-aa35-83124f5be14c.PNG)
### Web View for face_sun.txt
![FaceWebView](https://user-images.githubusercontent.com/65457905/190865444-15169dc5-ccff-4055-89b2-fcebced0f5e5.PNG)
