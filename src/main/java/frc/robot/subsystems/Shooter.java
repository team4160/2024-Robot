package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Shooter extends SubsystemBase{
    TalonSRX shooterMotor_1; // sooo idk if its supposed to be SRX but im thinking thats a later problem
    TalonSRX shooterMotor_2;

    public Shooter(){
        shooterMotor_1 = new TalonSRX(Constants.MotorConstants.shooterMotor_1_id);
        shooterMotor_2 = new TalonSRX(Constants.MotorConstants.shooterMotor_2_id);

        shooterMotor_1.setNeutralMode(NeutralModeValue.Brake); // so like figure that out <3
        shooterMotor_2.setNeutralMode(NeutralModeValue.Brake); // might be stopMotor(); ?? wait no could be disable
    }

    public void shoot(double percentOutput_1, double percentOutput_2){
        shooterMotor_1.set(ControlMode.Current, percentOutput_1);
        shooterMotor_2.set(ControlMode.Current, percentOutput_2); // might need to be negative something to get it to spin other way ??
    }
}
