package frc.robot.subsystems;

//import com.ctre.phoenix.motorcontrol.can.WPITalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.WheelConstants;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
public class MecanumSystem extends SubsystemBase{
    //!!IMPORTANT!! ONLY WORKS ON ROBOTS THAT HAVE A MECANUM BASE (MOSTLY HOOKBOT)
    
    //initializes motor controllers with hookbot constants. 
    WPI_TalonSRX frontLeft = new WPI_TalonSRX(WheelConstants.left1);
    WPI_TalonSRX frontRight = new WPI_TalonSRX(WheelConstants.right1);
    WPI_TalonSRX backLeft = new WPI_TalonSRX(WheelConstants.left2);
    WPI_TalonSRX backRight = new WPI_TalonSRX(WheelConstants.right2);

    public MecanumDrive m_mecanum;
    public MecanumSystem(){
        //reverses sum fun motors. 
        frontLeft.setInverted(true);
        backLeft.setInverted(true);
    }

    //these four methods just set the speeds of individual stuff. 
    
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
