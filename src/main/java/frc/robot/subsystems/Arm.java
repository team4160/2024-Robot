package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase{
    
    TalonFX armMotor_1;
    TalonFX armMotor_2;
    TalonFXConfiguration armConfig = new TalonFXConfiguration();;

    public Arm(){
        TalonFX armMotor_1 = new TalonFX(Constants.MotorConstants.arm_1_id);
        TalonFX armMotor_2 = new TalonFX(Constants.MotorConstants.arm_2_id);
        armMotor_1.setNeutralMode(NeutralModeValue.Brake);
        armMotor_2.setNeutralMode(NeutralModeValue.Brake);

        armMotor_2.setControl(new Follower(armMotor_1.getDeviceID(), true));
    }

    public void setIntake(double percentOutput){
        armMotor_1.set(percentOutput);
    }
}