package frc.robot.commands;
import frc.robot.subsystems.*;
import frc.robot.subsystems.TankDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DigitalInput;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;


public class AutonomousCommand extends Command{
    private XboxController xbox;
    private TankDrive tankdrive;
    private LimeLightValues limeLight;
    private boolean isActive;
    private Timer time = new Timer();
    public AutonomousCommand(TankDrive driveSystem, XboxController xboxCont, LimeLightValues ll){
        tankdrive = driveSystem;
        xbox = xboxCont;
        limeLight = ll;
        time.reset();
        time.start();


        addRequirements(tankdrive);


        
    }
    @Override 
    public void execute(){
        // if (xbox.getRightBumper()){
        //     isActive = true;
        // }
        // if (isActive){

        
        //     if (limeLight.getTv() != 0){
        //         while (limeLight.getInchesFromGoal() >= 50){
        //             tankdrive.drive(0.1,0.1);
        //         }
        //         time.reset();
        //         time.start();
        //     }
        //     while (time.get() < 2.5){
        //         tankdrive.drive(0.2,-0.2);
        //     }
        //     tankdrive.drive(0,0);
        //}

    }


}
