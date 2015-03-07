package org.usfirst.frc.team2022.robot.commands.auto;

import java.awt.Robot;

import org.usfirst.frc.team2022.robot.RobotMain;
import org.usfirst.frc.team2022.robot.subsystems.PneumaticSubsystem;
import org.usfirst.frc.team2022.robot.subsystems.TankDriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * Command used in autonomous to move the bot forward.
 *
 */
public class AutoMoveHighGear extends Command {

	long stopTime;
	int runTime;

	double speedLeft;
	double speedRight;

	TankDriveSubsystem tankDrive;
	PneumaticSubsystem pneumatics;

	/**
	 * 
	 * @param millis
	 *            Time in milliseconds
	 */
	public AutoMoveHighGear(int millis, double speedLeft, double speedRight) {
		requires(RobotMain.tankSubsystem);
		requires(RobotMain.pneumaticSubsystem);

		runTime = millis;
		tankDrive = RobotMain.tankSubsystem;
		pneumatics = RobotMain.pneumaticSubsystem;
		
		this.speedLeft = speedLeft;
		this.speedRight = speedRight;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		stopTime = System.currentTimeMillis() + runTime;
		pneumatics.openShifterValve();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		tankDrive.setLeftSpeed(speedLeft);
		tankDrive.setRightSpeed(speedRight);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return System.currentTimeMillis() > stopTime;
	}

	// Called once after isFinished returns true
	protected void end() {
		tankDrive.stop();

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		tankDrive.stop();
	}
}
