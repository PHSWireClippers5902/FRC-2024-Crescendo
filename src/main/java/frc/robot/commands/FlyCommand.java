package frc.robot.commands;

import javax.lang.model.util.ElementScanner14;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.FlyWheelAndHook;
import frc.robot.subsystems.MecanumSystem;

public class FlyCommand extends Command{
    //!!IMPORTANT!! THIS IS A CODE SNIPPIT FOR THE 2024 CRESCENDO CHALLENGE!
    Timer lightTimer = new Timer();
    XboxController m_xbox;

    FlyWheelAndHook wheel;
    MecanumSystem light;
    public FlyCommand(XboxController xbox, FlyWheelAndHook fly,MecanumSystem lightSystem){
        m_xbox = xbox;
        lightTimer.reset();
        lightTimer.start();
        wheel = fly;
        
        addRequirements(wheel);
        light = lightSystem;
        
    }
    @Override
    public void execute() {

        if (m_xbox.getRightBumper()){
            //wheel.moveFly(m_xbox.getLeftTriggerAxis());
            wheel.moveTopFlyWheel(-0.7);
            wheel.moveBottomFlyWheel(-.4);
            if (Math.round(lightTimer.get()*10) % 2 == 0){
                light.changeColor(0.59);
            }
            else 
            {
                light.changeColor(0.99);
            }
        }
        else if (m_xbox.getLeftTriggerAxis() > 0.1){
            //light.changeColor(1);
            if (Math.round(lightTimer.get()*4) % 2 == 0){
                light.changeColor(0.77);
            }
            else 
            {
                light.changeColor(0.99);
            }
            wheel.moveFly(m_xbox.getLeftTriggerAxis());

        } 
        // else if (m_xbox.getLeftBumper()){
        //     wheel.moveBottomFlyWheel(0.25);
        //     wheel.moveTopFlyWheel(1);
        
        // }     
        else if (m_xbox.getRightTriggerAxis() > 0.1)
        {
            if (Math.round(lightTimer.get()*4) % 2 == 0){
                light.changeColor(0.77);
            }
            else 
            {
                light.changeColor(0.99);
            }
            wheel.moveTopFlyWheel(1);
            wheel.moveBottomFlyWheel(0);
        }
        // else {
        //     wheel.moveFly(0);
        // }
        
        // else if (js.getRawButton(5)){
        //     wheel.moveFly(-0.85);
        // }
        // else if (js.getRawButton(4)){
        //     wheel.moveFly(1);
        // }
        // else if(js.getRawButton(6)){
        //     wheel.moveTopFlyWheel(1);
        //     wheel.moveBottomFlyWheel(0);
        // }
        else {
            wheel.moveFly(0);
        }

        // if (m_xbox.getYButton()){
        //     wheel.moveHook(0.2);
        // }
        // else if (m_xbox.getAButton()){
        //     wheel.moveHook(-0.2);
        // }
        // else {
        //     wheel.moveHook(0);
        // }
        // if (m_xbox.getXButton()){
        //     wheel.moveFly(0);
        // }
        //code that would be used if used in comp
        
        // if (m_xbox.getAButton()){
        //     wheel.moveFly(1);
        // }
        // if (m_xbox.getAButton()){
        //     wheel.moveActuatorOn();
        // }
        // else if (m_xbox.getBButton()){
        //     wheel.moveActuatorOff();
        // }
        // else {
        //     //wheel.neutralActuator();
        // }
    }

    
}
