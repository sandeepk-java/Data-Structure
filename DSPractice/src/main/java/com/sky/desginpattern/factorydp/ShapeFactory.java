package com.sky.desginpattern.factorydp;

public class ShapeFactory {
	
	public Shape getShape(String shapeName){
		Shape shape = null;
		if(shapeName==null)
			shape = null;
		else if(shapeName.equalsIgnoreCase("circle"))
			shape = new Circle();
		else if(shapeName.equalsIgnoreCase("Rectangle"))
			shape = new Rectangle();
		else if(shapeName.equalsIgnoreCase("Square"))
			shape = new Square();
		return shape;
	}
}
