package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Lock extends SubsystemBase{
    TalonSRX lockMotor = new TalonSRX(Constants.MotorConstants.lock_id);
    public boolean isPrimed = false;

    public Lock(){
        lockMotor.setNeutralMode(NeutralMode.Brake);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Lock Current", lockMotor.getSupplyCurrent());
    }

    public void setLock(double percentOutput) {
        lockMotor.set(TalonSRXControlMode.PercentOutput, percentOutput);
    }
}
