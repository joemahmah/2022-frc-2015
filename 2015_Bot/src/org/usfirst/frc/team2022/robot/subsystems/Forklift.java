
package org.usfirst.frc.team2022.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import org.usfirst.frc.team2022.robot.RobotMap;
//import of robot map didn't allow access to variables defined within, 

/**
 *
 */
public class Forklift extends Subsystem {
    
//set isUpperLimit and isLowerLimit based on the limit switch
	static Jaguar winchMotor;
	static DigitalInput upperLimit;
	static DigitalInput lowerLimit;
	public static boolean isUpperLimit;
	public static boolean isLowerLimit;
	
    public void initDefaultCommand() {
    	winchMotor = new Jaguar(RobotMap.winch) ;
    	upperLimit = new DigitalInput(RobotMap.upperLimitSwitchPort);
    	lowerLimit = new DigitalInput(RobotMap.lowerLimitSwitchPort);
    }
	public static void moveForklift(double winchSpeed){
		if(upperLimit.get() != true & lowerLimit.get() != true){
			winchMotor.set(winchSpeed);
		}
		else{
			winchMotor.set(0);
		}
		isUpperLimit = upperLimit.get();
		isLowerLimit = upperLimit.get();
	}
	public static void toTop(){
		while(upperLimit.get() == false){
			winchMotor.set(1);
		}
		winchMotor.set(0);
	}
	public static void toBottom(){
		while(lowerLimit.get() == false){
			winchMotor.set(-1);
		}
		winchMotor.set(0);
	}


}

