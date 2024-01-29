package frc.robot;

//Spark Imports

import edu.wpi.first.wpilibj.Ultrasonic;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.subsystems.*;
import frc.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import static frc.robot.Constants.ControllerConstants;
import static frc.robot.Constants.AimConstants;
import static frc.robot.Constants.ClimbConstants;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
//import frc.robot.subsystems.AccelerometerSystem;

public class RobotContainer {
  // create inputs
  public final XboxController xbox = new XboxController(0);
  //public final DeepSpace deepSpace = new DeepSpace();
  //public final XboxController xbox2 = new XboxController(1);
  //create subsytem
  public final Gyroscope m_gyroscope = new Gyroscope();
  public final TankDrive m_TankDrive = new TankDrive();
  public final PneumaticBoard m_pneumatic = new PneumaticBoard();
  public final LimeLightValues m_value = new LimeLightValues();
  private final MecanumSystem m_mecanum = new MecanumSystem();
  public final FlyWheel m_fly = new FlyWheel();
  public final DoubleArm m_arm = new DoubleArm();
  //create Commands
  //public final DeepSpaceCommand m_spaceCommand = new DeepSpaceCommand(xbox, deepSpace);
  public final GyroCommand m_gyroCommand = new GyroCommand(xbox, m_gyroscope);
  public final AutonomousCommand m_autonomous = new AutonomousCommand(m_TankDrive, xbox, m_value);
  public final DriveWithTank m_TankCommand = new DriveWithTank(m_TankDrive, xbox,m_mecanum);
  public final SolenoidCommand m_pneumaticControl = new SolenoidCommand(m_pneumatic,xbox);
  public final LimeLight m_limelight = new LimeLight(m_value,xbox, m_TankDrive);
 public final FlyCommand m_flycommand = new FlyCommand(xbox, m_fly);
  public final DoubleArmCommand m_armcommand = new DoubleArmCommand(xbox, m_arm);
  //Default Constructor
  public RobotContainer(){
    //deepSpace.setDefaultCommand(m_spaceCommand);
    //set default commands
    m_value.setDefaultCommand(m_limelight);
    m_mecanum.setDefaultCommand(m_TankCommand);
    m_pneumatic.setDefaultCommand(m_pneumaticControl);
    m_gyroscope.setDefaultCommand(m_gyroCommand);
    m_fly.setDefaultCommand(m_flycommand);
    m_arm.setDefaultCommand(m_armcommand);
    
}

private void configureButtonBindings(){ 
    
  // new JoystickButton(analogstuff, 1)
  // .toggleWhenPressed(m_pneumaticControl);
  
  // new JoystickButton(joystickone,5)
  // .whileHeld(m_autoBalance);

  //Left turns positive, right turns negative (only) 
} 
  public XboxController getXbox() {
    return xbox;
  }

  }

  
  

  



  
  