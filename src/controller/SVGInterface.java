package controller;

import java.util.List;
import model.Shapes;

public interface SVGInterface {
			
		public boolean writeSVGFile(String content);
		
		//add shapes to a svg file
		public boolean addShapes(List<Shapes> listShapes);
		
		public boolean display();	
		
}
