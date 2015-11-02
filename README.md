# LangageDessinVectoriel

This project aims to create SVG images through the command of a user.

The subject of the subject is described [here](http://www.grall.name/teaching/softwareArchitecture/2016/project_vectorGraphics.html) (in French)

## How to use the software:

Once the project has been retrieved, you can use it to create SVG files.
In the package src/view, you have a file "Draw.java". This is the java class you'll have to use to run the software.

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

		SVGFile svg = new SVGFile("name_of_the_file");
		
Add your shapes to it and call the display to update the object after adding new Shapes.
		svg.addShapes(shapes);

### Step 4:
Create your SVG file, that will be created in the folder File in the root of the project by calling the function:

		svg.writeSVGFile();
		
When this method is called, it checks if there is an other svg file with the same name. If yes, the svg file cannot be created and a warning is displayed. If no, then the file will be created.



## Team Members:

Anqi Tong

Thomas Garesse

Xiaxing Shi
