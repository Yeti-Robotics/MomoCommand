
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.AccelerateCommand;

/**
 *
 * @author Matthew
 */
public class AcceleratorSubsystem extends Subsystem
  {

    Jaguar initialSpeed;
    Jaguar finalSpeed;

    public void initDefaultCommand()
      {
        setDefaultCommand(new AccelerateCommand());
        initialSpeed = new Jaguar(RobotMap.INITIALSPEED_PORT);
        finalSpeed = new Jaguar(RobotMap.FINALSPEED_PORT);
      }

    public void spin(double speed)
      {
        initialSpeed.set(speed * (3/4));
        finalSpeed.set(speed);
      }
  }
