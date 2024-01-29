package frc.robot.commands;

import javax.lang.model.util.ElementScanner14;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DeepSpace;

public class DeepSpaceCommand extends Command{
    XboxController controller;
    DeepSpace spaceSystem;


    public DeepSpaceCommand (XboxController xbox, DeepSpace space){
        spaceSystem = space;
        controller = xbox;
        //addRequirement(spaceSystem);
        addRequirements(spaceSystem);
    }
    @Override
    public void execute() {
        spaceSystem.moveLeft(-0.3*controller.getLeftY());
        spaceSystem.moveRight(-0.3*controller.getRightY());
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
