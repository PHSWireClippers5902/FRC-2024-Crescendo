package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.RemoteFeedbackDevice;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
//import com.ctre.phoenix.motorcontrol.can.WPITalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.WheelConstants;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MecanumSystem extends SubsystemBase{
    //!!IMPORTANT!! ONLY WORKS ON ROBOTS THAT HAVE A MECANUM BASE (MOSTLY HOOKBOT)
    //RelativeEncoder frontLeftEnc;
    public double ticks=0,aveFL=0,aveFR=0,aveBL=0,aveBR=0,totalFL=0,totalFR= 0 ,totalBR = 0,totalBL = 0;
    public double asFL=1.1072,asFR=1,asBL=1,asBR = 1;
    Spark color = new Spark(0);
    double MAX_VELOCITY = 4000;
    public double MecanumColor = 0.99;
    //initializes motor controllers with hookbot constants. 
    WPI_TalonSRX frontLeft = new WPI_TalonSRX(4);
    WPI_TalonSRX frontRight = new WPI_TalonSRX(3);
    WPI_TalonSRX backLeft = new WPI_TalonSRX(1);
    WPI_TalonSRX backRight = new WPI_TalonSRX(2);
    double initfl,initfr,initbl,initbr;
    double flpos,frpos,blpos,brpos;
    public MecanumDrive m_mecanum;
    public MecanumSystem(){
        factoryDefaults();
        configurekF(.38);
        configurekP(0);
        configurekI(0);
        configurekD(0);
        configurekIZ(0);

        configureFeedSensors();
        configureSensorPos();

        color.set(MecanumColor);
        //reverses sum fun motors. 
        //initializes position for motors

        
        frontLeft.setInverted(true);
        backLeft.setInverted(true);
    }

    @Override
    public void periodic() {
        color.set(MecanumColor);
    }
    public void factoryDefaults(){
        frontLeft.configFactoryDefault();
        frontRight.configFactoryDefault();
        backLeft.configFactoryDefault();
        backRight.configFactoryDefault();

    }
    public void configureFeedSensors(){
        frontLeft.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,0,1);
        frontRight.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,0,1);
        backLeft.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,0,1);
        backRight.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,0,1);

    }
    public void configureSensorPos(){
        frontLeft.setSelectedSensorPosition(0,0,1);
        frontRight.setSelectedSensorPosition(0,0,1);
        backLeft.setSelectedSensorPosition(0,0,1);
        backRight.setSelectedSensorPosition(0,0,1);

    }
    public void configurekI(double value){
        frontLeft.config_kD(0,value);
        frontRight.config_kD(0,value);
        backLeft.config_kD(0,value);
        backRight.config_kD(0,value);
    }
    // public void configureMinMax(double min, double max){
    //     frontLeft.configPeakOutputForward(max);
    //     frontLeft.configPeakOutputReverse(-max);
    // }
    public void configurekIZ(double value){
        frontLeft.config_IntegralZone(0,value);
        frontRight.config_IntegralZone(0,value);
        backLeft.config_IntegralZone(0,value);
        backRight.config_IntegralZone(0,value);
    }
    public void configurekD(double value){
        
        frontLeft.config_kI(0,value);
        frontRight.config_kI(0,value);
        backLeft.config_kI(0,value);
        backRight.config_kI(0,value);
    }
    public void configurekF(double value){
        
        frontLeft.config_kF(0,value);
        frontRight.config_kF(0,value);
        backLeft.config_kF(0,value);
        backRight.config_kF(0,value);
    }
    public void configurekP(double value){
        
        frontLeft.config_kP(0,value);
        frontRight.config_kP(0,value);
        backLeft.config_kP(0,value);
        backRight.config_kP(0,value);
    }   

    public void changeColor(double colour){
        MecanumColor = colour;
    }

    
    public void zeromotors(){
        frontLeft.setSelectedSensorPosition(0,0,0);
        frontRight.setSelectedSensorPosition(0,0,0);
        backLeft.setSelectedSensorPosition(0,0,0);
        backRight.setSelectedSensorPosition(0,0,0);
    }
    // public double feetToTicks(double feet){
    //     return 500*feet;
        
    // }

    // public void goFLTo(double feet){
    //     SmartDashboard.putNumber("FrontLeft Position: ",frontLeft.getSelectedSensorPosition());
    //     //frontLeft.set(ControlMode.Position,feetToTicks(feet));
    //     frontLeft.set(ControlMode.Position,1);
    // }
    // public void goFRTo(double feet){
    //     SmartDashboard.putNumber("FrontRigjt Position: ",frontRight.getSelectedSensorPosition());
    //     frontRight.set(ControlMode.Position,feetToTicks(feet));
    // }
    // public void goBLTo(double feet){
    //     SmartDashboard.putNumber("BackLeft Position: ",backLeft.getSelectedSensorPosition());
    //     backLeft.set(ControlMode.Position,feetToTicks(feet));
    // }
    // public void goBRTo(double feet){
    //     SmartDashboard.putNumber("BackRight Position: ",backRight.getSelectedSensorPosition());
    //     backRight.set(ControlMode.Position,feetToTicks(feet));
    // }
    
    //these four methods just set the speeds of individual stuff. 
    
    public void moveFL(double speed){
        SmartDashboard.putNumber("frontLeftVel", frontLeft.getSelectedSensorVelocity(0));

        SmartDashboard.putNumber("FLSPEED", speed);
        frontLeft.set(ControlMode.Velocity,speed*MAX_VELOCITY);
        //frontLeft.set(asFL*speed);
        //frontLeft.setVoltage(0);

    }
    public void moveFR(double speed){
        SmartDashboard.putNumber("frontRightVel", frontRight.getSelectedSensorVelocity(0));

        SmartDashboard.putNumber("FRSPEED", speed);
        frontRight.set(ControlMode.Velocity,speed*MAX_VELOCITY);
        //frontRight.set(asFR*speed);

    }
    public void moveBL(double speed){
        SmartDashboard.putNumber("backLeftVel", backLeft.getSelectedSensorVelocity(0));
        SmartDashboard.putNumber("BLSPEED", speed);
        backLeft.set(ControlMode.Velocity,speed*MAX_VELOCITY);
        //backLeft.set(speed);

    }
    public void moveBR(double speed){
        SmartDashboard.putNumber("backRightVel", backRight.getSelectedSensorVelocity(0));
        SmartDashboard.putNumber("BRSPEED", speed);

        backRight.set(ControlMode.Velocity,speed*MAX_VELOCITY);
        //backRight.set(asBR*speed);

    }
    

    public void percentSpeeds(){
        ticks++;
        totalFL +=frontLeft.getSelectedSensorVelocity();
        totalFR +=frontRight.getSelectedSensorVelocity();
        totalBL += backLeft.getSelectedSensorVelocity();
        totalBR +=backRight.getSelectedSensorVelocity();

        aveFL = (totalFL)/ticks;
        aveBL = (totalBL)/ticks;
        aveFR = (totalFR)/ticks;
        aveBR = (totalBR)/ticks;
        
        // asFL = aveFL/aveBL;
        // asFR = aveFR/aveBL;
        // asBR = aveBR/aveBL;

        

        SmartDashboard.putNumber("FL->BL (%)",1/(aveFL/aveBL));
        SmartDashboard.putNumber("BR->BL (%)",1/(aveBR/aveBL));
        SmartDashboard.putNumber("FR->BL (%)",1/(aveFR/aveBL));
        
    }
    public void resetticks(){

        ticks = 0;
        totalFL = 0;
        totalFR = 0;
        totalBR = 0;
        totalBL = 0;
        
    }
    public void getTurnFL(){
        SmartDashboard.putNumber("Turns on FL: ", frontLeft.getSelectedSensorPosition(0)/4096);
    }
}
