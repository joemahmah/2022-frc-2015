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
	
	OI oi = RobotMain.oi;
	TankDriveSubsystem tankSubsystem;
	PneumaticSubsystem pneumaticSubsystem;
	boolean shifterActivated = false;
	
	int toggle = 0;
	
	public TankDriveCommand() {
		requires(RobotMain.tankSubsystem);
		requires(RobotMain.pneumaticSubsystem);
		tankSubsystem = RobotMain.tankSubsystem;
		pneumaticSubsystem = RobotMain.pneumaticSubsystem;
	}

	@Override
	protected void initialize() {
//		SmartDashboard.putString("TankDrive", "COMMAND_INIT");
	}

	@Override
	protected void execute() {
		double speedModifier = .75;
		double right = Math.max(Math.min(oi.xbox.GetRightY(), 1), -1);
		double left = Math.max(Math.min(oi.xbox.GetLeftY(), 1), -1);
		
		if (oi.xbox.GetRightBumperValue()) {
			tankSubsystem.toggleInversion();
		}
		
//		if(tankSubsystem.isInverted()){
//			speedModifier = .3;
//		}
		
		if (oi.xbox.GetLeftTriggers() > 0.1) { // turtle
			speedModifier = .5; 
		} else if (oi.xbox.GetRightTriggers() > 0.1) { // turbo
			speedModifier = 1; 
		}
		
		if(tankSubsystem.isInverted()){
			tankSubsystem.setLeftSpeed(right * speedModifier);
			tankSubsystem.setRightSpeed(left * speedModifier);
		}else{
			tankSubsystem.setLeftSpeed(left * speedModifier);
			tankSubsystem.setRightSpeed(right * speedModifier);
		}
		
		
		
		//Shifter Stuff goes down here
		if(oi.xbox.GetLeftBumperValue()){
			pneumaticSubsystem.toggleShifterState();
		}

//		tankSubsystem.setLeftSpeed(.2);
//		tankSubsystem.setRightSpeed(.2);
//		
//		if(oi.xbox.GetAValue()){
//			pneumaticSubsystem.openShifterValve();
//		}
		
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
}
