package org.usfirst.frc.team2022.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2022.robot.Robot;

/**
 *
 */
public class ExampleCommand extends Command {

	public ExampleCommand() {
		requires(Robot.exampleSubsystem);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}
}
