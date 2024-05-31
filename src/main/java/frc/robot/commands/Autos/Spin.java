package frc.robot.commands.Autos;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Swerve;

public class Spin extends Command {
    private final Swerve s_Swerve;
    private final Arm s_Arm;

    private final Timer timer = new Timer();
    private final double speed = 0.4;

    public Spin(Swerve s_Swerve, Arm s_Arm){
        this.s_Swerve = s_Swerve;
        addRequirements(s_Swerve);
        this.s_Arm = s_Arm;
        addRequirements(s_Arm);
    }
    @Override
    public void initialize() {
        s_Swerve.drive(new Translation2d(), speed, false,false);
        // s_Arm.Up();
        timer.reset();
        timer.start();
    }
    @Override
    public void execute() {
        if (timer.get() % 2 >= 1) {
            s_Arm.setArmAngle(80);
        }
        else
            s_Arm.setArmAngle(10);
    }
    @Override
    public boolean isFinished() {
        return false;
    }
    @Override
    public void end(boolean interrupted) {
        s_Swerve.drive(new Translation2d(),0,false,false);
    }
}
