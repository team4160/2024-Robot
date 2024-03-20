package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase{
    
    TalonFX intakeMotor;
    VictorSPX indexerMotor_1;
    VictorSPX indexerMotor_2;
    TalonFXConfiguration intakeConfig = new TalonFXConfiguration();;

    public Intake(){
        intakeMotor = new TalonFX(Constants.MotorConstants.intakeMotor_id);
        indexerMotor_1 = new VictorSPX(Constants.MotorConstants.indexer_1_id);
        indexerMotor_2 = new VictorSPX(Constants.MotorConstants.indexer_2_id);

        indexerMotor_1.setInverted(true);
        indexerMotor_2.setInverted(true);

        indexerMotor_2.follow(indexerMotor_1);

        intakeConfig.CurrentLimits.SupplyCurrentLimitEnable = true;
        intakeConfig.CurrentLimits.SupplyCurrentLimit = 30;
        intakeConfig.CurrentLimits.SupplyCurrentThreshold = 40;
        intakeConfig.CurrentLimits.SupplyTimeThreshold = 0.1;
        intakeMotor.getConfigurator().apply(intakeConfig);
    }

    public void setIntake(double percentOutput){
        if (percentOutput > 0.05) {
            intakeMotor.setControl(new VoltageOut(percentOutput * 8));
            indexerMotor_1.set(VictorSPXControlMode.PercentOutput, percentOutput);
        }
        else if (percentOutput < -0.05) {
            intakeMotor.setControl(new VoltageOut(percentOutput * 8));
            indexerMotor_1.set(VictorSPXControlMode.PercentOutput, percentOutput);
        }
        else {
            intakeMotor.set(0);
            indexerMotor_1.set(VictorSPXControlMode.PercentOutput, 0);
        }
    }
}