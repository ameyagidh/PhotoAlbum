Ameya Santosh Gidh

Assignment 9

The submission consists of the Model, View and Architecture.

Models contains -> 

Abstract Shape:-
	1) Variables:- String name Which is the name of the Shape
	2) Methods:- getName() which gets the name of the current shape.


Color:-
	1) Variables:- double red, double green, double blue.
	2) Methods:- getRed(), getGreen(), getBlue() which are the red, green 
		     and blue values of the color.

IModel:-
	 Methods:- String GetAllPhotoAlbumObject(), ResetSnapShotList(), TakeSnapShot().

IShape:-
	Methods:- getType(), getName(), getX(), getY(),getColor(), getSize1(), getSize2(), move(double x, double y),
		  move(double x, double y), resize(double size1, double size2), ChangeColor(Color color).

Oval:-
	1) Variables:- radius1, radius2, x, y, color, type.
	2) Methods:- A) toString()
		     B) getX()
		     c) getY()
		     D) getSize1()
		     E) getSize2()
		     F) getType()
		     G) move(double x, double y)
		     H) resize(double radius1, double radius2)
		     I) ChangeColor(Color color)
		     J) getColor() 
		 	

PhotoAlbum:-
	1) Variables:-List<String> PhotoAlbumList, List<IShape> ShapesList, IShape Shape.
	2) Methods:- A) createShape(String Name, String type, double x, double y,
                            double size1, double size2,
                            Color color).
		     B) AddShapeToPhotoAlbum(IShape shape)
		     C) List<String> getPhotoAlbumList()
		     D) removeShape(IShape shape)
		     E) List<IShape> getShapesList()
				

Rectangle:-
	1) Variables:-double width,double height, double x,double y,Color color;
	2) Methods:-A) toString()
		     B) getX()
		     c) getY()
		     D) getSize1()
		     E) getSize2()
		     F) getType()
		     G) move(double x, double y)
		     H)	resize(double width, double height)
		     I) ChangeColor(Color color)
		     J) getColor() 

SnapShot:-
	1) Variables:-String SnapShotID,Timestamp timestamp,String Description,
					PhotoAlbum photoAlbum_obj;
	2) Methods:- GetAllPhotoAlbumObject(),List<SnapShot> ResetSnapShotList(),TakeSnapShots(SnapShot snapshot),
		removeSnapShot(SnapShot snapshot), List<SnapShot> getSnapShotsList(),PhotoAlbum getPhotoAlbum_obj(),
		String getSnapShotID(), Timestamp getTimestamp(), String getDescription().    


View contains:-

IController:-
	Methods:- SnapShot getModel_obj(), go()

ControllerShapes:-
	1) Variables:-SnapShot model_obj,ViewOutput viewOutput_obj,IView view_obj;
	2) Methods:-SnapShot getModel_obj(), go().

Controller contains:-

IView:-
	Methods:- draw_view(), SetC(ControlledShapes controller)

ShapesPanel:-
	1) Variables:- SnapShot snapshot
	2) Methods:- setSnapshot(SnapShot snapshot), paintComponent(Graphics g).

ViewOutput:-
	1) Variables:-SnapShot snapshot,SnapShot snapshots,
	ShapesPanel panel,ControlledShapes controller_obj,int counter,
	JPanel snapshotPanel,JLabel id,JLabel desc.
	2) Methods:- draw_view(), redraw(), SetC(ControlledShapes controller).

WebView:-
	1) Variables:- SnapShot snapShot
	2) Methods:- draw_view(), SetC(ControlledShapes controller).















































