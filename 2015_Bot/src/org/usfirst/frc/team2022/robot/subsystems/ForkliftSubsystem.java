
package org.usfirst.frc.team2022.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import org.usfirst.frc.team2022.robot.RobotMap;

/**
 *
 */
public class ForkliftSubsystem extends Subsystem {
	private Jaguar winchMotor;
	private DigitalInput upperLimit;
	private DigitalInput lowerLimit;
	//set isUpperLimit and isLowerLimit based on the limit switch
	public boolean isUpperLimit;
	public boolean isLowerLimit;
	
	public ForkliftSubsystem(){
		winchMotor = new Jaguar(RobotMap.winchMotor) ;
		upperLimit = new DigitalInput(RobotMap.upperLimitSwitchPort);
		lowerLimit = new DigitalInput(RobotMap.lowerLimitSwitchPort);
	}

	public void initDefaultCommand() {}
	
	public void moveForklift(double winchSpeed){
		if(!upperLimit.get() && !lowerLimit.get()){
			winchMotor.set(winchSpeed);
		}else{
			winchMotor.set(0);
		}
		isUpperLimit = upperLimit.get();
		isLowerLimit = lowerLimit.get();
	}
}

