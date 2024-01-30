package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.PneumaticBoard;
import edu.wpi.first.wpilibj.XboxController;


public class SolenoidCommand extends Command {
  //!!IMPORATNT!! ONLY WORKS WITH ROBOTS THAT HAVE A PNEUMATIC SYSTEM. IF THIS IS COMMENTED< THEN UNCOMMENT THIS OUT> 
  private final PneumaticBoard m_pneumatics;
  private XboxController m_box;

  public SolenoidCommand(PneumaticBoard pneumatics, XboxController controller){
    //important: maps objects to existing objecst. 
    m_pneumatics = pneumatics;
    m_box = controller;
    addRequirements(m_pneumatics);
  }

  @Override
  public void initialize() {
    //no instantialized method. 
  }
  @Override
  public void execute() {

    //commented out jibber jabber. 
    
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

    //if the buttons are hit, then the piston will actuate. 
    if (m_box.getLeftStickButton()){
      m_pneumatics.actuateTrue();
    }
    else if (m_box.getRightStickButton()){
      m_pneumatics.actuateFalse();
    }
  }
}
