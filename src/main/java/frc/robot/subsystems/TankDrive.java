package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
//import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import static frc.robot.Constants.WheelConstants;
import frc.robot.Constants.ClimbConstants;
import javax.swing.text.LayeredHighlighter;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Encoder;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.WPILibVersion;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants.WheelConstants;
public class TankDrive extends SubsystemBase{

  public DifferentialDrive m_Drive;
  WPI_TalonSRX left1 = new WPI_TalonSRX(1);
  WPI_TalonSRX left2 = new WPI_TalonSRX(2);
  WPI_TalonSRX right1 = new WPI_TalonSRX(4);
  WPI_TalonSRX right2 = new WPI_TalonSRX(3);

  
  // WPI_TalonSRX left1 = new WPI_TalonSRX(4);
  // WPI_TalonSRX left2 = new WPI_TalonSRX(1);
  // WPI_TalonSRX right1 = new WPI_TalonSRX(2);
  // WPI_TalonSRX right2 = new WPI_TalonSRX(3);

  DigitalInput frontLeft = new DigitalInput(0);
  DigitalInput frontRight = new DigitalInput(1);
  DigitalInput backLeft = new DigitalInput(3);
  DigitalInput backRight = new DigitalInput(2);

  //CANSparkMax claw = new CANSparkMax(10,MotorType.kBrushless);
  SparkMaxPIDController pidcont;
  MotorControllerGroup leftmotors = new MotorControllerGroup(left1, left2);
  MotorControllerGroup rightmotors = new MotorControllerGroup(right1, right2);
  RelativeEncoder encoder;

    public TankDrive(){
      //leftmotors.setInverted(true);
      // claw.restoreFactoryDefaults();
      // encoder = claw.getEncoder();
      // pidcont = claw.getPIDController();
      // encoder.setPosition(0);
      // configurePID();
      // m_Drive = new DifferentialDrive(leftmotors, rightmotors);
      // m_Drive.setDeadband(0.01);
      // m_Drive.setSafetyEnabled(true);

    }
    private void configurePID(){
      // pidcont.setP(ClimbConstants.P);
      // pidcont.setI(ClimbConstants.I);
      // pidcont.setD(ClimbConstants.D);
      // pidcont.setIZone(ClimbConstants.Iz);
      // pidcont.setFF(ClimbConstants.FF);
      // pidcont.setOutputRange(ClimbConstants.MinOutput, ClimbConstants.MaxOutput);
    }

    public void moveTo(double position){
      //pidcont.setReference(position, CANSparkMax.ControlType.kPosition);
    }

    public void setPosition(double position){
      //encoder.setPosition(position);
    }
    @Override
    public void periodic(){
      // System.out.print("left1 & 2 " + left1.get() + " / " + left2.get());
      // System.out.print("right & 2 " + right1.get() + " / " + right2.get());
    } 

    public double getArmPos(){
      //return encoder.getPosition();
      //left1.getSelectedSensorPosition();
      return 0;
    }
    // public void breaks(){
    
    // }

    //public void setLimits(double motorpower){
      // left1.configClosedloopRamp(motorpower);
      // left2.configClosedloopRamp(motorpower);
      // right1.configClosedloopRamp(motorpower);
      // right2.configClosedloopRamp(motorpower);


      // left1.configPeakOutputForward(softlimit);
      // left2.configPeakOutputForward(softlimit);
      // right1.configPeakOutputForward(softlimit);
      // right2.configPeakOutputForward(softlimit);

      // left1.configPeakOutputReverse(softlimit);
      // left2.configPeakOutputReverse(softlimit);
      // right1.configPeakOutputReverse(softlimit);
      // right2.configPeakOutputReverse(softlimit);
      
    //}

   // public double getPosition(){
     //   return m_encoder.getPosition();
   // }
   
    public boolean frontRightSwitch(){
      return frontRight.get();
    }
    public boolean backRightSwitch(){
      return backRight.get();
    }
    public boolean backLeftSwitch(){
      return backLeft.get();
    }
    public boolean frontLeftSwitch(){
      return frontLeft.get();
    }

    public void setSpeed(double speed){
      if (this.getArmPos() > 50 && speed > 0){
        //claw.set(0);
      }
      else
      {
        //claw.set(speed);
      }
    }

    public double getLeftEncoder(){
      //return left1.encoder();
      return 0;
    }


    public void drive(double left, double right){
      
      //System.out.println(left*1.05);
      //m_Drive.tankDrive(left, right, false);
      left1.set(left);
      left2.set(left);
      right1.set(right);
      right2.set(right);
    }
}
