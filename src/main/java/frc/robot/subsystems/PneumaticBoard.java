// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class PneumaticBoard extends SubsystemBase {
  /** Creates a new pneumaticBoard. */

  Solenoid exampleSingle; 
  Compressor pcmCompressor;
  
  public PneumaticBoard(){

    exampleSingle = new Solenoid(PneumaticsModuleType.CTREPCM, 0);
    pcmCompressor  = new Compressor(20, PneumaticsModuleType.CTREPCM);
  }
  public boolean compenabled(){
    //return pcmCompressor.isEnabled();
    return true;
  }
  
  public void actuateTrue(){
   
    // Initialize the Solenoid so it knows where to start.  Not required for single solenoids.
    //exampleSingle.
    exampleSingle.set(true);
  }
  public void actuateFalse(){
    exampleSingle.set(false);
  }

}