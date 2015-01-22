
package org.usfirst.frc.team2022.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2022.robot.OI;
import org.usfirst.frc.team2022.robot.Robot;

/**
 *
 */
public class TankDriveCommand extends Command {
	public TankDriveCommand() {
		requires(Robot.tankSubsystem);
	}
	@Override
	protected void initialize() {
	}
	@Override
	protected void execute() {
		OI oi = Robot.oi;
		double speedModifier = .75;
		double right = Math.max(Math.min(oi.xbox.GetRightY(), 1),-1);
		double left = Math.max(Math.min(oi.xbox.GetRightY(), 1),-1);
		if(oi.xbox.GetLeftBumperValue()){
			if(oi.xbox.GetStartButton().get()){
				speedModifier = .25;//fast turtle
			} else{
				speedModifier = .5;//turtle
			}
		} else if(oi.xbox.GetRightBumperValue()){ //turbo
			speedModifier = 1;
		}
		Robot.tankSubsystem.setLeftSpeed(left* speedModifier);
		Robot.tankSubsystem.setRightSpeed(right * speedModifier);
	}
	@Override
	protected boolean isFinished() {
		return false;
	}
	@Override
	protected void end() {
		throw new IllegalStateException("NOT FINISHED!");
	}
	@Override
	protected void interrupted() {
		//this command is rather important and should not be canceled
	}
	@Override
	//no it doesn't :)
	public void cancel(){}
}
