package org.usfirst.frc.team2022.robot.commands;

import org.usfirst.frc.team2022.robot.subsystems.Collector;
import org.usfirst.frc.team2022.robot.subsystems.Pivot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Spit the ball out into the low goal assuming that the robot is in front of it.
 */
public class LowGoal extends CommandGroup {
    public  LowGoal() {
    	addSequential(new SetPivotSetpoint(Pivot.LOW_GOAL));
    	addSequential(new SetCollectionSpeed(Collector.REVERSE));
    	addSequential(new ExtendShooter());
    }
}
