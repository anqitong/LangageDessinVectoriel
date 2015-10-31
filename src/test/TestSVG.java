package test;

import org.junit.Assert;
import org.junit.Test;

import model.presentation.xml.SVGFile;

public class TestSVG {

	/*
	 * The creation of the file "svg" return true 
	 */
	@Test
	public void createSVG_success() {
		SVGFile svg = new SVGFile("test","some content");
		Assert.assertEquals(true, svg.writeSVGFile());
	}
	
	/*
	 * The creation of the file "f2" return false
	 * because there is already another file with 
	 * the same name 
	 */
	@Test
	public void createSVG_fail(){
		SVGFile f1 = new SVGFile("testFile","some content");
		f1.writeSVGFile();
		SVGFile f2 = new SVGFile("testFile","some content");
		Assert.assertEquals(false, f2.writeSVGFile());
	}

}
