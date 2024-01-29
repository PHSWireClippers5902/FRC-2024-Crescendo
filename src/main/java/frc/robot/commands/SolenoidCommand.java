package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.PneumaticBoard;
import edu.wpi.first.wpilibj.XboxController;


public class SolenoidCommand extends Command {

  private final PneumaticBoard m_pneumatics;
  private XboxController m_box;

  public SolenoidCommand(PneumaticBoard pneumatics, XboxController controller){
    m_pneumatics = pneumatics;
    m_box = controller;
    addRequirements(m_pneumatics);
  }

  @Override
  public void initialize() {
    
  }
  @Override
  public void execute() {
    
    //System.out.println(m_pneumatics.compenbaled());
    
    // if(m_box.getRightBumper()){
    //     //System.out.println("Actuate");
    //     // if (logic){
    //     //   System.out.println("Actuate");
    //     //   m_pneumatics.actuate();
    //     //   logic = false;
    //     // }
    //     //m_pneumatics.actuate();
    //     m_pneumatics.actuateTrue();
         
    //  }
    //  if (m_box.getLeftBumper()){
    //   m_pneumatics.actuateFalse();
    //  }
    if (m_box.getLeftStickButton()){
      m_pneumatics.actuateTrue();
    }
    else if (m_box.getRightStickButton()){
      m_pneumatics.actuateFalse();
    }
  }
}