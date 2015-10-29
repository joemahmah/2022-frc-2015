package org.usfirst.frc.team2022.robot.commands;

import org.usfirst.frc.team2022.robot.OI;
import org.usfirst.frc.team2022.robot.Robot;
import org.usfirst.frc.team2022.robot.RobotMain;
import org.usfirst.frc.team2022.robot.subsystems.IntakeSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeCommand extends Command{
	
	OI oi = Robot.oi;
	IntakeSubsystem intakeSubsystem;
	
	public IntakeCommand(){
		requires(RobotMain.intakeSubsystem);
		intakeSubsystem = RobotMain.intakeSubsystem;
	}

	@Override
	protected void end() {
		RobotMain.intakeSubsystem.stop();
	}

	@Override
	protected void execute() {
		
		//Take in totes
		if(oi.attack3.getButton(2) || oi.attack4.getButton(2)){
			intakeSubsystem.totesIn();
		//Spit out totes
		}else if(oi.attack3.getButton(2) || oi.attack4.getButton(3)){
			intakeSubsystem.totesOut();
		}else{
			intakeSubsystem.stop();
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
		return false;
	}

}
