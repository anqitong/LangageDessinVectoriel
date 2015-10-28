package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import controller.SVGInterface;

public class SVGFile implements SVGInterface{

	private String filnename;
	private String xmlcontent;
	
	public static File file;
	private static BufferedWriter out;
	
	/*
	 * the path to the folder where svg files should be saved
	 */
	private static String filepath = "files"+File.separator+"%s.svg";

	
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
		
		/*
		 * put the file name into the filepath
		 * e.g. "files\filename.svg"
		 */
		file = new File(String.format(filepath, this.getFilnename()));
		
		//if the file exists, return false and a warning
		if(file.exists()){
			System.out.println("WARNING : the file "+this.getFilnename()+" already exists!");
			return false;
		}else{
			try {
				//write the file and its content
				out = new BufferedWriter(new FileWriter(file));
				out.write(this.getXmlcontent()+"\n");
				out.close();
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			} 
		}
	}


	@Override
	public boolean display() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
