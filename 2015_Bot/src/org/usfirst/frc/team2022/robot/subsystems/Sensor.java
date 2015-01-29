
package org.usfirst.frc.team2022.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;
import org.usfirst.frc.team2022.robot.Robot;

/**
 *
 */
public class Sensor extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
    	Robot.gyro.initGyro();
    }
    
    //gyro functions
    public double getAngle(){
    	return Robot.gyro.getAngle();
    }
    public double getRotationRate(){
    	return Robot.gyro.getRate();
    }
    public void setGyroSensitivity(double voltsPerDegreePerSecond){
    	Robot.gyro.setSensitivity(voltsPerDegreePerSecond);
    }
    
    //camera functions should go here
    
    //light functions
    
    
}

