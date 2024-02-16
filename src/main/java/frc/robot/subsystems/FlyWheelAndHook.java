package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FlyWheelAndHook extends SubsystemBase{
    // Servo actuator = new Servo(1);
    //CODE STUB FOR THE 2024 Crescendo Season. 
    WPI_TalonSRX topfly = new WPI_TalonSRX(6);
    //WPI_TalonSRX topfly = new WPI_TalonSRX(5);
    CANSparkMax bottomfly = new CANSparkMax(8,MotorType.kBrushless);
    //RelativeEncoder hookencoder;
    //CANSparkMax hook = new CANSparkMax(7,MotorType.kBrushless);
    //SparkPIDController hookpid;
    // public void moveActuatorOn(){
    //     actuator.setAngle(180);
    //     System.out.println(actuator.getAngle());
    // }
    // public void moveActuatorOff(){
    //     actuator.setAngle(0);
    //     System.out.println(actuator.getAngle());
    // }
    // public void neutralActuator(){
    //     actuator.set(0);
    // }
    public void FlyWheel(){
        //hookpid = hook.getPIDController();
    }
    public void moveHook(double speed){
        //hook.set(speed);
    }
    public void moveFly(double speed){
        SmartDashboard.putNumber("DFLY:",speed);
        bottomfly.set(speed);
        topfly.set(speed);
    }

    public void moveBottomFlyWheel(double speed){
        SmartDashboard.putNumber("BFLY: ",speed);
        bottomfly.set(speed);
    }

    public void moveTopFlyWheel(double speed){
        SmartDashboard.putNumber("TFLY: ",speed);
        topfly.set(speed);
    }



}
