package org.usfirst.frc.team2022.robot.commands;

import org.usfirst.frc.team2022.robot.Robot;
import org.usfirst.frc.team2022.robot.RobotMain;
import org.usfirst.frc.team2022.robot.subsystems.IntakeSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeAutonomousCommand extends Command{
	
	IntakeSubsystem intakeSubsystem;
	public String direction;
	
	public IntakeAutonomousCommand(String direction) {
		this.direction = direction;
		requires(Robot.intakeSubsystem);
		intakeSubsystem = Robot.intakeSubsystem;
	}

	@Override
	protected void end() {
		intakeSubsystem.stop();
	}

	@Override
	protected void execute() {
		long firstTime = System.currentTimeMillis();
		long secondTime = firstTime + 1000;
		while(System.currentTimeMillis() < secondTime){
			if(direction.equals("In")){
				intakeSubsystem.totesIn();
			}else if(direction.equals("Out")){
				intakeSubsystem.totesOut();
			}
		}
		if(direction.equals("In")){
			intakeSubsystem.totesIn();
		}
	}

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void interrupted() {
		end();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	
}
