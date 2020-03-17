package application.controllers;


/**
 * Gives ViewControllers the ability to choose when to initialize.
 * @author Interco
 */
public abstract class ViewController {
	public abstract void init(Object... args);
}
