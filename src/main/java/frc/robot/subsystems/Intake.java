package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase{

    TalonFX intakeMotor = new TalonFX(Constants.MotorConstants.intakeMotor_id);
    TalonFXConfiguration intakeConfig = new TalonFXConfiguration();;

    public Intake(){
        intakeConfig.CurrentLimits.SupplyCurrentLimitEnable = true;
        intakeConfig.CurrentLimits.SupplyCurrentLimit = 30;
        intakeConfig.CurrentLimits.SupplyCurrentThreshold = 40;
        intakeConfig.CurrentLimits.SupplyTimeThreshold = 0.1;
        intakeMotor.getConfigurator().apply(intakeConfig);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Intake Current", getCurrent());
    }

    public void setIntake(double percentOutput){
        intakeMotor.setControl(new VoltageOut(percentOutput * 8));
    }

    public void setIntakeVelocity(double velocity){
        intakeMotor.setControl(new VelocityVoltage(velocity));
    }

    //get the current of the intake
    public double getCurrent(){
        return intakeMotor.getSupplyCurrent().getValueAsDouble();
    }
}
