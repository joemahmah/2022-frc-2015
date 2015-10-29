//package org.usfirst.frc.team2022.robot.commands.autonomous;
//
//import org.usfirst.frc.team2022.robot.RobotMain;
//import org.usfirst.frc.team2022.robot.subsystems.TankDriveSubsystem;
//
//import edu.wpi.first.wpilibj.command.Command;
//
//public class MoveAutonomousCommand extends Command{
//	
//	TankDriveSubsystem tankSubsystem;
//	public String direction;
//	public double distance;
//	
//	public MoveAutonomousCommand(double distance, String direction){
//		this.direction = direction;
//		this.distance = distance;
//		requires(RobotMain.tankSubsystem);
//		tankSubsystem = RobotMain.tankSubsystem;
//	}
//
//	@Override
//	protected void end() {
//		tankSubsystem.stop();
//	}
//
//	@Override
//	protected void execute() {
//		if(direction.equals("Forward")){
//			double speed = 1;
//			tankSubsystem.setLeftSpeed(speed);
//			tankSubsystem.setRightSpeed(speed);
//			
//		}else if(direction.equals("Right")){
//			double speed = .75;
//			long currentTime = System.currentTimeMillis();
//			long lastTime = currentTime + 1000;
//			while(System.currentTimeMillis() < lastTime){
//				tankSubsystem.setLeftSpeed(speed);
//				tankSubsystem.setRightSpeed(speed);
//			}
//			
//		}
//		else if(direction.equals("Back")){
//			double speed = -1;
//			tankSubsystem.setLeftSpeed(speed);
//			tankSubsystem.setRightSpeed(speed);
//		}
//		
//		
//		
//	}
//
//	@Override
//	protected void initialize() {
//		tankSubsystem.resetEncoder();
//	}
//
//	@Override
//	protected void interrupted() {
//		end();
//	}
//
//	@Override
//	protected boolean isFinished() {
//		if(direction.equals("Forward")){
//			return (tankSubsystem.getEncoderDistance() >= distance);
//		}else if(direction.equals("Back")){
//			return (tankSubsystem.getEncoderDistance() <= distance);
//		}else{
//			return true;
//		}
//		
//		
//	}
//
//}
