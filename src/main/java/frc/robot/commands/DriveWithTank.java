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
  public double speed = 0.25;
  public double sideSpeed = 0.25;
  public double strafeSpeed = 0.5;
  Timer lightTimer = new Timer();
  Timer ampTimer = new Timer();
  Timer trapTimer = new Timer();
  //private DigitalInput frontLeft, frontRight, backLeft, backRight;
  private XboxController xboxtonk;

  public DriveWithTank(XboxController xbox,MecanumSystem mecanum){
    //essential: maps initialized objects with what already exists. 
    xboxtonk = xbox;
    m_mecanum = mecanum;
    lightTimer.reset();
    ampTimer.reset();
    ampTimer.start();
    trapTimer.reset();
    trapTimer.start();
    m_mecanum.teleopConfigs();
    addRequirements(m_mecanum);
    
  }

  @Override
  public void initialize() {
    m_mecanum.teleopConfigs();

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
    // if (xboxtonk.getAButton()){
    //   m_mecanum.moveActuator(-1);
    // }else if (xboxtonk.getXButton()){
    //   m_mecanum.moveActuator(1);
    // }
    // else {
    //   m_mecanum.moveActuator(0);
    // }

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
      SmartDashboard.putNumber("Velocity: ",m_mecanum.asBL);
      if (xboxtonk.getLeftBumper()){
        speed = 0.9;
        sideSpeed = 0.9;
        strafeSpeed = 0.9;
      }else {
        speed = 0.25;
        sideSpeed = 0.6;
        strafeSpeed = 0.5;
      }
      // if (js.getTrigger()){
      //   speed = 0.1;
      // }
      // else
      // {
      //   speed = 0.3;
      // }
      //code snippet only for mecanum based drivetrains. 
      
      // SmartDashboard.putNumber("Speed",speed);
      // SmartDashboard.putNumber("pivot",pivot);
      // SmartDashboard.putNumber("Vert: ",vert);
      // SmartDashboard.putNumber("Horiz",horiz);
      if (xboxtonk.getPOV() == 90){
        if (trapTimer.get() < 0.1){
          m_mecanum.zeromotors();
        }
        else if (trapTimer.get()  < 4 && trapTimer.get() > 0.1){
          // m_mecanum.moveBL(0.1);
          // m_mecanum.moveBR(0.1);
          // m_mecanum.moveFL(0.1);
          // m_mecanum.moveFR(0.1);
          
          m_mecanum.moveAllFourTo(-0.21,-0.21,-0.21,-0.21);
        }
        // else  if (trapTimer.get() > 4 && trapTimer.get() < 5){
        //   m_mecanum.moveAllFourToTURNS(-.2,.2,.2,-.2);
        // }
        else {
            m_mecanum.moveBL(0);
            m_mecanum.moveBR(0);
            m_mecanum.moveFL(0);
            m_mecanum.moveFR(0);
        }
      }
      // else {
        
      // }

      else if (xboxtonk.getXButton()){
        //m_mecanum.percentSpeeds();
        //m_mecanum.changeColor(0.57);


        //TODO: put amp code here;
        if (ampTimer.get() < 0.1){
          m_mecanum.zeromotors();
        }
        else if (ampTimer.get() < 2 && ampTimer.get() > 0.1){
            m_mecanum.moveAllFourTo(-.1,-.1,-.1,-.1);
        }
        else if (ampTimer.get() > 2 && ampTimer.get() < 2.5){
          //continue;
          m_mecanum.moveBL(0);
          m_mecanum.moveBR(0);
          m_mecanum.moveFL(0);
          m_mecanum.moveFR(0);
        }
        else if (ampTimer.get() > 2.5 && ampTimer.get() < 4){
          m_mecanum.moveFL(-0.1);
          m_mecanum.moveFR(-0.1);
          m_mecanum.moveBL(-0.1);
          m_mecanum.moveBR(-0.1);
        }
        else {
          
          m_mecanum.moveBL(0);
          m_mecanum.moveBR(0);
          m_mecanum.moveFL(0);
          m_mecanum.moveFR(0);
        }


        //move backwards X inches (time based)
        //movem 

        m_mecanum.printpositions();
      }
      else {
        
        ampTimer.reset();
        ampTimer.start();
        
      trapTimer.reset();
        trapTimer.start();



      m_mecanum.moveBL(speed*(vert)-strafeSpeed*(horiz)+sideSpeed*pivot);
      m_mecanum.moveFR(speed*(vert)-strafeSpeed*(horiz)-sideSpeed*pivot);
      m_mecanum.moveBR(speed*(vert)+strafeSpeed*(horiz)-sideSpeed*pivot);
      m_mecanum.moveFL(speed*(vert)+strafeSpeed*(horiz)+sideSpeed*pivot);
        // m_mecanum.moveFL(speed*horiz);
        // m_mecanum.moveBL(-speed*horiz);
        // m_mecanum.moveFR(-speed*horiz);
        // m_mecanum.moveBR(speed*horiz);
        

        //m_mecanum.resetticks();
      }
      // if (xboxtonk.getBButton()){
      //   m_mecanum.changeColor(-.99);
      // }
      if (xboxtonk.getPOV() == 90){
        m_mecanum.changeColor(-.97);
        m_mecanum.zeromotors();
      }
      // else if (xboxtonk.getPOV() == 180){
      //   m_mecanum.changeColor(-.95);
      // }
      // m_mecanum.moveFL(1);
    
      
  }
    

  @Override
  public void end(boolean interrupted) {
    m_mecanum.moveFL(0);
    m_mecanum.moveFR(0);
    m_mecanum.moveBL(0);
    m_mecanum.moveBR(0);  
  }
}
