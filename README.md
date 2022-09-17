# PhotoAlbum

Youtube Video Link https://youtu.be/gvLs8VI4-dM

Photo album is a project made in java which uses swing and html to build a swing view and a web view. 

To run the project use command line arguments as 
-in resources/buildings.txt -v web -out buildingsOut.html 1000 1000
(-in resorces/(inputfile.txt) -v (graphical/web) (outputfilename.html) size of screen)
# Slide - Puzzle Game

Start the game 
Load a splash screen which has the splash image present in the resources file
I wanted a plain whit background for the puzzle hence included a1.gif file

After 3 seconds time (using the time library) the screen is changed and the user is prompted to 
add his name and moves [5 to 200]
error messages if any are written here or a message is printed to the screen

The Board is drawn, player moves and leaders are plotted using the turtle library
The Quit, Reset and Load images are added and the coordinates of these images are mapped
to the conditions in get_click function which acts according to the input (x,y) values

The default file loaded is mario.Images are plotted as objects of class images on the screen
with each image having the image name and coordinates as attributes.
 
These objects are appended to a list and when an object is clicked and it
matches the is_neighbour function the image is swapped with the blank image and 
these chnages are reflected in the list as well.

The images can be moved within the board play area. If the user finishes the game within 
the number of moves available then the player wins else the player has lost 

The player can choose from the load files resent if the file is not present then 
it results in reprompting the user for the right file name.

The player can use Quit button anytime to exit the game

The Reset button is a cheat which enables the user to get the puzzle to the right formation and thus help win win the game

There is a 5001_puzzle_err.txt file for appending the errors encountered during execution of the program
## Installation
Install my-project 

### Requirements:-

 1. Python (Version 3.7 and higher)
 2. Python integrated development environment (IDE) preffered(Pycharm).
 3. Unzip the file "fall_2021_final_project".
 4. Run the file puzzle_game.py.

## Screenshots:-

![DemoGraphicalView4](https://user-images.githubusercontent.com/65457905/190865441-5b98ff95-f795-431b-8248-28a0b3ed30ae.PNG)
![FaceGraphicalView](https://user-images.githubusercontent.com/65457905/190865443-5b1983bc-d3ea-4c5a-aa35-83124f5be14c.PNG)
![FaceWebView](https://user-images.githubusercontent.com/65457905/190865444-15169dc5-ccff-4055-89b2-fcebced0f5e5.PNG)
![GraphicalView1](https://user-images.githubusercontent.com/65457905/190865445-a1c10d6a-3bf8-45a1-a36d-729c50210271.PNG)
![GraphicalView2](https://user-images.githubusercontent.com/65457905/190865446-80fca2b5-cbbb-4ab3-9ae1-0e0053f37c6e.PNG)
![GraphicalView3](https://user-images.githubusercontent.com/65457905/190865447-9cfc94e0-6f67-4560-8248-81d6819ce8ee.PNG)
![NightView1](https://user-images.githubusercontent.com/65457905/190865448-fdc3f731-f22e-4887-b41b-03625dc68b6a.PNG)
![NightView2](https://user-images.githubusercontent.com/65457905/190865449-fcc0200b-fd39-40a6-8b8b-10354e596b50.PNG)
![NightView3](https://user-images.githubusercontent.com/65457905/190865450-2c4e5173-fe0d-4cda-8681-103e7bcd9e52.PNG)
![PlayGroundGraphicalView1](https://user-images.githubusercontent.com/65457905/190865451-7bb7f757-6224-469b-8134-7db670be2cc2.PNG)

![DemoGraphicalView3](https://user-images.githubusercontent.com/65457905/190865440-d98b528e-a1ce-4f62-b835-2bbd50c6e56a.PNG)
![DemoGraphicalView2](https://user-images.githubusercontent.com/65457905/190865439-20be9cb7-1e58-456e-b488-1b7706f705a9.PNG)ew![DemoGraphicalView1](https://user-images.githubusercontent.com/65457905/190865438-798693ef-9388-497d-a9eb-4fa39e3ce4e3.PNG)m![PlayGroundgif](https://user-images.githubusercontent.com/65457905/190865437-d2a3b8a9-dfa2-475d-ad99-2c12969c0154.gif)
![Shapesgif](https://user-images.githubusercontent.com/65457905/190865435-5ce7b910-a0bb-4e41-aff6-dc10b4ea7ab3.gif)

![PlayGroundGraphicalView2](https://user-images.githubusercontent.com/65457905/190865415-9a00183c-8e11-44ac-a1f4-54b6e6556f35.PNG)
![PlayGroundGraphicalView3](https://user-images.githubusercontent.com/65457905/190865417-2b923a7e-54a3-4ac4-93a7-8324ae841b1d.PNG)
![PlayGroundGraphicalView4](https://user-images.githubusercontent.com/65457905/190865418-60b894b3-5644-470b-b2f1-fcd8ba152430.PNG)
![PlayGroundGraphicalView5](https://user-images.githubusercontent.com/65457905/190865419-57f9c8db-5068-447f-8739-0d0d4446d4d7.PNG)
![PlayGroundGraphicalView6](https://user-images.githubusercontent.com/65457905/190865420-077b8d1c-857f-4505-995c-bbb9e29665f8.PNG)
![PlayGroundGraphicalView7](https://user-images.githubusercontent.com/65457905/190865421-f48b3cd5-14b4-4b96-a91e-37f4d85aa884.PNG)
![PlayGroundGraphicalView8](https://user-images.githubusercontent.com/65457905/190865423-0352fce1-ddf6-4fcc-be07-058a2b1a93cf.PNG)
![PlayGroundWebView1](https://user-images.githubusercontent.com/65457905/190865424-b71bdba7-6809-4464-927b-341ac6214d02.PNG)
![PlayGroundWebView2](https://user-images.githubusercontent.com/65457905/190865425-4993d7ed-805a-4927-a469-aff48d678f8e.PNG)
![PlayGroundWebView3](https://user-images.githubusercontent.com/65457905/190865426-c8a21309-2489-4a0f-9852-4094f7db7824.PNG)
![PlayGroundWebView4](https://user-images.githubusercontent.com/65457905/190865427-52260660-d367-4bb6-8826-60fbd68d5e82.PNG)
![PlayGroundWebView5](https://user-images.githubusercontent.com/65457905/190865428-f33b84e6-c5c4-4937-bebe-2e7f5abd0ed1.PNG)
![PlayGroundWebView6](https://user-images.githubusercontent.com/65457905/190865429-4dd1a2be-cce4-4063-8d6f-943ec4179d2a.PNG)
![PlayGroundWebView7](https://user-images.githubusercontent.com/65457905/190865431-628de8a2-0ddd-40fc-bc76-bcf055e94c8c.PNG)
![PlayGroundWebView8](https://user-images.githubusercontent.com/65457905/190865432-b5bdc9b0-e154-4b82-b360-5090f1d84ae3.PNG)
![Buildingsgif](https://user-images.githubusercontent.com/65457905/190865433-0ac30bed-fe32-428b-abac-c2c539f039ce.gif)


