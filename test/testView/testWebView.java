package testView;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Models.Color;
import Models.Oval;
import Models.PhotoAlbum;
import Models.Rectangle;
import Models.SnapShot;
import View.WebView;

public class testWebView {

  // String comparision.
  // model, object and sent webview.
  private String html;
  private WebView view_obj;
  private String s1;
  private String s2;

  /**
   * setUp() function creates an object of type Recipient and MailItem.
   */

  @Before
  public void setUp() {


  }
  /**
   * testGetWidth() function check if the value returned by getWidth
   * is as required.
   */

  @Test
  public void testgetHtml1() {
    PhotoAlbum photoAlbum_obj = new PhotoAlbum();
    Color color1 = new Color(222, 77, 56);
    Rectangle r1 = new Rectangle( "R1",20,30,color1,200,100);
    photoAlbum_obj.AddShapeToPhotoAlbum(r1);
    Color color2 = new Color(204, 233, 73);
    Oval o1 = new Oval( "O1",90,45,color2,150,160);
    photoAlbum_obj.AddShapeToPhotoAlbum(o1);
    Rectangle r2 = new Rectangle( "R2",20,30,color1,200,100);
    photoAlbum_obj.AddShapeToPhotoAlbum(r2);
    SnapShot snap_model = new SnapShot("SnapShot1",photoAlbum_obj);
    snap_model.TakeSnapShots(snap_model);
    this.s1 = snap_model.getSnapShotID();
    this.view_obj = new WebView(snap_model,"test.html");
    this.view_obj.draw_view();
    String html_output = "<!DOCTYPE html>\n"
            + "<html lang=\"en\">\n"
            + "  <head>\n"
            + "    <meta charset=\"UTF-8\">\n"
            + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
            + "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n"
            + "    <title>CS 5004</title>\n"
            + "    <link rel=\"stylesheet\" href=\"style.css\">\n"
            + "  </head>\n"
            + "  <body>\n"
            + "<h2 style = background-color: Pink>"+this.s1+"&nbspSnapShot1</h2><div>\n"
            + " <svg width=\"1000\" height=\"1000\"><rect id=\"background\" x=\"0.000000\""
            + " y=\"0.000000\" width=\"800.000000\" height=\"800.000000\" fill=\"rgb(33.000000,94.000000,248.000000)\">"
            + "</rect> <svg width=\"1000\" height=\"1000\"><rect id=\"R1\" x=\"20.000000\" y=\"30.000000\" width=\"200.000000\" "
            + "height=\"100.000000\" fill=\"rgb(222.000000,77.000000,56.000000)\"></rect>    <svg width=\"1000\" height=\"1000\">"
            + "<ellipse id=\"O1\" cx=\"90.000000\" cy=\"45.000000\" rx=\"150.000000\" ry=\"160.000000\" fill=\""
            + "rgb(204.000000,233.000000,73.000000)\"></ellipse>    <svg width=\"1000\" height=\"1000\"><rect id=\"R2\" x=\"20.000000\""
            + " y=\"30.000000\" width=\"200.000000\" height=\"100.000000\" fill=\"rgb(222.000000,77.000000,56.000000)\"></rect></svg>"
            + "</div></body>\n"
            + "</html>\n";
    assertEquals(html_output, this.view_obj.getHtml());
  }
  /**
   * testGetWidth() function check if the value returned by getWidth
   * is as required.
   */

