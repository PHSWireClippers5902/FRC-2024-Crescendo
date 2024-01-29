package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.FlyWheel;

public class FlyCommand extends Command{
    XboxController m_xbox;
    FlyWheel wheel;
    
    public FlyCommand(XboxController xbox, FlyWheel fly){
        m_xbox = xbox;
        wheel = fly;
        addRequirements(wheel);
    }
    @Override
    public void execute() {
        //code that would be used if used in comp
        
        // if (m_xbox.getAButton()){
        //     wheel.moveFly(1);
        // }
    }

    
}
