
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.RobotTemplate;
import edu.wpi.first.wpilibj.templates.commands.AccelerateCommand;

/**
 *
 * @author Matthew
 */
public class AcceleratorSubsystem extends Subsystem
  {

    Jaguar jaguar1;
    Jaguar jaguar2;

    public void initDefaultCommand()
      {
        setDefaultCommand(new AccelerateCommand());
        jaguar1 = new Jaguar(RobotMap.BACKJAGUAR_PORT);
        jaguar2 = new Jaguar(RobotMap.FRONTJAGUAR_PORT);
      }

    public void spinBoth(double speed)
      {
        jaguar1.set(speed * 0.75d);
        jaguar2.set(speed);
      }
    
    public void spinBack(double speed)
      {
        jaguar1.set(speed);
      }
    
    public void spinFront(double speed)
      {
        jaguar2.set(speed);
      }
  }
