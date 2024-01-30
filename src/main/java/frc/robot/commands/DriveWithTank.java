package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.TankDrive;
// import frc.robot.subsystems.FlyWheel;
import frc.robot.subsystems.TankDrive;
import frc.robot.subsystems.MecanumSystem;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DigitalInput;

import edu.wpi.first.wpilibj.Timer;

import javax.lang.model.util.ElementFilter;
import javax.lang.model.util.ElementScanner14;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

public class DriveWithTank extends Command {
  //!!IMPORTANT!! Before using, make sure that the TankDrive subsystem has proper configuration. Limit switches will only work on the vacum bot. 
  //initializes a lot of important objects and variables
  private final TankDrive m_tank;
  private final MecanumSystem m_mecanum;
  private double left,right,pivot,leftx,vert,horiz;
  private boolean inContact, FrontLeftContact, BackLeftContact, FrontRightContact, BackRightContact, a, b, y;
  
  private double armsp = 0;
  private int driveTrue;
  public double speed = 0.1;
  public Timer time;
  //private DigitalInput frontLeft, frontRight, backLeft, backRight;
  private XboxController xboxtonk;

  public DriveWithTank(TankDrive tankSystem, XboxController xbox,MecanumSystem mecanum){
    //essential: maps initialized objects with what already exists. 
    m_tank = tankSystem;
    xboxtonk = xbox;
    m_mecanum = mecanum;
    time = new Timer();
    addRequirements(m_mecanum);
    addRequirements(m_tank);
    inContact = true;
    FrontLeftContact = true;
    FrontRightContact = true;
    BackLeftContact = true;
    BackRightContact = true;

    //frontLeft = new DigitalInput(0);
    time.reset();
    time.start();
    driveTrue = 0;
    
  }

  @Override
  public void execute() {
    //sets variables to the xbox joysticks. 
    left = xboxtonk.getLeftY();
    right = xboxtonk.getRightY();
    leftx = xboxtonk.getLeftX();
    pivot = -xboxtonk.getRightX();
    horiz = -xboxtonk.getLeftX();
    vert = xboxtonk.getLeftY();

    //if the xbox buttons are pressed, then it will change the drive "mode"
    if (xboxtonk.getYButton()){
      //driveTrue = 2;
    }
    if (xboxtonk.getBButton()){
      //driveTrue = 0;

    }
    if (xboxtonk.getAButton()){
      //driveTrue = 1;
    }
    if (xboxtonk.getXButton()){
      //driveTrue = 2;
    }
    //while driveTrue is 0, then it will be standard drive. 
    if (driveTrue==0){
      //changes speed depending on xbox button. 
      if (xboxtonk.getRightBumper()){
        speed = 0.2;
      }
      else if (xboxtonk.getLeftBumper()){
        speed = 0.5;
      }

      //CODE SNIPPET THAT IS COMMENTED ONLY WORKS ON HOOKBOT. 
      
      // if (xboxtonk.getPOV() == 0){
      //   armsp = 0.3;
      // }
      // else if (xboxtonk.getPOV() == 180){
      //   armsp = -0.3;
      // }
      // else {
      //   armsp = 0;
      // }
      // if (xboxtonk.getPOV()==90){
      //   m_tank.moveTo(20);
      // }
      // else if (xboxtonk.getPOV()==270){
      //   m_tank.moveTo(40);
      // }
      // else {

      //   m_tank.setSpeed(armsp);
      // }
      
      //SmartDashboard.putNumber("Encoder: ", m_tank.getArmPos());

      //if the xbox's triggeraxis is less than 0.2, then it will make the tank drive at the speed. 
      if (xboxtonk.getRightTriggerAxis() < 0.2){

      
        m_tank.drive(speed*left, speed*right);
      }
      //code snippit only for gerald. 
      
      // SmartDashboard.putBoolean("FR: ",!m_tank.frontRightSwitch());
      // SmartDashboard.putBoolean("FL: ",!m_tank.frontLeftSwitch());
      // SmartDashboard.putBoolean("BR: ",!m_tank.backRightSwitch());
      // SmartDashboard.putBoolean("BL: ",!m_tank.backLeftSwitch());

      //code snippet only for mecanum based drivetrains. 
      // m_mecanum.moveFL(speed*(pivot+vert+horiz));
      // m_mecanum.moveBL(speed*(pivot+vert-horiz));
      // m_mecanum.moveFR(speed*(-pivot+vert-horiz));
      // m_mecanum.moveBR(speed*(-pivot+vert+horiz));

    
      
    }
    else if (driveTrue == 1)
    {
      //ALL COMMENTED OUT!!!!! ONLY WORKS FOR GERALD, IS VACCUM drive.
      
      //System.out.println(m_tank.frontLeftSwitch());


        //if the limit switch is hit, then it will begin the turning process. 
      
        // if (!m_tank.frontRightSwitch()){
        //   time.reset();
        //   time.start();
        //   FrontRightContact = false;
        // } 
        // else if (!m_tank.frontLeftSwitch()){
        //   time.reset();
        //   time.start();
        //   FrontLeftContact = false;
        // }
        // else if (!m_tank.backLeftSwitch()){
        //   time.reset();
        //   time.start();
        //   BackLeftContact = false;
        // }
        // else if (!m_tank.backRightSwitch()){
        //   time.reset();
        //   time.start();
        //   BackRightContact = false;
        // }
        



      //essentially, this is the turning process. this is time based turning. 
      
      //   if (FrontRightContact == false){
      //     if (time.get()<2){
      //       m_tank.drive(0.1,0.1);
      //     }
      //     else if (time.get()<4.3){
      //         m_tank.drive(0.1,-0.1);
      //     }
      //     else if (time.get()>4.3){
      //       time.reset();
      //       FrontRightContact = true;
      //     }
      //   }
      //   else if (FrontLeftContact == false){
      //     if (time.get()<2){
      //     m_tank.drive(0.1,0.1);
      //     }
      //     else if (time.get()<4.3){
      //       m_tank.drive(0.1,-0.1);
      //     }
      //     else if (time.get()>4.3){
      //     time.reset();
      //     FrontLeftContact = true;
      //     }
      //   }
      //   else if (BackRightContact == false){
      //     if (time.get()<2){
      //     m_tank.drive(0.1,0.1);
      //     }
      //     else if (time.get()<4.3){
      //       m_tank.drive(-0.1,0.1);
      //     }
      //     else if (time.get()>4.3){
      //     time.reset();
      //     BackRightContact = true;
      //     }
      //   }
      //   else if (BackLeftContact == false){
      //     if (time.get()<2){
      //     m_tank.drive(0.1,0.1);
      //     }
      //     else if (time.get()<4.2){
      //       m_tank.drive(-0.1,0.1);
      //     }
      //     else if (time.get()>4.2){
      //     time.reset();
      //     BackLeftContact = true;
      //     }
      //   }
      //   else {
      //     m_tank.drive(-0.1,-0.1);
      //     //m_tank.drive(0,0);
      //   }
      // }
      //else if (driveTrue == 2){
        //does nothing because this exception is handled by the limelight command. 
        

      }
      
        



    }

    //commented code snippit, this is the VERY BASE train. 
  
    // time.start();
    // m_tank.drive(-0.2,-0.2);
    // if (time.get() >= 1 && time.get() < 2){
    //   m_tank.drive(-0.2,0.2);
    // }
    // if (time.get() >= 2){
    //   m_tank.drive(0,0);
        

    

  @Override
  public void end(boolean interrupted) {
    m_tank.drive(0,0);
  }
}
