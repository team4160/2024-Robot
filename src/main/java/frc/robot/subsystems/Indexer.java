package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Indexer extends SubsystemBase{

    VictorSPX indexerMotor_1 = new VictorSPX(Constants.MotorConstants.indexer_1_id);
    VictorSPX indexerMotor_2 = new VictorSPX(Constants.MotorConstants.indexer_2_id);

    public Indexer(){
        indexerMotor_1.setInverted(true);
        indexerMotor_2.setInverted(true);

        indexerMotor_2.follow(indexerMotor_1);
    }

    public void setIndex(double percentOutput){
        indexerMotor_1.set(VictorSPXControlMode.PercentOutput, percentOutput);
    }
}
