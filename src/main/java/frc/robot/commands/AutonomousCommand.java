package frc.robot.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.MecanumSystem;

public class AutonomousCommand extends Command{
    private Timer time = new Timer();
    private MecanumSystem drive;
    public AutonomousCommand(MecanumSystem mecanum){
        drive = mecanum;
        addRequirements(drive);
    }
    
    @Override
    public void initialize() {
        time.reset();
        time.start();
    }

    @Override
    public void execute() {
        //System.out.println("Hello, World, AutoActive");
        // if (time.get() < 1){
        //     //drive.factoryDefaults();
        //     // drive.configurekF(.3);
        //     // drive.configurekP(0);
        //     // drive.configurekI(0.1);
        //     // drive.configurekD(0);
        //     // drive.configurekIZ(0);
        //     // drive.configureFeedSensors();
        //     // drive.configureSensorPos();
        //     //drive.configureMinMax(0,0.3);
        //     //drive.zeromotors();
            
        // }
        // else if (time.get() > 1 && time.get() < 6){
        //     drive.goFLTo(1);
        //     drive.goFRTo(1);
        //     drive.goBLTo(1);
        //     drive.goBRTo(1);
        // }
        // else {
        //     drive.goFLTo(0);
        //     drive.goFRTo(0);
        //     drive.goBLTo(0);
        //     drive.goBRTo(0);
        //     // time.reset();
        //     // time.start();
            
        // }




    }

    @Override
    public void end(boolean interrupted) {
        time.reset();
    }

    

}
