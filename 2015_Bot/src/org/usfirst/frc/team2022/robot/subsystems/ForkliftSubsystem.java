
package org.usfirst.frc.team2022.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.hal.CanTalonSRX;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;

import org.usfirst.frc.team2022.robot.RobotMap;
import org.usfirst.frc.team2022.robot.commands.ForkliftCommand;

/**
 *
 */
public class ForkliftSubsystem extends Subsystem {
	private CanTalonSRX winchMotor;
	private Encoder winchEncoder;
//	private DigitalInput upperLimit;
//	private DigitalInput lowerLimit;
	//set isUpperLimit and isLowerLimit based on the limit switch
	
	public ForkliftSubsystem(){
		winchMotor = new CanTalonSRX(RobotMap.winchMotor) ;
		winchEncoder = new Encoder(RobotMap.winchEncoderChannelA, RobotMap.winchEncoderChannelB);
//		upperLimit = new DigitalInput(RobotMap.upperLimitSwitchPort);
//		lowerLimit = new DigitalInput(RobotMap.lowerLimitSwitchPort);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new ForkliftCommand());
	}
	
	public void moveForklift(double winchSpeed){
//		if(!upperLimit.get() && !lowerLimit.get()){
		if(true){
			winchMotor.Set(winchSpeed);
		}else{
			winchMotor.Set(0);
		}
	}
	public boolean getUpperLimit(){
//		return upperLimit.get();
		return false;
	}
	public boolean getLowerLimit(){
//		return lowerLimit.get();
		return false;
	}
}