  @Test
  public void testgetHtml2() {
    PhotoAlbum photoAlbum_obj2 = new PhotoAlbum();
    Color color4 = new Color(222, 77, 56);
    Rectangle r3 = new Rectangle( "R3",20,30,color4,200,100);
    photoAlbum_obj2.AddShapeToPhotoAlbum(r3);
    Color color5 = new Color(204, 233, 73);
    Oval o2 = new Oval( "O1",90,45,color5,150,160);
    photoAlbum_obj2.AddShapeToPhotoAlbum(o2);
    SnapShot snap_model2 = new SnapShot("SnapShot2",photoAlbum_obj2);
    snap_model2.TakeSnapShots(snap_model2);
    this.s2 = snap_model2.getSnapShotID();
    this.s1 = snap_model2.getSnapShotID();
    this.view_obj = new WebView(snap_model2,"test.html");
    this.view_obj.draw_view();
    String html_output = "<!DOCTYPE html>\n"
            + "<html lang=\"en\">\n"
            + "  <head>\n"
            + "    <meta charset=\"UTF-8\">\n"
            + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
            + "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n"
            + "    <title>CS 5004</title>\n"
            + "    <link rel=\"stylesheet\" href=\"style.css\">\n"
            + "  </head>\n"
            + "  <body>\n"
            + "<h2 style = background-color: Pink>"+this.s2+"&nbspSnapShot2</h2><div>\n"
            + " <svg width=\"1000\" height=\"1000\"><rect id=\"background\" x=\"0.000000\""
            + " y=\"0.000000\" width=\"800.000000\" height=\"800.000000\" fill=\"rgb(33.000000,94.000000,248.000000)\">"
            +"</rect><svg width=\"1000\" height=\"1000\"><rect id=\"R3\" x=\"20.000000\" y=\"30.000000\" width=\"200.000000\" "
            + "height=\"100.000000\" fill=\"rgb(222.000000,77.000000,56.000000)\"></rect> <svg width=\"1000\" height=\"1000\">"
            + "<ellipse id=\"O1\" cx=\"90.000000\" cy=\"45.000000\" rx=\"150.000000\" ry=\"160.000000\" fill=\"rgb(204.000000,233.000000,"
            + "73.000000)\"></ellipse></svg></div></body>\n"
            + "</html>\n";
    assertEquals(html_output, this.view_obj.getHtml());
  }
  /**
   * testGetWidth() function check if the value returned by getWidth
   * is as required.
   */

  @Test
  public void testgetHtml3() {
    PhotoAlbum photoAlbum_obj3 = new PhotoAlbum();
    Color color3 = new Color(195, 70, 96);
    Rectangle r5 = new Rectangle( "R5",28,46,color3,300,500);
    photoAlbum_obj3.AddShapeToPhotoAlbum(r5);
    Color color2 = new Color(206, 23, 73);
    Oval o1 = new Oval( "O1",90,45,color2,150,160);
    photoAlbum_obj3.AddShapeToPhotoAlbum(o1);
    Rectangle r6 = new Rectangle( "R6",180,390,color2,290,80);
    photoAlbum_obj3.AddShapeToPhotoAlbum(r6);
    SnapShot snap_model = new SnapShot("SnapShot3",photoAlbum_obj3);
    snap_model.TakeSnapShots(snap_model);
    this.s1 = snap_model.getSnapShotID();
    this.view_obj = new WebView(snap_model,"test.html");
    this.view_obj.draw_view();
    String html_output = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "  <head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
            "    <title>CS 5004</title>\n" +
            "    <link rel=\"stylesheet\" href=\"style.css\">\n" +
            "  </head>\n" +
            "  <body>\n" +
            "<h2 style = background-color: Pink>"+this.s1+"&nbspSnapShot3</h2><div>\n" +
            " <svg width=\"1000\" height=\"1000\"><rect id=\"background\" x=\"0.000000\" y=\"0.000000\" width=\"800.000000\" height=\"800.000000\" fill=\"rgb(33.000000,94.000000,248.000000)\"></rect>    <svg width=\"1000\" height=\"1000\"><rect id=\"R5\" x=\"28.000000\" y=\"46.000000\" width=\"300.000000\" height=\"500.000000\" fill=\"rgb(195.000000,70.000000,96.000000)\"></rect>    <svg width=\"1000\" height=\"1000\"><ellipse id=\"O1\" cx=\"90.000000\" cy=\"45.000000\" rx=\"150.000000\" ry=\"160.000000\" fill=\"rgb(206.000000,23.000000,73.000000)\"></ellipse>    <svg width=\"1000\" height=\"1000\"><rect id=\"R6\" x=\"180.000000\" y=\"390.000000\" width=\"290.000000\" height=\"80.000000\" fill=\"rgb(206.000000,23.000000,73.000000)\"></rect></svg></div></body>\n" +
            "</html>\n";
    assertEquals(html_output, this.view_obj.getHtml());
  }
}
