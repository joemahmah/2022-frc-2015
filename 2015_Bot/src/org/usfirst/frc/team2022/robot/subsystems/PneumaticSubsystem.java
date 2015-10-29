package org.usfirst.frc.team2022.robot.subsystems;

import org.usfirst.frc.team2022.robot.RobotMain;
import org.usfirst.frc.team2022.robot.commands.CompressorCommand;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;

/**
 *
 * @author Michael Dow
 * @author Ben Maher
 *
 */

public class PneumaticSubsystem extends Subsystem {

	private Compressor compressor;
	private DoubleSolenoid shifterSolenoid;
	private DoubleSolenoid clawSolenoid;
	private long lastShifterChangeTime;
	private long lastClawChangeTime;
	
	private boolean shifterForward;
	private boolean clawForward;

	public PneumaticSubsystem(int pressureSwitchChannel, int shifterChannel1, int shifterChannel2,
			int clawChannel1, int clawChannel2){
		compressor = new Compressor(pressureSwitchChannel);
		shifterSolenoid = new DoubleSolenoid(pressureSwitchChannel,shifterChannel1, shifterChannel2);
		clawSolenoid = new DoubleSolenoid(pressureSwitchChannel,clawChannel1, clawChannel2);
		
		compressor.start();
		shifterSolenoid.set(DoubleSolenoid.Value.kOff);
		clawSolenoid.set(DoubleSolenoid.Value.kOff);
		
		lastClawChangeTime = System.currentTimeMillis();
		lastShifterChangeTime = System.currentTimeMillis();
		
		shifterForward = false;
		clawForward = false;
	}

	protected void initDefaultCommand() {
		setDefaultCommand(new CompressorCommand());
	}

	public void start() {
		compressor.start();
	}

	public void stop() {
		compressor.stop();
	}
	
	public void toggleShifterState(){
		if(System.currentTimeMillis() > lastShifterChangeTime + 250){
			lastShifterChangeTime = System.currentTimeMillis();
			shifterForward = !shifterForward;
			
			if(shifterForward){
				shifterSolenoid.set(DoubleSolenoid.Value.kForward);
			} else{
				shifterSolenoid.set(DoubleSolenoid.Value.kReverse);
			}
		}
	}
	
	public void toggleClawState(){
		if(System.currentTimeMillis() > lastClawChangeTime + 250){
			lastClawChangeTime = System.currentTimeMillis();
			clawForward = !clawForward;
			
			if(clawForward){
				clawSolenoid.set(DoubleSolenoid.Value.kForward);
			} else{
				clawSolenoid.set(DoubleSolenoid.Value.kReverse);
			}
		}
	}
	
	public void openShifterValve() {
		shifterSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void closeShifterValve() {
		shifterSolenoid.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void openClawValve() {
		clawSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void closeClawValve() {
		clawSolenoid.set(DoubleSolenoid.Value.kReverse);
	}
}
