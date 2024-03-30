package frc.robot.commands.Autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Robot;
import frc.robot.commands.Shooter.Shoot;

public class JustShoot extends SequentialCommandGroup {

    public JustShoot(){
        addCommands(
            new Shoot(Robot.intake, Robot.indexer, Robot.shooter, 40)
        );
    }
}
