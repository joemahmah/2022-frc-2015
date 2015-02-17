package org.usfirst.frc.team2022.robot.subsystems;

import org.usfirst.frc.team2022.robot.RobotMap;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GyroSubsystem extends Subsystem {
	public final Gyro gyro;

	public GyroSubsystem() {
		gyro = new Gyro(RobotMap.gyroChannel);
		gyro.initGyro();
	}

	public void initDefaultCommand() {
	}

	// gyro functions
	public double getAngle() {
		return gyro.getAngle();
	}

	public double getRotationRate() {
		return gyro.getRate();
	}

	public void setGyroSensitivity(double voltsPerDegreePerSecond) {
		gyro.setSensitivity(voltsPerDegreePerSecond);
	}
}
