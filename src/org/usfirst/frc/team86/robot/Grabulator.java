package org.usfirst.frc.team86.robot;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;

public class Grabulator extends IO {
	
	private Solenoid sole1;
	private Solenoid sole2;
	private Solenoid sole3;
	public enum State {DEFAULT, GEARPREP, GEARREACH, GEARGRIPPED, GEARUP, GEARREADY}
	public State state;
	public Timer timer = new Timer();
	public Double delayTime = 0.25;

	public Grabulator(Solenoid sole1, Solenoid sole2, Solenoid sole3) {
		this.sole1 = sole1;
		this.sole2 = sole2;
		this.sole3 = sole3;
	}
	
	private void rotateDown() {
		sole1.set(true);
	}
	
	private void rotateUp() {
		sole1.set(false);
	}
	
	private void extendDown() {
		sole2.set(true);
	}
	
	private void extendUp() {
		sole2.set(false);
	}
	
	private void grip() {
		sole3.set(true);
	}
	
	private void gripRelease() {
		sole3.set(false);
	}
	
	public void update() {
		if(joy.getRawButton(1) == true) {
			switch(state) {
			
			case DEFAULT:
				timer.start();
				state = State.GEARPREP;
				break;
				
			case GEARPREP:
				//Solenoid 1 is rotated down
				//Checking for Gear
				//Once sensor = false, move to state 1
				if(timer.get() > delayTime) {
					rotateDown();
				}
				if(sensor.get() == false) 
					state = State.GEARREACH;
				timer.reset();
				break;
				
			case GEARREACH:
				//Solenoid 2 is extended down
				//Once extended down, move to state 2
				if(timer.get() > delayTime) {
					extendDown();
				}
				state = State.GEARGRIPPED;
				timer.reset();
				break;
				
			case GEARGRIPPED:
				//Solenoid 3 is gripped
				//Once gripped, move to state 3
				if(timer.get() > delayTime) {
					grip();
				}
				state = State.GEARUP;
				timer.reset();
				break;
				
			case GEARUP:
				//Solenoid 2 is extended up
				//Once extended up, move to state 4
				if(timer.get() > delayTime) {
					extendUp();
				}
				state = State.GEARREADY;
				timer.reset();
				break;
				
			case GEARREADY:
				//Solenoid 1 is rotated up
				rotateUp();
				break;	
				
			}
		}
		else if(joy.getRawButton(1) == false) {
			if(sole3.get() == true) {
				//Once button is let go, gear is released
				gripRelease();
			}
			if(sole2.get() == true) {
				extendUp();
			}
			if(sole1.get() == true) {
				rotateUp();
			}
		}
		timer.stop();
	}
}
