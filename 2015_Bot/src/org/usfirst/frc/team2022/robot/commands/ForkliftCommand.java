
package org.usfirst.frc.team2022.robot.commands;

import org.usfirst.frc.team2022.robot.OI;
import org.usfirst.frc.team2022.robot.RobotMain;
import org.usfirst.frc.team2022.robot.subsystems.ForkliftSubsystem;

import edu.wpi.first.wpilibj.command.Command;




/**
 *
 */
public class ForkliftCommand extends Command {

	ForkliftSubsystem forkliftSubsystem;
	OI oi;
	
	public ForkliftCommand() {
        requires(RobotMain.forkliftSubsystem);
    }
	
    @Override
    protected void initialize() {
    	forkliftSubsystem = RobotMain.forkliftSubsystem;
    	oi = RobotMain.oi;
    }

    @Override
    protected void execute() {
    	double speedMod = .5;
    	
		double moveMag = Math.max(Math.min(oi.attack4.getYAxis(), 1), -1);
		
//		if(oi.attack3.getButton(1)){
//			speedMod = .75 - Math.abs(oi.attack3.getXAxis() * oi.attack3.getYAxis() * 3 / 4);
//		} else if(oi.attack3.getButton(5)){
//			speedMod = .75 + Math.abs(oi.attack3.getXAxis() * oi.attack3.getYAxis() / 4);
//		}
		
		if(oi.attack4.getButton(1)){
			speedMod = .25;
		} else if(oi.attack4.getButton(4)){
			speedMod = .75;
		}
		
    	//forwards == down, backwards == up
		if(moveMag > RobotMain.oi.attackThrottleSensitivity && !RobotMain.forkliftSubsystem.getUpperLimit()){
			forkliftSubsystem.moveForklift(moveMag * speedMod);
		}else if(moveMag < -RobotMain.oi.attackThrottleSensitivity && !RobotMain.forkliftSubsystem.getLowerLimit()){
			forkliftSubsystem.moveForklift(moveMag * speedMod);
		}else{
			forkliftSubsystem.moveForklift(0);
		}
    }
    
    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    	forkliftSubsystem.moveForklift(0);
    }
    
    @Override
    protected void interrupted() {
    	end();
    }
}
