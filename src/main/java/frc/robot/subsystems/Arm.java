package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase{

    TalonFX armMotor_1 = new TalonFX(Constants.MotorConstants.arm_1_id);
    TalonFX armMotor_2 = new TalonFX(Constants.MotorConstants.arm_2_id);
    TalonFXConfiguration armConfig = new TalonFXConfiguration();

    public Arm(){
        armConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake;
        // armConfig.SoftwareLimitSwitch.ForwardSoftLimitEnable = true;

        armMotor_1.getConfigurator().apply(armConfig);
        armMotor_2.getConfigurator().apply(armConfig);
        armMotor_2.setControl(new Follower(armMotor_1.getDeviceID(), true));
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Arm Position", armMotor_1.getPosition().getValueAsDouble());
    }

    public void setArm(double percentOutput){
        armMotor_1.set(percentOutput);
    }
}
