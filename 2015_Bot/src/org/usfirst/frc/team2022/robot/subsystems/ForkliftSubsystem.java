
package org.usfirst.frc.team2022.robot.subsystems;

import org.usfirst.frc.team2022.robot.RobotMap;
import org.usfirst.frc.team2022.robot.commands.ForkliftCommand;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ForkliftSubsystem extends Subsystem {
	private Talon winchMotor;
	private Encoder winchEncoder;
	private DigitalInput upperLimit;
	private DigitalInput lowerLimit;
	//set isUpperLimit and isLowerLimit based on the limit switch
	
	public ForkliftSubsystem(){
		winchMotor = new Talon(RobotMap.winchMotor) ;
		winchEncoder = new Encoder(RobotMap.winchEncoderChannelA, RobotMap.winchEncoderChannelB);
		upperLimit = new DigitalInput(RobotMap.upperLimitSwitchPort);
		lowerLimit = new DigitalInput(RobotMap.lowerLimitSwitchPort);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new ForkliftCommand());
	}
	
	public void moveForklift(double winchSpeed){
		if(!upperLimit.get() && !lowerLimit.get()){
			winchMotor.set(winchSpeed);
		}else{
			winchMotor.set(0);
		}
	}
	public boolean getUpperLimit(){
		return upperLimit.get();
	}
	public boolean getLowerLimit(){
		return lowerLimit.get();
	}
}

