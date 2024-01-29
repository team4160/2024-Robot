package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.configs.TalonFXConfiguration;

public final class CTREConfigs {
    public TalonSRXConfiguration swerveAngleSRXConfig = new TalonSRXConfiguration();
    public TalonFXConfiguration swerveDriveFXConfig = new TalonFXConfiguration();
    public static final boolean invertGyro = true; // Always ensure Gyro is CCW+ CW-

    public CTREConfigs(){
        /** Swerve Angle Motor Configurations */
        /* Motor Inverts and Neutral Mode */
        swerveAngleSRXConfig.MotorOutput.Inverted = Constants.Swerve.angleMotorInvert;
        swerveAngleSRXConfig.MotorOutput.NeutralMode = Constants.Swerve.angleNeutralMode;

        /* Gear Ratio and Wrapping Config */
        swerveAngleSRXConfig.Feedback.SensorToMechanismRatio = Constants.Swerve.angleGearRatio;
        swerveAngleSRXConfig.ClosedLoopGeneral.ContinuousWrap = true;

        if (Constants.Swerve.angleEnableCurrentLimit) {
            swerveAngleSRXConfig.continuousCurrentLimit = Constants.Swerve.angleCurrentLimit;
            swerveAngleSRXConfig.peakCurrentLimit = Constants.Swerve.angleCurrentThreshold;
            swerveAngleSRXConfig.peakCurrentDuration = (int) Constants.Swerve.angleCurrentThresholdTime * 1000;
        }
        else {
            swerveAngleSRXConfig.continuousCurrentLimit = 0;
            swerveAngleSRXConfig.peakCurrentLimit = 0;
            swerveAngleSRXConfig.peakCurrentDuration = 0;
        }

        /* PID Config */
        swerveAngleSRXConfig.slot0.kP = Constants.Swerve.angleKP;
        swerveAngleSRXConfig.slot0.kI = Constants.Swerve.angleKI;
        swerveAngleSRXConfig.slot0.kD = Constants.Swerve.angleKD;
        swerveAngleSRXConfig.slot0.kF = 0;

        /** Swerve Drive Motor Configuration */
        /* Motor Inverts and Neutral Mode */
        swerveDriveFXConfig.MotorOutput.Inverted = Constants.Swerve.driveMotorInvert;
        swerveDriveFXConfig.MotorOutput.NeutralMode = Constants.Swerve.driveNeutralMode;

        /* Gear Ratio Config */
        swerveDriveFXConfig.Feedback.SensorToMechanismRatio = Constants.Swerve.driveGearRatio;

        /* Current Limiting */
        swerveDriveFXConfig.CurrentLimits.SupplyCurrentLimitEnable = Constants.Swerve.driveEnableCurrentLimit;
        swerveDriveFXConfig.CurrentLimits.SupplyCurrentLimit = Constants.Swerve.driveCurrentLimit;
        swerveDriveFXConfig.CurrentLimits.SupplyCurrentThreshold = Constants.Swerve.driveCurrentThreshold;
        swerveDriveFXConfig.CurrentLimits.SupplyTimeThreshold = Constants.Swerve.driveCurrentThresholdTime;

        /* PID Config */
        swerveDriveFXConfig.Slot0.kP = Constants.Swerve.driveKP;
        swerveDriveFXConfig.Slot0.kI = Constants.Swerve.driveKI;
        swerveDriveFXConfig.Slot0.kD = Constants.Swerve.driveKD;

        /* Open and Closed Loop Ramping */
        swerveDriveFXConfig.OpenLoopRamps.DutyCycleOpenLoopRampPeriod = Constants.Swerve.openLoopRamp;
        swerveDriveFXConfig.OpenLoopRamps.VoltageOpenLoopRampPeriod = Constants.Swerve.openLoopRamp;

        swerveDriveFXConfig.ClosedLoopRamps.DutyCycleClosedLoopRampPeriod = Constants.Swerve.closedLoopRamp;
        swerveDriveFXConfig.ClosedLoopRamps.VoltageClosedLoopRampPeriod = Constants.Swerve.closedLoopRamp;
    }
}