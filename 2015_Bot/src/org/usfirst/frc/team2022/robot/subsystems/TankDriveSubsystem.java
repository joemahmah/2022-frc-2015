
package org.usfirst.frc.team2022.robot.subsystems;

import org.usfirst.frc.team2022.robot.RobotMap;
import org.usfirst.frc.team2022.robot.commands.TankDriveCommand;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TankDriveSubsystem extends Subsystem {
	public double motorSpeed=1;
	private final Jaguar frontLeft,frontRight,rearLeft,rearRight;
	private double leftSpeed,rightSpeed;
	private boolean inverted;

	public TankDriveSubsystem() {
		frontLeft = new Jaguar(RobotMap.leftMotorFront);
		frontRight = new Jaguar(RobotMap.rightMotorFront);
		rearLeft = new Jaguar(RobotMap.leftMotorBack);
		rearRight = new Jaguar(RobotMap.rightMotorBack);
	}
	@Override //this is important for WPILib.
	public void initDefaultCommand() {
        setDefaultCommand(new TankDriveCommand());
    }
	//Speed Manipulation Methods-these are more fine grained
	public double getLeftSpeed() {
		return leftSpeed;
	}
	public double getRightSpeed() {
		return rightSpeed;
	}
	public void setLeftSpeed(double ls){
		leftSpeed = ls;
		frontLeft.set(ls);
		rearLeft.set(ls);
	}
	public void setRightSpeed(double rs){
		rightSpeed = rs;
		frontRight.set(rs);
		rearRight.set(rs);
	}
	//Inversion
	public boolean isInverted(){
		return inverted;
	}
	public void toggleInversion(){
		inverted = !inverted;
		motorSpeed *= -1;
		leftSpeed *= -1;
		rightSpeed *= -1;
	}
    //Forwards and Reverse Control for each side.
    public void forwardLeft(){
    	frontLeft.set(motorSpeed);
    	rearLeft.set(motorSpeed);
    	leftSpeed=motorSpeed;
    }
    public void backwardLeft(){
    	frontLeft.set(-motorSpeed);
    	rearLeft.set(-motorSpeed);
    	leftSpeed = -motorSpeed;
    }
    public void forwardRight(){
    	frontRight.set(motorSpeed);
    	rearRight.set(motorSpeed);
    	rightSpeed=motorSpeed;
    }
    public void backwardRight(){
    	frontRight.set(-motorSpeed);
    	rearRight.set(-motorSpeed);
    	rightSpeed=-motorSpeed;
    }
    public void stop(){
    	frontRight.stopMotor();
    	frontLeft.stopMotor();
    	rearRight.stopMotor();
    	rearLeft.stopMotor();
    	rightSpeed = 0;
    	leftSpeed = 0;
    }
}

