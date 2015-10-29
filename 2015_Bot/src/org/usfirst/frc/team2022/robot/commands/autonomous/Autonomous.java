//package org.usfirst.frc.team2022.robot.commands.autonomous;
//
//import org.usfirst.frc.team2022.robot.Robot;
//import org.usfirst.frc.team2022.robot.commands.TankDriveCommand;
//
//import edu.wpi.first.wpilibj.command.CommandGroup;
//
//public class Autonomous extends CommandGroup{
//
//	public Autonomous(){
//		
//		//Move forward while picking up first tote
//		addSequential(new MoveArmCommand("All Down"));
//		addParallel(new MoveAutonomousCommand(30, "Forward"));
//		addSequential(new IntakeAutonomousCommand("In"));
//		addSequential(new MoveArmCommand("Up"));
//		
//		//Move forward while pushing bin
//		addParallel(new IntakeAutonomousCommand("Out"));
//		addSequential(new MoveAutonomousCommand(54, "Forward"));
//		
//		//Move forward while taking in second tote
//		addParallel(new MoveAutonomousCommand(27, "Forward"));
//		addSequential(new IntakeAutonomousCommand("In"));
//		
//		//bring down arm and pick up tote
//		addSequential(new MoveArmCommand("All Down"));
//		addSequential(new MoveArmCommand("Up"));
//		
//		//Move forward while pushing bin
//		addParallel(new IntakeAutonomousCommand("Out"));
//		addSequential(new MoveAutonomousCommand(54, "Forward"));
//		
//		//MoveForward while taking in third tote
//		addSequential(new MoveArmCommand("All Down"));
//		addParallel(new IntakeAutonomousCommand("In"));
//		addSequential(new MoveAutonomousCommand(27, "Foward"));
//		
//		//Turn right and move Forward
//		addSequential(new MoveAutonomousCommand(1000, "Right"));
//		addSequential(new MoveAutonomousCommand(100, "Forward"));
//
//		//Move back and eject totes
//		addParallel(new IntakeAutonomousCommand("Out"));
//		addSequential(new MoveAutonomousCommand(30, "Back"));
//	}
//
//}
