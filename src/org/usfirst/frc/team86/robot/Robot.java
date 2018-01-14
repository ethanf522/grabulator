package org.usfirst.frc.team86.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	public Grabulator grabulator;

	@Override
	public void robotInit() {
		grabulator = new Grabulator(IO.sole1, IO.sole2, IO.sole3);
	}

	@Override
	public void autonomousInit() {
		
	}
	}
	@Override
	public void autonomousPeriodic() {
		
	}

	@Override
	public void teleopPeriodic() {
		grabulator.update();
	}


	@Override
	public void testPeriodic() {
	}
}

