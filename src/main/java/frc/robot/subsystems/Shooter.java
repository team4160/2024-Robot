package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase{
    TalonFX shooterMotor_1 = new TalonFX(Constants.MotorConstants.shooterMotor_1_id);
    TalonFX shooterMotor_2 = new TalonFX(Constants.MotorConstants.shooterMotor_2_id);
    TalonFXConfiguration shooterConfig = new TalonFXConfiguration();
    public boolean isLoaded = false;

    public Shooter(){
        shooterConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake; // it could be coast, doesn't really matter
        shooterConfig.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
        shooterConfig.CurrentLimits.SupplyCurrentLimitEnable = true;
        shooterConfig.CurrentLimits.SupplyCurrentLimit = 40;
        shooterConfig.CurrentLimits.SupplyCurrentThreshold = 50;
        shooterConfig.CurrentLimits.SupplyTimeThreshold = 0.1;
        shooterConfig.Slot0.kP = 0.25;
        shooterConfig.Slot0.kI = 25;
        shooterConfig.Slot0.kD = 0.01;
        shooterMotor_1.getConfigurator().apply(shooterConfig);
        shooterMotor_2.getConfigurator().apply(shooterConfig);
        shooterMotor_2.setControl(new Follower(shooterMotor_1.getDeviceID(), true));
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Shooter Velocity", shooterMotor_1.getVelocity().getValueAsDouble());
        // SmartDashboard.putNumber("Shooter Loop Error", shooterMotor_1.getClosedLoopError().getValueAsDouble());
    }

    public void shoot(double velocity){
        shooterMotor_1.setControl(new VelocityVoltage(velocity));
    }

    public void percentOutput(double percentOutput){
        shooterMotor_1.set(percentOutput);
    }

    public void stop(){
        shooterMotor_1.stopMotor();
    }

    //get the current velocity of the shooter
    public double getVelocity(){
        return shooterMotor_1.getVelocity().getValueAsDouble();
    }
}
