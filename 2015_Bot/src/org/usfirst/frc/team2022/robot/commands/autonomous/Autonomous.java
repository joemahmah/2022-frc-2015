package org.usfirst.frc.team2022.robot.commands.autonomous;

import org.usfirst.frc.team2022.robot.commands.MoveForward;
import org.usfirst.frc.team2022.robot.commands.TankDriveCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous extends CommandGroup{

	public Autonomous(){
		
		addSequential(new MoveForward());
		
		
	}

}
