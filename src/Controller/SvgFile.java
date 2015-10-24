package controller;

import java.util.List;
import model.Shapes;

public interface SvgFile {
	//if filename does not exist, create a new svg file
		//if filename exists, then write content into it
		public boolean writeSVGFile(String filename, String content);
		
		//add shapes to a svg file
		public boolean addShapes(List<Shapes> listShapes);
		
		public boolean display(String filename);	
}
