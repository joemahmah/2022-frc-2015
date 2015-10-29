package org.usfirst.frc.team2022.robot.commands;

import org.usfirst.frc.team2022.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command allows PS3 joystick to drive the robot. It is always running
 * except when interrupted by another command.
 */
public class DriveWithJoystick extends Command {
	public DriveWithJoystick() {
		requires(Robot.drivetrain);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.drivetrain.tankDrive(Robot.oi.getJoystick());
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.drivetrain.stop();
	}

	protected void interrupted() {
		end();
	}
}