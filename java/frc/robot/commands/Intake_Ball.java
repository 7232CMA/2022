// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import subsystems.Intake;

public class Intake_Ball extends CommandBase {
  /** Creates a new Intake_Ball. */
  double m_speed;
  public Intake_Ball( double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    //addRequirements(Robot.robotContainer.m_intake);
    m_speed = speed;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.robotContainer.m_intake.intakeBall(m_speed);
  }
  
  public void executeStop() {
    Robot.robotContainer.m_intake.intakeBall(0);
  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
