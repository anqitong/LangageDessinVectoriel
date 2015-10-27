package test;

import model.SVGFile;

public class Test {
	public static void main(String[] args) {
		SVGFile f = new SVGFile("test","empty");
		System.out.println(f.writeSVGFile());
	}
}
