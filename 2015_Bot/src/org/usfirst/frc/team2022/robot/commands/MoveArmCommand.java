package org.usfirst.frc.team2022.robot.commands;

import org.usfirst.frc.team2022.robot.RobotMain;
import org.usfirst.frc.team2022.robot.subsystems.ForkliftSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class MoveArmCommand extends Command{
	
	ForkliftSubsystem forkliftSubsystem;
	public String direction;
	
	public MoveArmCommand(String direction){
		this.direction = direction;
		requires(RobotMain.forkliftSubsystem);
		forkliftSubsystem = RobotMain.forkliftSubsystem;
	}

	@Override
	protected void end() {
		forkliftSubsystem.moveForklift(0);
	}

	@Override
	protected void execute() {
		if(direction.equals("AllDown")){
			forkliftSubsystem.moveForklift(-1);
		}else{
			long firstTime = System.currentTimeMillis();
			long secondTime = firstTime + 1000;
			while(System.currentTimeMillis() < secondTime){
				if(direction.equals("Up")){
					forkliftSubsystem.moveForklift(1);
				}else if(direction.equals("down")){
					forkliftSubsystem.moveForklift(-1);
				}
			}
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
