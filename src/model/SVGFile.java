package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import controller.SVGInterface;

public class SVGFile implements SVGInterface{

	private String filnename;
	private String xmlcontent;
	
	private static File file;
	private static BufferedWriter out;
	private static String filepath = "files\"%s.svg";

	
	public SVGFile(String filnename, String xmlcontent) {
		this.filnename = filnename;
		this.xmlcontent = xmlcontent;
	}

	public SVGFile(String filnename) {
		this.filnename = filnename;
		this.xmlcontent = "";
	}

	public String getFilnename() {
		return filnename;
	}
	public void setFilnename(String filnename) {
		this.filnename = filnename;
	}

	public String getXmlcontent() {
		return xmlcontent;
	}

	public void setXmlcontent(String xmlcontent) {
		this.xmlcontent = xmlcontent;
	}

	
	/*
	 * save SVG file into files
	 */
	@Override
	public boolean writeSVGFile() {
		file = new File(String.format(filnename, this.getXmlcontent()));
		if(file.exists()){
			System.out.println("WARNING : the file "+this.getFilnename()+" already exists!");
			return false;
		}else{
			try {
				out = new BufferedWriter(new FileWriter(file));
				out.write(this.getXmlcontent());
				out.close();
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			} 
		}
	}

	@Override
	public boolean addShapes(List<ShapesType> listShapes) {
//		for(ShapesType shape:listShapes){
//			shape.getXML(pencil)
//		}
		return false;
	}

	@Override
	public boolean display() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
