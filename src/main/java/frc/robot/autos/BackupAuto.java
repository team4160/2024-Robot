package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Swerve;

public class BackupAuto extends SequentialCommandGroup{
    
    public BackupAuto(Swerve s_Swerve, boolean direction, boolean far){ // idk if direction or far will be used yet
        Command path = PathPlannerLoader.getAutoCommand(s_Swerve, "simpleAuto"); //used for moving the swerve

        addCommands(
            // i dont think we need any commands bc we're just backing up
            path
        );
    }
}