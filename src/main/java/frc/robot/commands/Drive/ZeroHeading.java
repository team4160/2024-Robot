package frc.robot.commands.Drive;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Swerve;

public class ZeroHeading extends Command {
    private Swerve swerve;

    public ZeroHeading(Swerve s) {
        swerve = s;
        addRequirements(swerve);
    }

    @Override
    public void execute() {
        // swerve.zeroHeading();
        swerve.setHeading(new Rotation2d(Units.degreesToRadians(180)));
    }
}
