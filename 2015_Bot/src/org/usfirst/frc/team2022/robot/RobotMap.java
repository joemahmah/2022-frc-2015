package org.usfirst.frc.team2022.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// Tank Drive Motors
	public static int leftMotorFront = -1;
	public static int leftMotorBack = -1;
	public static int rightMotorFront = -1;
	public static int rightMotorBack = -1;
	//Camera Host Name
	public static String cameraName = "$\u0004";
	//Pneumatic Shifters
	public static int shiftPressureSwitchChannel = -1;
	public static int shiftValveChannel1 = -1;
	public static int shiftValveChannel2 = -1;
	// Claw Pneumatics
	public static int clawPressureSwitchChannel = -1;
	public static int clawValveChannel1 = -1;
	public static int clawValveChannel2 = -1;
	public static int gyroChannel = -1;
	//Lidar
	public static int lidarPort = -1;
	public static int lidarScalar = 1;//Not a port
	//Forklift
	public static int upperLimitSwitchPort = -1;
	public static int lowerLimitSwitchPort = -1;
	public static int winch = -1;
}
