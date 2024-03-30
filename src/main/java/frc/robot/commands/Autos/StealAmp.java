package frc.robot.commands.Autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Robot;
import frc.robot.commands.Shooter.Passthrough;
import frc.robot.commands.Shooter.Shoot;

public class StealAmp extends SequentialCommandGroup {
    public double waittime = 0;

    public StealAmp(){
        addCommands(
            new Shoot(Robot.intake, Robot.indexer, Robot.shooter, 40),
            new WaitCommand(waittime),
            new GetPath().getAutonomousCommand("Steal Amp").alongWith(new Passthrough(Robot.intake, Robot.indexer, Robot.shooter, 10))
        );
    }
}
