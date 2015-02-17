package org.usfirst.frc.team2022.robot.sensors;

import edu.wpi.first.wpilibj.AnalogInput;

import org.usfirst.frc.team2022.robot.RobotMap;

public class Lidar extends AnalogInput {

	public Lidar(int channel) {
		super(channel);
	}

	public double getDistance() {
		// this assumes a linear relationship between voltage and distance,
		// verify if that is correct
		double voltage = this.getVoltage();
		double distance = voltage * RobotMap.lidarScalar;
		return distance;
	}
}
