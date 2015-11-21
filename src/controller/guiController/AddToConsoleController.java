package controller.guiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JTextField;

import model.ColorSVG;
import model.Pencil;
import model.Shape;
import model.presentation.xml.SVGFile;
import model.specific_path.Circle;
import model.specific_path.Ellipse;
import model.specific_path.Line;
import model.specific_path.Polygone;
import model.specific_path.Polyline;
import model.specific_path.Rectangle;
import model.specific_path.Text;

public class AddToConsoleController implements Observer, ActionListener{

	
	public AddToConsoleController(ColorSVG fillColor, JTextField fillRedValue, JTextField fillGreenValue,
			JTextField fillBlueValue, Pencil pencil, ColorSVG pencilColor, JTextField thicknessValue,
			JTextField pencilRedValue, JTextField pencilGreenValue, JTextField pencilBlueValue, Circle circle,
			JTextField centerX, JTextField centerY, JTextField radiusValue, Ellipse ellipse,
			JTextField ellipseCenterValueX, JTextField ellipseCenterValueY, JTextField ellipseRadiusValueX,
			JTextField ellipseRadiusValueY, Line line, JTextField x1Value, JTextField y1Value,
			JTextField x2Value, JTextField y2Value, Polygone polygone, Polyline polyline,
			Rectangle rectangle, JTextField rectValueX, JTextField rectValueY,
			JTextField rectWidthValue, JTextField rectHeightValue, Text text, 
			JTextField textValueX, JTextField textValueY, JTextField textValue) {
		this.fillColor = fillColor;
		this.fillRedValue = fillRedValue;
		this.fillGreenValue = fillGreenValue;
		this.fillBlueValue = fillBlueValue;
		this.pencil = pencil;
		this.pencilColor = pencilColor;
		this.thicknessValue = thicknessValue;
		this.pencilRedValue = pencilRedValue;
		this.pencilGreenValue = pencilGreenValue;
		this.pencilBlueValue = pencilBlueValue;
		this.circle = circle;
		this.centerX = centerX;
		this.centerY = centerY;
		this.radiusValue = radiusValue;
		this.ellipse = ellipse;
		this.ellipseCenterValueX = ellipseCenterValueX;
		this.ellipseCenterValueY = ellipseCenterValueY;
		this.ellipseRadiusValueX = ellipseRadiusValueX;
		this.ellipseRadiusValueY = ellipseRadiusValueY;
		this.line = line;
		this.x1Value = x1Value;
		this.y1Value = y1Value;
		this.x2Value = x2Value;
		this.y2Value = y2Value;
		this.polygone = polygone;
		this.polyline = polyline;
		this.rectangle = rectangle;
		this.rectValueX = rectValueX;
		this.rectValueY = rectValueY;
		this.rectWidthValue = rectWidthValue;
		this.rectHeightValue = rectHeightValue;
		this.text = text;
		this.textValueX = textValueX;
		this.textValueY = textValueY;
		this.textValue = textValue;
	}

	//Fill color
	private ColorSVG fillColor;
	private JTextField fillRedValue;
	private JTextField fillGreenValue;
	private JTextField fillBlueValue;

	//Pencil
	private Pencil pencil;
	private ColorSVG pencilColor;
	private JTextField thicknessValue;
	private JTextField pencilRedValue;
	private JTextField pencilGreenValue;
	private JTextField pencilBlueValue;
	
	//Circle
	private Circle circle;
	private	JTextField centerX;
	private JTextField centerY;
	private JTextField radiusValue;
	
	//Ellipse
	private Ellipse ellipse;
	private JTextField ellipseCenterValueX;
	private JTextField ellipseCenterValueY;
	private JTextField ellipseRadiusValueX;
	private JTextField ellipseRadiusValueY;
	
	//Line
	private Line line;
	private JTextField x1Value;
	private JTextField y1Value;
	private JTextField x2Value;
	private JTextField y2Value;
	
	//Polygone
	private Polygone polygone;
	
	//Polyline
	private Polyline polyline;
	
	//Rectangle
	private Rectangle rectangle;
	private JTextField rectValueX;
	private JTextField rectValueY;
	private JTextField rectWidthValue;
	private JTextField rectHeightValue;
	
	//Text
	private Text text;
	private JTextField textValueX;
	private JTextField textValueY;
	private JTextField textValue;
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		
		//setting pencil parameters
		if(thicknessValue.getText()!=null){
			pencil.setWidth(Integer.parseInt(thicknessValue.getText().trim()));
		}
		String pencilRed = pencilRedValue.getText();
		String pencilGreen = pencilGreenValue.getText();
		String pencilBlue = pencilBlueValue.getText();
		if(!pencilRed.equals("") && !pencilGreen.equals("") && !pencilBlue.equals("")){
			int red = Integer.parseInt(pencilRed.trim());
			int green = Integer.parseInt(pencilGreen.trim());
			int blue = Integer.parseInt(pencilBlue.trim());
			int rgb = red;
			rgb = (rgb << 8) + green;
			rgb = (rgb << 8) + blue;
			pencilColor = new ColorSVG(rgb);
			pencil.setColor(pencilColor);
		}
		
