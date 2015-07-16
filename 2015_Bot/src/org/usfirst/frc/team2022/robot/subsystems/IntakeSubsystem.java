package org.usfirst.frc.team2022.robot.subsystems;

import org.usfirst.frc.team2022.robot.RobotMap;
import org.usfirst.frc.team2022.robot.commands.IntakeCommand;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeSubsystem extends Subsystem {
	private Talon rightIntake;
	private Talon leftIntake;
	
	public IntakeSubsystem(){
		rightIntake = new Talon(RobotMap.rightIntake);
		leftIntake = new Talon(RobotMap.leftIntake);
	}
	
	

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new IntakeCommand());
	}
	
	public double getRightSpeed(){
		return rightIntake.get();
	}
	
	public double getLeftSpeed(){
		return leftIntake.get();
	}
	
	public void setRightSpeed(double speed){
		rightIntake.set(speed);		
	}
	
	public void setLeftSpeed(double speed){
		leftIntake.set(speed);
	}
	
	public void totesIn(){
		setRightSpeed(1);
		setLeftSpeed(-1);
	}
	
	public void totesOut(){
		setRightSpeed(-.75);
		setLeftSpeed(.75);
	}
	
	public void stop(){
		rightIntake.set(0);
		leftIntake.set(0);
	}

}
