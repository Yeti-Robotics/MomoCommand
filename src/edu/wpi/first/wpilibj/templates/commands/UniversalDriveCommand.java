/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.templates.RobotTemplate;

/**
 *
 * @author acampbell
 */
public class UniversalDriveCommand extends Command {
    
    double leftValue;
    double rightValue;
    double time;
    
    public UniversalDriveCommand(double leftValue, double rightValue, double time) {
        this.leftValue = leftValue;
        this.rightValue = rightValue;
        this.time = time;
        requires(RobotTemplate.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        RobotTemplate.drive.drive(-leftValue, -rightValue);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
