package org.usfirst.frc.team2022.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2022.robot.OI;
import org.usfirst.frc.team2022.robot.RobotMain;
import org.usfirst.frc.team2022.robot.controllers.Xbox;
import org.usfirst.frc.team2022.robot.subsystems.PneumaticSubsystem;
import org.usfirst.frc.team2022.robot.subsystems.TankDriveSubsystem;

/**
 *
 */
public class TankDriveCommand extends Command {
	
	private OI oi = RobotMain.oi;
	private TankDriveSubsystem tankSubsystem;
	private PneumaticSubsystem pneumaticSubsystem;
	private boolean shifterActivated = false;
	
	private final static int gracePeriodMS = 500;
	
	//To be used with button combos?
	private long lastLeftTrigger;
	private long lastRightTrigger;
	private long lastLeftBumper;
	private long lastRightBumper;
	
	private int driveState;
	
	private final static int STICK_TANK = 0;
	private final static int STICK_LR = 1;
	private final static int STICK_L = 2;
	private final static int MAX_DRIVE_STATE = 2;
	
	public TankDriveCommand() {
		requires(RobotMain.tankSubsystem);
		requires(RobotMain.pneumaticSubsystem);
	}

	@Override
	protected void initialize() {
		tankSubsystem = RobotMain.tankSubsystem;
		pneumaticSubsystem = RobotMain.pneumaticSubsystem;

		lastLeftTrigger = System.currentTimeMillis() - gracePeriodMS;
		lastRightTrigger = System.currentTimeMillis() - gracePeriodMS;
		lastLeftBumper = System.currentTimeMillis() - gracePeriodMS;
		lastRightBumper = System.currentTimeMillis() - gracePeriodMS;
		
		driveState = STICK_TANK;
		
	}

	@Override
	protected void execute() {
		double speedModifier = .75;
		
		//Driver inputs w/ dead zone
		double right = Math.max(Math.min(oi.xbox.GetRightY(), 1), -1);
		double left = Math.max(Math.min(oi.xbox.GetLeftY(), 1), -1);
		if(left < .1){
			left = 0;
		}
		if(right < .1){
			right = 0;
		}
		
		//Pressed objects
		boolean leftTrigger = oi.xbox.GetLeftTriggers() > .1;
		boolean rightTrigger = oi.xbox.GetRightTriggers() > .1;
		boolean leftBumper = oi.xbox.GetLeftBumperValue();
		boolean rightBumper = oi.xbox.GetRightBumperValue();
		
		if (rightBumper) {
			tankSubsystem.toggleInversion();
			lastRightBumper = System.currentTimeMillis();
		}
		
		if (leftTrigger && !rightTrigger) { // turtle
			speedModifier = .5; 
			lastLeftTrigger = System.currentTimeMillis();
		} else if (rightTrigger && !leftTrigger) { // turbo
			speedModifier = 1; 
			lastRightTrigger = System.currentTimeMillis();
		} else if(rightTrigger && leftTrigger){
			switchMode();
		}
		
		switch(driveState){
		case STICK_TANK:
			if(tankSubsystem.isInverted()){
				tankSubsystem.setLeftSpeed(right * speedModifier);
				tankSubsystem.setRightSpeed(left * speedModifier);
			}else{
				tankSubsystem.setLeftSpeed(left * speedModifier);
				tankSubsystem.setRightSpeed(right * speedModifier);
			}
			break;
		case STICK_LR:
			
			break;
		case STICK_L:
			
			break;
		}
		
		
		//Shifter Stuff goes down here
		if(leftBumper){
			pneumaticSubsystem.toggleShifterState();
			lastLeftBumper = System.currentTimeMillis();
		}
		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		RobotMain.tankSubsystem.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}
	
	protected void switchMode(){
		driveState++;
		
		if(driveState > MAX_DRIVE_STATE){
			driveState = 0;
		}
	}
}
