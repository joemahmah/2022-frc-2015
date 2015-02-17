package org.usfirst.frc.team2022.robot.commands;

import org.usfirst.frc.team2022.robot.OI;
import org.usfirst.frc.team2022.robot.RobotMain;
import org.usfirst.frc.team2022.robot.subsystems.PneumaticSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CompressorCommand extends Command {

	OI oi;
	PneumaticSubsystem pneumaticSubsystem;
	
    public CompressorCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(RobotMain.pneumaticSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	oi = RobotMain.oi;
    	
    	pneumaticSubsystem = RobotMain.pneumaticSubsystem;
    	pneumaticSubsystem.start();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	
    	
    }

    //Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	pneumaticSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	pneumaticSubsystem.stop();
    }
}
