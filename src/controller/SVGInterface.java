package controller;

import java.util.List;

import view.ShapeState;

public interface SVGInterface {
			
		public boolean writeSVGFile(String content);
		
		//add shapes to a svg file
		public boolean addShapes(List<ShapeState> listShapes);
		
		public boolean display();	
}
