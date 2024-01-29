package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.CANCoder;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class EncoderSystem  extends SubsystemBase {
    TalonSRX left2 = new TalonSRX(0);
    TalonSRX left1Encoder = new TalonSRX(1);
    TalonSRX right2 = new TalonSRX(2);
    TalonSRX right1Encoder = new TalonSRX(3);
    
    TankDrive drive;
    public EncoderSystem(TankDrive tankdr){
        drive = tankdr;
        //left1Encoder.set()
    }


    public double getLeftEncoder(){
        return 1;
    }
    public double getRightEncoder(){
        return 1;
    }


        
}
