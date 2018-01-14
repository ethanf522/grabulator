package org.usfirst.frc.team86.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;

public class IO {
		
	public static Joystick joy = new Joystick(0);
	public static Solenoid sole1 = new Solenoid(1);
	public static Solenoid sole2 = new Solenoid(2);
	public static Solenoid sole3 = new Solenoid(3);
	public static DigitalInput sensor = new DigitalInput(4);
	public static DigitalInput limitSensor = new DigitalInput(5);
	
}
