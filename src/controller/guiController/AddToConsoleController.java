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

import model.ColorRBG;
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


	public AddToConsoleController(ColorRBG fillColor, JTextField fillRedValue, JTextField fillGreenValue,
			JTextField fillBlueValue, Pencil pencil, ColorRBG pencilColor, JTextField thicknessValue,
			JTextField pencilRedValue, JTextField pencilGreenValue, JTextField pencilBlueValue, Circle circle,
			JTextField centerX, JTextField centerY, JTextField radiusValue, Ellipse ellipse,
			JTextField ellipseCenterValueX, JTextField ellipseCenterValueY, JTextField ellipseRadiusValueX,
			JTextField ellipseRadiusValueY, Line line, JTextField x1Value, JTextField y1Value, JTextField x2Value,
			JTextField y2Value, Polygone polygone, JLabel xListPolygoneValues,
			JLabel yListPolygoneValues, JTextField xInputPolygoneValue,
			JTextField yInputPolygoneValue, Polyline polyline,
			JLabel xListPolylineValues, JLabel yListPolylineValues, 
			JTextField xInputPolylineValue, JTextField yInputPolylineValue, Rectangle rectangle,
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
		this.xListPolygoneValues = xListPolygoneValues;
		this.yListPolygoneValues = yListPolygoneValues;
		this.xInputPolygoneValue = xInputPolygoneValue;
		this.yInputPolygoneValue = yInputPolygoneValue;
		this.polyline = polyline;
		this.xListPolylineValues = xListPolylineValues;
		this.yListPolylineValues = yListPolylineValues;
		this.xInputPolylineValue = xInputPolylineValue;
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
	private ColorRBG fillColor;
	private JTextField fillRedValue;
	private JTextField fillGreenValue;
	private JTextField fillBlueValue;

	//Pencil and its inputs
	private Pencil pencil;
	private ColorRBG pencilColor;
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
	private JLabel xListPolygoneValues;
	private JLabel yListPolygoneValues;
	private JTextField xInputPolygoneValue;
	private JTextField yInputPolygoneValue ;
	
	//Polyline and its inputs
	private Polyline polyline;
	private JLabel xListPolylineValues;
	private JLabel yListPolylineValues;
	private JTextField xInputPolylineValue;
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
			pencilColor = new ColorRBG(rgb);
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
			
			//left shift : <<
			/* The left operands value is moved left by the number
			 *  of bits specified by the right operand
			 */
			rgb = (rgb << 8) + green;
			rgb = (rgb << 8) + blue;
			fillColor = new ColorRBG(rgb);
		}
		
		//get circle input values and set parameters
		if(!centerX.getText().equals("") && !centerY.getText().equals("") && !radiusValue.getText().equals("")){
			circle = new Circle();
			circle.setCenter_x(Integer.parseInt(centerX.getText().trim()));
			circle.setCenter_y(Integer.parseInt(centerY.getText().trim()));
			circle.setRadius(Integer.parseInt(radiusValue.getText().trim()));
			
			ColorRBG penColor = new ColorRBG(pencilColor.getRGB());
			Pencil pen = new Pencil(pencil.getWidth(),penColor);
			ColorRBG fillingColor = new ColorRBG(fillColor.getRGB());
			
			circle.setPencil(pen);
			circle.setColor(fillingColor);
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
			
			ColorRBG penColor = new ColorRBG(pencilColor.getRGB());
			Pencil pen = new Pencil(pencil.getWidth(),penColor);
			ColorRBG fillingColor = new ColorRBG(fillColor.getRGB());
			
			ellipse.setPencil(pen);
			ellipse.setColor(fillingColor);
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
			
			ColorRBG penColor = new ColorRBG(pencilColor.getRGB());
			Pencil pen = new Pencil(pencil.getWidth(),penColor);
			ColorRBG fillingColor = new ColorRBG(fillColor.getRGB());
			
			line.setColor(fillingColor);
			line.setPencil(pen);
			shapeList.add(line);
		}
		
		//check if polygone has points and add pencil and color
		if(polygone.getPoints()!=null && polygone.getPoints().size()>0){
			Polygone pol = new Polygone();
			
			ColorRBG penColor = new ColorRBG(pencilColor.getRGB());
			Pencil pen = new Pencil(pencil.getWidth(),penColor);
			ColorRBG fillingColor = new ColorRBG(fillColor.getRGB());
			
			pol.setPencil(pen);
			pol.setColor(fillingColor);
			pol.setPoints(polygone.getPoints());
			shapeList.add(pol);
			polygone.setPoints(new ArrayList<Point>());
		}
		
		//check if polyline has points and add pencil and color
		if(polyline.getPoints()!=null && polyline.getPoints().size()>0){
			
			Polyline pol = new Polyline();
			ColorRBG penColor = new ColorRBG(pencilColor.getRGB());
			Pencil pen = new Pencil(pencil.getWidth(),penColor);
			ColorRBG fillingColor = new ColorRBG(fillColor.getRGB());
			
			pol.setPencil(pen);
			pol.setColor(fillingColor);
			pol.setPoints(polyline.getPoints());
			shapeList.add(pol);
			polyline.setPoints(new ArrayList<Point>());
		}
		
		//get rectangle input values and set parameters for rectangle
		if(!rectValueX.getText().equals("") && !rectValueY.getText().equals("") &&
				!rectWidthValue.getText().equals("") && !rectHeightValue.getText().equals("")){
			rectangle = new Rectangle();
			rectangle.setX(Integer.parseInt(rectValueX.getText().trim()));
			rectangle.setY(Integer.parseInt(rectValueY.getText().trim()));
			rectangle.setWidth(Integer.parseInt(rectWidthValue.getText().trim()));
			rectangle.setHeight(Integer.parseInt(rectHeightValue.getText().trim()));
			
			ColorRBG penColor = new ColorRBG(pencilColor.getRGB());
			Pencil pen = new Pencil(pencil.getWidth(),penColor);
			ColorRBG fillingColor = new ColorRBG(fillColor.getRGB());
			
			rectangle.setColor(fillingColor);
			rectangle.setPencil(pen);
			shapeList.add(rectangle);
		}
		
		//get text input values and set parameters for text
		if(!textValueX.getText().equals("") && !textValueY.getText().equals("")
				&& !textValue.getText().equals("")){
			text = new Text();
			text.setX(Integer.parseInt(textValueX.getText().trim()));
			text.setY(Integer.parseInt(textValueY.getText().trim()));
			text.setText(textValue.getText());
			
			ColorRBG penColor = new ColorRBG(pencilColor.getRGB());
			Pencil pen = new Pencil(pencil.getWidth(),penColor);
			ColorRBG fillingColor = new ColorRBG(fillColor.getRGB());
			
			text.setColor(fillingColor);
			text.setPencil(pen);
			shapeList.add(text);
		}
		
		//get the xml string of all the shapes and display it in console area
		if(shapeList!=null && shapeList.size()>0){
			SVGFile svg = new SVGFile("testGUI");
			svg.addShapes(shapeList);
			//svg.createDrawing();
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
		xListPolygoneValues.setText("");
		yListPolygoneValues.setText("");
		xInputPolygoneValue.setText("");
		yInputPolygoneValue.setText("");
		
		//polyline inputs
		xListPolylineValues.setText("");
		yListPolylineValues.setText("");
		xInputPolylineValue.setText("");
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
