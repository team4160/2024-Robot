package frc.robot.commands.Autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Robot;
import frc.robot.commands.Shooter.Shoot;

public class BackupAmp extends SequentialCommandGroup {
    public double waittime = 9;

    public BackupAmp(){
        addCommands(
            new Shoot(Robot.intake, Robot.indexer, Robot.shooter, 40),
            new WaitCommand(waittime),
            new GetPath().getAutonomousCommand("Backup Amp")
        );
    }
}
