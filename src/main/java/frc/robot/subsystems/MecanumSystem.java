package frc.robot.subsystems;

//import com.ctre.phoenix.motorcontrol.can.WPITalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.WheelConstants;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
public class MecanumSystem extends SubsystemBase{
    WPI_TalonSRX frontLeft = new WPI_TalonSRX(WheelConstants.left1);
    WPI_TalonSRX frontRight = new WPI_TalonSRX(WheelConstants.right1);
    WPI_TalonSRX backLeft = new WPI_TalonSRX(WheelConstants.left2);
    WPI_TalonSRX backRight = new WPI_TalonSRX(WheelConstants.right2);

    public MecanumDrive m_mecanum;
    public MecanumSystem(){
        //m_mecanum = new MecanumDrive(frontLeft,backLeft,frontRight,backRight);
        frontLeft.setInverted(true);
        backLeft.setInverted(true);
    }

    
    // public void drive(double x, double y, double z){
    //     //m_mecanum.driveCartesian(x,y,z);
    // }
    public void moveFL(double speed){
        frontLeft.set(speed);
    }
    public void moveFR(double speed){
        frontRight.set(speed);
    }
    public void moveBL(double speed){
        backLeft.set(speed);
    }
    public void moveBR(double speed){
        backRight.set(speed);
    }
    
}
