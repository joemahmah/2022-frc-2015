package org.usfirst.frc.team2022.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//Tank
	public static int leftMotorFront = 2;
	public static int leftMotorBack = 3;
	public static int rightMotorFront = 1;
	public static int rightMotorBack = 0;

	//Pneumatics
	public static int compressor = 2;
	public static int shiftValveChannel1 = 0;
	public static int shiftValveChannel2 = 1;
	public static int clawValveChannel1 = 2;
	public static int clawValveChannel2 = 3;
	
	//Misc Sensors
	public static int gyroChannel = 4;
	public static int lidarPort = 3;
	public static int lidarScalar = 1;//Not a port
	
	//Forklift
	public static int upperLimitSwitchPort = 1;
	public static int lowerLimitSwitchPort = 2;
	public static int winchMotor = 4;
	public static int winchEncoderChannelA = 5;
	public static int winchEncoderChannelB = 6;
}
