package frc.robot.commands;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController;

import edu.wpi.first.wpilibj.Timer;

public class LimeLight extends Command{

    private double x = 0;
    private double y = 0;
    private double nums = 0;
    private double area = 0;
    private XboxController m_xbox;
    private Timer timer;
    private final  LimeLightValues values; 
    private TankDrive tank;
    private int autocorrect = 0;
    public LimeLight(LimeLightValues limelightvalues, XboxController xbox, TankDrive m_tank){
        m_xbox =  xbox;
        tank = m_tank;
        values = limelightvalues;
        addRequirements(values);
        timer = new Timer();
        timer.reset();
        timer.start();
    
    }
    

    @Override
    public void execute(){
        // if (timer.get() > 0.5){
        //     System.out.println("x: " + values.getTx());
        //     System.out.println("y: " + values.getTy());
        //     System.out.println("area: " + values.getTa());
        //     timer.reset();
        //     timer.start();
        
        // }
        x = values.getTx();
        y = values.getTy();
        area = values.getTa();
        nums = values.getTv();
        //post to smart dashboard periodically
        SmartDashboard.putNumber("LimelightX", x);
        SmartDashboard.putNumber("LimelightY", y);
        SmartDashboard.putNumber("LimelightArea", area);
        SmartDashboard.putNumber("DistanceFromGoal", values.getInchesFromGoal());
        SmartDashboard.putNumber("Limelight Values: ",nums);
        float Kp = -0.1f;
        float min_command = 0.05f;
        
        //std::shared_ptr<NetworkTable> table = NetworkTable::GetTable("limelight");
        //float tx = table->GetNumber("tx");
        if (m_xbox.getXButton()){
            //autocorrect = 2;
        }
        if (m_xbox.getYButton()){
            //autocorrect = 1;
        }
        if (m_xbox.getAButton()){
            //autocorrect = 0;
        }
        if (m_xbox.getBButton()){
            //autocorrect = 0;
        }
        if (autocorrect == 1)
        {
            double heading_error = -values.getTx();
            double steering_adjust = 0.0;
            if (Math.abs(heading_error) > 0.7) 
            {
                if (heading_error < 0) 
                {
                    steering_adjust = Kp*heading_error + min_command;
                } 
                else 
                {
                    steering_adjust = Kp*heading_error - min_command;
                }
            }
            //tank.drive(-0.1*steering_adjust, 0.1*steering_adjust); 
            //left_command += steering_adjust;
            //right_command -= steering_adjust;
        
            if (values.getTv() == 0){
                //tank.drive(0,0);
            }
            else if (Math.abs(heading_error) < 0.7){
                //tank.drive(0,0);
            }
            SmartDashboard.putNumber("heading_error",heading_error);
        }




        if (autocorrect == 2){



            Kp = -0.1f;
            min_command = 0.05f;

            double heading_error = -values.getTx();
            double steering_adjust = 0.0;
            
            double sadj = 0.11;


            //HEADING ERROR CALCULATIONS


            if (Math.abs(heading_error) > 0.7) 
            {
                if (heading_error < 0) 
                {
                    steering_adjust = Kp*heading_error + min_command;
                } 
                else 
                {
                    steering_adjust = Kp*heading_error - min_command;
                }
            } 
            //left_command += steering_adjust;
            //right_command -= steering_adjust;
        
            
            SmartDashboard.putNumber("heading_error",heading_error);
            double xdist = values.getInchesFromGoal();
            double err = 4;
            double targ = 40;
            double sp = 0;
            //double dif = Math.abs(xdist - targ);
            //double inc = 0.005;
            if (Math.abs(targ - xdist) >= err)
            {
                if (targ-xdist > 0){
                    sp = sadj;
                }
                else
                {
                    sp = -sadj;
                }
            }
            else
            {
                sp = 0;
            }
            
            SmartDashboard.putNumber("Steering_adjust: ", steering_adjust);
            //PART THAT MAKES STUFF MOVE
            //tank.drive(-0.1*steering_adjust+sp, 0.1*steering_adjust+sp);
            if (values.getTv() == 0){
                //tank.drive(0,0);
            }
            

            
            

        }
        
    }
}
