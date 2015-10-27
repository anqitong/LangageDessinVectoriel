package controller;

import java.util.List;

import model.Shapes;
import model.ShapesType;

public interface SVGInterface {
			
		/*
		 * save SVG file into files
		 */
		public boolean writeSVGFile();
		
		/*
		 * add shapes from listShqpes to a svg file
		 */
		public boolean addShapes(List<ShapesType> listShapes);
		
		public boolean display();	
		
}
