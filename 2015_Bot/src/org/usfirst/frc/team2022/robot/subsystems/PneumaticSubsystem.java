package org.usfirst.frc.team2022.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 *
 * @author Michael Dow
 * @author Ben Maher
 * @author Sean Ngo
 *
 */

public class PneumaticSubsystem extends Subsystem {

	private Compressor compressor;
	private DoubleSolenoid valve;

	public PneumaticSubsystem(int pressureSwitchChannel, int valveChannel1,
			int valveChannel2) {
		compressor = new Compressor(pressureSwitchChannel);
		valve = new DoubleSolenoid(valveChannel1, valveChannel2);
	}

	protected void initDefaultCommand() {}

	public void start() {
		compressor.start();
	}

	public void stop() {
		compressor.stop();
	}
	
	public void openValve() {
		valve.set(DoubleSolenoid.Value.kForward);
	}

	public void closeValve() {
		valve.set(DoubleSolenoid.Value.kReverse);
	}

	public void disableValvesOperation() {
		valve.set(DoubleSolenoid.Value.kOff);
	}
	public boolean isValveOpen(){
		return valve.get() == DoubleSolenoid.Value.kForward;
	}
}
