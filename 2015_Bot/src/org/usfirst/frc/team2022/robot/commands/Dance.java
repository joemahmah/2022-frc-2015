package org.usfirst.frc2022.commands;

/**
 
 * @author The Fab Four
 *
 */
public class DanceCommand extends CommandBase{
	public boolean GetStartValue(){
		return (getRawButton(START_BUTTON));
	}
	while(GetStartValue()==True){
		long System.currentTimeMillis();
		long startTime = System.currentTimeMillis();
	/**going forward for 4 seconds)
	 * 
	 */

		while(System.currentTimeMillis()< startTime + 4000){
			Robot.tankSubsystem.forwardAll(1);
			}
		
		
		/**spinning for 4 seconds
		 * 
		 */
		Robot.tankSubsystem.stop(0);
		while(startTime + 4000<System.currentTimeMillis() && System.currentTimeMillis()< startTime + 8000){
			Robot.tankSubsystem.forwardAllRight(1);
			Robot.tankSubsystem.forwardAllLeft(-1);
			
			
		}
		
		
		/**shimmying forward
		 * 
		 */
		Robot.tankSubsystem.stop(0);
	}	while(startTime + 8000<System.currentTimeMillis() && System.currentTimeMillis()<startTime + 8500)
			Robot.tankSubsystem.forwardAllRight(1);
}
		Robot.tankSubsystem.stop(0);
		while(startTime + 8500<System.currentTimeMillis() && System.currentTimeMillis()<startTime + 9000)
			Robot.tankSubsystem.forwardAllLeft(1);
}
		Robot.tankSubsystem.stop(0);
		while(startTime + 9000<System.currentTimeMillis() && System.currentTimeMillis()<startTime + 9500)
			Robot.tankSubsystem.forwardAllRight(1);
}
		Robot.tankSubsystem.stop(0);
		while(startTime + 9500<System.currentTimeMillis() && System.currentTimeMillis()<startTime + 10000)
			Robot.tankSubsystem.forwardAllLeft(1);
}
		

/**shimmying backwards
 * 
 */

		Robot.tankSubsystem.stop(0);
		
		}	while(startTime + 10000<System.currentTimeMillis() && System.currentTimeMillis()<startTime + 10500)
				Robot.tankSubsystem.forwardAllRight(-1);
	}
			Robot.tankSubsystem.stop(0);
			while(startTime + 10500<System.currentTimeMillis() && System.currentTimeMillis()<startTime + 11000)
				Robot.tankSubsystem.forwardAllLeft(-1);
	}
			Robot.tankSubsystem.stop(0);
			while(startTime + 11000<System.currentTimeMillis() && System.currentTimeMillis()<startTime +11500)
				Robot.tankSubsystem.forwardAllRight(-1);
	}
			Robot.tankSubsystem.stop(0);
			while(startTime + 11500<System.currentTimeMillis() && System.currentTimeMillis()<startTime + 12000)
				Robot.tankSubsystem.forwardAllLeft(-1);
	}
			Robot.tankSubsystem.stop(0);
		
		/**spinning clockwise
		 * 
		 */
	
			Robot.tankSubsystem.stop(0);
			while(startTime + 12000<System.currentTimeMillis() && System.currentTimeMillis() < startTime + 16000){
				Robot.tankSubsystem.forwardAllRight(-1);
				Robot.tankSubsystem.forwardAllLeft(1);
				
				
			}
	/**everybody dance now
	 * forklift raise the roof
	 */

	}