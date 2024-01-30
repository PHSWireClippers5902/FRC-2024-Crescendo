package frc.robot.commands;

import javax.lang.model.util.ElementScanner14;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DeepSpace;

public class DeepSpaceCommand extends Command{
    //!!IMPORTANT!! THIS COMMAND ONLY WORKS ON 2019 DUCKBOT. TO USE THIS, COMMENT MOST OF THE STUFF IN THE ROBOTCONTAINER OUT, AND UNCOMMENT THE INITIALIZATION OF THE DEEPSPACE COMMAND AND SUBSYSTEM
    //initializes the subsystem space System, and the xbox controller 
    XboxController controller;
    DeepSpace spaceSystem;


    public DeepSpaceCommand (XboxController xbox, DeepSpace space){
        //sets the values, and addrequirements of the subsystem. This code is essential. 
        spaceSystem = space;
        controller = xbox;
        //addRequirement(spaceSystem);
        addRequirements(spaceSystem);
    }
    @Override
    public void execute() {
        //moves the wheels by the xbox controllers joysticks. 
        spaceSystem.moveLeft(-0.3*controller.getLeftY());
        spaceSystem.moveRight(-0.3*controller.getRightY());
        //if the bumper is pressed, then move the intake thingy. 
        if (controller.getLeftBumper()){
            spaceSystem.moveIntake(1);

        }else if (controller.getRightBumper()){
            spaceSystem.moveIntake(-1);

        }
        else {
            spaceSystem.moveIntake(0);
        }


    }
}
