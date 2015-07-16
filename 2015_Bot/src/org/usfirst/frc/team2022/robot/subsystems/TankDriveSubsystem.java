package org.usfirst.frc.team2022.robot.subsystems;

import org.usfirst.frc.team2022.robot.RobotMap;
import org.usfirst.frc.team2022.robot.commands.TankDriveCommand;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TankDriveSubsystem extends Subsystem {
	private Talon frontLeft, frontRight, rearLeft, rearRight;
	private double leftSpeed, rightSpeed;
	private boolean inverted;
	private long lastTime;

	public TankDriveSubsystem() {
		// SmartDashboard.putString("TankDrive", "SUBSYSTEM_INIT"); //Will
		// crash. TODO: fix?
		frontLeft = new Talon(RobotMap.leftMotorFront);
		frontRight = new Talon(RobotMap.rightMotorFront);
		rearLeft = new Talon(RobotMap.leftMotorBack);
		rearRight = new Talon(RobotMap.rightMotorBack);

		inverted = false;
		lastTime = System.currentTimeMillis();
	}

	@Override	
	// this is important for WPILib.
	public void initDefaultCommand() {
		setDefaultCommand(new TankDriveCommand());

	}

	// Speed Manipulation Methods-these are more fine grained
	public double getLeftSpeed() {
		return leftSpeed;
	}

	public double getRightSpeed() {
		return rightSpeed;
	}

	public void setLeftSpeed(double ls) {
		leftSpeed = ls;
		frontLeft.set(ls);
		rearLeft.set(ls);
	}

	public void setRightSpeed(double rs) {
		rightSpeed = rs;
		frontRight.set(rs);
		rearRight.set(rs);
	}

	// Inversion
	public boolean isInverted() {
		return inverted;
	}

	public void toggleInversion() {
		if (System.currentTimeMillis() > lastTime + 250) {
			lastTime = System.currentTimeMillis();
			inverted = !inverted;
			leftSpeed *= -1;
			rightSpeed *= -1;
		}
	}

	// Forwards and Reverse Control for each side.
	public void stop() {
		frontRight.set(0);
		frontLeft.set(0);
		rearRight.set(0);
		rearLeft.set(0);
		rightSpeed = 0;
		leftSpeed = 0;
	}
}
