// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandScheduler;


/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {
  Command autonomousCommand;
  public static RobotContainer robotContainer;
  //Command autonamousCommand;
  SendableChooser<Command> chooser = new SendableChooser<>();
  //public static final String m_drivetrain = null;
  //private final PWMSparkMax m_leftDrive = new PWMSparkMax(0);
  //private final PWMSparkMax m_rightDrive = new PWMSparkMax(1);
  //private final DifferentialDrive m_robotDrive = new DifferentialDrive(DifferentialDrive, rightDrive);
  //private final Joystick m_stick = new Joystick(0);
  //private final Timer m_timer = new Timer();

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    //drivetrain = new Drivetrain();
    robotContainer = new RobotContainer();
    //driverController = new Joystick(Constants.DRIVER_CONTROLLER);
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    //m_rightDrive.setInverted(true);
    chooser.setDefaultOption("Autonomous Command", new AutonomousCommand(4));
    //RobotContainer rc = new RobotContainer();
  }

  /** This function is run once each time the robot enters autonomous mode. */
  @Override
  public void autonomousInit() {
    autonomousCommand = chooser.getSelected();
    robotContainer.m_drivetrain.tankDrive(-.8, .8);
    //m_timer.reset();
    //m_timer.start();
    if (autonomousCommand != null) ((Timer) autonomousCommand).start();
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    robotContainer.m_drivetrain.tankDrive(-.8, .8);
  }

  /** This function is called once each time the robot enters teleoperated mode. */
  @Override
  public void teleopInit() {
    if (autonomousCommand != null) autonomousCommand.cancel();
  }

  /** This function is called periodically during teleoperated mode. */
  @Override
  public void teleopPeriodic() {
    robotContainer.m_drivetrain.tankDrive(-robotContainer.driverController.getRawAxis(Constants.DRIVE_LEFT), robotContainer.driverController.getRawAxis(Constants.DRIVE_RIGHT));

  }

  /** This function is called once each time the robot enters test mode. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
