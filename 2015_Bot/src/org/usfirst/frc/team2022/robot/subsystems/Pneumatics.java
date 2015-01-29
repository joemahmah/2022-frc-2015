package org.usfirst.frc.team2022.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
*
*@author Michael Dow
*@author Ben Maher
*@author Sean Ngo
*
*/



public class Pneumatics extends Subsystem{

	private Compressor compressor;
	private DoubleSolenoid valve;
	
	
	public Pneumatics(int pressureSwitchChannel, int valveChannel1, int valveChannel2){
		compressor = new Compressor(pressureSwitchChannel);
		valve = new DoubleSolenoid(valveChannel1, valveChannel2);
		
	}
	
	protected void initDefaultCommand() {
        
    }
	
	public void start(){
        compressor.start();
    }
    
    public void stop(){
        compressor.stop();
    }
    
    public void valveOpen(){
        valve.set(DoubleSolenoid.Value.kForward);
    }
    
    public void valveClose(){
        valve.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void disableValvesOperation(){
        valve.set(DoubleSolenoid.Value.kOff);
    }
	
}
