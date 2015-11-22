package controller.guiController;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
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
			JTextField ellipseRadiusValueY, Line line, JTextField x1Value, JTextField y1Value, JTextField x2Value,
			JTextField y2Value, Polygone polygone, JLabel xListPolygone, JLabel xListPolygoneValues,
			JLabel yListPolygone, JLabel yListPolygoneValues, JLabel xInputPolygone, JTextField xInputPolygoneValue,
			JLabel yInputPolygone, JTextField yInputPolygoneValue, Polyline polyline, JLabel xListPolyline,
			JLabel xListPolylineValues, JLabel yListPolyline, JLabel yListPolylineValues, JLabel xInputPolyline,
			JTextField xInputPolylineValue, JLabel yInputPolyline, JTextField yInputPolylineValue, Rectangle rectangle,
			JTextField rectValueX, JTextField rectValueY, JTextField rectWidthValue, JTextField rectHeightValue,
			Text text, JTextField textValueX, JTextField textValueY, JTextField textValue, JTextArea textArea,
			ArrayList<Shape> shapeList) {
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
		this.xListPolygone = xListPolygone;
		this.xListPolygoneValues = xListPolygoneValues;
		this.yListPolygone = yListPolygone;
		this.yListPolygoneValues = yListPolygoneValues;
		this.xInputPolygone = xInputPolygone;
		this.xInputPolygoneValue = xInputPolygoneValue;
		this.yInputPolygone = yInputPolygone;
		this.yInputPolygoneValue = yInputPolygoneValue;
		this.polyline = polyline;
		this.xListPolyline = xListPolyline;
		this.xListPolylineValues = xListPolylineValues;
		this.yListPolyline = yListPolyline;
		this.yListPolylineValues = yListPolylineValues;
		this.xInputPolyline = xInputPolyline;
		this.xInputPolylineValue = xInputPolylineValue;
		this.yInputPolyline = yInputPolyline;
		this.yInputPolylineValue = yInputPolylineValue;
		this.rectangle = rectangle;
		this.rectValueX = rectValueX;
		this.rectValueY = rectValueY;
		this.rectWidthValue = rectWidthValue;
		this.rectHeightValue = rectHeightValue;
		this.text = text;
		this.textValueX = textValueX;
		this.textValueY = textValueY;
		this.textValue = textValue;
		this.textArea = textArea;
		this.shapeList = shapeList;
	}

	//Fill color and its inputs
	private ColorSVG fillColor;
	private JTextField fillRedValue;
	private JTextField fillGreenValue;
	private JTextField fillBlueValue;

	//Pencil and its inputs
	private Pencil pencil;
	private ColorSVG pencilColor;
	private JTextField thicknessValue;
	private JTextField pencilRedValue;
	private JTextField pencilGreenValue;
	private JTextField pencilBlueValue;
	
	//Circle and its inputs
	private Circle circle;
	private	JTextField centerX;
	private JTextField centerY;
	private JTextField radiusValue;
	
	//Ellipse and its inputs
	private Ellipse ellipse;
	private JTextField ellipseCenterValueX;
	private JTextField ellipseCenterValueY;
	private JTextField ellipseRadiusValueX;
	private JTextField ellipseRadiusValueY;
	
	//Line and its inputs
	private Line line;
	private JTextField x1Value;
	private JTextField y1Value;
	private JTextField x2Value;
	private JTextField y2Value;
	
	//Polygone and its inputs
	private Polygone polygone;
	private JLabel xListPolygone;
	private JLabel xListPolygoneValues;
	private JLabel yListPolygone;
	private JLabel yListPolygoneValues;
	private JLabel xInputPolygone;
	private JTextField xInputPolygoneValue;
	private JLabel yInputPolygone;
	private JTextField yInputPolygoneValue ;
	
	//Polyline and its inputs
	private Polyline polyline;
	private JLabel xListPolyline;
	private JLabel xListPolylineValues;
	private JLabel yListPolyline;
	private JLabel yListPolylineValues;
	private JLabel xInputPolyline;
	private JTextField xInputPolylineValue;
	private JLabel yInputPolyline;
	private JTextField yInputPolylineValue ;
	
	//Rectangle and its inputs
	private Rectangle rectangle;
	private JTextField rectValueX;
	private JTextField rectValueY;
	private JTextField rectWidthValue;
	private JTextField rectHeightValue;
	
	//Text and its inputs
	private Text text;
	private JTextField textValueX;
	private JTextField textValueY;
	private JTextField textValue;
	
	//Console area
	private JTextArea textArea;
	
	//list of shapes
	private ArrayList<Shape> shapeList;
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//get pencil input values and set width and color
		if(!thicknessValue.getText().equals("")){
			/*
			 * the function trim deletes empty spaces at the beginning and at the end
			 * of the string
			 */
			pencil.setWidth(Integer.parseInt(thicknessValue.getText().trim()));
		}else{
			//display warning for the width
			JOptionPane.showMessageDialog(null, "Warning : default value of the pencil width is 4 !");
		}
		String pencilRed = pencilRedValue.getText();
		String pencilGreen = pencilGreenValue.getText();
		String pencilBlue = pencilBlueValue.getText();
		if(!pencilRed.equals("") && !pencilGreen.equals("") && !pencilBlue.equals("")){
			
			/* 
			 * convert the red, green and blue integers into a rgb integer
			 */
			int red = Integer.parseInt(pencilRed.trim());
			int green = Integer.parseInt(pencilGreen.trim());
			int blue = Integer.parseInt(pencilBlue.trim());
			int rgb = red;
			rgb = (rgb << 8) + green;
			rgb = (rgb << 8) + blue;
			pencilColor = new ColorSVG(rgb);
			pencil.setColor(pencilColor);
		}else{
			//display warning for default color values
			JOptionPane.showMessageDialog(null, "Warning : default color of the pencil is black !");
		}
		
		//get red, green and blue input values and set fill color
		String fillRed = fillRedValue.getText();
		String fillGreen = fillGreenValue.getText();
		String fillBlue = fillBlueValue.getText();
		if(!fillRed.equals("") && !fillGreen.equals("") && !fillBlue.equals("")){
			/* 
			 * convert the red, green and blue integers into a rgb integer
			 */
			int red = Integer.parseInt(fillRed.trim());
			int green = Integer.parseInt(fillGreen.trim());
			int blue = Integer.parseInt(fillBlue.trim());
			int rgb = red;
			rgb = (rgb << 8) + green;
			rgb = (rgb << 8) + blue;
			fillColor = new ColorSVG(rgb);
		}
		
		//get circle input values and set parameters
		if(!centerX.getText().equals("") && !centerY.getText().equals("") && !radiusValue.getText().equals("")){
			circle = new Circle();
			circle.setCenter_x(Integer.parseInt(centerX.getText().trim()));
			circle.setCenter_y(Integer.parseInt(centerY.getText().trim()));
			circle.setRadius(Integer.parseInt(radiusValue.getText().trim()));
			circle.setPencil(pencil);
			circle.setColor(fillColor);
			shapeList.add(circle);
		}
		
		//get ellipse input values and set ellipse parameters
		if(!ellipseCenterValueX.getText().equals("") && !ellipseCenterValueY.getText().equals("") &&
				!ellipseRadiusValueX.getText().equals("") && !ellipseRadiusValueY.getText().equals("")){
			ellipse = new Ellipse();
			ellipse.setCenter_x(Integer.parseInt(ellipseCenterValueX.getText().trim()));
			ellipse.setCenter_y(Integer.parseInt(ellipseCenterValueY.getText().trim()));
			ellipse.setRadius_x(Integer.parseInt(ellipseRadiusValueX.getText().trim()));
			ellipse.setRadius_y(Integer.parseInt(ellipseRadiusValueY.getText().trim()));
			ellipse.setPencil(pencil);
			ellipse.setColor(fillColor);
			shapeList.add(ellipse);
		}
		
		//get lines input values and set line parameters 
		if(!x1Value.getText().equals("") && !y1Value.getText().equals("")
				&& !x2Value.getText().equals("") && !y2Value.getText().equals("")){
			line = new Line();
			line.setX1(Integer.parseInt(x1Value.getText().trim()));
			line.setY1(Integer.parseInt(y1Value.getText().trim()));
			line.setX2(Integer.parseInt(x2Value.getText().trim()));
			line.setY2(Integer.parseInt(y2Value.getText().trim()));
			line.setColor(fillColor);
			line.setPencil(pencil);
			shapeList.add(line);
		}
		
		//check if polygone has points and add pencil and color
		if(polygone.getPoints()!=null && polygone.getPoints().size()>0){
			polygone = new Polygone();
			polygone.setPoints(new ArrayList<Point>());
			polygone.setColor(fillColor);
			polygone.setPencil(pencil);
			shapeList.add(polygone);
		}
		
		//check if polyline has points and add pencil and color
		if(polyline.getPoints()!=null && polyline.getPoints().size()>0){
			polyline = new Polyline();
			polyline.setPoints(new ArrayList<Point>());
			polyline.setColor(fillColor);
			polyline.setPencil(pencil);
			shapeList.add(polyline);
		}
		
		//get rectangle input values and set parameters for rectangle
		if(!rectValueX.getText().equals("") && !rectValueY.getText().equals("") &&
				!rectWidthValue.getText().equals("") && !rectHeightValue.getText().equals("")){
			rectangle = new Rectangle();
			rectangle.setX(Integer.parseInt(rectValueX.getText().trim()));
			rectangle.setY(Integer.parseInt(rectValueY.getText().trim()));
			rectangle.setWidth(Integer.parseInt(rectWidthValue.getText().trim()));
			rectangle.setHeight(Integer.parseInt(rectHeightValue.getText().trim()));
			rectangle.setColor(fillColor);
			rectangle.setPencil(pencil);
			shapeList.add(rectangle);
		}
		
		//get text input values and set parameters for text
		if(!textValueX.getText().equals("") && !textValueY.getText().equals("")
				&& !textValue.getText().equals("")){
			text = new Text();
			text.setX(Integer.parseInt(textValueX.getText().trim()));
			text.setY(Integer.parseInt(textValueY.getText().trim()));
			text.setText(textValue.getText());
			text.setColor(fillColor);
			text.setPencil(pencil);
			shapeList.add(text);
		}
		
		//get the xml string of all the shapes and display it in console area
		if(shapeList!=null && shapeList.size()>0){
			SVGFile svg = new SVGFile("testGUI");
			svg.addShapes(shapeList);
			String textRes = svg.getXmlcontent();
			this.textArea.setText(textRes);
		}
		
		
		/*
		 * clear all the input field
		 */
		
		//fill color inputs
		fillRedValue.setText("");
		fillGreenValue.setText("");
		fillBlueValue.setText("");

		//pencil inputs
		thicknessValue.setText("");
		pencilRedValue.setText("");
		pencilGreenValue.setText("");
		pencilBlueValue.setText("");
		
		//cirlce inputs
		centerX.setText("");
		centerY.setText("");
		radiusValue.setText("");
		
		//ellipse inputs
		ellipseCenterValueX.setText("");
		ellipseCenterValueY.setText("");
		ellipseRadiusValueX.setText("");
		ellipseRadiusValueY.setText("");
		
		//line inputs
		x1Value.setText("");
		y1Value.setText("");
		x2Value.setText("");
		y2Value.setText("");
		
		//polygone inputs
		xListPolygone.setText("");
		xListPolygoneValues.setText("");
		yListPolygone.setText("");
		yListPolygoneValues.setText("");
		xInputPolygone.setText("");
		xInputPolygoneValue.setText("");
		yInputPolygone.setText("");
		yInputPolygoneValue.setText("");
		
		//polyline inputs
		xListPolyline.setText("");
		xListPolylineValues.setText("");
		yListPolyline.setText("");
		yListPolylineValues.setText("");
		xInputPolyline.setText("");
		xInputPolylineValue.setText("");
		yInputPolyline.setText("");
		yInputPolylineValue.setText("");
		
		//rectangle inputs
		rectValueX.setText("");
		rectValueY.setText("");
		rectWidthValue.setText("");
		rectHeightValue.setText("");
		
		//text inputs
		textValueX.setText("");
		textValueY.setText("");
		textValue.setText("");
		
			
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}

}
