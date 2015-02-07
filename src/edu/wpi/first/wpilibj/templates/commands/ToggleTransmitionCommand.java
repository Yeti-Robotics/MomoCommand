/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.templates.RobotTemplate;

/**
 *
 * @author Matthew
 */
public class ToggleTransmitionCommand extends Command
  {
    
    public ToggleTransmitionCommand()
      {
          requires(RobotTemplate.drive);
      }

    // Called just before this Command runs the first time
    protected void initialize()
      {
      }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
      {
        if (RobotTemplate.drive.getShift() == DoubleSolenoid.Value.kForward) {
            RobotTemplate.drive.shiftDown();
        } else if (RobotTemplate.drive.getShift() == DoubleSolenoid.Value.kReverse){
            RobotTemplate.drive.shiftUp();
        } else {
            RobotTemplate.drive.shiftUp();
        }
          System.out.println(RobotTemplate.drive.getShift());
      }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
      {
        return true;
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
