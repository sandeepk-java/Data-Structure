package com.sky.desginpattern.factorydp;

public class Main {

	public static void main(String[] args) {
		ShapeFactory factory = new ShapeFactory();
		Shape c = factory.getShape("Circle");
		c.draw();

	}

}
