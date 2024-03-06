package frc.robot.subsystems;

//import com.ctre.phoenix.motorcontrol.NeutralMode;
//import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
//import com.reduxrobotics.sensors.canandcoder.Canandcoder;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase{
    TalonFX intakeMotor;

    public Intake(){
        intakeMotor = new TalonFX(Constants.MotorConstants.intakeMotor_id);

        intakeMotor.setNeutralMode(NeutralModeValue.Brake); // idk if this is the right value
    }

    public void setIntake(double percentOutput){
        intakeMotor.set(percentOutput);
    }
}