
package org.usfirst.frc.team2022.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2022.robot.Robot;
import org.usfirst.frc.team2022.robot.subsystems.Pneumatics;

/**
 *
 */
public class ClawCommand extends Command {
	
	boolean isExtended = false;
	boolean isDone;

    public ClawCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.claw);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	isDone = false;
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//each case
		if(isExtended == false){
    		Robot.claw.valveOpen();
    		isExtended = true;
    	}
    	else;if(isExtended == true){
    		Robot.claw.valveClose();
    		isExtended = false;
    	}
    	isDone = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isDone;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
