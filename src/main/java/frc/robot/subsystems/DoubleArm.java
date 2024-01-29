package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DoubleArm extends SubsystemBase{
    RelativeEncoder botL, botR, topEnc;
    CANSparkMax neoBL = new CANSparkMax(6, MotorType.kBrushless);
    CANSparkMax neoBR = new CANSparkMax(5, MotorType.kBrushless);
    CANSparkMax neoTop = new CANSparkMax(7, MotorType.kBrushless);
    SparkMaxPIDController botLPID, botRPID, botTop;
    //public static final int aimMotorPort = 15;
    public static final double P = 0.8; 
    public static final double I = 0.00001;
    public static final double D = 0; 
    public static final double Iz = 0; 
    public static final double FF = 0; 
    public static final double MaxOutput = .1; 
    public static final double MinOutput = -0.1;
    public DoubleArm(){
        botL = neoBL.getEncoder();
        botR = neoBR.getEncoder();
        topEnc = neoTop.getEncoder();
        
        botLPID = neoBL.getPIDController();
        botRPID = neoBR.getPIDController();
        botTop = neoTop.getPIDController();

        botL.setPosition(0);
        botR.setPosition(0);
        topEnc.setPosition(0);

        ConfigurePID();
    }
    public void posReset(){
        
        botL.setPosition(0);
        botR.setPosition(0);
        topEnc.setPosition(0);
    }
    public void ConfigurePID(){
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
        return botL.getPosition();
    }

    public double getBottomRightMotorPosition(){
        return botR.getPosition();
    }

    public double getTopMotorPosition(){
        return topEnc.getPosition();
    }


    public void moveBLTo(double position){
        botLPID.setReference(position, CANSparkMax.ControlType.kPosition);
        
    }

    public void moveBRTo(double position){
        botRPID.setReference(position, CANSparkMax.ControlType.kPosition);
        
    }

    public void moveTopTo(double position){
        botTop.setReference(position, CANSparkMax.ControlType.kPosition);
        
    }



}
