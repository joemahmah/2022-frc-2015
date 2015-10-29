package org.usfirst.frc.team2022.robot;

import org.usfirst.frc.team2022.robot.commands.Collect;
import org.usfirst.frc.team2022.robot.commands.DriveForward;
import org.usfirst.frc.team2022.robot.commands.LowGoal;
import org.usfirst.frc.team2022.robot.commands.SetCollectionSpeed;
import org.usfirst.frc.team2022.robot.commands.SetPivotSetpoint;
import org.usfirst.frc.team2022.robot.commands.Shoot;
import org.usfirst.frc.team2022.robot.subsystems.Collector;
import org.usfirst.frc.team2022.robot.subsystems.Pivot;
import org.usfirst.frc.team2022.robot.triggers.DoubleButton;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The operator interface of the robot, it has been simplified from the real
 * robot to allow control with a single PS3 joystick. As a result, not all
 * functionality from the real robot is available.
 */
public class OI {
	public Joystick joystick;

	public OI() {
		joystick = new Joystick(0);
		
		new JoystickButton(joystick, 12).whenPressed(new LowGoal());
		new JoystickButton(joystick, 10).whenPressed(new Collect());
		
		new JoystickButton(joystick, 11).whenPressed(new SetPivotSetpoint(Pivot.SHOOT));
		new JoystickButton(joystick, 9).whenPressed(new SetPivotSetpoint(Pivot.SHOOT_NEAR));
		
		new DoubleButton(joystick, 2, 3).whenActive(new Shoot());
		
		
		// SmartDashboard Buttons
		SmartDashboard.putData("Drive Forward", new DriveForward(2.25));
		SmartDashboard.putData("Drive Backward", new DriveForward(-2.25));
		SmartDashboard.putData("Start Rollers", new SetCollectionSpeed(Collector.FORWARD));
		SmartDashboard.putData("Stop Rollers", new SetCollectionSpeed(Collector.STOP));
		SmartDashboard.putData("Reverse Rollers", new SetCollectionSpeed(Collector.REVERSE));
	}

	public Joystick getJoystick() {
		return joystick;
	}
}
