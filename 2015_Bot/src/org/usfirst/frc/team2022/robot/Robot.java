package org.usfirst.frc.team2022.robot;

import org.usfirst.frc.team2022.robot.commands.CompressorCommand;
import org.usfirst.frc.team2022.robot.commands.ForkliftCommand;
import org.usfirst.frc.team2022.robot.commands.IntakeCommand;
import org.usfirst.frc.team2022.robot.commands.TankDriveCommand;
//import org.usfirst.frc.team2022.robot.commands.autonomous.Autonomous;
import org.usfirst.frc.team2022.robot.subsystems.ForkliftSubsystem;
import org.usfirst.frc.team2022.robot.subsystems.GyroSubsystem;
import org.usfirst.frc.team2022.robot.subsystems.IntakeSubsystem;
import org.usfirst.frc.team2022.robot.subsystems.TankDriveSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */ 
public class Robot extends IterativeRobot {
    

	public static TankDriveSubsystem tankSubsystem;
	public static ForkliftSubsystem forkliftSubsystem;
	public static GyroSubsystem gyroSubsystem;
	public static OI oi;
	public static IntakeSubsystem intakeSubsystem;

//	CommandGroup autonomousCommand;
	TankDriveCommand tankCommand;
	ForkliftCommand forkliftCommand;
	IntakeCommand intakeCommand;
	CompressorCommand compressorCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
                tankSubsystem = new TankDriveSubsystem();
                forkliftSubsystem = new ForkliftSubsystem();
                gyroSubsystem = new GyroSubsystem();
                intakeSubsystem = new IntakeSubsystem();
		// instantiate the command used for the autonomous period
//		autonomousCommand = new Autonomous();
		// instantiate the real commands
		tankCommand = new TankDriveCommand();
		forkliftCommand = new ForkliftCommand();
		intakeCommand = new IntakeCommand();
		compressorCommand = new CompressorCommand();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		// schedule the autonomous command
//		if (autonomousCommand != null)
//			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
//		if (autonomousCommand != null)
//			autonomousCommand.cancel();
		tankCommand.start();
		forkliftCommand.start();
		intakeCommand.start();
		compressorCommand.start();
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	@Override
	public void disabledInit() {
		//
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
	}
}
