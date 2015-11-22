# LangageDessinVectoriel

This project aims to create SVG images through the command of a user.

The subject of the subject is described [here](http://www.grall.name/teaching/softwareArchitecture/2016/project_vectorGraphics.html) (in French)

## How to use the software:

Once the project is retrieved, you can use it to create graphics. With this project, you have three ways to draw an image. Firstly, using the GUI to draw, which is easy to use; or you can use a drawing language based on Java, which is less intuitive but you will gain more control from it. Then you have the basic java language to draw.
The last two ways have example of code to help you use it.

In the package src/view, you will find 3 classes needed:

view.GUI: This is the entrance for our GUI.
view.Painting: Here is the "drawing language" that we defined. It is a script that you could modify to tell the software what it should draw.
view.Draw: Where you can write what you want to draw directly, allowing you to have more control on things. But in another hand it will be less intuitive as the two other methods.

Lets start by explaining how to use the three differents input to create vectoriel drawing.

## Using the GUI:

The GUI is composed of models in *model* package, controllers in *controller/guiController* and the user interface in *view*.

To launch the gui, you need to run the *view/GUI.java* class.
Once the gui is launched, you will have to use the text fields to create shapes.


###Pencil : 

In the left panel, you have the pencil section : you can enter values for pencil thickness and for the pencil color. The inputs are the RGB components. For example, you will fill *255, 0, 0* for the color RED.
The default color of the pencil is black.


###Shapes : 

Under the pencil section, you will find radio buttons for the different shapes you want draw. Click on them and the input text fields will appear. 

###Fill color : 

You can choose to fill the shapes when possible. The default color is white.

At the bottom of the left panel, you can add the shape to the list of shapes.


###Text area :

The text area is in the right panel. Once you added your shapes, the corresponding xml will be displayed in it. 

###Run the AWT : 

You can run the AWT preview before you save the image. Once you added your shapes, you can click on this button under the text area and see how it looks like.

###Save the drawing : 

Add the bottom of the right panel you will see a text field to enter the name you want for the svg file. Once you completed it, you can click on the save button and the svg file will be saved in *files*, and also opened.


## Using the Drawing Language:

The drawing language is clear and simple. And it's basically a class that calls our well defined APIs. Here is an example: 

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
To create a vector graphics, we need to call `p.setName` and `p.setCanvasSize` to define it's name and size. But it is not required to do this before calling other APIs. These two methods could be called at anytime. If they are not be called, a default setting would be used.

### Stroke & filling color:
You'll then need to decide the stroke and the filling color that would be used by calling these methods:

- `p.stroke(int width, Color strokeColor);`
- `p.fill(Color fillColor);`

These settings would be used as long as you do not change them. So in the example, both the circle and the ellipse are filled with red color that defined the line 9: `p.fill(Color.red);`.

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
After finishing writing codes in the `Painting` object, you can get the result by running it's `main` method. The SVG file is saved in `files/` with the name of the painting.

## Using the basic Java Langage:

### Step 1:
In the main method, you'll first need to create a Pencil (or some Pencils) to draw.
`Pencil p = new Pencil(4, new ColorSVG(Color.black.getRGB()));`
Pencil takes 2 arguments: the width of the line that will be drawn, and the color of that line (which uses a ColorSVG class, which takes an int as argument (RGB int)).

### Step 2:
You'll then need some shapes to draw.
The list of shapes are for now listed in src/model/ShapeName.
Each type of shape has it's own attribute. So for now, you'll need to see what they are for each specific shapes.
They are located in src/model/specific_path.
As an example: `Circle c = new Circle(50,40,30);`
You are encourage to add a color to your shape like that: `c.setColor(new ColorSVG(Color.blue.getRGB()));`
As well as defining the pencil used to draw that shape, pencil you would already have created: `c.setPencil(p);`

You can reapeat the Step 2 as many times as you want.

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


## More information

For more information you can check our [wiki](https://github.com/anqitong/LangageDessinVectoriel/wiki)

## Team Members:

Anqi Tong

Thomas Garesse

Xiaxing Shi
