package frc.robot.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.FlyWheelAndHook;
import frc.robot.subsystems.MecanumSystem;

public class AutonomousCommand extends Command{
    private Timer time = new Timer();
    private MecanumSystem drive;
    private FlyWheelAndHook flyhook;
    private Timer shootTimer = new Timer();
    public AutonomousCommand(MecanumSystem mecanum,FlyWheelAndHook flysystem){
        drive = mecanum;
        flyhook = flysystem;
        shootTimer.reset();
        shootTimer.start();
        addRequirements(drive);
        addRequirements(flyhook);
    }
    
    @Override
    public void initialize() {
        time.reset();
        time.start();
        shootTimer.reset();
        shootTimer.start();
        flyhook.moveFly(0);
        //drive.autonomousConfigs();
        drive.zeromotors();
        System.out.println("Hello, World, AutoActive");
    
    }

    @Override
    public void execute() {
        //30000 per 360
        //30000/4 = 7500
        //drive.customMoveFLTo(10000);
        if (time.get() > 0 && time.get() < 3){

        
            drive.moveAllFourTo(-1,-1,-1,-1);
        }
        else if (time.get() > 3 && time.get() < 3.1) {
            drive.zeromotors();
            //drive.moveAllFourTo()
        }
        else if (time.get() > 3.1 && time.get() < 7){
            //drive.moveAllFourToTURNS(8,-8,8,-8);
            //drive.moveAllFourToDegrees(90,90,90,90);
            drive.moveAllFourToTicks(drive.degreesToTicks(190),-drive.degreesToTicks(190),drive.degreesToTicks(190),-drive.degreesToTicks(190));

        }
        else  if (time.get() > 7 && time.get() < 7.1){
            //drive.moveAllFourTo(0,0,0,0);
            drive.zeromotors();
            shootTimer.reset();
            shootTimer.start();
        }
        else {
            if (shootTimer.get() < 1.25){
                flyhook.moveTopFlyWheel(1);
            }
            else {
                flyhook.moveTopFlyWheel(1);
                flyhook.moveBottomFlyWheel(1);
            }
            drive.moveAllFourTo(0,0,0,0);
        }
        
        drive.printpositions();





    }

    @Override
    public void end(boolean interrupted) {
        time.reset();
    }

    

}
