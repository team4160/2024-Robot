package frc.robot.commands.Autos;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.commands.Shooter.Passthrough;
import frc.robot.commands.Shooter.Shoot;
import frc.robot.subsystems.Swerve;

public class ComplexAuto extends SequentialCommandGroup {
    public ComplexAuto(Swerve s_Swerve){
        addCommands(
            new Shoot(Robot.intake, Robot.indexer, Robot.shooter, s_Swerve, 40),
            // new WaitCommand(7),
            new ParallelRaceGroup(
                new Passthrough(Robot.intake, Robot.indexer, Robot.shooter, 14),
                new RobotContainer().getAutonomousCommand()
            )
        );
    }
}
