package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Shooter extends SubsystemBase{
    TalonFX shooterMotor_1;
    TalonFX shooterMotor_2;

    public Shooter(){
        shooterMotor_1 = new TalonFX(Constants.MotorConstants.shooterMotor_1_id);
        shooterMotor_2 = new TalonFX(Constants.MotorConstants.shooterMotor_2_id);
        TalonFX armMotor_1 = new TalonFX(Constants.MotorConstants.arm_1_id);
        TalonFX armMotor_2 = new TalonFX(Constants.MotorConstants.arm_2_id);
        armMotor_1.setNeutralMode(NeutralModeValue.Brake);
        armMotor_2.setNeutralMode(NeutralModeValue.Brake);

        shooterMotor_1.setNeutralMode(NeutralModeValue.Brake);
        shooterMotor_2.setNeutralMode(NeutralModeValue.Brake);
    }

    public void shoot(double percentOutput_1, double percentOutput_2){
        // shooterMotor_1.set(ControlMode.Current, percentOutput_1);
        // shooterMotor_2.set(ControlMode.Current, percentOutput_2); // might need to be negative something to get it to spin other way ??
    }
}
