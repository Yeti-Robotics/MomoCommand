/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotTemplate;
import edu.wpi.first.wpilibj.templates.commands.CheckCompressorCommand;

/**
 *
 * @author acampbell
 */
public class PneumaticsSubsystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Relay compressorRelay;
    DoubleSolenoid climber;
    DoubleSolenoid magazine;
    DigitalInput compressor;
    
    public PneumaticsSubsystem() {
        compressorRelay = new Relay(1);
        climber = new DoubleSolenoid(3, 4);
        magazine = new DoubleSolenoid(1, 2);
//        compressorRelay.set(Relay.Value.kOff);
        compressor = new DigitalInput(1);
        if (compressor.get()) {
            compressorRelay.set(Relay.Value.kOff);
        } else {
            compressorRelay.set(Relay.Value.kForward);
        }
    }

    public void initDefaultCommand() {
        setDefaultCommand(new CheckCompressorCommand());
    }
    
    public boolean shouldCompressorBeOn() {
        return compressor.get();
    }
    
    public void compressorOn() {
        compressorRelay.set(Relay.Value.kForward);
    }
    
    public void compressorOff() {
        compressorRelay.set(Relay.Value.kOff);
    }
    
    public void climberForward() {
        climber.set(DoubleSolenoid.Value.kForward);
    }
    
    public void climberReverse() {
        climber.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void magazineForward() {
        magazine.set(DoubleSolenoid.Value.kForward);
    }
    
    public void magazineReverse() {
        magazine.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void log() {
        SmartDashboard.putBoolean("Pressure Switch", compressor.get());
    }
}
