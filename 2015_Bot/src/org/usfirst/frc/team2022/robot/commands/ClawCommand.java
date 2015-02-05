package org.usfirst.frc.team2022.robot.commands;

import org.usfirst.frc.team2022.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ClawCommand extends Command {

	boolean isDone = false;

	public ClawCommand() {
		requires(Robot.clawSubsystem);
	}

	@Override
	protected void initialize() {
		isDone = false;
	}

	@Override
	protected void execute() {
		if (!Robot.oi.attack4.getTrigger())
			return;
		if (!Robot.clawSubsystem.isValveOpen()) {
			Robot.clawSubsystem.openValve();
		} else {
			Robot.clawSubsystem.closeValve();
		}
	}

	@Override
	protected boolean isFinished() {
		return isDone;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
		end();
	}
}
