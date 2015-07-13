package org.usfirst.frc.team2022.robot.commands.autonomous;

import org.usfirst.frc.team2022.robot.Robot;
import org.usfirst.frc.team2022.robot.commands.IntakeAutonomousCommand;
import org.usfirst.frc.team2022.robot.commands.MoveArmCommand;
import org.usfirst.frc.team2022.robot.commands.MoveAutonomousCommand;
import org.usfirst.frc.team2022.robot.commands.TankDriveCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous extends CommandGroup{

	public Autonomous(){
		
		addParallel(new MoveArmCommand("All Down"));
		addSequential(new MoveAutonomousCommand(1000, "Straight"));
		
		addSequential(new IntakeAutonomousCommand("In"));
		addSequential(new MoveArmCommand("Up"));
		addParallel(new IntakeAutonomousCommand("Out"));
		addSequential(new MoveAutonomousCommand(1000, "Straight"));
		
		addParallel(new IntakeAutonomousCommand("In"));
		addSequential(new MoveArmCommand("All Down"));
		addSequential(new MoveArmCommand("Up"));
		addParallel(new IntakeAutonomousCommand("Out"));
		addSequential(new MoveAutonomousCommand(1000, "Straight"));
		
		addParallel(new IntakeAutonomousCommand("In"));
		addSequential(new MoveArmCommand("All Down"));
		addSequential(new MoveAutonomousCommand(500, "Right"));
		
		addSequential(new MoveAutonomousCommand(750, "Straight"));
		addParallel(new IntakeAutonomousCommand("Out"));
		addSequential(new MoveAutonomousCommand(1000, "Back"));
	}

}
