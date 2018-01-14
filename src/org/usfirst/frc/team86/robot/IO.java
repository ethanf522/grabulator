
package org.usfirst.frc.team86.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;


public class IO {
		
	public static Joystick joy = new Joystick(2);
	public static Solenoid sole1 = new Solenoid(1, 0);
	public static Solenoid sole2 = new Solenoid(1, 1);
	public static Solenoid sole3 = new Solenoid(1, 2);
	public static DigitalInput sensor = new DigitalInput(1);
	public static DigitalInput limitSensor = new DigitalInput(0);
	public static Compressor compressor = new Compressor(1);
	public static Relay relay = new Relay(0);
	
}
