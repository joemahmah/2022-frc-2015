//package org.usfirst.frc.team2022.robot.commands;
//
//import org.usfirst.frc.team2022.robot.RobotMain;
//
//import edu.wpi.first.wpilibj.command.Command;
//
//public class ClawCommand extends Command {
//
//	boolean isDone = false;
//
//	public ClawCommand() {
//		requires(Robot.clawSubsystem);
//	}
//
//	@Override
//	protected void initialize() {
//		isDone = false;
//	}
//
//	@Override
//	protected void execute() {
//		if (!RobotMain.oi.attack4.getTrigger())
//			return;
//		if (!RobotMain.clawSubsystem.isValveOpen()) {
//			RobotMain.clawSubsystem.openShifterValve();
//		} else {
//			RobotMain.clawSubsystem.closeShifterValve();
//		}
//	}
//
//	@Override
//	protected boolean isFinished() {
//		return isDone;
//	}
//
//	@Override
//	protected void end() {
//	}
//
//	@Override
//	protected void interrupted() {
//		end();
//	}
//}
