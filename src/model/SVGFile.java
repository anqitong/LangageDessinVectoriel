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

	//write new content and save
	@Override
	public boolean writeSVGFile(String content) {
		File file = new File("files\""+this.getFilnename()+".svg");
		BufferedWriter out;
		try {
			out = new BufferedWriter(new FileWriter(file));
			out.write(content);
			out.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return false;
	}

	@Override
	public boolean addShapes(List<Shapes> listShapes) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean display() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
