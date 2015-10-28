package model;

import java.util.List;

import view.ShapeState;
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

	@Override
	public boolean writeSVGFile(String content) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addShapes(List<ShapeState> listShapes) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean display() {
		// TODO Auto-generated method stub
		return false;
	}
}
