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
 * @author Matthew
 */
public class BackAccceleratorTimeCommand1 extends Command{
    
    double time;
    double speed;
    
    public BackAccceleratorTimeCommand1(double speed, double time)
      {
        this.time = time;
        this.speed = speed;
        requires(RobotTemplate.accelerator);
      }

    // Called just before this Command runs the first time
    protected void initialize()
      {
          setTimeout(time);
      }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
      {
          RobotTemplate.accelerator.spinBack(speed);
      }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
      {
        return isTimedOut();
      }

    // Called once after isFinished returns true
    protected void end()
      {
      }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
      {
      }
  }
