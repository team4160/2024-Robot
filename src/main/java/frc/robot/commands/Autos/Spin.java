package frc.robot.commands.Autos;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Swerve;

public class Spin extends Command {
    private final Swerve s_Swerve;

    private final double speed = 0.25;

    public Spin(Swerve s_Swerve){
        this.s_Swerve = s_Swerve;
        addRequirements(s_Swerve);
    }
    @Override
    public void initialize() {
        s_Swerve.drive(new Translation2d(), speed, false,false);
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
