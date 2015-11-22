# LangageDessinVectoriel

This project aims to create vector graphics through the command of a user. And created graphics could be show in a java frame and saved as a SVG file.

The subject of the subject is described [here](http://www.grall.name/teaching/softwareArchitecture/2016/project_vectorGraphics.html) (in French)

## About the software:

Once the project is retrieved, you can use it to create graphics. With this project, you have two way to draw an image. Firstly, using the **GUI** to draw, which is easy to use; or you can use a **drawing language** based on Java, which is less intuitive but you gain more control from it.

In the package src/view, you will find 3 classes. And they are all you need:

- `view.GUI`: This is the entrance for our GUI.
- `view.Painting`: Here is the "drawing language" that we defined. It is a script that you could modify to tell the software what it should draw.
- `view.Draw`: This is the class that we run the software to draw contents defined in `view.Painting`.

## Using the GUI

// **TODO**

## Using the drawing language

The drawing language is clear and simple. And it's basicly a class that calls our well defined APIs. Here is an example: 

	public class Painting implements DrawingTask {

	    @Override
	    public void draw(Painter p) {
	        p.setName("Painting with language");
	        p.setCanvasSize(600, 600);
	
	        p.stroke(1, Color.blue);
	        p.fill(Color.red);
	        p.circle(30, 30, 30);
	
	        p.stroke(2, Color.darkGray);
	        p.ellipse(100, 30, 40, 20);	    }
	}

As you can see, all drawing tasks are finished by calling methods in the given object `p` in the `void draw(Painter p)` method.

### Name & size:
To create a vector graphics, we need to call `p.setName` and `p.setCanvasSize` to define it's name and size. But it is not required to do this before calling other APIs. These two methods could be call at anytime. If they are not be called, which a default setting would be used.

### Stroke & filling color:
You'll then need to decide the stroke and the filling color that would be used by calling these methods:

- `p.stroke(int width, Color strokeColor);`
- `p.fill(Color fillColor);`

These setting would be used as long as you do not change them. So in the example, both the circle and the ellipse are filled with red color that defined that line 9: `p.fill(Color.red);`.

### Shapes & text:
Here is all methods in `p` that you can draw: 

    void circle(int x, int y, int r);
    void ellipse(int x, int y, int rx, int ry);
    void line(int x1, int y1, int x2, int y2);
    void path(LineType type, int[] xs, int[] ys);
    void polygone(int[] xs, int[] ys);
    void polyline(int[] xs, int[] ys);
    void rectangle(int x, int y, int width, int height);
    void text(int x, int y, String text);
    
### Get result
After finish writing codes in the `Painting` object, you could get the result by running  `view.Draw`. The SVG file is saved in `files/` with the name of the painting.

## Team Members:

Anqi Tong

Thomas Garesse

Xiaxing Shi

- - -
## Sould be reused after defined insert in Painter
### Step 3:
Gather your shapes to add them to a drawing:

		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(c);

Once it is done, you'll need to create a SVGFile, which is the presentation that will create a SVG File :

		SVGFile svg = new SVGFile("name_of_the_file_without_extention");
		
Add your shapes to it and call the display to update the object after adding new Shapes.

		svg.addShapes(shapes);
		svg.display();

You can also add a drawing into another drawing by doing:

		svg.insert(svg1); //with sv1 being a SVGFile
		

### Step 4:
Create your SVG file, that will be created in the folder File in the root of the project by calling the function:

		svg.writeSVGFile();
		
When this method is called, it checks if there is an other svg file with the same name. If yes, the svg file cannot be created and a warning is displayed. If no, then the file will be created.

If you want to open that file in your default browser, call the view() method:

		svg.view();
		
The file must have been created for it to be displayed without error.
