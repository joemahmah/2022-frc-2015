package org.usfirst.frc.team2022.robot.subsystems;

import java.sql.Time;
import java.util.Calendar;
import java.util.Timer;

import org.usfirst.frc.team2022.robot.RobotMap;
import org.usfirst.frc.team2022.robot.commands.TankDriveCommand;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.hal.CanTalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TankDriveSubsystem extends Subsystem {
	private CanTalonSRX frontLeft, frontRight, rearLeft, rearRight;
	private double leftSpeed, rightSpeed;
	private boolean inverted;
	private long lastTime;

	public TankDriveSubsystem() {
		// SmartDashboard.putString("TankDrive", "SUBSYSTEM_INIT"); //Will
		// crash. TODO: fix?
		frontLeft = new CanTalonSRX(RobotMap.leftMotorFront);
		frontRight = new CanTalonSRX(RobotMap.rightMotorFront);
		rearLeft = new CanTalonSRX(RobotMap.leftMotorBack);
		rearRight = new CanTalonSRX(RobotMap.rightMotorBack);

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
		frontLeft.Set(ls);
		rearLeft.Set(ls);
	}

	public void setRightSpeed(double rs) {
		rightSpeed = rs;
		frontRight.Set(rs);
		rearRight.Set(rs);
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
		frontRight.Set(0);
		frontLeft.Set(0);
		rearRight.Set(0);
		rearLeft.Set(0);
		rightSpeed = 0;
		leftSpeed = 0;
	}
}
