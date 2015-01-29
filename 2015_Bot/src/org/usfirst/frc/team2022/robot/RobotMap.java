package org.usfirst.frc.team2022.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	public static int upperLimitSwitchPort = 1; //fake value
	public static int lowerLimitSwitchPort = 1; //fake value
	public static int winch = 1; //fake value
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	public static int leftMotorFront = 1;
	public static int leftMotorBack = 2;
	public static int rightMotorFront = 3;
	public static int rightMotorBack = 4;
	public static int shiftPressureSwitchChannel = -1;
	public static int shiftValveChannel1 = -1;
	public static int shiftValveChannel2 = -1;
	public static int clawPressureSwitchChannel = -1;
	public static int clawValveChannel1 = -1;
	public static int clawValveChannel2 = -1;
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
