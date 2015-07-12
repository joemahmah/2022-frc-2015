package org.usfirst.frc.team2022.robot.commands;

import java.util.Timer;

import org.usfirst.frc.team2022.robot.RobotMain;
import org.usfirst.frc.team2022.robot.subsystems.TankDriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class MoveForward extends Command{
	
	TankDriveSubsystem tankSubsystem;

	public MoveForward(){
		requires(RobotMain.tankSubsystem);
		tankSubsystem = RobotMain.tankSubsystem;
	}

	@Override
	protected void end() {
		tankSubsystem.stop();
	}

	@Override
	protected void execute() {
		double speedModifier = .5;
		int timeToRun = 5000;
		long firstTime;
		long secondTime;
		
		
		firstTime = System.currentTimeMillis();
		secondTime = System.currentTimeMillis() + timeToRun;
		while(System.currentTimeMillis() < secondTime){
			tankSubsystem.setLeftSpeed(speedModifier);
			tankSubsystem.setRightSpeed(speedModifier);
		}
		tankSubsystem.setLeftSpeed(0);
		tankSubsystem.setRightSpeed(0);
		
		
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

}
