// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
//import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.DriveArcade;


public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  //Define Global Vars
  public final PWMVictorSPX leftFrontSpark;
  public final PWMVictorSPX leftBackSpark;
  public final PWMVictorSPX rightFrontSpark;
  public final PWMVictorSPX rightBackSpark;

  private final MotorControllerGroup leftDrive;
  private final MotorControllerGroup rightDrive;

  public final DifferentialDrive differentialDrive;  
  
  
  /**Constructor */
  public Drivetrain() {
    leftFrontSpark = new PWMVictorSPX(Constants.DRIVETRAIN_LEFT_FRONT_SPARK);
    leftFrontSpark.setInverted(true);
    leftBackSpark = new PWMVictorSPX(Constants.DRIVETRAIN_LEFT_BACK_SPARK);
    leftBackSpark.setInverted(true);
    rightFrontSpark = new PWMVictorSPX(Constants.DRIVETRAIN_RIGHT_FRONT_SPARK);
    rightFrontSpark.setInverted(true);
    rightBackSpark = new PWMVictorSPX(Constants.DRIVETRAIN_RIGHT_BACK_SPARK);
    rightBackSpark.setInverted(true);

    leftDrive = new MotorControllerGroup(leftFrontSpark, leftBackSpark);
    rightDrive = new MotorControllerGroup(rightFrontSpark, rightBackSpark);

    differentialDrive = new DifferentialDrive(leftDrive, rightDrive);
    differentialDrive.setSafetyEnabled(true);
    differentialDrive.setExpiration(0.1);
    differentialDrive.setMaxOutput(1.0);
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void initDefaultCommand() {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveArcade());
}

  public void tankDrive(double leftSpeed, double rightSpeed, boolean b) {
    //setDefaultCommand(new DriveArcade());
    differentialDrive.tankDrive(leftSpeed, rightSpeed, true);
  }




}
