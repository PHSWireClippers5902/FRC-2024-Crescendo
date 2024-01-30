package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DoubleArm extends SubsystemBase{

    //!!IMPORTANT!! THIS ONLY WORKS ON 5902PAT. ALL OTHER ROBOTS AND THIS WILL MOST LIKELY FAIL. THIS UTILIZES A DOUBLE ARM SYSTEM

    //initializes relative encoders, the cansparks, and the pid controllers. 
    RelativeEncoder botL, botR, topEnc;
    CANSparkMax neoBL = new CANSparkMax(6, MotorType.kBrushless);
    CANSparkMax neoBR = new CANSparkMax(5, MotorType.kBrushless);
    CANSparkMax neoTop = new CANSparkMax(7, MotorType.kBrushless);
    SparkMaxPIDController botLPID, botRPID, botTop;
    //public static final int aimMotorPort = 15;

    //these are the calculus terms that i use for PIDF control. 
    public static final double P = 0.8; 
    public static final double I = 0.00001;
    public static final double D = 0; 
    public static final double Iz = 0; 
    public static final double FF = 0; 
    public static final double MaxOutput = .1; 
    public static final double MinOutput = -0.1;
    public DoubleArm(){
        //first cansparkmax encoders are grabbed
        botL = neoBL.getEncoder();
        botR = neoBR.getEncoder();
        topEnc = neoTop.getEncoder();
        //then the pid controllers are grabbed.
        botLPID = neoBL.getPIDController();
        botRPID = neoBR.getPIDController();
        botTop = neoTop.getPIDController();
        //then it sets the position to 0,0,0.
        botL.setPosition(0);
        botR.setPosition(0);
        topEnc.setPosition(0);
        //runs method that is configured later. 
        ConfigurePID();
    }
    public void posReset(){
        //resets the position to 0s. 
        botL.setPosition(0);
        botR.setPosition(0);
        topEnc.setPosition(0);
    }
    public void ConfigurePID(){
        //configures pid for all three motor controllers. 
        botLPID.setP(P);
        botLPID.setI(I);
        botLPID.setD(D);
        botLPID.setIZone(Iz);
        botLPID.setFF(0);
        botLPID.setOutputRange(MinOutput, MaxOutput);

        botRPID.setP(P);
        botRPID.setI(I);
        botRPID.setD(D);
        botRPID.setIZone(Iz);
        botRPID.setFF(0);
        botRPID.setOutputRange(MinOutput, MaxOutput);

        botTop.setP(P);
        botTop.setI(I);
        botTop.setD(D);
        botTop.setIZone(Iz);
        botTop.setFF(0);
        botTop.setOutputRange(MinOutput, MaxOutput);
    }

    public double getBottomLeftMotorPosition(){
        //gets bottom left position
        return botL.getPosition();
    }

    public double getBottomRightMotorPosition(){
        //gets bottom right position
        return botR.getPosition();
    }

    public double getTopMotorPosition(){
        //gets top motor position
        return topEnc.getPosition();
    }


    public void moveBLTo(double position){
        //moves bottom left to position using pid reference
        botLPID.setReference(position, CANSparkMax.ControlType.kPosition);
        
    }

    public void moveBRTo(double position){
        //moves bottom right to position using pid reference

        botRPID.setReference(position, CANSparkMax.ControlType.kPosition);
        
    }

    public void moveTopTo(double position){
        //moves top motor to position using pid reference
        botTop.setReference(position, CANSparkMax.ControlType.kPosition);
        
    }



}
