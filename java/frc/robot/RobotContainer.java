// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Joystick;
import subsystems.Intake;

import edu.wpi.first.wpilibj.buttons.Button;
//import edu.wpi.first.wpilibj2.command.Button;
//import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.AutonomousCommand;
import frc.robot.commands.Intake_Ball;





/** Add your docs here. */
public class RobotContainer {
    public Drivetrain m_drivetrain; //subsystem
    public Intake m_intake; //subsystem
    public Joystick driverController;

    public Intake_Ball intakeBall; //command


  public RobotContainer() {
    driverController = new Joystick(Constants.DRIVER_CONTROLLER);
    m_drivetrain = new Drivetrain(); //subsystem
    m_intake = new Intake(); //subsystem
    configureButtonBindings();
  }

     /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton intake = new JoystickButton(driverController, 1);
    intake.whileHeld(new Intake_Ball(.5));
    intake.whenReleased(new Intake_Ball(0));
  }



  public Joystick getJoystickDrive(){
    return driverController;
  }
}
