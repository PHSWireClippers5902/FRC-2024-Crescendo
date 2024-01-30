package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DeepSpace extends SubsystemBase{
    //!!IMPORTANT!! THIS ONLY WORKS ON THE DUCKBOT. ANYWHERE ELSE AND THIS WILL MOST LIKELY FAIL...... so I won't be spending much time commenting this cause no one actually uses DUCK :skull:
    
    //PneumaticHub hub;
    //initailizes the motor controllers, solneoid, and compressor. 
    WPI_TalonSRX frontLeft,frontRight,backLeft,backRight,intakeleft,intakeright;
    Solenoid bl,br,fl,fr;
    Compressor comp;
    public DeepSpace(){
        //maps objects to existing objects. 
        comp = new Compressor(20,PneumaticsModuleType.CTREPCM);
        // bl = new Solenoid(PneumaticsModuleType.CTREPCM,0);
        // br = new Solenoid(PneumaticsModuleType.CTREPCM,0);
        frontLeft = new WPI_TalonSRX(4);
        backLeft = new WPI_TalonSRX(3);
        frontRight = new WPI_TalonSRX(1);
        backRight = new WPI_TalonSRX(2);
        intakeleft = new WPI_TalonSRX(5);
        intakeright = new WPI_TalonSRX(6);
        frontRight.setInverted(true);
        backRight.setInverted(true);
        intakeright.setInverted(true);
       

    }
    public void moveLeft(double speed){
        //moves left motors
        frontLeft.set(speed);
        backLeft.set(speed);
    }
    public void moveRight(double speed){
        //moves right motors
        frontRight.set(speed);
        backRight.set(speed);
    }
    public void moveIntake(double speed){
        //moves the intake at the same speed. 
        intakeleft.set(speed);
        intakeright.set(speed);
    }



    // public void actuateTrue(){
    //     bl.set(true);
    //     br.set(true);
    // }
    // public void actuateFalse(){
    //     bl.set(false);
    //     br.set(false);
    // }






}
