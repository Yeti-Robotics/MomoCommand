/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Matthew
 */
public class TestCommandGroup extends CommandGroup
  {
    
    public TestCommandGroup()
      {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
        //Pick Up Can
        addSequential(new MagazineReverseCommand());
        //drive under tote
        addSequential(new UniversalDriveCommand(0.5, 0.5, 1));
        //pick up tote
        addSequential(new FrontAccceleratorTimeCommand(0.3, 1));
        //drive to next set
        addParallel(new MagazineForwardCommand());
        addSequential(new UniversalDriveCommand(1, 1, 2));

        //pick up can
        addSequential(new MagazineReverseCommand());
        //drive to tote
        addSequential(new UniversalDriveCommand(0.5, 0.5, 1));
        //put tote on tote
        addSequential(new FrontAccceleratorTimeCommand(-0.3, 1));
        //pick up
        addSequential(new FrontAccceleratorTimeCommand(0.3, 1));
        //drive to next set
        addParallel(new MagazineForwardCommand());
        addSequential(new UniversalDriveCommand(1, 1, 2));

        //pick up can
        addSequential(new MagazineReverseCommand());
        //drive to tote
        addSequential(new UniversalDriveCommand(0.5, 0.5, 1));
        //put tote on tote
        addSequential(new FrontAccceleratorTimeCommand(-0.3, 1));
        //pick up
        addSequential(new FrontAccceleratorTimeCommand(0.3, 1));

        //turn right
        addSequential(new UniversalDriveCommand(1, -1, 0.5));
        //drive straight
        addSequential(new UniversalDriveCommand(1, 1, 2));
        //put down totes
        addSequential(new FrontAccceleratorTimeCommand(-0.3, 1));
        //drive back
        addSequential(new UniversalDriveCommand(0.5, 0.5, 0.5));
      }
  }
