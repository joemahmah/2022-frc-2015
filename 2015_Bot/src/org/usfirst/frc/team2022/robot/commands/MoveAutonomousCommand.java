package org.usfirst.frc.team2022.robot.commands;

import org.usfirst.frc.team2022.robot.RobotMain;
import org.usfirst.frc.team2022.robot.subsystems.TankDriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class MoveAutonomousCommand extends Command{
	
	TankDriveSubsystem tankSubsystem;
	public int time;
	public String direction;
	
	public MoveAutonomousCommand(int time, String direction){
		this.direction = direction;
		this.time = time;
		requires(RobotMain.tankSubsystem);
		tankSubsystem = RobotMain.tankSubsystem;
	}

	@Override
	protected void end() {
		tankSubsystem.stop();
	}

	@Override
	protected void execute() {
		if(direction.equals("Straight")){
			double speed = 1;
			long firstTime;
			long secondTime;
			
			
			firstTime = System.currentTimeMillis();
			secondTime = System.currentTimeMillis() + time;
			while(System.currentTimeMillis() < secondTime){
				tankSubsystem.setLeftSpeed(speed);
				tankSubsystem.setRightSpeed(speed);
			}
			tankSubsystem.setLeftSpeed(0);
			tankSubsystem.setRightSpeed(0);
		}else if(direction.equals("Right")){
			double speed = .75;
			long firstTime;
			long secondTime;
			
			
			firstTime = System.currentTimeMillis();
			secondTime = System.currentTimeMillis() + time;
			while(System.currentTimeMillis() < secondTime){
				tankSubsystem.setLeftSpeed(speed);
				tankSubsystem.setRightSpeed(0);
			}
			tankSubsystem.setLeftSpeed(0);
			tankSubsystem.setRightSpeed(0);
		}
		else if(direction.equals("Back")){
			double speed = -1;
			long firstTime;
			long secondTime;
			
			
			firstTime = System.currentTimeMillis();
			secondTime = System.currentTimeMillis() + time;
			while(System.currentTimeMillis() < secondTime){
				tankSubsystem.setLeftSpeed(speed);
				tankSubsystem.setRightSpeed(speed);
			}
			tankSubsystem.setLeftSpeed(0);
			tankSubsystem.setRightSpeed(0);
		}
		
		
		
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
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
