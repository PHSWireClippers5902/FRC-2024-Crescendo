package frc.robot;

public final class Constants{
    public static final class VisionConstants{
        public static final double Targetheight = 40.5;
        public static final double Lightheight = 27;
        public static final double AngleOffset = -4.82;
        public static final double RangeThreshhold = 100;

    }
  public static final class WheelConstants{
      public static final int left1 = 1;
      public static final int left2 = 2;
      public static final int right1 = 4;
      public static final int right2 = 3;
  }
  public static final class AimConstants{
      public static final int aimMotorPort = 15;
      public static final double P = 0.7; 
      public static final double I = 0.00001;
      public static final double D = 0; 
      public static final double Iz = 0; 
      public static final double FF = 0; 
      public static final double MaxOutput = .1; 
      public static final double MinOutput = -0.1;
      public static final float MotorUpPosition = 23;
      public static final float MotorDownPosition = (float) 0.5;
  }
  public static final class ClimbConstants{
    public static final int climbMotorPort = 10;
    public static final double P = 0.3; 
    public static final double I = 1e-4;
    public static final double D = 0; 
    public static final double Iz = 0; 
    public static final double FF = 0; 
    public static final double MaxOutput = .2; 
    public static final double MinOutput = -.2;
    public static final float MotorUpPosition = 57;
    public static final float MotorDownPosition = 0;
    //Don't use this maybe??? who knowwss? Cruunch
    //public static final double PostionConversionFactor = 2;
}
  public static final class ControllerConstants {
      public static final int A = 1;
      public static final int B = 2;
      public static final int X = 3;
      public static final int Y = 4;
      public static final int LeftButton = 5;
      public static final int RightButton = 6;
      public static final int LinkButton = 7;
      public static final int ControllerPort = 0;
  }

  public static final class FlyWheelConstants{
      public static final int motorOnePort = 7;
      public static final int motorTwoPort = 8;
  }
  
}