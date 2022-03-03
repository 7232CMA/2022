// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;


public class AutonomousCommand extends CommandBase {
  //RobotContainer robotcontainer = new RobotContainer();
  double m_time;

  /** Creates a new AutonomousCommand. */
  public AutonomousCommand(double time) {
    m_time = time;
    
    
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.robotContainer.m_drivetrain.tankDrive(-.8, .8, true);
       
       
    //isFinished();
  }

  public void end(){
    Robot.robotContainer.m_drivetrain.tankDrive(0,0,true);
  }


  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
