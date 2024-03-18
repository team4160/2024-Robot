package frc.robot.subsystems;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Shooter extends SubsystemBase{
    TalonFX shooterMotor_1;
    TalonFX shooterMotor_2;

    public Shooter(){
        // just here to make sure the motors are set to brake mode, move to its own subsystem when created
        TalonFX armMotor_1 = new TalonFX(Constants.MotorConstants.arm_1_id);
        TalonFX armMotor_2 = new TalonFX(Constants.MotorConstants.arm_2_id);
        armMotor_1.setNeutralMode(NeutralModeValue.Brake);
        armMotor_2.setNeutralMode(NeutralModeValue.Brake);

        shooterMotor_1 = new TalonFX(Constants.MotorConstants.shooterMotor_1_id);
        shooterMotor_2 = new TalonFX(Constants.MotorConstants.shooterMotor_2_id);
        shooterMotor_2.setControl(new Follower(shooterMotor_1.getDeviceID(), true));

        shooterMotor_1.setNeutralMode(NeutralModeValue.Brake); // it could be coast, doesn't really matter
        shooterMotor_2.setNeutralMode(NeutralModeValue.Brake);
    }

    public void shoot(double velocity){
        shooterMotor_1.setControl(new VelocityVoltage(velocity));
    }
}
