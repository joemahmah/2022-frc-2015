package org.usfirst.frc.team2022.robot;

import org.usfirst.frc.team2022.robot.commands.ForkliftCommand;
import org.usfirst.frc.team2022.robot.commands.TankDriveCommand;
import org.usfirst.frc.team2022.robot.subsystems.ForkliftSubsystem;
import org.usfirst.frc.team2022.robot.subsystems.GyroSubsystem;
import org.usfirst.frc.team2022.robot.subsystems.PneumaticSubsystem;
import org.usfirst.frc.team2022.robot.subsystems.TankDriveSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotMain extends IterativeRobot {

	public static final TankDriveSubsystem tankSubsystem = new TankDriveSubsystem();
	public static final ForkliftSubsystem forkliftSubsystem = new ForkliftSubsystem();
	public static final PneumaticSubsystem pneumaticSubsystem = new PneumaticSubsystem(
			RobotMap.compressor, RobotMap.shiftValveChannel1,
			RobotMap.shiftValveChannel2, RobotMap.clawValveChannel1, RobotMap.clawValveChannel2);
	public static OI oi;

	Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		// instantiate the command used for the autonomous period
		// instantiate the real commands
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		// schedule the autonomous command (example)
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
		LiveWindow.run();
	}
}
