
package org.usfirst.frc.team2022.robot.commands;

import org.usfirst.frc.team2022.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;




/**
 *
 */
public class ForkliftCommand extends Command {

    boolean isDone=false;

	public ForkliftCommand() {
        requires(Robot.forkliftSubsystem);
    }
    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
    	double throttle = Robot.oi.attack4.getThrottle();
    	//forwards == down, backwards == up
		if(throttle > Robot.oi.attackThrottleSensitivity && !Robot.forkliftSubsystem.isLowerLimit){
			Robot.forkliftSubsystem.moveForklift(-1);
		}else if(throttle < -Robot.oi.attackThrottleSensitivity && !Robot.forkliftSubsystem.isUpperLimit){
			Robot.forkliftSubsystem.moveForklift(1);
		}else{
			Robot.forkliftSubsystem.moveForklift(0);
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
