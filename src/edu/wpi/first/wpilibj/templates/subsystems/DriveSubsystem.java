/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.UserDriveCommand;

/**
 *
 * @author acampbell
 */
public class DriveSubsystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    RobotDrive drive;
    DoubleSolenoid shifter;

    public DriveSubsystem() {
        drive = new RobotDrive(1, 2, 3, 4);
        shifter = new DoubleSolenoid(7, 8);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new UserDriveCommand());
    }
    
    public void drive(double leftSpeed, double rightSpeed) {
        drive.tankDrive(leftSpeed, rightSpeed);
    }
    
    public void shiftUp() {
        shifter.set(DoubleSolenoid.Value.kForward);
    }
    
    public void shiftDown() {
        shifter.set(DoubleSolenoid.Value.kReverse);
    }
    
    public DoubleSolenoid.Value getShift() {
        return shifter.get();
    }
}
