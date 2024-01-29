package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FlyWheel extends SubsystemBase{
    CANSparkMax flywheel = new CANSparkMax(9, MotorType.kBrushless);

    public void FlyWheel(){

    }
    
    public void moveFly(double speed){
        flywheel.set(speed);
    }


}
