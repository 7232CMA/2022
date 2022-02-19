// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.*;



/** Add your docs here. */
public class RobotContainer {
    public Drivetrain m_drivetrain;
    public Joystick driverController;
    public RobotContainer() {
        configureButtonBindings();
        driverController = new Joystick(Constants.DRIVER_CONTROLLER);
        m_drivetrain = new Drivetrain();
        // Set default commands on subsystems
        //m_drivetrain = Robot.robotContainer.m_drivetrain;
       // m_drivetrain.setDefaultCommand(new DriveArcade());
    }

     /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }

  //public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    //return m_autoCommand;
  //}

  public Joystick getJoystickDrive(){
    return driverController;
  }





}
