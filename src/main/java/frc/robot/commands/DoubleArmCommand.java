package frc.robot.commands;

import javax.lang.model.util.ElementScanner14;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DoubleArm;


public class DoubleArmCommand extends Command{
    //!!IMPORTANT!! THIS COMMAND ONLY WORKS ON 5902PAT. ANY OTHER ROBOT AND THIS WILL MOST LIKELY FAIL. If this doesn't work, UNCOMMENT the initialization of the subsystem and command. 
    //initializes a ton of variables / controllers. This is essential. 
    XboxController m_xbox;
    XboxController m_xbox2;
    DoubleArm m_arm;
    private double savedBl = 0, savedBr = 0, savedTop = 0;
    private boolean configuredYet;
    private double adjustBack = 0, adjustFront;
    Timer time = new Timer();
    private boolean BButton;
    public DoubleArmCommand(XboxController xbox, DoubleArm doubleArm){
        //this part is essential. It maps the instantiated objects to objects that already exists. Also adds requirement of a subsystem. 
        m_arm = doubleArm;
        time.reset();
        m_xbox = xbox;
        //m_xbox2 = xbox2;
        addRequirements(m_arm);
        configuredYet = false;
    }

    @Override
    public void execute() {
        //outputs encoder values to smartdashboard
        SmartDashboard.putNumber("BottomLeft: ", m_arm.getBottomLeftMotorPosition());
        SmartDashboard.putNumber("BottomRight: ", m_arm.getBottomRightMotorPosition());
        SmartDashboard.putNumber("Top: ", m_arm.getTopMotorPosition());
        
        //if the right trigger is hit, then it will swap to position control using the joysticks as input. 
        if (m_xbox.getRightTriggerAxis() > 0.2){
            adjustBack+=m_xbox.getLeftY()*0.3;
            adjustFront+=m_xbox.getRightY()*0.3;
            m_arm.moveBLTo(-adjustBack);
            m_arm.moveBRTo(adjustBack);
            m_arm.moveTopTo(adjustFront);
        }



        //if the pov (the dpad thing at the bottom of the xbox), is at the top, then the arm will save the encoder position. Else, if the dpad is at the bottom, then it will move the arm to the saved position. 
        if (m_xbox.getPOV() == 0){
            savedBl = m_arm.getBottomLeftMotorPosition();
            savedBr = m_arm.getBottomRightMotorPosition();
            savedTop = m_arm.getTopMotorPosition();
        }else if (m_xbox.getPOV() == 180){
            m_arm.moveBLTo(savedBl);
            m_arm.moveBRTo(savedBr);
            m_arm.moveTopTo(savedTop);
        }
        //if the y button is hit, then the arm will go to it's default position. Else, if the B button is hit, then it will go to a semi opened position. If the A button is hit, then it will go to the top position. If the x button is hit, then it will go to the bottom position. 
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

        

        
    }
}
