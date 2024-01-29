package frc.robot.commands;

import javax.lang.model.util.ElementScanner14;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DoubleArm;


public class DoubleArmCommand extends Command{
    XboxController m_xbox;
    XboxController m_xbox2;
    DoubleArm m_arm;
    private double savedBl = 0, savedBr = 0, savedTop = 0;
    private boolean configuredYet;
    private double adjustBack = 0, adjustFront;
    Timer time = new Timer();
    private boolean BButton;
    public DoubleArmCommand(XboxController xbox, DoubleArm doubleArm){
        m_arm = doubleArm;
        time.reset();
        m_xbox = xbox;
        //m_xbox2 = xbox2;
        addRequirements(m_arm);
        configuredYet = false;
    }

    @Override
    public void execute() {
        SmartDashboard.putNumber("BottomLeft: ", m_arm.getBottomLeftMotorPosition());
        SmartDashboard.putNumber("BottomRight: ", m_arm.getBottomRightMotorPosition());
        SmartDashboard.putNumber("Top: ", m_arm.getTopMotorPosition());

        if (m_xbox.getRightTriggerAxis() > 0.2){
            adjustBack+=m_xbox.getLeftY()*0.3;
            adjustFront+=m_xbox.getRightY()*0.3;
            m_arm.moveBLTo(-adjustBack);
            m_arm.moveBRTo(adjustBack);
            m_arm.moveTopTo(adjustFront);
        }



        if (m_xbox.getPOV() == 90){

        }

        if (m_xbox.getPOV() == 0){
            savedBl = m_arm.getBottomLeftMotorPosition();
            savedBr = m_arm.getBottomRightMotorPosition();
            savedTop = m_arm.getTopMotorPosition();
            // if (configuredYet){
            //     m_arm.moveBLTo(savedBl);
            //     m_arm.moveBRTo(savedBr);
            //     m_arm.moveTopTo(savedTop);
            // }
            // else
            // {
            //     savedBl = m_arm.getBottomLeftMotorPosition();
            //     savedBr = m_arm.getBottomRightMotorPosition();
            //     savedTop = m_arm.getTopMotorPosition();
            // }
        }else if (m_xbox.getPOV() == 180){
            m_arm.moveBLTo(savedBl);
            m_arm.moveBRTo(savedBr);
            m_arm.moveTopTo(savedTop);
        }
        if (m_xbox.getYButton()){
            // time.reset();
            m_arm.moveBLTo(0);
            m_arm.moveBRTo(0);
            m_arm.moveTopTo(0);
            
        }
        else if (m_xbox.getBButton()){
            
            m_arm.moveBLTo(7);
            m_arm.moveBRTo(-7);
            m_arm.moveTopTo(-9);
                
        }
        else if (m_xbox.getAButton()){
            // time.reset();
            m_arm.moveBLTo(-5);
            m_arm.moveBRTo(5);
            m_arm.moveTopTo(-53);
            BButton = false;
        }
        else if (m_xbox.getXButton()){
            m_arm.moveBLTo(-5);
            m_arm.moveBRTo(5);
            m_arm.moveTopTo(-4);
        }
        // m_arm.moveBLTo(0);
        // m_arm.moveBRTo(0);
        // m_arm.moveTopTo(100);
        

        
    }
}