		//setting filling color
		String fillRed = fillRedValue.getText();
		String fillGreen = fillGreenValue.getText();
		String fillBlue = fillBlueValue.getText();
		if(!fillRed.equals("") && !fillGreen.equals("") && !fillBlue.equals("")){
			int red = Integer.parseInt(fillRed.trim());
			int green = Integer.parseInt(fillGreen.trim());
			int blue = Integer.parseInt(fillBlue.trim());
			int rgb = red;
			rgb = (rgb << 8) + green;
			rgb = (rgb << 8) + blue;
			fillColor = new ColorSVG(rgb);
		}
		
		//setting circle parameters
		if(!centerX.getText().equals("") && !centerY.getText().equals("") && !radiusValue.getText().equals("")){
			circle.setCenter_x(Integer.parseInt(centerX.getText().trim()));
			circle.setCenter_y(Integer.parseInt(centerY.getText().trim()));
			circle.setRadius(Integer.parseInt(radiusValue.getText().trim()));
			circle.setPencil(pencil);
			circle.setColor(fillColor);
			shapes.add(circle);
		}
		
		//setting ellipse parameters
		if(!ellipseCenterValueX.getText().equals("") && !ellipseCenterValueY.getText().equals("") &&
				!ellipseRadiusValueX.getText().equals("") && !ellipseRadiusValueY.getText().equals("")){
			ellipse.setCenter_x(Integer.parseInt(ellipseCenterValueX.getText().trim()));
			ellipse.setCenter_y(Integer.parseInt(ellipseCenterValueY.getText().trim()));
			ellipse.setRadius_x(Integer.parseInt(ellipseRadiusValueX.getText().trim()));
			ellipse.setRadius_y(Integer.parseInt(ellipseRadiusValueY.getText().trim()));
			ellipse.setPencil(pencil);
			ellipse.setColor(fillColor);
			shapes.add(ellipse);
		}
		
		//setting line parameters 
		if(!x1Value.getText().equals("") && !y1Value.getText().equals("")
				&& !x2Value.getText().equals("") && !y2Value.getText().equals("")){
			line.setX1(Integer.parseInt(x1Value.getText().trim()));
			line.setY1(Integer.parseInt(y1Value.getText().trim()));
			line.setX2(Integer.parseInt(x2Value.getText().trim()));
			line.setY2(Integer.parseInt(y2Value.getText().trim()));
			line.setColor(fillColor);
			line.setPencil(pencil);
			shapes.add(line);
		}
		
		//check if polygone has points
		if(polygone.getPoints()!=null && polygone.getPoints().size()>0){
			polygone.setColor(fillColor);
			polygone.setPencil(pencil);
			shapes.add(polygone);
		}
		
		//check if polyline has points
		if(polyline.getPoints()!=null && polyline.getPoints().size()>0){
			polyline.setColor(fillColor);
			polyline.setPencil(pencil);
			shapes.add(polyline);
		}
		
		//setting parameters for rectangle
		if(!rectValueX.getText().equals("") && !rectValueY.getText().equals("") &&
				!rectWidthValue.getText().equals("") && !rectHeightValue.getText().equals("")){
			rectangle.setX(Integer.parseInt(rectValueX.getText().trim()));
			rectangle.setY(Integer.parseInt(rectValueY.getText().trim()));
			rectangle.setWidth(Integer.parseInt(rectWidthValue.getText().trim()));
			rectangle.setHeight(Integer.parseInt(rectHeightValue.getText().trim()));
			rectangle.setColor(fillColor);
			rectangle.setPencil(pencil);
			shapes.add(rectangle);
		}
		
		//setting paramters for text
		if(!textValueX.getText().equals("") && !textValueY.getText().equals("")
				&& !textValue.getText().equals("")){
			text.setX(Integer.parseInt(textValueX.getText().trim()));
			text.setY(Integer.parseInt(textValueY.getText().trim()));
			text.setText(textValue.getText());
			text.setColor(fillColor);
			text.setPencil(pencil);
			shapes.add(text);
		}
			
		
		
		// Create the drawing (named test) (empty here)
		SVGFile svg = new SVGFile("testGUI");
		// Add the shapes to draw
		svg.addShapes(shapes);
		// Create the drawing in the object
		svg.createDrawing();
		System.out.println(svg.getXmlcontent());
		// Create a svg file with the drawing
		svg.writeSVGFile();
		// Open it in your defaul browser
		svg.view();	
	}

	@Override
	public void update(Observable o, Object arg) {
	}

}
