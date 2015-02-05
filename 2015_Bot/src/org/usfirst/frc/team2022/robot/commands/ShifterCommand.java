
package org.usfirst.frc.team2022.robot.commands;

import org.usfirst.frc.team2022.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShifterCommand extends Command {
	
	boolean isExtended = false;
	boolean isDone;

    public ShifterCommand() {
        requires(Robot.shifterSubsystem);
    }

    @Override
	protected void initialize() {
    	isDone = false;
    }

    @Override
	protected void execute() {
    	if(!Robot.oi.attack3.getTrigger())return;
		if(!isExtended){
    		Robot.shifterSubsystem.openValve();
    		isExtended = true;
    	}else{
    		Robot.shifterSubsystem.closeValve();
    		isExtended = false;
    	}
    }

    @Override
	protected boolean isFinished() {
        return isDone;
    }

    @Override
	protected void end() {
    }

    @Override
	protected void interrupted() {
    	end();
    }
}
