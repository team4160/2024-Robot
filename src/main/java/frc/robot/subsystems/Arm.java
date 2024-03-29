package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.GravityTypeValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase{

    TalonFX armMotor_1 = new TalonFX(Constants.MotorConstants.arm_1_id);
    TalonFX armMotor_2 = new TalonFX(Constants.MotorConstants.arm_2_id);
    TalonFXConfiguration armConfig = new TalonFXConfiguration();
    // private boolean endGame = false;

    public Arm(){
        armConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake;
        armConfig.SoftwareLimitSwitch.ForwardSoftLimitEnable = true;
        armConfig.SoftwareLimitSwitch.ForwardSoftLimitThreshold = 0.22;
        armConfig.SoftwareLimitSwitch.ReverseSoftLimitEnable = true;
        armConfig.SoftwareLimitSwitch.ReverseSoftLimitThreshold = 0;

        armConfig.CurrentLimits.SupplyCurrentLimitEnable = false;
        armConfig.CurrentLimits.SupplyCurrentLimit = 80;
        armConfig.CurrentLimits.SupplyCurrentThreshold = 80;
        armConfig.CurrentLimits.SupplyTimeThreshold = 0.1;
        armConfig.CurrentLimits.StatorCurrentLimitEnable = false;
        armConfig.CurrentLimits.StatorCurrentLimit = 100;

        armConfig.Feedback.SensorToMechanismRatio = 144;
        armConfig.Slot0.GravityType = GravityTypeValue.Arm_Cosine; // sensor reports a position of 0 when the mechanism is horizonal (parallel to the ground)
        armConfig.Slot0.kP = 72; // need to test these values, got them from 4467
        armConfig.Slot0.kI = 6.0;
        armConfig.Slot0.kD = 3.0;
        armConfig.Slot0.kS = 0.375;
        armConfig.Slot0.kV = 0.0;
        armConfig.Slot0.kG = 0.375;

        armConfig.MotionMagic.MotionMagicCruiseVelocity = Units.degreesToRotations(360);
        armConfig.MotionMagic.MotionMagicAcceleration = Units.degreesToRotations(720);

        armMotor_1.getConfigurator().apply(armConfig);
        armMotor_2.getConfigurator().apply(armConfig);
        armMotor_2.setControl(new Follower(armMotor_1.getDeviceID(), true));

        armMotor_1.setPosition(0);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Arm Position", armMotor_1.getPosition().getValueAsDouble());
        SmartDashboard.putNumber("Arm1 Current", armMotor_1.getSupplyCurrent().getValueAsDouble());
        SmartDashboard.putNumber("Arm2 Current", armMotor_2.getSupplyCurrent().getValueAsDouble());

        // //if match has one second left, lower the arm
        // if (Timer.getMatchTime() < 1 && !endGame) {
        //     endGame = true;
        //     // Down();
        // }
        // if (Timer.getMatchTime() <= 0 && endGame) { // reset
        //     endGame = false;
        // }
    }

    public void setArm(double percentOutput){
        // armMotor_1.setControl(new VoltageOut(percentOutput * 12));
        armMotor_1.set(percentOutput);
    }
    // public void setArmAngle(double degrees) {
    //     // degrees = MathUtil.clamp(degrees, ARM_LOWER_LIMIT, ARM_UPPER_LIMIT);
    //     // armMotor_1.setControl(new PositionVoltage(0).withSlot(0).withPosition(degrees / 360.0));
    //     armMotor_1.setControl(new MotionMagicVoltage(0).withSlot(0).withPosition(degrees / 360.0));
    // }
    // public void Up(){ // need to get the positions
    //     setArmAngle(0);
    // }
    // public void Down(){
    //     setArmAngle(90);
    // }
}
