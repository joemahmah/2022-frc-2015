package org.usfirst.frc.team2022.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// Tank Drive Motors
	public static int leftMotorFront = 3;
	public static int leftMotorBack = 4;
	public static int rightMotorFront = 2;
	public static int rightMotorBack = 1;
	//Camera Host Name
	public static String cameraName = "$\u0004";
	//Pneumatic Shifters
	public static int shiftPressureSwitchChannel = 0;
	public static int shiftValveChannel1 = 0;
	public static int shiftValveChannel2 = 0;
	// Claw Pneumatics
	public static int clawPressureSwitchChannel = 0;
	public static int clawValveChannel1 = 0;
	public static int clawValveChannel2 = 0;
	public static int gyroChannel = 4;
	//Lidar
	public static int lidarPort = 0;
	public static int lidarScalar = 1;//Not a port
	//Forklift
	public static int upperLimitSwitchPort = 0;
	public static int lowerLimitSwitchPort = 0;
	public static int winchMotor = 5;
}
