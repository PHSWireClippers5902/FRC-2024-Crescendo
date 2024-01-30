package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Gyroscope;


public class GyroCommand extends Command{
    //!!IMPORTANT!! THIS CODE HAS NOT BEEN TOUCHED UPON. GYROSCOPES ARE VERY TRICKY AND HARD TO WORK WITH SO IF U WANT TO ADD ON, good luck. 
    XboxController m_box;
    Gyroscope m_gyro;
    public GyroCommand(XboxController xbox, Gyroscope gyro){
        m_box = xbox;
        m_gyro = gyro;
        addRequirements(m_gyro);
    }

    @Override 
    public void execute(){
        if (m_box.getLeftBumper()){

            m_gyro.calibrate();
        }


    }




}
