package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
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
  private final MecanumSystem m_mecanum;
  private Joystick js;
  private double left,right,pivot,leftx,vert,horiz;
  public double speed = 0.3;
  Timer lightTimer = new Timer();
  //private DigitalInput frontLeft, frontRight, backLeft, backRight;
  private XboxController xboxtonk;

  public DriveWithTank(XboxController xbox,MecanumSystem mecanum){
    //essential: maps initialized objects with what already exists. 
    xboxtonk = xbox;
    m_mecanum = mecanum;
    lightTimer.reset();
    
    addRequirements(m_mecanum);
    
  }

  @Override
  public void execute() {
    //m_mecanum.getTurnFL();
    //sets variables to the xbox joysticks. 
    // left = xboxtonk.getLeftY();
    // right = xboxtonk.getRightY();
    // leftx = xboxtonk.getLeftX();

    if (Math.abs(xboxtonk.getRightX()) > 0.1){
      pivot = -xboxtonk.getRightX();
    }
    else{
      pivot = 0;
    }
    if (Math.abs(xboxtonk.getLeftX()) > 0.1){
      horiz = -xboxtonk.getLeftX();
    }else {
      horiz = 0;
    }
    if (Math.abs(xboxtonk.getLeftY()) > 0.1)
    {
      
      m_mecanum.changeColor(0.57);
      vert = xboxtonk.getLeftY();

    }
    else 
    {
      vert = 0;
    }
    // vert = 0;
    // pivot = 0;
    // vert = js.getY();
    // horiz = -js.getX();
    // pivot = -js.getZ();
    // // pivot=0;
    // horiz=0;
    //if the xbox buttons are pressed, then it will change the drive "mode"
      // if (xboxtonk.getAButton()){
      //   m_mecanum.zeromotors();

      // }
      if (xboxtonk.getLeftBumper()){
        speed = 0.6;
      }else {
        speed = 0.3;
      }
      // if (js.getTrigger()){
      //   speed = 0.1;
      // }
      // else
      // {
      //   speed = 0.3;
      // }
      //code snippet only for mecanum based drivetrains. 
      
      m_mecanum.moveBL(speed*(pivot+vert-horiz));
      m_mecanum.moveFR(speed*(-pivot+vert-horiz));
      m_mecanum.moveBR(speed*(-pivot+vert+horiz));
      m_mecanum.moveFL(speed*(pivot+vert+horiz));
      SmartDashboard.putNumber("Speed",speed);
      SmartDashboard.putNumber("pivot",pivot);
      SmartDashboard.putNumber("Vert: ",vert);
      SmartDashboard.putNumber("Horiz",horiz);
      if (xboxtonk.getXButton()){
        m_mecanum.percentSpeeds();
        m_mecanum.changeColor(0.57);
      }
      else {
        m_mecanum.resetticks();
      }
      if (xboxtonk.getBButton()){
        m_mecanum.changeColor(-.99);
      }
      if (xboxtonk.getPOV() == 90){
        m_mecanum.changeColor(-.97);
      }
      else if (xboxtonk.getPOV() == 180){
        m_mecanum.changeColor(-.95);
      }
    
      
  }
    

  @Override
  public void end(boolean interrupted) {
    m_mecanum.moveFL(0);
    m_mecanum.moveFR(0);
    m_mecanum.moveBL(0);
    m_mecanum.moveBR(0);  
  }
}
