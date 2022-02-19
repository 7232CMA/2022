package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

import frc.robot.Constants;
import frc.robot.Robot;


public class DriveArcade extends CommandBase {
    public DriveArcade(){
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(Robot.robotContainer.m_drivetrain);
    }

    // Called just before this Command runs the first time
    @Override
    public void initialize() {
    }

    @Override
    public void execute(){
        double driveLeft = Robot.robotContainer.driverController.getRawAxis(Constants.DRIVE_LEFT); //(check to see if needed to be inverted)
        double driveRight = Robot.robotContainer.driverController.getRawAxis(Constants.DRIVE_RIGHT);

        Robot.robotContainer.m_drivetrain.tankDrive(driveLeft, driveRight);
        

    }

    @Override
    public void end(boolean inturrupted){
        Robot.robotContainer.m_drivetrain.tankDrive(0,0);
    }

    @Override
    public boolean isFinished() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
